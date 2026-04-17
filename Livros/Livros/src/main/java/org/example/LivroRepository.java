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
        String sql = "SELECT * FROM livo WHERE nome=?";
        List<Livo> livro = new ArrayList<>();
        try (Connection con = Conexao.getcon(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, nome);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Livo livroAtual = new Livo();
                    livroAtual.setNome(rs.getString("nome"));
                    livroAtual.setAutor(rs.getString("autor"));
                    livroAtual.setId(rs.getInt("id"));
                    livroAtual.setGenero(rs.getString("genero"));

                    livro.add(livroAtual);

                }
                return livro;
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
    public void inserir(Livo conta){
        String sql="INSERT INTO livo (nome,genero,autor) values(?,?,?)";

        try(Connection con=Conexao.getcon();PreparedStatement stmt=con.prepareStatement(sql)){

            stmt.setString(1,conta.getNome());
            stmt.setString(2, conta.getGenero());
            stmt.setString(3,conta.getAutor());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
