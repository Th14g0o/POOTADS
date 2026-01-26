x = 5
y = 5
print(type(x))
print(id(x))
print("id y =", id(y)) # Existe um 5 na memoria então recebem o mesmo id(não é toda linguagem que trata assim)
x = "Teste"
print(type(x))
print(id(x))
print("-----")
z = print # não chama, atribui a funcão print a z
z("Olá")
print(type(z)) 
print(z) 
z = print("Olá")
print(z) # printa nada, portanto None