# Streams

![Diagrama Streams](diagramaStream.png)

Substitui laços, codigos de inserção lista,  filtros, ...

Facilita a manipulação de coleções de dados

```java
package br.com.fabioalvaro.aula1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        System.out.println("Tutorial de Streams Java!! #Fabao");

        // Lista de Numeros da Mega Sena
        List<Integer> numerosDaMegaSenha = Arrays.asList(11, 12, 23, 32, 44, 50);

        // Java 8
        Optional<Integer> maximo = numerosDaMegaSenha.stream()
                .max(Comparator.naturalOrder()); // Pode retornar None por isso o Optional

        System.out.println("Máximo: " + maximo.get()); // impriome o maior valor
    }
}
```

```java
List<Integer> numerosDaMegaSenha = Arrays.asList(23,44,12,32,11,50);

// Lambda java 8
numerosDaMegaSenha.stream().forEach(e -> System.out.println(e));
```

## Operação Intermediaria

### SKIP
pula indices a partir do indice "0"

```java
// Lista de Numeros da Mega Sena
List<Integer> numerosDaMegaSenha = Arrays.asList(11,12,23,32,44,50);

// Lambda java 8
numerosDaMegaSenha.stream()
.skip(2)
.forEach(e -> System.out.println(e));
```
### LIMIT
Pega a partir do indice "0" a qtd de elementos definidas no seu parametro
```java
// Lista de Numeros da Mega Sena
List<Integer> numerosDaMegaSenha = Arrays.asList(11,12,23,32,44,50);

// Lambda java 8
numerosDaMegaSenha.stream()
.limit(2)
.forEach(e -> System.out.println(e));
```

### DISTINCT
Semelhante ao distinct do SQL ele não repete números no stream que esta chegando.

```java
// Lista de Numeros da Mega Sena
List<Integer> numerosDaMegaSenha = Arrays.asList(11,12,12,23,32,44,50,11,23);

// Lambda java 8
numerosDaMegaSenha.stream()
.limit(2)
.forEach(e -> System.out.println(e));
```

### FILTER
É um filtro personalizado no caso do skip, limit e distinct não serem suficientes para a sua lógica. permite adicioar uma condição. 

```java
// Lista de Numeros da Mega Sena
List<Integer> numerosDaMegaSenha = Arrays.asList(11,17,23,32,43,50);

// filtro que mostra apenas o numeros terminados com 3 e 7 :)
numerosDaMegaSenha.stream()
.distinct()
.filter(e -> e % 10 == 3 || e % 10 == 7)
.forEach(e -> System.out.println(e));
o resultado é esse:
```

### MAP transformação de dados
Apesar do nome ser map ele não tem nada a ver com hashmap, com a interface Map do Java. Esse map é uma transformação aplicada no stream.
lembrando que a lista original não é modificada. Ele faz a transformação no dado que esta passando no stream.

```java
 // Lista de Numeros da Mega Sena
 List<Integer> numerosDaMegaSenha = Arrays.asList(11,12,23,32,44,50);
 
 // multiplicando cada item por 2x
  numerosDaMegaSenha.stream()
  .distinct()
  .map(e -> e *2) 
  .forEach(e -> System.out.println(e));

  System.out.println("lista original > "+numerosDaMegaSenha);
```

## Operações finais com stream
Uma coisa importante sobre as operações finais é que uma fez chamada ela não pode utilizar novamente o stream . Nesse caso vamos tentar chamar duas vezes o foreach, Isso vai gerar um erro dizendo que o stream já foi fechado.

```java
// Lista de Numeros da Mega Sena
List<Integer> numerosDaMegaSenha = Arrays.asList(11, 12, 23, 32, 44, 50);

// Java 8
Stream<Integer> mapNumeros = numerosDaMegaSenha.stream()
        .limit(3)
        .map(e -> e * 2);

mapNumeros.forEach(e -> System.out.println(e));
mapNumeros.forEach(e -> System.out.println(e));
```

vai gerar erro:

```java
Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
        at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:229)
        at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:596)
        at br.com.fabioalvaro.aula1.Streams.main(Streams.java:21)
```

