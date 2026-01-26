# POO

Modelagem de algo real. 

seus membros são:
* Atributos: dados
* Metodos: funções internas da classe

podemos sobrescrever ações padrãos do java nessa classe como sua exibição

seus membros podem ser privados, publicos, protegidos,...

## Criação
```java
class Retangulo{
    public double largura;
    public double altura; // atributo

    public double area(){
        return this.largura * altura; // this. é opcional, mas pode servir para quando o parametro tiver o mesmo nome do atributo
    }
}
```

## Acesso
```java
Retangulo r = new Retangulo(); // instancionado objeto, agora o objeto nos permite acessar os dados e metodos
r.largura = 10; // atibuindo valor
r.altura = 20; // atribuindo valor
System.out.print(r.largura + " "); // printando largura
System.out.print(r.altura + " "); // printando altura
System.out.println(r.area()); //chamando metodo
```

## Construtor
na classe pode ser exigido que na instancia seja passado valores.

para isso basta cirar um metodo com retorno com mesmo tipo da classe e sem nome.

```java
class Retangulo{
    public double largura;
    public double altura; 

    public Retangulo(altura : double, largura : double){
        this.largura = largura;
        this.altura = altura; // aqui é nessario usar o this por exemplo
    }

    public double area(){
        return this.largura * altura; 
    }
}
```

## Acesso com construtor
```java
// Retangulo r = new Retangulo(); // da erro
Retangulo r = new Retangulo(20, 10); // nova forma de instaciar
//r.largura = 10; // pode ser usado
//r.altura = 20; // pode ser usado
System.out.print(r.largura + " "); // printando largura
System.out.print(r.altura + " "); // printando altura
System.out.println(r.area()); //chamando metodo
```

## Encapsulamento

O objetivo desse conceito é dar acesso ao usuario somente o necessario e garantir a integridade do dado durante a manipulação dos dados da classe 

tornar o que é publico e não precisa ser diretamente associado ao usuario em privado. Ou seja o usuario não vai ter acesso direto ao atributo.

dessa forma é necessario criar metodos auxiliares que permitam o usuario alterar e recuperar esses dados. os metodos de alterações podem possuir regras de validação para alteração, garantindo um melhor controle do sistema.

```java
class Retangulo{
    private double largura; // atributo privado
    private double altura; // atributo privado

    public Retangulo(altura : double, largura : double){
        SetBase(largura);
        SetAltura(altura); // usando set com validação já
    }

    public void SetBase(double largura){
        if (largura > 0) this.largura = largura; // só setando se valor for positivo
    }
    public void SetAltura(double altura){
        if (altura > 0) this.altura = altura; // só setando se valor for positivo
    }
    public double GetBase(){
        return largura; // retorna valor
    }
    public double GetAltura(){
        return altura; // retorna valor
    }

    public double area(){
        return this.largura * altura;
    }
}
```

## Sobrescrever exibição default

```java
class Retangulo{
    private double largura; 
    private double altura; 

    public Retangulo(altura : double, largura : double){
        SetBase(largura);
        SetAltura(altura); 
    }

    public void SetBase(double largura){
        if (largura > 0) this.largura = largura;
    }
    public void SetAltura(double altura){
        if (altura > 0) this.altura = altura;
    }
    public double GetBase(){
        return largura;
    }
    public double GetAltura(){
        return altura;
    }

    public double area(){
        return this.largura * altura;
    }

    @Override // sobrescre o padrão
    public String toString() {
        return String.format("Retangulo\nBase: %.2f\nAltura: %.2f\nArea = %.2f", largura, altura, CalcArea()); // ao ser printado o objeto esse valor sera exibido
    }
}
```

