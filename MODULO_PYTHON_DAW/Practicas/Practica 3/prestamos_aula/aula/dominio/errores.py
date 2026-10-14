class ErrorAula(Exception):
    """Base de los errores previstos de la aplicacion"""

class NombreInvalidoError(ErrorAula):
    pass

class CantidadInvalidaError(ErrorAula):
    pass 

class MaterialDuplicadoError(ErrorAula):
    pass

class EntidadInexistenteError(ErrorAula):
    def __init__(self, tipo: str, identificador: str):
        self.tipo: str = tipo
        self.identificador: str = identificador
        super().__init__(f"No existe {tipo} con identificador {identificador}")

class StockInsuficienteError(ErrorAula):
    def __init__(self, disponible: int, solicitados: int):
        self.disponible: int = disponible
        self.solicitados: int = solicitados
        super().__init__(f"Solicitadas {solicitados} unidades, pero solo hay {disponible} disponibles")


class AlumnoInactivoError(ErrorAula):
    pass



class DevolucionExcesivaError(ErrorAula):
    def __init__(self, pendientes: int, devueltas: int):
            self.pendientes: int = pendientes
            self.devueltas: int = devueltas
            super().__init__(f"Intenas devolver {devueltas} unidades, pero solo quedan {pendientes} disponibles")