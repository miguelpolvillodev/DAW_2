from dataclasses import dataclass

from tienda.producto import Producto

@dataclass(frozen=True)
class LineaPedido:
    """Se compone de 1 producto y una cantidad entera positiva"""

    producto : Producto
    cantidad: int 

    def __post_init__(self) -> None:
        if type(self.cantidad) is not int or self.cantidad <= 0:
            raise ValueError("La cantidad debe ser un entero positivo")

    @property
    def subtotal_centimos(self) -> int:
        """Property convierte en atributo el metodo para poder usarlo LineaPedido: linea  linea.subtotal_centimos"""
        return self.producto.precio_centimos * self.cantidad