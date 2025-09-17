# Entidade
class Triangulo():
	def __init__(self):
		self.b = 0
		self.h = 0
	def calc_area(self):
		return self.b * self.h /2

# Interface com Usuario
x = Triangulo()
x.b = float(input("Base: "))
x.h = float(input("Altura: "))
print("Area = ", x.calc_area())