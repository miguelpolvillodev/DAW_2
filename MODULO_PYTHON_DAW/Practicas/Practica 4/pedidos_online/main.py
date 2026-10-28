from dataclasses import FrozenInstanceError
from tienda.producto import Producto
from tienda.linea import LineaPedido

def main() -> None:
    try:
        teclado = Producto("TEC","Teclado", 2500)
        otro = Producto("TEC","Teclado", 2500)
        linea = LineaPedido(teclado, 2)
        teclado.nombre = ""

        print(teclado)
        print(repr(teclado))
        print("son iguales: ", teclado == otro, "mismo objeto", teclado is otro)
        print("subtotal:", linea.subtotal_centimos)
    except ValueError as error:
        print("datos invalidos: ", error)

if __name__ == "__main__":
    main()

p = Producto("TEC","Teclado",2500)

print(p)
print(f"{p!r}")
assert str(p) == "Teclado (2500 centimos)"
assert repr(p) == "Producto(codigo='TEC', nombre='Teclado', precio_centimos=2500)"
assert p is not Producto("TEC","Teclado",2500)