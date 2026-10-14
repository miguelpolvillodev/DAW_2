from aula.datos.memoria import crear_estado_inicial
from aula.dominio.modelos import EstadoAula
from prestamos_aula.aula.servicios.materiales import crear_material
from prestamos_aula.aula.dominio.errores import ErrorAula
from prestamos_aula.aula.servicios.materiales import listar_materiales


def main() -> None:
    estado: EstadoAula = crear_estado_inicial()

    try:
        material_id: str = crear_material(estado, "Tablet", 8)

        print("Identificador del material creado", material_id)
        print(listar_materiales(estado))
    except ErrorAula as error:
        print(error)

    try:
        material2_id: str = crear_material(estado, "TABLET", 2)
        print(listar_materiales(estado))
    except ErrorAula as error:
        print(error)

    print("el id del siguiente material tendra el valor", estado["siguiente_material"])


if __name__ == "__main__":
    main()
