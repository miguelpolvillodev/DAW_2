class ErrorAula(Exception):
    """Base de los errores previstos de la aplicación."""


class NombreInvalidoError(ErrorAula):
    """El nombre está vacío tras limpiar los espacios."""


class CantidadInvalidaError(ErrorAula):
    """La cantidad no es un entero positivo."""


class MaterialDuplicadoError(ErrorAula):
    """Ya existe un material con ese nombre."""


class EntidadInexistenteError(ErrorAula):
    def __init__(self, tipo: str, identificador: str) -> None:
        self.tipo: str = tipo
        self.identificador: str = identificador
        super().__init__(f"No existe {tipo} con identificador {identificador}")


class AlumnoInactivoError(ErrorAula):
    """El alumno no está activo y no puede recibir préstamos."""


class StockInsuficienteError(ErrorAula):
    def __init__(self, disponibles: int, solicitadas: int) -> None:
        self.disponibles: int = disponibles
        self.solicitadas: int = solicitadas
        super().__init__(
            f"Solicitadas {solicitadas} unidades, pero solo hay {disponibles} disponibles"
        )


class DevolucionExcesivaError(ErrorAula):
    def __init__(self, pendientes: int, devueltas: int) -> None:
        self.pendientes: int = pendientes
        self.devueltas: int = devueltas
        super().__init__(
            f"Intentas devolver {devueltas} unidades, pero solo quedan {pendientes} pendientes"
        )
