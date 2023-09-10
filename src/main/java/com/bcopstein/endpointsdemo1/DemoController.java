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
    private AcervoMemoriaImpl acervo;
    
    @Autowired
    public DemoController(AcervoMemoriaImpl acervo){
        System.out.println("\n\nCriado DemoController\n\n");
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

    // Recebendo uma Query String
    // Devolve os livros de um determinado autor
    @GetMapping("/livrosautor")
    @CrossOrigin(origins = "*")
    public List<Livro> getLivrosDoAutor(@RequestParam(value = "autor") String autor) {
        return acervo.getLivrosDoAutor(autor);
    }

    // Recebendo Path Parameters - versão usando ResponseEntity
    // Retorna o livro que tem determinado título
    @GetMapping("/livrotitulo/{titulo}")
    @CrossOrigin(origins = "*")
    public Livro getLivroTitulo(@PathVariable("titulo") String titulo) {
        return acervo.getLivroTitulo(titulo);
    }


    // Recebendo parâmetros no corpo da mensagem (POST)
    // Cadastra um livro novo
    @PostMapping("/novolivro")
    @CrossOrigin(origins = "*")
    public boolean cadastraLivroNovo(@RequestBody final Livro livro) {
        return acervo.cadastraLivroNovo(livro);
    }

    // Recebendo uma Query String
    // Remove livro com codigo recebido
    @GetMapping("/remove_livro")
    @CrossOrigin(origins = "*")
    public Boolean remove_livro(@RequestParam(value = "codigo") int codigo) {
        return acervo.removeLivro(codigo);
    }

    //-------------RESPOSTAS PARA EXERCICIO DE REPOSITORIO (ACERVO) -------------------

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