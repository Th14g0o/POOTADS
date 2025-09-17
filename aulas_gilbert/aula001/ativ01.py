def ex01():
    pares = 0 
    impares = 0
    print("informe 4 numeros:")
    for i in range(4):
        n = int(input())
        if n % 2 == 0:
            pares += n
        else:
            impares += n
    print("Soma dos Pares = {}\n Soma dos Impares {}".format(pares, impares))

def ex02():
    mes = int(input("Informe o mês\n"))

    msg = "O mês de "
    if   mes == 1:
        msg += "Janeiro"
    elif mes == 2:
        msg += "Fevereiro"
    elif mes == 3:
        msg += "Março"
    elif mes == 4:
        msg += "Abril"
    elif mes == 5:
        msg += "Maio"
    elif mes == 6:
        msg += "Junho"
    elif mes == 7:
        msg += "Julho"
    elif mes == 8:
        msg += "Agosto"
    elif mes == 9:
        msg += "Setembro"
    elif mes == 10:
        msg += "Outubro"
    elif mes == 11:
        msg += "Novembro"
    else:
        msg += "Dezembro"

    if mes <= 3:
        msg += " é do primeiro trimeste"
    elif mes <= 6:
        msg += " é do segundo trimestre"
    elif mes <= 9:
        msg += " é do terceiro trimestre"
    else:
        msg += " é do quarto trimestre"

def ex03():
    ns = []
    print("informe 4 numeros:")
    for i in range(4):
        ns.append(int(input()))
    ns.sort()
    print("Maior valor = {}\nMenor valor = {}\nSoma do segundo maior valor com o segundo menor = {}".format(ns[3], ns[0], ns[1] + ns[2]))

def ex04():
    try:
        d, m, a = map(int, input("Digite uma data no formato dd/mm/aaaa\n").split('/'))
        if 1900 <= a <= 2100 and d >= 1: 
            if m < 1 or m > 12:
                print("a data informada não é valida")
            if m in (1, 3, 5, 7, 8, 10, 12) and d > 31:
                print("a data informada não é valida")
            if m in (4, 6, 9, 11) and d > 30:
                print("a data informada não é valida")
            if (m == 28 and d > 28) or (((a % 4 == 0 and a % 100 != 0) or (a % 400 == 0)) and d > 29):
                print("a data informada não é valida")
        else:
            print("a data informada não é valida")
    except:
        print("a data informada não é valida")

def ordem(lista_ns : list):
    if len(lista_ns) < 2:
        return lista_ns

    ns = lista_ns.copy()
    ns_sort = [] 
    
    while len(ns) != 0:
        menor = None
        index = None
        for i in range(len(ns)):
            n = ns[i]
            if menor == None or n < menor:
                menor = n
                index = i
        if index != None:
            ns_sort.append(ns[index])
            ns.pop(index)
    return ns_sort             
def ex05():
    ns = []
    print("informe 3 numeros:")
    for i in range(3):
        n = int(input())
        ns.append(n)
    print(*ordem(ns))

def ex06():
    ns = ""
    for i in range(10):
        ns += str(i + 1 if i % 2 == 0 else -(i+1)) + (" " if  i < 9 else "") 
    print(ns)

def ex07():
    palavras = input("Digite uma frase:\n").split()
    print("")
    for i in range(len(palavras)):
        for j in range(i, len(palavras)):
            print(palavras[j], end=" ")
        print("")

def ex08():
    texto = input("Digite uma frase:\n")
    print("")
    for i in range(len(texto)):
        print(texto[i+1:len(texto)] + texto[0:i+1])

def ex09():
    palavras = input("Digite uma frase:\n").split()
    print("")
    for p in palavras:
        p_i = ""
        for i in range(len(p) - 1, -1, -1):
            p_i += p[i]
        print(p_i)

def ex10():
    for i in range(1, 11):
        linha = str(i)
        for j in range(1, i + 1):
            if j % 2 == 0 and j <= i:
                linha += " " + str(j)
        print(linha)

def Diagonal(b, h):
    return (b**2 + h**2)**(1/2)
def ex11():
    b = float(input("Base: "))
    h = float(input("Altura: "))
    print("Diagonal = {:.2f}".format(Diagonal(b, h)))

def MenorInteiro(x):
    if x < 0 and x != int(x):
        return int(x) - 1
    return int(x)
def ex12():
    x = float(input("Digite um número real: "))
    print("Menor inteiro = {}".format(MenorInteiro(x)))


ex11()