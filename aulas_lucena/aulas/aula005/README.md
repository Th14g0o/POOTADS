# Coleções

O pacote java.util.* define diversas estruturas de 
dados

As estruturas implementam interfaces padrões:
* Lista: List
* Conjunto: Set
* Dicionário: Map

Cada interface tem uma implementação padrão 
(usualmente utilizada pelos programadores)
* Lista: ArrayList
* Conjunto: HashSet
* Dicionário: HashMap

### Percorrer coleção
```java
for (Pessoa pessoa : pessoas) { 
  System.out.print(pessoa.getNome() + " tem " + pessoa.getIdade() + " anos."); 
}
```

## List
Vetores Dinâmicos

A lista pode conter qualquer tipo de objeto Java, em
qualquer quantidade

Os elementos podem ser acessados em qualquer 
ordem.

são indexados.

### Declaração
```java
List pessoas = new ArrayList<>() 
```

### Principais métodos
    add(elemento): adiciona elemento no final da lista
    add(posição, elemento): adiciona elemento em uma posição da lista
    set(posição, elemento): troca o elemento em uma posição da lista
    remove(elemento): remove um elemento da lista
    remove(posição): remove o elemento que está em uma posição da lista
    clear(): remove todos os elementos da lista
    get(posição): retorna o elemento em uma posição da lista
    indexOf(elemento): retorna a posição de um elemento da lista
    isEmpty(): informa se a lista está vazia
    size(): informa o número de elementos da lista
### Ver demais métodos em 
    http://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html

## Set
conjuntos  dinâmicos.

Equivalente a lista, porém não impõe ordem aos elementos e não permite duplicata.

Ignora elementos repetidos(só considera 1). Se percorrer usando foreach a ordem é aleatoria.

A forma de pegar o valor e procurando por ele.

internamente não tem uma ordem.

### Declaração
```java
Set palavras = new HashSet<>()
```

### Principais métodos:
  add(elemento): adiciona elemento no conjunto
  remove(elemento): remove um elemento do conjunto
  clear(): remove todos os elementos da lista
  contains(elemento): informa se o elemento está no conjunto
  isEmpty(): informa se o conjunto está vazio
  size(): informa o número de elementos do conjunto

### Ver demais métodos em 
  http://docs.oracle.com/javase/8/docs/api/java/util/Set.html

## Dicionario
Guardar valores associados com uma chave.

a chave é como o indeice.

internamente não tem uma ordem.

### Declaração
```java
Map<String, String> dddPorMunicipio = new HashMap<>()
// tipo da chave e tipo do valor
```

### Principais métodos:
* put(chave, valor): adiciona uma chave indexando um valor no dicionário
* get(chave): retorna o valor indexado pela chave, gera exeção se não encontra
* getOrDefault(chave, valor): retorna o valor indexado pela chave ou o valor default informado, para evitar erro
* keySet(): retorna um conjunto com todas as chaves do dicionário, pode ser pecorrido e no foreach com o valor da chave pegamos o valor associado
* remove(chave): remove o valor indexado pela chave no dicionário
* clear(): remove todas as entradas do dicionário
* isEmpty(): informa se o dicionário está vazio
* size(): informa o número de entradas do dicionário

### Ver demais métodos em 
http://docs.oracle.com/javase/8/docs/api/java/util/Map.html
