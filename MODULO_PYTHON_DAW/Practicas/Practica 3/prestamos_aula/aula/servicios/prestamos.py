from aula.dominio import (
    Alumno,
    AlumnoInactivoError,
    CantidadInvalidaError,
    DevolucionExcesivaError,
    EntidadInexistenteError,
    EstadoAula,
    Material,
    Prestamo,
    StockInsuficienteError,
)
from aula.servicios.alumnos import obtener_alumno
from aula.servicios.decoradores import registrar_operacion
from aula.servicios.materiales import obtener_material


def obtener_prestamo(estado: EstadoAula, prestamo_id: str) -> Prestamo:
    prestamo: Prestamo | None = estado["prestamos"].get(prestamo_id)
    if prestamo is None:
        raise EntidadInexistenteError("préstamo", prestamo_id)
    return prestamo


@registrar_operacion
def prestar_material(
    estado: EstadoAula, alumno_id: str, material_id: str, cantidad: int
) -> str:
    """Crea un préstamo y reduce disponibles. Devuelve el identificador."""
    # 1. Validar todo antes de modificar
    alumno: Alumno = obtener_alumno(estado, alumno_id)
    material: Material = obtener_material(estado, material_id)
    if cantidad <= 0:
        raise CantidadInvalidaError("La cantidad debe ser un entero positivo")
    if not alumno["activo"]:
        raise AlumnoInactivoError(f"El alumno {alumno_id} no está activo")
    if cantidad > material["disponibles"]:
        raise StockInsuficienteError(material["disponibles"], cantidad)

    # 2. Modificar
    prestamo_id: str = f"PRE{estado['siguiente_prestamo']:03d}"
    estado["prestamos"][prestamo_id] = {
        "alumno_id": alumno_id,
        "material_id": material_id,
        "cantidad": cantidad,
        "pendientes": cantidad,
    }
    material["disponibles"] -= cantidad
    estado["siguiente_prestamo"] += 1
    return prestamo_id


@registrar_operacion
def devolver_material(estado: EstadoAula, prestamo_id: str, cantidad: int) -> int:
    """Registra una devolución. Devuelve las unidades que quedan pendientes."""
    prestamo: Prestamo = obtener_prestamo(estado, prestamo_id)
    if cantidad <= 0:
        raise CantidadInvalidaError("La cantidad debe ser un entero positivo")
    if cantidad > prestamo["pendientes"]:
        raise DevolucionExcesivaError(prestamo["pendientes"], cantidad)
    material: Material = obtener_material(estado, prestamo["material_id"])

    prestamo["pendientes"] -= cantidad
    material["disponibles"] += cantidad
    return prestamo["pendientes"]


def consultar_prestamos(
    estado: EstadoAula,
    alumno_id: str | None = None,
    *,
    solo_pendientes: bool = False,
) -> list[tuple[str, Prestamo]]:
    """Lista préstamos, opcionalmente de un alumno y solo los pendientes."""
    if alumno_id is not None:
        obtener_alumno(estado, alumno_id)  # lanza error si no existe

    resultado: list[tuple[str, Prestamo]] = []
    for prestamo_id, prestamo in estado["prestamos"].items():
        if alumno_id is not None and prestamo["alumno_id"] != alumno_id:
            continue
        if solo_pendientes and prestamo["pendientes"] == 0:
            continue
        resultado.append((prestamo_id, prestamo))
    return resultado
