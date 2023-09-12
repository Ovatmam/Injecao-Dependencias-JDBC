package com.bcopstein.endpointsdemo1;

import org.springframework.stereotype.Component;

@Component
public interface IEstatisticas {
    public int qtdObrasAutor(String autor);
    public int obrasDepoisDe(int ano);
    public double mediaObrasAutor(String autor);
}
