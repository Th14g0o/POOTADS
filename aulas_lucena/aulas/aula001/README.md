# Introdução

## IDE
IntelliJ, vsCode

## Compilador Java
[JavaC - Java Downloads | Oracle](https://www.oracle.com/java/technologies/downloads/#java8-windows)

## Compilar:
* javac arquivo.java gera .class que pode ser rodado em qulquer ambiente virtual java
* para rodar java arquivo.java
```bash
PS C:\Users\20251014040033\repos\POOTADS\aulas_lucena\aula001> java .\HelloWorld.java
Hello, World!
PS C:\Users\20251014040033\repos\POOTADS\aulas_lucena\aula001> javac --version
javac 17.0.16
PS C:\Users\20251014040033\repos\POOTADS\aulas_lucena\aula001> javac .\HelloWorld.java
PS C:\Users\20251014040033\repos\POOTADS\aulas_lucena\aula001> java HelloWorld     
Hello, World!
```

O .class pode ser executado também em linux, diferentemente do .exe gerado pelo C++

## Classe
java usa aplica POO na maioria das funcionalidades. então sempre vai ter um objeto responsalvel por algo. Para ser rodavel a classe principal tem que ter o mesmo nome de arquivo. recomendado ter uma classe por arquivo.

### Declaração
```java
class HelloWorld{
    //resto do codgio
}
```

## Main
Podemos criar esse metodo em qualquer uma de nossas classes, é ele que vai rodar de fato geralmente.

### Declaração
```java
public static void main(String[] args){
    System.out.print("Hello, World!");
}
```

## Prints
* System.out.print("\n") printa sem quebra de linha mas pode ser adicionado com \n
* System.out.println("") printa com quebra de linha
* System.out.printg("%s") printa sem quebra de linha mas pode ser adicionado com \n, e permite formatar valores