package org.example;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.util.List;


public class BancoRepository {

    public void createTable(){
        String sql= "CREATE TABLE IF NOT EXISTS contas (numeroConta INTEGER, saldo FLOAT, status BOOLEAN, tipodeConta VARCHAR(10))";

        try (Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/banco", "postgres", "sambm1409"); PreparedStatement smt = conexao.prepareStatement(sql)){

            conexao.prepareStatement(sql);
            conexao.prepareStatement(sql).execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void insertInto()
    public List<Banco> FindbyNumeroconta(Integer numeroconta) {
        String sql = "SELECT * FROM contas WHERE numeroconta = ?";
        try (Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/banco", "postgres", "sambm1409"); PreparedStatement smt = conexao.prepareStatement(sql)) {


            List<Banco> usuarios = new ArrayList<>();
            smt.setInt(1,numeroconta);
            try (ResultSet rs = smt.executeQuery()) {
                while (rs.next()) {
                    Banco conta = Banco.abrirConta();
                    conta.setStatus(rs.getBoolean("status"));
                    conta.setNumeroConta(rs.getInt("numeroconta"));
                    conta.setSaldo(rs.getFloat("saldo"));
                    usuarios.add(conta);
                }

            } catch (SQLException e){
                e.printStackTrace();
            }
            return usuarios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
