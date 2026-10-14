from typing import TypedDict


class Material(TypedDict):
    nombre: str
    total: int
    disponible: int


mi_material: Material = {"nombre": "portatil", "total": 5, "disponible": 5}


class Alumno(TypedDict):
    nombre: str
    activo: bool


mi_alumno: Alumno = {"nombre": "Miguel", "activo": True}


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
