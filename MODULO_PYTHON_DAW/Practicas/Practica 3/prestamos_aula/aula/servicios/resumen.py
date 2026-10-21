from aula.dominio import EstadoAula, Resumen


def sumar_cantidades(*cantidades: int) -> int:
    total: int = 0
    for cantidad in cantidades:
        total += cantidad
    return total


def obtener_resumen(estado: EstadoAula) -> Resumen:
    materiales = estado["materiales"].values()
    prestamos = estado["prestamos"].values()

    return {
        "tipos_material": len(estado["materiales"]),
        "alumnos_registrados": len(estado["alumnos"]),
        "unidades_totales": sumar_cantidades(*[m["total"] for m in materiales]),
        "unidades_disponibles": sumar_cantidades(*[m["disponibles"] for m in materiales]),
        "unidades_prestadas": sumar_cantidades(*[p["pendientes"] for p in prestamos]),
        "materiales_agotados": len([m for m in materiales if m["disponibles"] == 0]),
        "prestamos_pendientes": len([p for p in prestamos if p["pendientes"] > 0]),
    }
