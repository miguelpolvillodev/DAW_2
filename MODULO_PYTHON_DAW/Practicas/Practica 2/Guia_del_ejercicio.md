# Validador modular de despliegues
## Práctica de integración de los días 1 y 2
Duración: 60 minutos. Python 3.13 o superior. Trabajo individual.

Vas a transformar el validador del primer día en una aplicación pequeña organizada en paquetes. No despliega nada: calcula recursos y decide si una configuración puede aceptarse según unas reglas. La estructura, la entrada por teclado y las pruebas están preparadas.

## Qué entregarás
La carpeta proyecto_base con los seis TODO completados, sus type hints conservados y las pruebas del contrato superadas. El uso de IA es opcional y no se evalúa.

## Arranque
Abre proyecto_base en VS Code y selecciona el intérprete de Python 3.13 o superior. Ejecuta desde la carpeta que contiene main.py.
```powershell
python --version
python main.py
python -m unittest discover -s tests -v
```
Para la primera ejecución introduce: api_clase, produccion, 8, 50, 48 y s, una respuesta por pregunta. El mensaje PENDIENTE y varias pruebas fallidas son normales al principio. El temporizador devuelve provisionalmente la función original y todavía no imprime métricas. Busca TODO en el editor: hay seis tareas, no hay que reescribir todo el proyecto.


---

# El proyecto y su contrato
## Localiza cada responsabilidad
```text
proyecto_base/
  main.py                   entrada a la aplicación
  sistema_despliegues/
    __init__.py             API pública e import relativo
    dominio/
      modelos.py            campos de Configuracion
      errores.py            TODO 1
    servicios/
      calculos.py           TODO 2 y 3
      decoradores.py        TODO 4
      validacion.py         TODO 5
    infraestructura/
      entrada.py            input y conversiones ya preparados
      salida.py             TODO 6 y resumen preparado
      sonda.py              reintentos simulados ya preparados
  tests/test_contrato.py    pruebas ya preparadas
  AGENTS.md                 reglas opcionales si se usa IA
```
Todas las carpetas del paquete llevan __init__.py. Configuracion es un diccionario con claves y tipos descritos en modelos.py; puedes usar config["ram_gb"] como en cualquier diccionario. No necesitas implementar una clase de modelo.

## Reglas que debes respetar
Datos inválidos: nombre vacío, entorno distinto de desarrollo/staging/produccion, RAM menor o igual a cero, latencia o presupuesto negativos o no finitos. Esa comprobación ya está implementada y se conserva. La entrada convierte RAM con int, latencia y presupuesto con float, y SSL mediante respuesta == "s". Las respuestas SSL diferentes de s/n se rechazan.

Producción apta: entorno == "produccion", RAM >= 8, latencia <= 50.0 y SSL activo. Las cuatro condiciones deben cumplirse.

Pruebas aptas: entorno desarrollo o staging y RAM >= 2. No se exige SSL ni un límite de latencia de 50 ms, aunque los datos deben seguir siendo válidos.

Si alguna regla de aptitud se cumple, validar_despliegue termina y devuelve None. Si no, lanza DespliegueNoAptoError. El presupuesto solo interviene en el cálculo del coste, no decide la aptitud. Son reglas didácticas, no una política real de despliegue.


---

# Completa los errores y los cálculos
## TODO 1 Excepción con contexto
Archivo: dominio/errores.py. Se entrega la jerarquía ErrorDespliegue, DatosInvalidosError y DespliegueNoAptoError. Completa únicamente el constructor de esta última.
```python
def __init__(self, nombre: str, motivo: str) -> None:
    ...
```
Guarda nombre y motivo en atributos str. Llama a super().__init__ con un mensaje que incluya ambos. Retira el NotImplementedError. La captura puede leer error.motivo sin analizar el mensaje. No captures BaseException.

## TODO 2 Argumentos posicionales variables
Archivo: servicios/calculos.py. Completa calcular_coste_hora.
```python
def calcular_coste_hora(*partidas: float) -> float:
    ...
```
partidas es una tupla de presupuestos diarios. Devuelve su suma dividida entre 24. Ejemplos de aceptación: sin argumentos devuelve 0.0; con 48.0 devuelve 2.0; con 24.0 y 48.0 devuelve 3.0. Usa sum(partidas). No redondees dentro de la función; el formato de salida usa dos decimales.

## TODO 3 Operadores y retorno de varios resultados
Archivo: servicios/calculos.py. Completa calcular_recursos conservando la validación inicial.
```python
def calcular_recursos(
    peticiones: int, capacidad: int = 100
) -> tuple[int, int]:
    ...
```
Devuelve una tupla: contenedores completos con // y peticiones sobrantes con %. Para 1050 peticiones y capacidad 100, el resultado es (10, 50). El 50 representa peticiones, no otro contenedor completo. Para 0, devuelve (0, 0); para 100, (1, 0).

