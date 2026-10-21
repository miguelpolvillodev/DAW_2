from aula.dominio import Alumno, EntidadInexistenteError, EstadoAula, NombreInvalidoError
from aula.servicios.decoradores import registrar_operacion


def listar_alumnos(estado: EstadoAula) -> list[tuple[str, Alumno]]:
    return list(estado["alumnos"].items())


def obtener_alumno(estado: EstadoAula, alumno_id: str) -> Alumno:
    alumno: Alumno | None = estado["alumnos"].get(alumno_id)
    if alumno is None:
        raise EntidadInexistenteError("alumno", alumno_id)
    return alumno


@registrar_operacion
def crear_alumno(estado: EstadoAula, nombre: str) -> str:
    """Da de alta un alumno activo. Se permiten nombres repetidos."""
    nombre_limpio: str = nombre.strip()
    if not nombre_limpio:
        raise NombreInvalidoError("El nombre no puede estar vacío")

    alumno_id: str = f"AL{estado['siguiente_alumno']:03d}"
    estado["alumnos"][alumno_id] = {"nombre": nombre_limpio, "activo": True}
    estado["siguiente_alumno"] += 1
    return alumno_id
