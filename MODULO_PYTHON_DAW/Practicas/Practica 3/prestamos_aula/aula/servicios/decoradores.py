from collections.abc import Callable
from functools import wraps

from aula.dominio import ErrorAula


def formatear_evento(evento: str, operacion: str, **metadatos: object) -> str:
    """Crea una línea de registro: [EVENTO] operacion clave=valor ..."""
    detalles: str = " ".join(f"{clave}={valor}" for clave, valor in metadatos.items())
    return f"[{evento}] {operacion} {detalles}".rstrip()


def registrar_operacion[**P, R](funcion: Callable[P, R]) -> Callable[P, R]:
    """Registra INICIO, OK o ERROR sin cambiar el resultado ni los errores."""

    @wraps(funcion)
    def envoltorio(*args: P.args, **kwargs: P.kwargs) -> R:
        print(formatear_evento("INICIO", funcion.__name__))
        try:
            resultado: R = funcion(*args, **kwargs)
        except ErrorAula as error:
            print(formatear_evento("ERROR", funcion.__name__, tipo=type(error).__name__))
            raise
        print(formatear_evento("OK", funcion.__name__, resultado=resultado))
        return resultado

    return envoltorio
