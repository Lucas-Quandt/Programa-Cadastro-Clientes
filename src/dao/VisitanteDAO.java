/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import modelo.Visitante;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VisitanteDAO {

    private Connection connection;
    Long id;
    String nome;
    String cpf;
    String valoraserpago;
    
    public VisitanteDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void salvar(Visitante objVisitante) {
        try {
            String sql;
            if (String.valueOf(objVisitante.getId()).isEmpty()) {
                sql = "INSERT INTO visitante(nome,cpf,valoraserpago) VALUES(?,?,?)";
                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setString(1, objVisitante.getNome());
                stmt.setString(2, objVisitante.getCpf());
                stmt.setString(3, objVisitante.getValoraserpago());
                stmt.execute();
                stmt.close();

            } else {
                sql = "UPDATE visitante SET nome = ?, cpf = ?, valoraserpago = ?  WHERE visitante.id = ?";

                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setString(1, objVisitante.getNome());
                stmt.setString(2, objVisitante.getCpf());
                stmt.setString(3, objVisitante.getValoraserpago());
                stmt.execute();
                stmt.close();

            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public ArrayList buscar(Visitante objVisitante) {
        try {
            String sql = "";
            if (!objVisitante.getNome().isEmpty()) {
                sql = "SELECT * FROM visitante WHERE nome LIKE '%" + objVisitante.getNome() + "%' ";

            } else if (!objVisitante.getCpf().isEmpty()) {
                sql = "SELECT * FROM visitante WHERE cpf LIKE '%" + objVisitante.getCpf() + "%' ";
            }
            ArrayList dado = new ArrayList();

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                dado.add(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("valoraserpago"),
                        
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

    public void deletar(Visitante objVisitante) {
        try {
            String sql;
            if (!String.valueOf(objVisitante.getId()).isEmpty()) {
                sql = "DELETE FROM visitante WHERE visitante.id = ?";
                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setString(1, objVisitante.getId());
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

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM visitante");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                dado.add(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("valoraserpago")
                    
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
