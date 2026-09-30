rol = input("Dime tu rol: ")
antiguedad_meses = int(input("Dime tu antiguedad en meses: "))
respuesta_super = input("Eres superusuario? s/n")



if respuesta_super.__contains__("s") or rol == "admin" and antiguedad_meses >=12 :
    permiso = True 
else : 
    permiso = False 

print("Super usuario: ",permiso)