from dataclasses import dataclass


@dataclass(frozen=True)
class Producto:
    """Clase que describe un Productocon un precio expresado en centimos"""
    codigo: str
    nombre: str 
    precio_centimos: int

    @property
    def nombre(self) -> str:
        return self.nombre

    @nombre.setter
    def nombre(self, nuevo_nombre) -> None:
        if not self.nombre.strip():
            raise ValueError("Nombre no puede ser vacio")


    def __post_init__(self) -> None:
        
        if type(self.precio_centimos) is not int or self.precio_centimos<0:
            raise ValueError("El precio debe ser un entero positivo")
       

    def __str__(self) -> str:
        return f"{self.nombre} ({self.precio_centimos} centimos)"

    def __repr__(self)-> str:
        return f"Producto(codigo={self.codigo!r}, nombre={self.nombre!r}, precio_centimos={self.precio_centimos!r})"

   
        
        