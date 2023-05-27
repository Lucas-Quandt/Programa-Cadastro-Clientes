/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import modelo.Aluno;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AlunoDAO {

    private Connection connection;
    Long id;
    String nome;
    String cpf;
    String mensalidade;
    String telefone;
    String idade;
    String multa;
    String endereco;
    
    public AlunoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void salvar(Aluno objAluno) {
        try {
            String sql;
            if (String.valueOf(objAluno.getId()).isEmpty()) {
                sql = "INSERT INTO aluno(nome,cpf,mensalidade,telefone,idade,multa,endereco) VALUES(?,?,?,?,?,?,?)";
                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setString(1, objAluno.getNome());
                stmt.setString(2, objAluno.getCpf());
                stmt.setString(3, objAluno.getMensalidade());
                stmt.setString(4, objAluno.getTelefone());
                stmt.setString(5, objAluno.getIdade());
                stmt.setString(6, objAluno.getMulta());
                stmt.setString(7, objAluno.getEndereco());

                stmt.execute();
                stmt.close();

            } else {
                sql = "UPDATE aluno SET nome = ?, cpf = ?, mensalidade = ?, telefone = ?, idade = ?, multa = ?, endereco = ? WHERE aluno.id = ?";

                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setString(1, objAluno.getNome());
                stmt.setString(2, objAluno.getCpf());
                stmt.setString(3, objAluno.getMensalidade());
                stmt.setString(4, objAluno.getTelefone());
                stmt.setString(5, objAluno.getIdade());
                stmt.setString(6, objAluno.getMulta());
                stmt.setString(7, objAluno.getEndereco());

                stmt.execute();
                stmt.close();

            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public ArrayList buscar(Aluno objAluno) {
        try {
            String sql = "";
            if (!objAluno.getNome().isEmpty()) {
                sql = "SELECT * FROM aluno WHERE nome LIKE '%" + objAluno.getNome() + "%' ";

            } else if (!objAluno.getCpf().isEmpty()) {
                sql = "SELECT * FROM aluno WHERE cpf LIKE '%" + objAluno.getCpf() + "%' ";
            }
            ArrayList dado = new ArrayList();

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                dado.add(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("mensalidade"),
                    rs.getString("telefone"),
                    rs.getString("idade"),
                    rs.getString("multa"),
                    rs.getString("endereco"),
                    
                });

            }
            ps.close();
            rs.close();
            connection.close();

            return dado;
        } catch (SQLException e) {
            e.getMessage();
            JOptionPane.showMessageDialog(null, "Erro preencher o ArrayList");
            return null;
        }

    }

    public void deletar(Aluno objAluno) {
        try {
            String sql;
            if (!String.valueOf(objAluno.getId()).isEmpty()) {
                sql = "DELETE FROM aluno WHERE aluno.id = ?";
                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setString(1, objAluno.getId());
                stmt.execute();
                stmt.close();

            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public ArrayList listarTodos() {
        try {

            ArrayList dado = new ArrayList();

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM aluno");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                dado.add(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("mensalidade"),
                    rs.getString("telefone"),
                    rs.getString("idade"),
                    rs.getString("multa"),
                    rs.getString("endereco")
                });

            }
            ps.close();
            rs.close();
            connection.close();

            return dado;
        } catch (SQLException e) {
            e.getMessage();
            JOptionPane.showMessageDialog(null, "Erro preencher o ArrayList");
            return null;
        }
    }

    public static void testarConexao() throws SQLException {
        try (Connection objConnection = new ConnectionFactory().getConnection()) {
            JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso! ");
        }
    }
            
}
