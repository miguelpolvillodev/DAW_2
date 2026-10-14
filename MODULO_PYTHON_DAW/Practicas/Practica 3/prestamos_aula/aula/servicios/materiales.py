from aula.dominio.errores import (
    CantidadInvalidaError,
    EntidadInexistenteError,
    MaterialDuplicadoError,
    NombreInvalidoError,
)
from aula.dominio.modelos import EstadoAula, Material


def listar_materiales(estado: EstadoAula) -> list[tuple[str, Material]]:
    return list(estado["materiales"].items())


def obtener_material(estado: EstadoAula, material_id: str) -> Material:
    material: Material | None = estado["materiales"].get(material_id)
    if material is None:
        raise EntidadInexistenteError(f"No se encuentra el material {material_id}")
    return material


def crear_material(estado: EstadoAula, nombre: str, cantidad: int) -> str:
    nombre_limpio: str = nombre.strip()
    if not nombre_limpio:
        raise NombreInvalidoError("El nombre no puede estar vacío")
    if cantidad <= 0:
        raise CantidadInvalidaError("La cantidad debe ser un entero positivo")
    for existente in estado["materiales"].values():
        if existente["nombre"].strip().casefold() == nombre_limpio.casefold():
            raise MaterialDuplicadoError(f"Ya existe el material {nombre_limpio}")

    material_id: str = f"MAT{estado['siguiente_material']:03d}"
    estado["materiales"][material_id] = {
        "nombre": nombre_limpio,
        "total": cantidad,
        "disponibles": cantidad,
    }
    estado["siguiente_material"] += 1
    return material_id