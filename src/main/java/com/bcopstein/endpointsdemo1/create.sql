DROP TABLE livros IF EXISTS;
CREATE TABLE livros (
    codigo int,
    titulo VARCHAR(255),
    autor VARCHAR(255),
    ano int,
    PRIMARY KEY (codgo)
);

INSERT INTO livros (codigo, titulo, autor, ano) VALUES
(10, 'Introdução ao Java', 'Huguinho Pato', 2022);

INSERT INTO livros (codigo, titulo, autor, ano) VALUES
(20, 'Introdução ao Spring-Boot', 'Zezinho Pato', 2020);

INSERT INTO livros (codigo, titulo, autor, ano) VALUES
(15, 'Principios SOLID', 'Luizinho Pato', 2023);

INSERT INTO livros (codigo, titulo, autor, ano) VALUES
(17, 'Padroes de Projeto', 'Lala Pato', 2019);