## TODO 5 Expresiones booleanas y errores de negocio
Archivo: servicios/validacion.py. La primera parte ya valida los datos. En el TODO define dos variables bool con las reglas de la página anterior. Combínalas con or. Si ambas son False, usa raise DespliegueNoAptoError(config["nombre"], motivo). Si alguna es True, termina sin lanzar un error. Conserva @temporizador.


---

# Completa el decorador y el registro
## TODO 4 Envolver una función
Archivo: servicios/decoradores.py. Se entregan los imports y la firma. Sustituye return func, que es un retorno provisional, por el decorador completo. No añadas print a validacion.py para medir tiempos.
```python
def temporizador(
    func: Callable[[Configuracion], None],
) -> Callable[[Configuracion], None]:
    ...
```
Callable describe una función que recibe Configuracion y devuelve None. Sigue estos pasos:
- Define dentro una función wrapper(config: Configuracion) -> None y aplícale @wraps(func).
- Guarda inicio: float con time.perf_counter().
- En un try, llama a func(config). En un finally, calcula duracion: float y muestra una línea que contenga [MÉTRICA], func.__name__ y la duración.
- Devuelve wrapper desde temporizador sin ejecutarlo: no escribas wrapper(config) en ese retorno.
wrapper recuerda func: es una clausura. finally debe imprimir la métrica tanto en casos aptos como rechazados. Se mide la validación, no el tiempo de entrada. No necesitas clases ni genéricos avanzados.

## TODO 6 Argumentos nombrados variables
Archivo: infraestructura/salida.py. Completa el retorno de registrar_evento. La construcción de detalles ya está preparada.
```python
def registrar_evento(evento: str, **metadatos: object) -> str:
    ...
```
Devuelve evento, el separador " | " y detalles. **metadatos recoge los argumentos nombrados adicionales en un diccionario. Ejemplo: registrar_evento("AUDIT", usuario="ana", apto=True) devuelve "AUDIT | usuario=ana, apto=True". object permite valores de distintos tipos sin perder la anotación.

## Lee también lo que se entrega completo
main.py usa la API pública, captura errores y llama a mostrar_resumen(..., apto=apto). En mostrar_resumen, el * solo exige que apto se pase por nombre: no recoge argumentos.
entrada.py transforma ValueError en DatosInvalidosError mediante raise ... from error. Así se conserva la causa técnica mientras se muestra un mensaje comprensible.
```powershell
python -m sistema_despliegues.infraestructura.sonda
```
La sonda falla dos veces por conexión y funciona en el tercer intento. Lee su decorador: reintenta ConnectionError, no reglas de negocio. No tienes que modificarlo. Si un import falla, confirma que ejecutas desde proyecto_base; no cambies sys.path para ocultar un error de estructura.


---

# Comprueba y entrega
## Casos de aceptación
- Producción, 8 GB, 50 ms, SSL sí: apto. Con presupuesto 48 euros, coste por hora 2.00 euros y recursos (10, 50).
- Producción, 7 GB, 50 ms, SSL sí: no apto, con mensaje de negocio y resumen apto=False.
- Producción, 8 GB, 50.1 ms, SSL sí: no apto. Producción sin SSL: no apto.
- Staging, 2 GB, 200 ms, SSL no: apto. Staging con 1 GB: no apto.
- Entorno desconocido, RAM cero o número escrito como "ocho": datos incorrectos y salida comprensible.
```powershell
python main.py
python -m unittest discover -s tests -v

Ejecutar unittest: verifica el mismo contrato sin instalaciones. Hay 15 pruebas; en la solución pasan todas. Algunas agrupan varios casos frontera.

## Ayuda opcional con IA
Puedes completar la práctica y obtener toda la puntuación sin utilizar IA. Si eliges usar un agente ya configurado, puedes pedir una revisión con este prompt: "Lee AGENTS.md y revisa sistema_despliegues/servicios/validacion.py según el contrato. No modifiques archivos. Comprueba RAM 8, latencia 50 y SSL activo en producción; y staging con RAM 2, latencia 200 y sin SSL. Señala un hallazgo con evidencia y propone una prueba. No cambies las firmas".

Comprueba cualquier propuesta con el contrato y las pruebas antes de aceptarla. No tienes que enviar prompts, capturas, informes ni evidencias del uso de IA. La revisión es una ayuda accesoria, no una tarea obligatoria.

No necesitas instalar agentes, arneses ni memoria para resolver el ejercicio. AGENTS.md solo sirve como contexto para quien utilice IA.

## Lista de entrega
Comprueba que no quedan tareas pendientes: el decorador ya no devuelve directamente func, los demás TODO no contienen NotImplementedError, mantienes las firmas tipadas y las pruebas pasan. Verifica que la métrica aparece con datos aptos y rechazados y se conserva el nombre validar_despliegue. No se exige una duración concreta. Entrega solo tu proyecto, sin .venv ni carpetas de caché.