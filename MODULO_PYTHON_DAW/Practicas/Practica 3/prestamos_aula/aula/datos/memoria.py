from aula.dominio.modelos import EstadoAula


def crear_estado_inicial() -> EstadoAula:
    return {
        "materiales":{
            "MAT001": {"nombre": "Portátil", "total": 5, "disponible":5},
            "MAT002":{"nombre": "Portátil", "total": 5, "disponible":5}
        },
        "alumnos": {
            "AL001": {"nombre":"Ana","estado":True},
            "AL002": {"nombre":"Luis","estado":True}
        },
        "prestamos":{},
        "siguiente_material": 3,
        "siguiente_alumno": 3,
        "siguiente_prestamo": 1
    }