# Record

- Classe simplificada
- Imutavel
- Geram metodos como quals, hashCode, toString 
- São declarados como palavvra chavve

### Sintaxe:
```java
record Pessoa(String nome, int idade) {// entende os parametros como atributos
    // Metodos aqui(opcional, se pode deixar as chaves vazias)
    // Possui metodos como quals, hashCode, toString  
}

// Equivale com a classe abaixo

class Pessoa{
    final private String nome;
    final private int idade;
    public Produto(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }
    public String nome(){return this.nome;}
    public String idade(){return this.idade;}
    // metodos utils(como equals, hashCode, toString)
}
```

> o "const" em java é "final", e ambos são palavras reservadas para valores constantes
```java
final double a = 0; // variavel constante
```

### Exemplo:
```java
record Pessoa(String nome, int idade) {}

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("João", 25);
        System.out.println(pessoa.nome()); // João
        System.out.println(pessoa.idade()); // 25
        System.out.println(pessoa); // Pessoa[nome=João, idade=25]
    }
}
```

## Customização

- Construtor
> Valida valores. Não exige parametros, pois usa os do record
```java
record Pessoa(String nome, int idade) {
    // Construtor personalizado
    public Pessoa {
        if (idade < 0) {
            throw new IllegalArgumentException("Idade não pode ser negativa!");
        }
    }
}
```
- Novos
> PErmite adicionar novos metodos
```java
record Pessoa(String nome, int idade) {
    // Método personalizado
    public String saudacao() {
        return "Olá, meu nome é " + nome + " e tenho " + idade + " anos.";
    }
}
```

## Coleções

Records podem ter atributos que são referencias a coleções.

```java
import java.util.List;

record Turma(String nome, List<String> alunos) {
    public Turma {
        // Torna a lista imutável
        alunos = List.copyOf(alunos); // sem o copy o atributo guardaria a referencia e seria possivel mudar o valor aqui alterando por fora
    }
}
```

Uso:
```java
public class Main {
    public static void main(String[] args) {
        Turma turma = new Turma("Matemática", List.of("Ana", "João", "Maria"));
        System.out.println(turma.alunos()); // [Ana, João, Maria]
    }
}'
```
