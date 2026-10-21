from tienda.producto import Producto

p = Producto("TEC","Teclado",2500)

print(p)
print(f"{p!r}")
assert str(p) == "Teclado (2500 centimos)"
assert repr(p) == "Producto(codigo='TEC', nombre='Teclado', precio_centimos=2500)"
assert p is not Producto("TEC","Teclado",2500)