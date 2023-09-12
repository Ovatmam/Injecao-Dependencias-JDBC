package com.bcopstein.endpointsdemo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatisticas")
public class EstatController {
    private Estatisticas estat;

    @Autowired
    public EstatController(Estatisticas estat){
        this.estat = estat;
    }

    @GetMapping("/")
    @CrossOrigin(origins = "*")
    public String getSaudacao() {
        return "Bem vindo as estastisticas!";
    }

    @GetMapping("/quantidade-obras-autor")
    @CrossOrigin("*")
    public int qtdObrasAutor(@RequestParam(value = "autor")String autor) {
        return estat.qtdObrasAutor(autor);
    }
    @GetMapping("/obras-depois-de")
    @CrossOrigin("*")
    public int obrasDepoisDe(@RequestParam(value = "ano") int ano) {
        return estat.obrasDepoisDe(ano);
    }
    
    @GetMapping("/media-de-obras")
    @CrossOrigin("*")
    public double mediaObrasAutor() {
        return estat.mediaObrasAutor();
    }
}
