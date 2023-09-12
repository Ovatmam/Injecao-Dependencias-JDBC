package com.bcopstein.endpointsdemo1;

import org.springframework.stereotype.Component;

@Component
public class Estatisticas {
    private IAcervoRepository acervo;

    public Estatisticas(IAcervoRepository acervo){
        this.acervo = acervo;
    }

    public int qtdObrasAutor(String autor){
        return acervo.getLivrosDoAutor(autor).size();
    }

    public int obrasDepoisDe(int ano){
        int qtd = 0;
        for(Livro livro : acervo.getAll()) {
            if(livro.ano() >= ano)
            qtd++;
        }
        return qtd;
    }

    public double mediaObrasAutor(){
        return (double)acervo.getTitulos().size() / (double)acervo.getAutores().size();
    }
}
