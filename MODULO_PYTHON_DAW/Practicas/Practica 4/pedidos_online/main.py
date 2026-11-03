from tienda.errores import ErrorPedido
from tienda.notificaciones import NotificadorConsola, NotificadorMemoria, NotificadorPrefijo
from tienda.pedido import Pedido
from tienda.producto import Producto
from tienda.servicios import confirmar_y_avisar


def main() -> None:
    teclado = Producto("TEC", "Teclado", 2500)
    raton = Producto("RAT", "Ratón", 1500)

    
    print(teclado)
    print(repr(teclado))
    otro = Producto("TEC", "Teclado", 2500)
    print("Iguales:", teclado == otro, "| Mismo objeto:", teclado is otro)

    try:
        Producto("TEC", "Teclado", True)
    except ValueError as error:
        print("Datos inválidos:", error)

    
    p1 = Pedido("P001")
    p1.agregar_producto(teclado, 2)
    p1.agregar_producto(raton, 1)
    print(p1)
    p1.quitar_producto("RAT")
    print("Tras quitar el ratón:", p1.total_centimos)

   
    try:
        p1.quitar_producto("XXX")
    except ErrorPedido as error:
        print("Rechazado:", error)

    # Etapa 05: ABC
    confirmar_y_avisar(p1, NotificadorConsola())
    try:
        p1.agregar_producto(raton, 1)
    except ErrorPedido as error:
        print("Rechazado:", error)
    p1.cancelar()
    print(p1)

    p2 = Pedido("P002")
    p2.agregar_producto(teclado, 2)
    memoria = NotificadorMemoria()
    confirmar_y_avisar(p2, memoria)
    print("En memoria:", memoria.mensajes)

    
    p3 = Pedido("P003")
    p3.agregar_producto(teclado, 2)
    confirmar_y_avisar(p3, NotificadorPrefijo("TIENDA"))
    print(p3)


if __name__ == "__main__":
    main()
