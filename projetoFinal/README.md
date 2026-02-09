# Projeto Programação Orientada a Objetos - 2° Período de TADS

## Especificação do projeto
### 1. Requisitos Funcionais:
- O sistema deve permitir o cadastro, edição, exclusão e consulta das entidades principais (ex: livros, usuários, produtos, etc.).⏳
> Foi feito cadastro edição e listagem. A listagem não atualiza dinamicamente
- Deve haver funcionalidades específicas para o domínio do sistema (ex: empréstimo de livros, fechamento de pedidos, agendamento de consultas, etc.).❌
- O sistema deve gerar relatórios ou listagens relevantes (ex: listar todos os livros emprestados, produtos com estoque baixo, consultas agendadas, etc.).❌
### 2. Requisitos Técnicos:
- Classes e Objetos: Criar classes que representem as entidades do sistema, com atributos e métodos bem definidos. ✔
- Records: Usar records quando for o caso.  ✔
- Encapsulamento: Utilizar atributos privados e métodos públicos (getters e setters) para garantir o encapsulamento.  ✔
- Herança e Polimorfismo: Criar hierarquias de classes e utilizar polimorfismo quando aplicável.  ✔
- Interfaces: Definir interfaces para comportamentos comuns (ex: Emprestavel, Pagavel, etc.).  ✔
- Coleções: Utilizar coleções como ArrayList, HashMap, etc., para armazenar listas de objetos.  ✔
- Exceções: Implementar tratamento de exceções para situações de erro (ex: tentativa de emprestar um livro já emprestado). ❌
- ~ Persistência de Dados: Salvar e carregar dados em arquivos (ex: .txt, .csv). ~  ✔
### 3. Funcionalidades Adicionais:
- Validação de Dados: Validar entradas do usuário (ex: CPF, e-mail, datas, etc.). ❌
> So verifico se tem valor ou não e criei inputs para Numero(não se consegue digitar textos)
- Interface de Usuário: Implementar uma interface simples via console ou, opcionalmente. ✔
### 4. Entregáveis:
- Código Fonte: O projeto completo, organizado em pacotes e seguindo as boas práticas de POO. ✔
- Diagrama: Diagrama de Classes com todas as classes, interfaces e records do sistema. ❌
- Documentação: Comentários no código e um arquivo README.md explicando como executar o projeto e suas funcionalidades. ✔
- Relatório: Um relatório descrevendo as decisões de projeto, desafios enfrentados e soluções implementadas. ✔
### 5. Critérios de Avaliação:
- Funcionalidade: O sistema deve atender a todos os requisitos funcionais. ❌
> Somente consegui fazer a listagem e criação, começei a ediçao e exclusão, mas não finalizei. Porem no dao e servico ja tem metodos que finalizem tanto o CRUD quanto o gerenciamento da funcionalidade especifica
- Qualidade do Código: O código deve ser modular, bem organizado e seguir as boas práticas de POO. ✔
- Originalidade: O sistema deve ser único e criativo, evitando cópias de projetos prontos. ✔
- Complexidade: O projeto deve demonstrar um nível adequado de complexidade, utilizando os conceitos aprendidos na disciplina. ✔
> A maior complexidade foi trabalhar na interface, visto que tive que aprender enquanto fazia

## Ideia de Sistema

Sistema de Gerenciamento de Times Pokemon
- CRUD de pokemons, elementos, evolucoes.
- Controle de times.
- Geração de listagens com multiplicador de fraqueza e vantagem do time.

## Projeto

### Estrutura Manual no VSCode

A estrutura do projeto é manual e feito no VSCode então para conseguir rodar vai precisa adicionar no Classpath do java o jar da pasta lib do projeto.

Para isso aperte ```ctrl + shift + p``` e digite "Java: Configure Classpath" clique na opção e o VSCode abrira uma tela com abas para configurar o projeto java. Na aba libraries adicione o jar localizado nas pasta lib do projeto final(```.\projetoFinal\dependencias\sqlite-jdbc-3.51.1.0.jar```)

Se tiverem mais ```.jar``` dentro basta adicionar eles tambem

### Extenções do VSCode

#### Extension Pack for Java

Necessaria para rodar. 

basta ir no ```ui/telas/Main.java``` e clicar no run do metodo main(Gerado pelo Extension Pack for Java).

### Resetar banco (Opcional)

basta apagar o ```banco.db``` e rodar o ````logica/persistencia/Migracoes.java``` e clicar no run do metodo main(Gerado pelo Extension Pack for Java).

#### Dependencias
- SQLite JDBC Driver - 3.51.1.0 ([Fonte aqui!](https://github.com/xerial/sqlite-jdbc/releases))
- Extension Pack for Java - Extenção - [Baixe aqui!](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
