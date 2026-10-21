from aula.datos import crear_estado_inicial
from aula.dominio import EstadoAula
from aula.interfaz import ejecutar_menu


def main() -> None:
    estado: EstadoAula = crear_estado_inicial()
    ejecutar_menu(estado)


if __name__ == "__main__":
    main()
