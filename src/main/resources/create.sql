DROP TABLE livros IF EXISTS;
CREATE TABLE livros (
    codigo int,
    titulo VARCHAR(255),
    autor VARCHAR(255),
    ano int,
    PRIMARY KEY (codigo)
);