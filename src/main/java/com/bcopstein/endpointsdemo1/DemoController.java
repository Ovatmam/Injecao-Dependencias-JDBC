package com.bcopstein.endpointsdemo1;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/biblioteca")
public class DemoController{
    private Acervo acervo;

    @Autowired
    public DemoController(Acervo acervo){
        this.acervo = acervo;
    }

    @GetMapping("/")
    @CrossOrigin(origins = "*")
    public String getSaudacao() {
        return "Bem vindo as biblioteca central!";
    }

    @GetMapping("/livros")
    @CrossOrigin(origins = "*")
    public List<Livro> getLivros() {
        return acervo.getAll();
    }

    // Solucao da dinâmica
    @GetMapping("/titulos")
    @CrossOrigin(origins = "*")
    public List<String> getTitulos() {
        return acervo.getTitulos();
    }

    @GetMapping("/autores")
    @CrossOrigin(origins = "*")
    public List<String> getAutores() {
        return acervo.getAutores();
    }

    // Recebendo uma Qwery String
    // Devolve os livros de um determinado autor
    @GetMapping("/livrosautor")
    @CrossOrigin(origins = "*")
    public List<Livro> getLivrosDoAutor(@RequestParam(value = "autor") String autor) {
        return acervo.getLivrosDoAutor(autor);
    }

    /* 
    // Recebendo Path Parameters
    // Retorna o livro que tem determinado título
    @GetMapping("/livrotitulo/{titulo}")
    @CrossOrigin(origins = "*")
    public Livro getLivroTitulo(@PathVariable("titulo") String titulo) {
        return livros.stream()
               .filter(livro->livro.titulo().equals(titulo))
               .findFirst()
               .orElse(null);   
    }
    */

    // Recebendo Path Parameters - versão usando ResponseEntity
    // Retorna o livro que tem determinado título
    @GetMapping("/livrotitulo/{titulo}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Livro> getLivroTitulo(@PathVariable("titulo") String titulo) { 
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(acervo.getLivroTitulo(titulo));
    }


    // Recebendo parâmetros no corpo da mensagem (POST)
    // Cadastra um livro novo
    @PostMapping("/novolivro")
    @CrossOrigin(origins = "*")
    public boolean cadastraLivroNovo(@RequestBody final Livro livro) {
        return acervo.cadastraLivroNovo(livro);
    }
}