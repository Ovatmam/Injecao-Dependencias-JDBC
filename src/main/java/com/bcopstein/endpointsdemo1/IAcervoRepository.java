package com.bcopstein.endpointsdemo1;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface IAcervoRepository {
    List<Livro> getAll();
    List<String> getTitulos();
    List<String> getAutores();
    List<Livro> getLivrosDoAutor(String autor);
    Livro getLivroTitulo(String titulo);
    boolean cadastraLivroNovo(Livro livro);
    boolean removeLivro(int codigo);
    int num_obras_autor(String autor);
    int mais_recente_que(int ano);
    int media_livros_autor();
}