from typing import TypedDict


class Material(TypedDict):
    nombre: str
    total: int
    disponibles: int


class Alumno(TypedDict):
    nombre: str
    activo: bool


class Prestamo(TypedDict):
    alumno_id: str
    material_id: str
    cantidad: int
    pendientes: int


class EstadoAula(TypedDict):
    materiales: dict[str, Material]
    alumnos: dict[str, Alumno]
    prestamos: dict[str, Prestamo]
    siguiente_material: int
    siguiente_alumno: int
    siguiente_prestamo: int


class Resumen(TypedDict):
    tipos_material: int
    alumnos_registrados: int
    unidades_totales: int
    unidades_disponibles: int
    unidades_prestadas: int
    materiales_agotados: int
    prestamos_pendientes: int
