package gui;

import dao.ProfessorDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.ModelTable;
import modelo.Professor;

public class ProfessorGUI extends javax.swing.JFrame {

    private Professor objProfessor;
    private ProfessorDAO objDAO;
    private boolean buscar = false;

    /**
     * Creates new form UsuarioGUI
     */
    public ProfessorGUI() {

        initComponents();

        //Centralizando a janela
        this.setLocationRelativeTo(null);
        // Impede que a janela seja redimencionada 
        this.setResizable(false);
        // Trocando cursor para HAND CURSOR(Maozinha)
        // jButtonRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        // Variavel con recebendo a conexao
        carregarTable(null);
    }

    // Metodo que realiza conexao com o banco, faz uma instrucao Query(select)
    // para jogar na JTable atraves do modelo de tabela (ModelTabel.java)
    public void carregarTable(Professor objProfessor) {

        objDAO = new ProfessorDAO();
        ArrayList dados = new ArrayList();
        if (buscar) {
            dados = objDAO.buscar(objProfessor);
        } else {
            objProfessor = new Professor();
            dados = objDAO.listarTodos();
        }
        String[] colunas = objProfessor.getColunas();

        ModelTable modelo = new ModelTable(dados, colunas);

        tbListagemUsuario.setModel(modelo);
        tbListagemUsuario.getColumnModel().getColumn(0).setPreferredWidth(80);
        tbListagemUsuario.getColumnModel().getColumn(0).setResizable(false);
        tbListagemUsuario.getColumnModel().getColumn(1).setPreferredWidth(120);
        tbListagemUsuario.getColumnModel().getColumn(1).setResizable(false);
        tbListagemUsuario.getColumnModel().getColumn(2).setPreferredWidth(250);
        tbListagemUsuario.getColumnModel().getColumn(2).setResizable(false);
        tbListagemUsuario.getTableHeader().setReorderingAllowed(false);
        //  tbListagemUsuario.setAutoResizeMode(tbListagemUsuario.AUTO_RESIZE_ALL_COLUMNS);
        // tbListagemUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    // Metodo responsavel por selecionar um registro ao clicar ou seguir com as setas do teclado
    // na JTable, e realizar a vinculacao do mesmo nos TextFields
    public void selectRegistryTable() {

        txtID.setText(tbListagemUsuario.getValueAt(tbListagemUsuario.getSelectedRow(), 0).toString());

        //Object objNome = tbListagemUsuario.getValueAt(tbListagemUsuario.getSelectedRow(), 1);
        txtEndereco.setText(tbListagemUsuario.getValueAt(tbListagemUsuario.getSelectedRow(), 1).toString());
        txtCPF.setText(tbListagemUsuario.getValueAt(tbListagemUsuario.getSelectedRow(), 2).toString());
        txtSalario.setText(tbListagemUsuario.getValueAt(tbListagemUsuario.getSelectedRow(), 3).toString());
        txtTelefone.setText(tbListagemUsuario.getValueAt(tbListagemUsuario.getSelectedRow(), 4).toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        txtCPF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tbnLimpar = new javax.swing.JButton();
        tbnSalvar = new javax.swing.JButton();
        tbnExit = new javax.swing.JButton();
        tbnExit1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListagemUsuario = new javax.swing.JTable();
        txtID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtCargahoraria = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Loki&Thor Academia");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CADASTRO DE PROFESSOR");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        txtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoActionPerformed(evt);
            }
        });
        getContentPane().add(txtEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 160, -1));

        txtCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFActionPerformed(evt);
            }
        });
        getContentPane().add(txtCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 160, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CPF");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, -1, -1));
        getContentPane().add(txtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 160, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Telefone");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, -1, -1));
        getContentPane().add(txtSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 157, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Salario");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, -1, -1));

        tbnLimpar.setText("Limpar");
        tbnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(tbnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, -1, -1));

        tbnSalvar.setText("Salvar");
        tbnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(tbnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 99, -1));

        tbnExit.setText("Voltar");
        tbnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnExitActionPerformed(evt);
            }
        });
        getContentPane().add(tbnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, -1, -1));

        tbnExit1.setText("Testar Conex�o");
        tbnExit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnExit1ActionPerformed(evt);
            }
        });
        getContentPane().add(tbnExit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, -1, -1));

        tbListagemUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "CPF", "Salario", "Telefone", "Horas Trabalho", "Endereco"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbListagemUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbListagemUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbListagemUsuario);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 912, 89));

        txtID.setEditable(false);
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, 49, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ID");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 320, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 41, -1, -1));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, -1, -1));
        getContentPane().add(txtCargahoraria, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 160, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Horas Trabalhadas");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, -1, -1));

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 157, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Endere�o");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/imagens/logo-mini.jpg"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, 134));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/imagens/FotoProfessor.jpg"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoActionPerformed

    private void txtCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPFActionPerformed

    private void tbnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnSalvarActionPerformed

        objProfessor = new Professor();
        objProfessor.setId(txtID.getText());
        objProfessor.setNome(txtEndereco.getText());
        objProfessor.setCpf(txtCPF.getText());
        objProfessor.setSalario(txtSalario.getText());
        objProfessor.setTelefone(txtTelefone.getText());
        objProfessor.setCargahoraria(txtCargahoraria.getText());
        objProfessor.setEndereco(txtNome.getText());


        // fazendo a valida��o dos dados
        if ((txtEndereco.getText().isEmpty())){  
            JOptionPane.showMessageDialog(null, "Informe valores para os campos");
        } else if ((txtCPF.getText().isEmpty())){
            JOptionPane.showMessageDialog(null, "Campo CPF deve ser preenchido");
        } else if ((txtCargahoraria.getText().isEmpty())){
            JOptionPane.showMessageDialog(null, "Campo Carga Horaria deve ser preenchido");    
        } else if (Integer.parseInt(txtCargahoraria.getText())< 0) {
            JOptionPane.showInternalMessageDialog(null, "Campo Cara Horaria n�o permite valor negativo");
        } else if ((txtSalario.getText().isEmpty())){
            JOptionPane.showMessageDialog(null, "Campo Salario deve ser preenchido");    
        } else if (Integer.parseInt(txtSalario.getText())< 0) {
            JOptionPane.showInternalMessageDialog(null, "Campo Salario n�o permite valor negativo");   
        } else if ((txtTelefone.getText().isEmpty())){
            JOptionPane.showMessageDialog(null, "Campo Telefone deve ser preenchido");  
        } else {
            // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
            objDAO = new ProfessorDAO();
            objDAO.salvar(objProfessor);
            JOptionPane.showMessageDialog(null, "Professor " + txtEndereco.getText() + " inserido com sucesso! ");
        }

        carregarTable(null);

        // apaga os dados preenchidos nos campos de texto
        setClear();
    }//GEN-LAST:event_tbnSalvarActionPerformed

    private void tbnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnLimparActionPerformed
        setClear();
        carregarTable(null);
    }//GEN-LAST:event_tbnLimparActionPerformed

    private void tbnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnExitActionPerformed
                 this.setVisible(false);
                 MenuCadastro teladeMenuCadastro = new MenuCadastro();
                 teladeMenuCadastro.setVisible(true);
    }//GEN-LAST:event_tbnExitActionPerformed

    private void tbnExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnExit1ActionPerformed
        try {
            ProfessorDAO.testarConexao();
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }//GEN-LAST:event_tbnExit1ActionPerformed

    private void tbListagemUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListagemUsuarioMouseClicked
        // TODO add your handling code here:
        selectRegistryTable();
    }//GEN-LAST:event_tbListagemUsuarioMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        objProfessor = new Professor();
        objProfessor.setNome(txtEndereco.getText());
        objProfessor.setCpf(txtCPF.getText());

        // fazendo a valida��o dos dados
        if ((!txtEndereco.getText().isEmpty()) || (!txtCPF.getText().isEmpty())) {
            // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
            objDAO = new ProfessorDAO();
            buscar = true;
            carregarTable(objProfessor);
        }else{
            buscar = false;
            carregarTable(null);
        }

        // apaga os dados preenchidos nos campos de texto
        setClear();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    public void setClear() {
        txtID.setText(null);
        txtEndereco.setText(null);
        txtCPF.setText(null);
        txtSalario.setText(null);
        txtTelefone.setText(null);
        txtCargahoraria.setText(null);
        txtNome.setText(null);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProfessorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfessorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfessorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfessorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfessorGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbListagemUsuario;
    private javax.swing.JButton tbnExit;
    private javax.swing.JButton tbnExit1;
    private javax.swing.JButton tbnLimpar;
    private javax.swing.JButton tbnSalvar;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtCargahoraria;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
