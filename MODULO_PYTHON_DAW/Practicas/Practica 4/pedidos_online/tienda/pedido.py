from tienda.linea import LineaPedido
from tienda.producto import Producto


class Pedido:
    """Agrupa lineas de pedido y calcula su total sin almacenarlo por separado"""

    def __init__(self, numero: str) -> None:
        if not numero.strip():
            raise ValueError("El numero de pedido es obligatorio")
        self.numero = numero.strip()
        self._lineas: list[LineaPedido] = []

    @property
    def numero(self) -> str:
        return self._numero

    @property
    def lineas(self) -> tuple[LineaPedido, ...]:
        return tuple(self._lineas)

    @property
    def total_centimos(self) -> int:
        return sum(linea.subtotal_centimos for linea in self._lineas)

    def agregar_producto(self, producto: Producto, cantidad: int) -> None:
        if any(linea.producto.codigo == producto.codigo for linea in self._lineas):
            raise ErrorPedido("El producto ya esta en el pedido")