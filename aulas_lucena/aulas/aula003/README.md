# String

Se strings são criadas da forma convencional eles podem apontar pro mesmo valor, são referências(String var = “uia”). Porém em java string é um objeto então pode ser criado com construtor o que a torna um espaço único na memoria(String var = new String(“uia”))

string ele apontam para valores na memoria então duas variaveis com mesmo valor apontam pro mesmo lugar, mas se um sofre uma mundaça é criado uma nova string na memoria, seja por concatenação ou atribuição mesmo. o valor só some da memoria quando não tiver mais ninguem apontando para ele

String não são indexaveis em java, para pegar uma caractere precisa usar metodos da classe

## Criação: 

```java
String var = "texto";
```



## Comparador
  os operados == e != não são funcionais com strings. eles possuem métodos que servem para comparar os conteúdos.
  str.equals(str2); // verifica se são exatamente iguais
  str.equalsIgnoreCase(str2); // Ignora minusculas e maiusculas
  o == verificam se os objetos estão na mesma posição então não compare valor.

## Formatação
```java
String formatado = String.format(“Olá, %s!”, nome)
```
* %s define que o espaço reservado é string
* %. = double
* %d = decimal

## Operações
*  char   charAt(int indice) - retorna caractere em indice
*  int    str.compareTo(String str)
*  String replace(char antigo, char novo) - troca caracter por outro
*  String toLowerCase() - torna conteudo minusculo
*  String toUpperCase() - torna conteudo maiusculo
*  Bool   equals(str2) - verifica se tem o mesmo conteudo
*  Bool   equalsIgnoreCase(str2); - verifica se tem o mesmo conteudo, ignora maiusculo ou minusculo

> char + int = int; string + char = string;
