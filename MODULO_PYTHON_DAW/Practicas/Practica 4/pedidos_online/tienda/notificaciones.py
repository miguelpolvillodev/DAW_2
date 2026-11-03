from abc import ABC, abstractmethod
from typing import Protocol


class Notificador(ABC):
    """Contrato nominal: para cumplirlo hay que heredar de Notificador."""

    @abstractmethod
    def enviar(self, mensaje: str) -> None:
        """Entrega el mensaje por el canal concreto."""


class NotificadorConsola(Notificador):
    """Muestra el aviso por pantalla."""

    def enviar(self, mensaje: str) -> None:
        print(f"[AVISO] {mensaje}")


class NotificadorMemoria(Notificador):
    """Guarda los avisos en una lista propia de cada instancia."""

    def __init__(self) -> None:
        self.mensajes: list[str] = []

    def enviar(self, mensaje: str) -> None:
        self.mensajes.append(mensaje)


class CanalAviso(Protocol):

    def enviar(self, mensaje: str) -> None: ...


class NotificadorPrefijo:

    def __init__(self, prefijo: str) -> None:
        self.prefijo = prefijo

    def enviar(self, mensaje: str) -> None:
        print(f"{self.prefijo}: {mensaje}")
