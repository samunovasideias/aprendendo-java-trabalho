package org.example;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroRepository {
    Livo conta = new Livo();

    public List<Livo> findByName(String nome) {
        String sql = "SELECT * FROM livros WHERE nome=?";
        List<Livo> livros = new ArrayList<>();
        try (Connection con = Conexao.getcon(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, nome);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Livo livroAtual = new Livo();
                    livroAtual.setAutor(rs.getNString("nome"));
                    livroAtual.setAutor(rs.getNString("autor"));
                    livroAtual.setId(rs.getInt("id"));
                    livroAtual.setGenero(rs.getNString("genero"));

                    livros.add(livroAtual);

                }
                return livros;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//---------------------------------------------------------------------------------------

    public void createTableLivo() {
        String sql = "CREATE TABLE IF NOT EXISTS Livo (" +
                "id serial PRIMARY KEY , " +
                "nome VARCHAR(255), " +
                "autor VARCHAR(255), " +
                "genero VARCHAR(255))";
        try (Connection con = Conexao.getcon(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.execute();

        } catch (SQLException e) {
            System.out.println("a tarefa nao pode ser completada erro:" + e);
        }
    }
    //======================================================================
    public void inserir(String nome,String genero,String autor){
        String sql="INSERT INTO livo (nome,genero,autor) values(?,?,?)";
        try(Connection con=Conexao.getcon();PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setString(1,nome);
            stmt.setString(2,genero);
            stmt.setString(3,autor);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