### FOREACH
Não é muito utilizado pois não retorna nada. é mais para inspecionar o stream.

```java
        // Lista de Numeros da Mega Sena
        List<Integer> numerosDaMegaSenha = Arrays.asList(11, 12, 23, 32, 44, 50);

       //Java 8
        numerosDaMegaSenha.stream()
                .limit(2)
                .map(e -> e * 2)
                .forEach(e -> System.out.println("O número é:"+ e));
```

### COUNT
Nos retorna a quantidade de itens que restaram no stream.

```java
// Lista de Numeros da Mega Sena
List<Integer> numerosDaMegaSenha = Arrays.asList(11, 12, 23, 32, 44, 50);

// Java 8
long contador = numerosDaMegaSenha.stream()
        .limit(3)
        .map(e -> e * 2)
        .count();
System.out.println("contador: " + contador);
```

### MIN
Nos retorna a quantidade de itens que restaram no stream.

```java
// Lista de Numeros da Mega Sena
List<Integer> numerosDaMegaSenha = Arrays.asList(11, 12, 23, 32, 44, 50);

// Java 8
Optional<Integer> minimo = numerosDaMegaSenha.stream()

        // .map(e -> e * 2)
        .min(Comparator.naturalOrder());

System.out.println("minimo: " + minimo.get());
```  
  
### MAX
De forma semelhante ao MIN o MAX retorna um Optional de inteiro no nosso caso e devolve o maior numero.

```java
package br.com.fabioalvaro.aula1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Streams {
  public static void main(String[] args) {
      System.out.println("Tutorial de Streams Java!! #Fabao");

      // Lista de Numeros da Mega Sena
      List<Integer> numerosDaMegaSenha = Arrays.asList(11, 12, 23, 32, 44, 50);

      // Java 8
      Optional<Integer> maximo = numerosDaMegaSenha.stream()
              .max(Comparator.naturalOrder());

      System.out.println("Máximo: " + maximo.get());
  }
}
```

## Tipos de Collect

### COLLECT
O min e max são padrão e se quisermos algo ainda mais personalizado podemos utilizar o collect(). O collect tem duas assinaturas um mais simples e outro com 3 parametros bem mais complicado.

#### Collectors .list()
Nesse exemplo pego somente os numeros pares da lista e crio uma nova variável, ou seja, coleto os itens do stream para uma lista. Fácil ne?

```java
// Lista de Numeros da Mega Sena
List<Integer> numerosDaMegaSenha = Arrays.asList(11, 12, 23, 32, 44, 50);

// Java 8
List<Integer> novaLista = numerosDaMegaSenha.stream()
.filter(e->e % 2==0) //numeros pares
        .collect(Collectors.toList());

System.out.println(novaLista);
```

#### Collectors.groupingBy()
Um outro coletor que podemos usar é o GroupingBy , nesse caso o retorno é uma mapa booleano e inteiros. Podemos agrupar por boolean, inteiro, tipos de clientes,etc o céu é o limite.
```java

        // Lista de Numeros da Mega Sena
        List<Integer> numerosDaMegaSenha = Arrays.asList(11, 12, 23, 32, 44, 50);

        // Java 8
        Map<Boolean,List<Integer>> mapaDeNumeros = numerosDaMegaSenha.stream()
                 .map(e->e * 3) // multiplico os numeros por 3
                .collect(Collectors.groupingBy(e -> e %2 ==0)); //devolvo duas listas com numeros pares e impares

       System.out.println(mapaDeNumeros);
```

#### Collectors.joining()
Nesse proximo exemplo vamos usar o colector que junta os itens e coloca um separador entre os itens. nesse caso um ";"

```java
// Lista de Numeros da Mega Sena
List<Integer> numerosDaMegaSenha = Arrays.asList(11, 12, 23, 32, 44, 50);

// Java 8
String coletado  = numerosDaMegaSenha.stream()
         .map(e-> String.valueOf(e)  ) 
        .collect(Collectors.joining(";")); 
System.out.println(coletado);
```