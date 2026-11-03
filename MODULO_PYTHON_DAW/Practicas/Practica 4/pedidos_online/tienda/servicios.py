from tienda.notificaciones import CanalAviso
from tienda.pedido import Pedido


def confirmar_y_avisar(pedido: Pedido, notificador: CanalAviso) -> None:
    """Confirma primero y avisa después.

    Si confirmar falla, no se envía nada. Si el canal falla después de confirmar,
    el pedido queda CONFIRMADO y la excepción se propaga a quien llamó.
    """
    pedido.confirmar()
    notificador.enviar(f"Pedido {pedido.numero} confirmado: {pedido.total_centimos} céntimos")
