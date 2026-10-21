from aula.dominio import (
    Alumno,
    CantidadInvalidaError,
    ErrorAula,
    EstadoAula,
    Material,
    Prestamo,
    Resumen,
)
from aula.servicios import (
    consultar_prestamos,
    crear_alumno,
    crear_material,
    devolver_material,
    listar_alumnos,
    listar_materiales,
    obtener_resumen,
    prestar_material,
)


# ---------- Entrada ----------

def leer_entero(mensaje: str) -> int:
    texto: str = input(mensaje).strip()
    try:
        return int(texto)
    except ValueError as error:
        raise CantidadInvalidaError(f"'{texto}' no es un número entero") from error


def leer_identificador(mensaje: str) -> str:
    return input(mensaje).strip().upper()


# ---------- Presentación ----------

def mostrar_materiales(materiales: list[tuple[str, Material]]) -> None:
    if not materiales:
        print("No hay materiales registrados.")
        return
    for material_id, material in materiales:
        prestadas: int = material["total"] - material["disponibles"]
        print(
            f"{material_id} | {material['nombre']} | total: {material['total']} | "
            f"disponibles: {material['disponibles']} | prestadas: {prestadas}"
        )


def mostrar_alumnos(alumnos: list[tuple[str, Alumno]]) -> None:
    if not alumnos:
        print("No hay alumnos registrados.")
        return
    for alumno_id, alumno in alumnos:
        estado_texto: str = "activo" if alumno["activo"] else "inactivo"
        print(f"{alumno_id} | {alumno['nombre']} | {estado_texto}")


def mostrar_prestamos(prestamos: list[tuple[str, Prestamo]]) -> None:
    if not prestamos:
        print("No hay préstamos que mostrar.")
        return
    for prestamo_id, prestamo in prestamos:
        situacion: str = "completado" if prestamo["pendientes"] == 0 else "abierto"
        print(
            f"{prestamo_id} | alumno: {prestamo['alumno_id']} | "
            f"material: {prestamo['material_id']} | cantidad: {prestamo['cantidad']} | "
            f"pendientes: {prestamo['pendientes']} | {situacion}"
        )


def mostrar_resumen(resumen: Resumen) -> None:
    print(f"Tipos de material: {resumen['tipos_material']}")
    print(f"Alumnos registrados: {resumen['alumnos_registrados']}")
    print(f"Unidades totales: {resumen['unidades_totales']}")
    print(f"Unidades disponibles: {resumen['unidades_disponibles']}")
    print(f"Unidades prestadas: {resumen['unidades_prestadas']}")
    print(f"Materiales agotados: {resumen['materiales_agotados']}")
    print(f"Préstamos pendientes: {resumen['prestamos_pendientes']}")


# ---------- Menú ----------

def mostrar_menu() -> None:
    print()
    print("1. Mostrar materiales")
    print("2. Crear material")
    print("3. Mostrar alumnos")
    print("4. Crear alumno")
    print("5. Registrar préstamo")
    print("6. Registrar devolución")
    print("7. Consultar préstamos pendientes")
    print("8. Consultar historial de un alumno")
    print("9. Mostrar resumen")
    print("0. Salir")


def ejecutar_menu(estado: EstadoAula) -> None:
    while True:
        mostrar_menu()
        opcion: str = input("Opción: ").strip()
        try:
            if opcion == "0":
                print("Hasta luego.")
                break
            elif opcion == "1":
                mostrar_materiales(listar_materiales(estado))
            elif opcion == "2":
                nombre: str = input("Nombre del material: ")
                cantidad: int = leer_entero("Cantidad: ")
                print(f"Material creado: {crear_material(estado, nombre, cantidad)}")
            elif opcion == "3":
                mostrar_alumnos(listar_alumnos(estado))
            elif opcion == "4":
                nombre_alumno: str = input("Nombre del alumno: ")
                print(f"Alumno creado: {crear_alumno(estado, nombre_alumno)}")
            elif opcion == "5":
                alumno_id: str = leer_identificador("Identificador del alumno: ")
                material_id: str = leer_identificador("Identificador del material: ")
                cantidad_prestamo: int = leer_entero("Cantidad: ")
                prestamo_id: str = prestar_material(
                    estado, alumno_id, material_id, cantidad_prestamo
                )
                print(f"Préstamo registrado: {prestamo_id}")
            elif opcion == "6":
                prestamo_dev: str = leer_identificador("Identificador del préstamo: ")
                cantidad_dev: int = leer_entero("Cantidad a devolver: ")
                pendientes: int = devolver_material(estado, prestamo_dev, cantidad_dev)
                print(f"Devolución registrada. Unidades pendientes: {pendientes}")
            elif opcion == "7":
                mostrar_prestamos(consultar_prestamos(estado, solo_pendientes=True))
            elif opcion == "8":
                alumno_historial: str = leer_identificador("Identificador del alumno: ")
                mostrar_prestamos(consultar_prestamos(estado, alumno_historial))
            elif opcion == "9":
                mostrar_resumen(obtener_resumen(estado))
            else:
                print("Opción no válida.")
        except ErrorAula as error:
            print(f"Error: {error}")
