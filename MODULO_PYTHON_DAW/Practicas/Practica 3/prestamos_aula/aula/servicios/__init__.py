from aula.servicios.alumnos import crear_alumno, listar_alumnos, obtener_alumno
from aula.servicios.materiales import crear_material, listar_materiales, obtener_material
from aula.servicios.prestamos import (
    consultar_prestamos,
    devolver_material,
    obtener_prestamo,
    prestar_material,
)
from aula.servicios.resumen import obtener_resumen, sumar_cantidades

__all__ = [
    "consultar_prestamos",
    "crear_alumno",
    "crear_material",
    "devolver_material",
    "listar_alumnos",
    "listar_materiales",
    "obtener_alumno",
    "obtener_material",
    "obtener_prestamo",
    "obtener_resumen",
    "prestar_material",
    "sumar_cantidades",
]
