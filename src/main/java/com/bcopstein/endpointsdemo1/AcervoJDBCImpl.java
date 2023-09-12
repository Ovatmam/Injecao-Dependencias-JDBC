package com.bcopstein.endpointsdemo1;

import java.beans.Statement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Primary
public class AcervoJDBCImpl implements IAcervoRepository{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AcervoJDBCImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Livro> getAll(){
        List<Livro> resp = this.jdbcTemplate.query("SELECT * FROM livros",
        (rs,rowNum) -> new Livro(rs.getInt("codigo"),rs.getString("titulo"),rs.getString("autor"),rs.getInt("ano")));
        return (List<Livro>) resp;
    }

    @Override
    public List<String> getTitulos(){
        List<String> resp = this.jdbcTemplate.query("SELECT titulo FROM livros",
        (rs,rowNum) -> new String(rs.getString("titulo")));
        return (List<String>) resp;
    }

    @Override
    public List<String> getAutores(){
        List<String> resp = this.jdbcTemplate.query("SELECT autor FROM livros",
        (rs,rowNum) -> new String(rs.getString("autor")));
        return (List<String>) resp;
    }

    @Override
    public List<Livro> getLivrosDoAutor(String autor){
        List<Livro> resp = this.jdbcTemplate.query("SELECT * FROM livros WHERE autor in "+autor,
        (rs,rowNum) -> new Livro(rs.getInt("codigo"),rs.getString("titulo"),rs.getString("autor"),rs.getInt("ano")));
        return (List<Livro>) resp;
    }

    @Override
    public Livro getLivroTitulo(String titulo){
        Livro resp = this.jdbcTemplate.query("SELECT * FROM livros WHERE titulo in "+titulo,
        (rs,rowNum) -> new Livro(rs.getInt("codigo"),rs.getString("titulo"),rs.getString("autor"),rs.getInt("ano"))).get(0);
        return (Livro) resp;
    }

    @Override
    public boolean cadastraLivroNovo(Livro livro){
        String sql = String.format("INSERT INTO livros(codigo,titulo,autor,ano) VALUES(%d,%s,%s,%d)"
                ,livro.codigo(),livro.titulo(),livro.autor(),livro.ano());
        this.jdbcTemplate.update(sql);
        return true;
    }


    @Override
    public boolean removeLivro(int codigo){
        String sql = "DELETE FROM LIVROS WHERE codigo ="+codigo;
        this.jdbcTemplate.batchUpdate(sql);
        return true;
    }

    
    @Override
    public int num_obras_autor(String autor){
        int r = (int)getAll()
        .stream()
        .filter(livro -> livro.autor().equals(autor))
        .count();
        return r;
        
    }
    
    @Override
    public int mais_recente_que(int ano){
        int r = (int)getAll()
        .stream()
        .filter(livro -> livro.ano() > ano)
        .count();
        return r;
    }

    @Override
    public int media_livros_autor(){
        int num_autores = 0;
        int num_livros = 0;
        num_livros = getAll().size();
        num_autores = getAutores().size();
        return num_autores / num_livros;
    }

}
