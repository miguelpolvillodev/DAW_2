"""Comprobaciones de las tareas de cada etapa. Ejecutar con: python -B comprobar.py"""
from tienda.errores import ErrorPedido
from tienda.linea import LineaPedido
from tienda.notificaciones import NotificadorMemoria, NotificadorPrefijo
from tienda.pedido import Pedido
from tienda.producto import Producto
from tienda.servicios import confirmar_y_avisar


p = Producto("TEC", "Teclado", 2500)
assert str(p) == "Teclado (2500 céntimos)"
assert repr(p) == "Producto(codigo='TEC', nombre='Teclado', precio_centimos=2500)"
assert p is not Producto("TEC", "Teclado", 2500)


assert p == Producto("TEC", "Teclado", 2500)
assert LineaPedido(p, 2).subtotal_centimos == 5000


p = Pedido("P001")
p.agregar_producto(Producto("TEC", "Teclado", 2500), 2)
p.agregar_producto(Producto("RAT", "Ratón", 1500), 1)
assert p.total_centimos == 6500
p.quitar_producto("RAT")
assert p.total_centimos == 5000
assert len(p.lineas) == 1


p = Pedido("P001")
p.agregar_producto(Producto("TEC", "Teclado", 2500), 2)
p.confirmar()
p.cancelar()
assert p.estado == "CANCELADO"
assert p.total_centimos == 5000
assert len(p.lineas) == 1


p = Pedido("P002")
p.agregar_producto(Producto("TEC", "Teclado", 2500), 2)
n = NotificadorMemoria()
confirmar_y_avisar(p, n)
assert n.mensajes == ["Pedido P002 confirmado: 5000 céntimos"]
assert NotificadorMemoria().mensajes == []


p = Pedido("P003")
p.agregar_producto(Producto("TEC", "Teclado", 2500), 2)
confirmar_y_avisar(p, NotificadorPrefijo("TIENDA"))
assert p.estado == "CONFIRMADO"


for malo in (True, 25.0, -1, "2500"):
    try:
        Producto("TEC", "Teclado", malo)
    except ValueError:
        pass
    else:
        raise AssertionError(f"Precio {malo!r} debería rechazarse")
for codigo, nombre in (("", "Teclado"), ("TEC", ""), (" TEC", "Teclado"), ("TEC", "Teclado ")):
    try:
        Producto(codigo, nombre, 2500)
    except ValueError:
        pass
    else:
        raise AssertionError("Código/nombre inválido aceptado")
for mala in (0, -2, True, 1.5):
    try:
        LineaPedido(Producto("TEC", "Teclado", 2500), mala)
    except ValueError:
        pass
    else:
        raise AssertionError(f"Cantidad {mala!r} debería rechazarse")

vacio = Pedido("P009")
assert vacio.total_centimos == 0 and vacio.lineas == () and vacio.estado == "ABIERTO"
assert Pedido("A")._lineas is not Pedido("B")._lineas 

p = Pedido("P010")
p.agregar_producto(Producto("TEC", "Teclado", 2500), 1)
try:
    p.agregar_producto(Producto("TEC", "Teclado", 2500), 3)  
except ErrorPedido:
    pass
assert p.lineas[0].cantidad == 1
try:
    p.quitar_producto("tec")  
except ErrorPedido:
    pass
assert len(p.lineas) == 1
try:
    p.agregar_producto(Producto("RAT", "Ratón", 1500), 0)  
except ValueError:
    pass
assert len(p.lineas) == 1

v = Pedido("P011")
v.cancelar()  
assert v.estado == "CANCELADO"

for prop in ("numero", "lineas", "total_centimos", "estado"):
    try:
        setattr(p, prop, None)
    except AttributeError:
        pass
    else:
        raise AssertionError(f"{prop} no debería tener setter")

print("Todas las comprobaciones pasan")
