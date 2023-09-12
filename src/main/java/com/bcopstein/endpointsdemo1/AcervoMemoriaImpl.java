package com.bcopstein.endpointsdemo1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Primary
public class AcervoMemoriaImpl implements IAcervoRepository {
    ArrayList<Livro> lista_livros = new ArrayList<Livro>();

    public AcervoMemoriaImpl(){
        lista_livros.add(new Livro(10,"Introdução ao Java","Huguinho Pato",2022));
        lista_livros.add(new Livro(20,"Introdução ao Spring-Boot","Zezinho Pato",2020));
        lista_livros.add(new Livro(15,"Principios SOLID","Luizinho Pato",2023));
        lista_livros.add(new Livro(17,"Padroes de Projeto","Lala Pato",2019));
    }

    public List<Livro> getAll(){
        return lista_livros;
    }

    public List<String> getAutores(){
        return lista_livros.stream()
               .map(livro->livro.autor())
               .toList();
    }

    public List<Livro> getLivrosDoAutor(String autor) {
        return lista_livros.stream()
               .filter(livro->livro.autor().equals(autor))
               .toList();
    }


    public List<String> getTitulos() {
        return lista_livros.stream()
               .map(livro->livro.titulo())
               .toList();
    }

    public Livro getLivroTitulo(String titulo) {
        Livro resp = lista_livros.stream()
               .filter(livro->livro.titulo().equals(titulo))
               .findFirst()
               .orElse(null);   
        return resp;
    }

    public boolean cadastraLivroNovo(Livro l){
        lista_livros.add(l);
        return true;
    }

    public boolean removeLivro(int codigo){
        Livro x = lista_livros.stream()
        .filter(livro -> livro.codigo() == codigo)
        .findFirst()
        .orElse(null);
        lista_livros.remove(x);
        return true;
    }


    //---- DINAMICA 1 -----

    public int num_obras_autor(String autor){
        return (int)lista_livros.stream()
        .filter(livro -> livro.autor().equals(autor))
        .count();
    }

    public int mais_recente_que(int ano){
        return (int)lista_livros.stream()
        .filter(livro -> livro.ano() > ano)
        .count();
    }

    public int media_livros_autor(){
        int num_autores = this.getAutores().size();
        int num_livros = lista_livros.size();
        return num_autores / num_livros;
        
    }
}
