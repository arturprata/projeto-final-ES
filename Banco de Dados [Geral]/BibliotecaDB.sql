CREATE DATABASE Biblioteca;
USE Biblioteca;

CREATE TABLE Funcionario (
    id_funcionario INT AUTO_INCREMENT PRIMARY KEY,
    nome_funcionario VARCHAR(100) NOT NULL,
    cpf_funcionario VARCHAR(11) UNIQUE NOT NULL,
    email_funcionario  VARCHAR(50) NOT NULL,
    telefone_funcionario VARCHAR(20) NOT NULL,
    cargo VARCHAR(30) NOT NULL,
    senha_funcionario VARCHAR(30) NOT NULL
);

CREATE TABLE Cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nome_cliente VARCHAR(100) NOT NULL,
    cpf_cliente VARCHAR(14) UNIQUE NOT NULL,
    email_cliente  VARCHAR(50) NOT NULL,
    telefone_cliente VARCHAR(20) NOT NULL
);

CREATE TABLE Livro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    editora VARCHAR(100) NOT NULL,
    dataRecebimento VARCHAR(11) NOT NULL,
    situacao VARCHAR(15) NOT NULL
    
);

CREATE TABLE EmprestimoDevolucao(
	id_emprestimo INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT,
    livro_id INT,
    dataEmprestimo VARCHAR(11) NOT NULL,
    situacaoEmprestimo VARCHAR(15) NOT NULL,
    CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id_cliente),
    CONSTRAINT fk_livro FOREIGN KEY (livro_id) REFERENCES livro(id)
);