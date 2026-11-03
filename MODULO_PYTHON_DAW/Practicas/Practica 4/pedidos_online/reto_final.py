"""Reto final de integración. Ejecutar con: python -B reto_final.py"""
from tienda.errores import ErrorPedido
from tienda.notificaciones import NotificadorMemoria, NotificadorPrefijo
from tienda.pedido import Pedido
from tienda.producto import Producto
from tienda.servicios import confirmar_y_avisar

teclado = Producto("TEC", "Teclado", 2500)
raton = Producto("RAT", "Ratón", 1500)

# 1. P100 con dos teclados y un ratón
p100 = Pedido("P100")
p100.agregar_producto(teclado, 2)
p100.agregar_producto(raton, 1)
assert p100.total_centimos == 6500

# 2. Quitar el ratón
p100.quitar_producto("RAT")
assert p100.total_centimos == 5000

# 3. Confirmar con NotificadorMemoria
memoria = NotificadorMemoria()
confirmar_y_avisar(p100, memoria)
assert p100.estado == "CONFIRMADO"
assert memoria.mensajes == ["Pedido P100 confirmado: 5000 céntimos"]

# 4. Añadir tras confirmar: falla y no cambia nada
lineas_antes = p100.lineas
try:
    p100.agregar_producto(raton, 1)
except ErrorPedido as error:
    print("4. Rechazado:", error)
else:
    raise AssertionError("No debería poder añadirse a un pedido confirmado")
assert p100.lineas == lineas_antes
assert p100.total_centimos == 5000

# 5. Confirmar otra vez: falla y no se envía un segundo aviso
try:
    confirmar_y_avisar(p100, memoria)
except ErrorPedido as error:
    print("5. Rechazado:", error)
else:
    raise AssertionError("No debería poder confirmarse dos veces")
assert len(memoria.mensajes) == 1

# 6. Cancelar conserva total y línea; cancelar de nuevo falla
p100.cancelar()
assert p100.estado == "CANCELADO"
assert p100.total_centimos == 5000
assert len(p100.lineas) == 1
try:
    p100.cancelar()
except ErrorPedido as error:
    print("6. Rechazado:", error)
else:
    raise AssertionError("No debería poder cancelarse dos veces")
assert p100.estado == "CANCELADO"
assert p100.total_centimos == 5000
assert len(p100.lineas) == 1

# 7. P101 vacío: no se confirma ni se avisa
p101 = Pedido("P101")
otra_memoria = NotificadorMemoria()
try:
    confirmar_y_avisar(p101, otra_memoria)
except ErrorPedido as error:
    print("7. Rechazado:", error)
else:
    raise AssertionError("No debería confirmarse un pedido vacío")
assert p101.estado == "ABIERTO"
assert otra_memoria.mensajes == []

# 8. P102 con NotificadorPrefijo, sin tocar servicios.py
p102 = Pedido("P102")
p102.agregar_producto(raton, 1)
confirmar_y_avisar(p102, NotificadorPrefijo("CLASE"))  # CLASE: Pedido P102 confirmado: 1500 céntimos
assert p102.estado == "CONFIRMADO"

print("Reto final completado")
