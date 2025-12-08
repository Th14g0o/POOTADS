# Herança e Polimorfismo

## Conceitos base

### Abstração

* Representação computacional de um objeto real. 
* Representação que se concentra nas características que são relevantes para o problema

### Encapsulamento

* Esconder dados que não são necessarios pro "front"/cliente. 

### Modularidade

* Compor o sitema de objetos altamente coesos e fracamente acoplados.
* Onjetos colaboram entre si atraves de seus metodos.
> Classe Motorista chama metodo Freio da Classe Catrto

### Hierarquia

* Objetos devem ser organizados no sistema de forma hierárquica. Do mais generico pro mais especifico.
> Animal - Mamifero - Morcego. 3 gerações.
* Objetos herdam atributos e métodos dos seus ancestrais, caso possuam, na hierarquia.

## Herança

* Permite levar metodos e atributos de um classe pai para filho. Deixando o generico comum, mas permite levar em consideração as particularidades do filho. 

```java
class Animal {}
class Mamifero extends Animal {}
class Humano extends Mamifero {} // herda tudo de mamifero e animal, mas permite 
                                 // especificar com atributos ou metodos especificos
```

* A classe que forneceu os elementos herdados é chamada de ```superclasse```
* A classe herdeira é chamada de ```subclasse```
* A ```subclasse``` pode ```herdar``` os métodos e atributos de suas ```superclasses``` que estão publicos ou protegidos.

> Protegido: É privado pro programa mas não para as subclasses

* A subclasse pode definir novos atributos e métodos específicos(```especializar```) 
* Sem necessidade de redeclarar atributos ou metodos da superclasse. 
* Permite sobrescrever(redefinir) metodos da superclasse.(Polimorfismo)
* Em java só pode se herdar uma classe.
* Toda classe é uma subclasse da classe Object
* Objetos de uma subclasse podem ser atribuidas para uma super classe
* Qualquer ```subclasse``` é ```compatível``` com a sua ```superclasse```(Compatibilidade de tipos)
```java
public void static main(String[] args){
  Humano h = new Humano();
  Animal a = h; // ponteiro para variavel h
  dorme(a); // bota h para "dormir"
}
public void dorme(Animal){
  // faz algo
}
```

> Leitura: Um Humano é um Mamifero, um Mamifero é um Animal, um Humano é um Animal.

## Polimorfismo
Uma subclasse pode redefinir (sobrescrever) um método herdado
* Este mecanismo é chamado de polimorfismo
* O polimorfismo se realiza através da recodificação de um ou mais métodos herdados por uma subclasse
* Em tempo de execução, o Java saberá qual implementação deve ser usada