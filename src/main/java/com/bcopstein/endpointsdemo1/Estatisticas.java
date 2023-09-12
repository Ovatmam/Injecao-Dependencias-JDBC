package com.bcopstein.endpointsdemo1;

public class Estatisticas implements IEstatisticas{
    private Acervo acervo;

    public Estatisticas(Acervo acervo){
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

    public double mediaObrasAutor(String autor){
        return (double)acervo.getTitulos().size() / (double)acervo.getAutores().size();
    }
}