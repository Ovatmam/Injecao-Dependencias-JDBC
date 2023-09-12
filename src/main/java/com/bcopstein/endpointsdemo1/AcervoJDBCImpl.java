package com.bcopstein.endpointsdemo1;

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
    public AcervoJDBCImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Livro> getAll() {
        List<Livro> resp = this.jdbcTemplate.query("SELECT * FROM livros",
            (rs, rowNum) -> 
                new Livro(rs.getInt("codigo"), rs.getString("titulo"), rs.getString("autor"), rs.getInt("ano")));
        return resp;
    }

    @Override
    public List<String> getTitulos() {
        List<String> resp = this.jdbcTemplate.query("SELECT titulo FROM livros",
            (rs, rowNum) ->
                rs.getString("titulo"));
        return resp;
    }

    @Override
    public List<String> getAutores() {
        List<String> resp = this.jdbcTemplate.query("SELECT autor FROM livros",
            (rs, rowNum) ->
                rs.getString("autor"));
            return resp;
    }

    @Override
    public List<Livro> getLivrosDoAutor(String autor) {
        List<Livro> resp = this.jdbcTemplate.query("SELECT titulo FROM livros WHERE autor = "+autor,
            (rs, rowNum) ->
                new Livro(rs.getInt("codigo"), rs.getString("titulo"), rs.getString("autor"), rs.getInt("ano")));
        return resp;
    }

    @Override
    public Livro getLivroTitulo(String titulo) {
        List<Livro> resp = this.jdbcTemplate.query("SELECT * FROM livros WHERE titulo ="+titulo,
            (rs, rowNum) ->
                new Livro(rs.getInt("codigo"), rs.getString("titulo"), rs.getString("autor"), rs.getInt("ano")));
        return resp.get(0);
    }

    @Override
    public boolean cadastraLivroNovo(Livro livro) {
        this.jdbcTemplate.update(
            "INSERT INTO livros(codigo,titulo,autor,ano) VALUES (?,?,?,?)",
            livro.codigo(),livro.titulo(),livro.autor(),livro.ano());
        return true;
    }

    @Override
    public boolean removeLivro(int codigo) {
        String sql = "DELETE FROM livros WHERE id = "+codigo;
        this.jdbcTemplate.batchUpdate(sql);
        return true;
    }
    
}
