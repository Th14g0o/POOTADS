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
            if (m == 28 and d > 28) or ((a % 4 == 0 and (a % 400 == 0 or a % 100 != 0)) and d > 29):
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

ex05()