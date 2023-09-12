package com.bcopstein.endpointsdemo1;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {
    private ServicoEstatistica servicoEstatistica;

    @Autowired
    public EstatisticaController(ServicoEstatistica servicoEstatistica) {
        System.out.println("\n\nCriado Estatistica Controller\n\n");
        this.servicoEstatistica = servicoEstatistica;
    }

    @GetMapping("/")
    @CrossOrigin(origins = "*")
    public String getBemVindo() {
        return "Bem vindo as Estatisticas!";
    }

    @GetMapping("/qtd/{autor}")
    @CrossOrigin(origins = "*")
    public int getQtdLivrosDoAutor(@PathVariable("autor") String autor) {
        return servicoEstatistica.contadorAutor(autor);  
    }

    @GetMapping("/qtdano/{ano}")
    @CrossOrigin(origins = "*")
    public int getQtdLivrosAno(@PathVariable("ano") int ano) {
        return servicoEstatistica.contadorAno(ano);  
    }

    @GetMapping("/media")
    @CrossOrigin(origins = "*")
    public double getMediaAutor() {
        return servicoEstatistica.mediaAutor();  
    }
    
}
