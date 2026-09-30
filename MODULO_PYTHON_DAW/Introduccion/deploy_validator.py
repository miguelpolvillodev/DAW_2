#1 y 2 Parámetros
nombre_app = str(input("Introduce el nombre de al App: "))
entorno_destino = str(input("Introduce el entorno de destino: "))
ram = int(input("Introduce GB de memora RAM: "))
latencia = float(input("Introduce los ms: "))
max_euros_diarios =float(input("Introduce el máximo de euros diarios: "))
respuesta_ssl= str(input("Está activo el certificado?: S/N"))

ssl_activo = respuesta_ssl == "s"

#3 Operaciones aritmeticas
coste_hora = max_euros_diarios / 24

totales = 1050
contenedor = 100
se_llenaran = totales // contenedor 
exceso = totales % contenedor

#4 Evaluacion de expresiones
despliegue_true = entorno_destino == "produccion" and ram>=8 and latencia <=50.0 and ssl_activo == True or (entorno_destino != "produccion") and ram >=2

#5 Salida formateada
print("Nombre de la App: ", nombre_app)
print("Entorno de destino: ", entorno_destino)
print("Memoria Ram: ", ram)
print("Latencia: ", latencia)
print("Coste hora: ", coste_hora)
print("Contenedores llenos: ", se_llenaran)
print("Exceso de contenedores: ", exceso)
print("Indicador de certificado SSL activo", ssl_activo)
print("Despliegue: ", despliegue_true)
print(type(ram))
print(type(coste_hora))
print(type(despliegue_true))
