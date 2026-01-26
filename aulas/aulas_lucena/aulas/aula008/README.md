# Abstrata

São especies de interfaces pensadas para herança. Interface > Classe Abstrata > Herança é um fluxo comun. 

Elas não podem ser instanciados. 

sua criação já e pensada na subclasse.

Possui atributos e metodos comuns, mas alem disso possui metodos abstratos, que exige a implementação na subclasse.

## Sintaxe

```java
abstract class Carro
{
  // <atributos da classe Carro>
  // <métodos comuns da classe Carro>
  // <métodos abstratos da classe Carro>
}

```

## Exemplo

```java
public abstract class Pagamento {
  public abstract void paga(...);
}
```

```java
public class PagamentoVisa extends Pagamento {
  // ...
  public void paga(...) {
    // código de pagamento com cartão Visa
  }
}
```