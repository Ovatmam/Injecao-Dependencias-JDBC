package com.bcopstein.endpointsdemo1;

import org.springframework.stereotype.Component;

@Component
public class ServicoEstatistica {
    
    private AcervoMemoriaImpl acervo;

    public ServicoEstatistica(AcervoMemoriaImpl acervo){
        this.acervo = acervo;
    }

    public int contadorAutor(String autor){
        return (int) acervo.lista_livros.stream()
        .filter(elemento -> elemento.autor().equals(autor))
        .count();
    }

    public int contadorAno(int ano){
        return (int)acervo.lista_livros.stream()
        .filter(livro -> livro.ano() > ano)
        .count();
    }

    public double mediaAutor(){
        int num_autores = acervo.getAutores().size();
        int num_livros = acervo.lista_livros.size();

        //return num_autores;
        //return num_livros;
        return (double)num_livros / (double)num_autores;
    }


}
