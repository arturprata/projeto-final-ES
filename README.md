# Projeto Final - Engenharia de Software

Repositório destinado ao Projeto Final da disciplina de Engenharia de Software.

## Descrição do Projeto

Este projeto consiste na implementação de um **sistema de biblioteca** que permite gerenciar clientes, funcionários e livros, além de realizar operações essenciais, como **empréstimos e devoluções**. Para garantir uma arquitetura bem estruturada, foi utilizado o padrão de projeto **Data Access Object (DAO)**.

## Funcionalidades

- **CRUD de Cliente** (Criar, Ler, Atualizar e Deletar)
- **CRUD de Funcionário**
- **CRUD de Livro**
- **Realização de Empréstimos**
- **Processamento de Devoluções**

## Tecnologias Utilizadas

- **Java JDK 23**
- **MySQL 8.0.41**
- **MySQL Connector/J 9.2.0**

Para executar o projeto corretamente, é recomendável baixar apenas a pasta **`src`**, onde os pacotes já estão organizados para execução.

## Configuração do Ambiente

1. **Abra a sua IDE de preferência (Eclipse, IntelliJ, NetBeans, etc.) e crie um projeto Java**
2. **Importe a pasta `src` do projeto no GitHub e adicione ela na pasta do projeto criado, fazendo substituições caso seja necessário**
3. **Configure o banco de dados MySQL:**
   - Importe a pasta `bibliotecaBD` do projeto no GitHub para adquirir o script do banco de dados.
   - Execute o script SQL fornecido para criação das tabelas.
   - Não se esqueça de alterar o *user* e *password* em `ConexaoDAO`. 
4. **Adicione o MySQL Connector/J (versão 9.2.0) como biblioteca no projeto.**
5. **Compile e execute o sistema.**

## Por que utilizamos o padrão DAO?

O padrão **Data Access Object (DAO)** foi escolhido para separar a lógica de persistência (acesso ao banco de dados) do restante da aplicação. Isso traz vários benefícios, como:

- **Modularidade**: Facilita a manutenção e a expansão do sistema.
- **Reutilização de Código**: Evita repetição de consultas SQL espalhadas pelo projeto.
- **Separação de Responsabilidades**: Mantém a lógica do banco de dados separada da regra de negócio e da interface.

