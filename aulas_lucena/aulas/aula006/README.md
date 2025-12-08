# Interfaces

Tipo especial de classe, que não tem implementação

Uma interface define um protocolo

Classes podem implementar uma ou mais interfaces

Contrato que um classe segue. Os metodos e constantes da interface devem existir na classe. 

Na interface tudo é publico.

A interface exige que classes que a implementam declarem seus metodos, por isso o termo contrato.

List<String> -> List é uma interface. que vai trabalhar com um tipo. mas ela pode receber tanto um ArrayList<>() quanto um LinkedList<>() que impplementa os elementos da interface List

exemplo USB do celular, possui varios cabos mas um carregador funciona diferente de conecatar ao pc por exemplo.

pode servir para conter varias classes em um arquivo

## Declaração

A definição de uma interface é similar a de uma classe
* Utilizamos a palavra reservada interface
* A palavra reservada deve ser seguida do nome da interface
* Uma interface pode herdar de outras interfaces (extends)
* A interface possui apenas métodos sem implementação (abstratos) e constantes
* Pode ter varios implements

```java
public interface Taxavel{
    int ANO_INICIO = 1996;
    double calculaTaxa ();
}
```

```java
public class CarroImportado extends Carro implements Taxavel 
{
    // <atributos da CarroImportado>
    // <métodos da CarroImportado> 
    
    // <métodos implementados da interface Taxavel>
    double calculaTaxa (){
        return 0;
    };

}
```

## Comparable <T>

proble: organizar numeros não é porblema, nem string, mas como se organizaria Pessoa?

Define criterio de organização.  É uma interface que tem que ser implementada em uma classe para ser ordenada.

```java 
class Tipo extends Comparable<Pessoa>{
    // atributos e metodos
    @Override
    public int compareTo(Tipo outra){ // metodo da interface
        // ordena por nome, ordem alfabetica
        return this.name.compareTo(outra.nome);
    }
}
```

```java 
class Tipo extends Comparable<Pessoa>{
    // atributos e metodos
    @Override
    public int compareTo(Tipo outra){ // metodo da interface
        // ordena por idade, ordem crescente
        return Integer.compare(this.idade, outra.idade);
    }
}
```

Observações
* Para ordenar em ordem decrescente, basta inverter: return -this.nome.compareTo(outra.nome);
* Se precisar de mais de um critério (ex: idade, depois nome):

```java 
@Override
public int compareTo(Pessoa outra) { // multiplo criterio
    int comp = Integer.compare(this.idade, outra.idade);
    if (comp != 0) return comp;
    return this.nome.compareTo(outra.nome);
}
```