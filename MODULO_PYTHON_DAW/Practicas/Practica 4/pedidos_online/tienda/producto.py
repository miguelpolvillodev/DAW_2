class Producto:
    """Clase que describe un Productocon un precio expresado en centimos"""

    def __init__(self, codigo: str, nombre: str, precio_centimos: int) -> None:
        if not codigo.strip() or not nombre.strip():
            raise ValueError("Codigo y nombre son datos obligatorios")
        if type(precio_centimos) is not int or precio_centimos<0:
            raise ValueError("El precio debe ser un entero positivo")
        self.codigo = codigo
        self.nombre = nombre 
        self.precio_centimos = precio_centimos

    def __str__(self) -> str:
        return f"{self.nombre} ({self.precio_centimos} centimos)"

    def __repr__(self)-> str:
        return f"Producto(codigo={self.codigo!r}, nombre={self.nombre!r}, precio_centimos={self.precio_centimos!r})"

        
        