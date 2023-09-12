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
    private IEstatisticas estat;

    @Autowired
    public EstatController(Acervo acervo){
        this.estat = new Estatisticas(acervo);
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
    public double mediaObrasAutor(@RequestParam(value = "autor") String autor) {
        return estat.mediaObrasAutor(autor);
    }
}
