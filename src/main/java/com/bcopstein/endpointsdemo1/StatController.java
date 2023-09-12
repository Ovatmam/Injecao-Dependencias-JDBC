package com.bcopstein.endpointsdemo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class StatController {
    private IAcervoRepository acervo;

    @Autowired
    public StatController(IAcervoRepository acervo){
        this.acervo = acervo;
    }

    @GetMapping("/num_livros/{autor}")
    @CrossOrigin(origins = "*")
    public int num_livros_autor(@PathVariable("autor") String autor){
        return acervo.num_obras_autor(autor);
    }


    @GetMapping("/mais_recente_que")
    @CrossOrigin(origins = "*")
    public int mais_recente_que(@RequestParam(value = "ano") int ano){
        return acervo.mais_recente_que(ano);
    }

    @GetMapping("/media_obras_autor")
    @CrossOrigin(origins = "*")
    public int media_obras_autor(){
        return acervo.media_livros_autor();
    }
}
