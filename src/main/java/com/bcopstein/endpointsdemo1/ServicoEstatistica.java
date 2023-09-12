package com.bcopstein.endpointsdemo1;

public class ServicoEstatistica {
    
    private AcervoMemoriaImpl acervo;

    public ServicoEstatistica(AcervoMemoriaImpl acervo){
        this.acervo = acervo;
    }

    public int contadorAutor(String autor){
        return 1;
    }

    public int contadorAno(int ano){
        return 1;
    }

    public double mediaAutor(){
        return 1;
    }


}
