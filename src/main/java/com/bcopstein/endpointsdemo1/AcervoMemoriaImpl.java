package com.bcopstein.endpointsdemo1;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AcervoMemoriaImpl implements IAcervoRepository {
    private List<Livro> livros;

    public AcervoMemoriaImpl() {
        livros = new LinkedList<>();

        livros.add(new Livro(10,"Introdução ao Java","Huguinho Pato",2022));
        livros.add(new Livro(20,"Introdução ao Spring-Boot","Zezinho Pato",2020));
        livros.add(new Livro(15,"Principios SOLID","Luizinho Pato",2023));
        livros.add(new Livro(17,"Padroes de Projeto","Lala Pato",2019));
    }

    @Override
    public List<Livro> getAll() {
        return livros;
    }

    @Override
    public List<String> getTitulos() {
        return livros.stream()
               .map(livro->livro.titulo())
               .toList();
    }

    @Override
    public List<String> getAutores() {
        return livros.stream()
               .map(livro->livro.autor())
               .toList();
    }

    @Override
    public List<Livro> getLivrosDoAutor(String autor) {
        return livros.stream()
               .filter(livro->livro.autor().equals(autor))
               .toList();
    }

    @Override
    public Livro getLivroTitulo(String titulo) {
        Livro resp = livros.stream()
               .filter(livro->livro.titulo().equals(titulo))
               .findFirst()
               .orElse(null);   
        return resp;
    }

    @Override
    public boolean cadastraLivroNovo(Livro livro) {
        return livros.add(livro);
    }

    @Override
    public boolean removeLivro(int codigo) {
        List<Livro> tmp = livros.stream()
            .filter(livro -> livro.codigo() == codigo)
            .toList();
        return tmp.removeAll(tmp);
    }
}
