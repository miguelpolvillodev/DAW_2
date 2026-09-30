nombre_app = "App nueva"
version = 2.1
modulos_totales = 4
en_produccion = True 

print("Nombre App:",nombre_app,"Version:",version,"Modulos",modulos_totales,"En produccion",en_produccion)
print("Tipo de variable de version:",type(version),"Tipo de variable de produccion:",type(en_produccion))

dato = "100"
dato = 100

print(type(dato))

#Input -> Escribir por consola devuelve str // casteos -> int(x), float(x)...
lenguaje = input("Lenguaje principal: ")
print("Has elegido:",lenguaje)