from dataclasses import dataclass


@dataclass(frozen=True)
class Producto:
    """Producto de la tienda con su precio expresado en céntimos."""

    codigo: str
    nombre: str
    precio_centimos: int

    def __post_init__(self) -> None:
        for campo, valor in (("codigo", self.codigo), ("nombre", self.nombre)):
            if type(valor) is not str or not valor or valor != valor.strip():
                raise ValueError(f"El campo {campo} no puede estar vacío ni tener espacios exteriores")
        if type(self.precio_centimos) is not int or self.precio_centimos < 0:
            raise ValueError("El precio debe ser un entero no negativo")

    def __str__(self) -> str:
        return f"{self.nombre} ({self.precio_centimos} céntimos)"
