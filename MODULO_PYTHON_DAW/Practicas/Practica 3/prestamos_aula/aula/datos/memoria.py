from aula.dominio import EstadoAula


def crear_estado_inicial() -> EstadoAula:
    """Construye un estado nuevo en cada llamada (no se comparten diccionarios)."""
    return {
        "materiales": {
            "MAT001": {"nombre": "Portátil", "total": 5, "disponibles": 5},
            "MAT002": {"nombre": "Proyector", "total": 2, "disponibles": 2},
        },
        "alumnos": {
            "AL001": {"nombre": "Ana", "activo": True},
            "AL002": {"nombre": "Luis", "activo": True},
        },
        "prestamos": {},
        "siguiente_material": 3,
        "siguiente_alumno": 3,
        "siguiente_prestamo": 1,
    }
