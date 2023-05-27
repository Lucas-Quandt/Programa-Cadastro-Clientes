/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import modelo.Funcionario;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FuncionarioDAO {

    private Connection connection;
    Long id;
    String nome;
    String salario;
    String funcao;
    String endereco;
    String telefone;

    public FuncionarioDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void salvar(Funcionario objFuncionario) {
        try {
            String sql;
            if (String.valueOf(objFuncionario.getId()).isEmpty()) {
                sql = "INSERT INTO funcionario(nome,funcao,salario,endereco,telefone) VALUES(?,?,?,?,?)";
                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setString(1, objFuncionario.getNome());
                stmt.setString(2, objFuncionario.getFuncao());
                stmt.setString(3, objFuncionario.getSalario());
                stmt.setString(4, objFuncionario.getEndereco());
                stmt.setString(5, objFuncionario.getTelefone());
                stmt.execute();
                stmt.close();

            } else {
                sql = "UPDATE funcionario SET nome = ?, funcao = ?, salario = ?, endereco = ?, telefone = ?  WHERE funcionario.id = ?";

                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setString(1, objFuncionario.getNome());
                stmt.setString(2, objFuncionario.getFuncao());
                stmt.setString(3, objFuncionario.getSalario());
                stmt.setString(4, objFuncionario.getEndereco());
                stmt.setString(5, objFuncionario.getTelefone());
                stmt.execute();
                stmt.close();

            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public ArrayList buscar(Funcionario objFuncionario) {
        try {
            String sql = "";
            if (!objFuncionario.getNome().isEmpty()) {
                sql = "SELECT * FROM funcionario WHERE nome LIKE '%" + objFuncionario.getNome() + "%' ";

            } else if (!objFuncionario.getFuncao().isEmpty()) {
                sql = "SELECT * FROM funcionario WHERE funcao LIKE '%" + objFuncionario.getFuncao() + "%' ";
            }
            ArrayList dado = new ArrayList();

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                dado.add(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("funcao"),
                    rs.getString("salario"),
                    rs.getString("endereco"),
                    rs.getString("telefone")
                        
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

    public void deletar(Funcionario objFuncionario) {
        try {
            String sql;
            if (!String.valueOf(objFuncionario.getId()).isEmpty()) {
                sql = "DELETE FROM funciionario WHERE professor.id = ?";
                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setString(1, objFuncionario.getId());
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

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM funcionario");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                dado.add(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("funcao"),
                    rs.getString("salario"),
                    rs.getString("endereco"),
                    rs.getString("telefone"),

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
