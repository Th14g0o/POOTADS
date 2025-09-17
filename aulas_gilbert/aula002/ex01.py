class Triangulo:
    def __init__(self):
        self.b = 0 # atributo ou campo, variaveis do objeto
        self.h = 0

    def calc_area(self): # Metodo, função do objeto
        return self.b * self.h / 2 

x = Triangulo()
x.b = 10
x.h = 20

print(type(x), type(x.b), type(x.h))

t = Triangulo()
t.b = 30
t.h = 40

# print("Area x =", x.b * x.h / 2)
# print("Area t =", t.b * t.h / 2) # não mais necessario calcular a area aqui
print("Area x =", x.calc_area())
print("Area t =", t.calc_area())