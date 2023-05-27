/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import modelo.Professor;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProfessorDAO {

    private Connection connection;
    Long id;
    String nome;
    String cpf;
    String salario;
    String telefone;
    String cargahoraria;
    String endereco;
    
    public ProfessorDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void salvar(Professor objProfessor) {
        try {
            String sql;
            if (String.valueOf(objProfessor.getId()).isEmpty()) {
                sql = "INSERT INTO professor(nome,cpf,salario,telefone,cargahoraria,endereco) VALUES(?,?,?,?,?,?)";
                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setString(1, objProfessor.getNome());
                stmt.setString(2, objProfessor.getCpf());
                stmt.setString(3, objProfessor.getSalario());
                stmt.setString(4, objProfessor.getTelefone());
                stmt.setString(5, objProfessor.getCargahoraria());
                stmt.setString(6, objProfessor.getEndereco());

                stmt.execute();
                stmt.close();

            } else {
                sql = "UPDATE professor SET nome = ?, cpf = ?, salario = ?, telefone = ?, cargahoraria = ?, endereco ? WHERE professor.id = ?";

                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setString(1, objProfessor.getNome());
                stmt.setString(2, objProfessor.getCpf());
                stmt.setString(3, objProfessor.getSalario());
                stmt.setString(4, objProfessor.getTelefone());
                stmt.setString(5, objProfessor.getCargahoraria());
                stmt.setString(6, objProfessor.getEndereco());

                stmt.execute();
                stmt.close();

            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public ArrayList buscar(Professor objProfessor) {
        try {
            String sql = "";
            if (!objProfessor.getNome().isEmpty()) {
                sql = "SELECT * FROM professor WHERE nome LIKE '%" + objProfessor.getNome() + "%' ";

            } else if (!objProfessor.getCpf().isEmpty()) {
                sql = "SELECT * FROM professor WHERE cpf LIKE '%" + objProfessor.getCpf() + "%' ";
            }
            ArrayList dado = new ArrayList();

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                dado.add(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("salario"),
                    rs.getString("telefone"),
                    rs.getString("cargahoraria"),
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

    public void deletar(Professor objProfessor) {
        try {
            String sql;
            if (!String.valueOf(objProfessor.getId()).isEmpty()) {
                sql = "DELETE FROM professor WHERE professor.id = ?";
                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setString(1, objProfessor.getId());
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

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM professor");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                dado.add(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("salario"),
                    rs.getString("telefone"),
                    rs.getString("cargahoraria"),
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
