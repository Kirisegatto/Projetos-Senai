
package View;
import Controller.FuncionarioController;
import Controller.LoginController;
import DAO.ClasseConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class TelaCadastroFuncionario extends javax.swing.JFrame {
Connection conexao = null;
PreparedStatement pst = null;
ResultSet rs = null;

    private final FuncionarioController controller;
    public TelaCadastroFuncionario() {
        initComponents();
        controller = new FuncionarioController(this);
    }
    
    private void cadastrarClientes() {
        String sql = "insert into funcionarios(nomeFuncionarios,emailFuncionarios,telefoneFuncionarios,dataNascimentoFuncionarios,sexoFuncionarios,CPFFuncionarios,senha,nivel_acesso) values(?,?,?,?,?,?,?,?)";
        conexao = new ClasseConexao().conectorBD();
        
        try {
            //prepara e pega os dados do cadastro
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nomeFuncionario.getText());//nome
            pst.setString(2, sexoFuncionario.getSelectedItem().toString());//sexo
            pst.setString(3, cpfFuncionario.getText());//cpf

            //converter data dd/MM/yyyy para yyyy/MM/dd
            String dia = dataDeNascimentoFuncionario.getText().substring(0, 2);
            String mes = dataDeNascimentoFuncionario.getText().substring(3, 5);
            String ano = dataDeNascimentoFuncionario.getText().substring(6);
            String dataNascConv = ano + "-" + mes + "-" + dia;

            pst.setString(4, dataNascConv);//dataNascimento
            pst.setString(5, nivelDeAcessoFuncionario.getText());//endereco
            pst.setString(6, emailFuncionario.getText());//email
            pst.setString(7, telefoneFuncionario.getText());//telefone
            pst.setString(8, senhaFuncionario.getText());//cep

            //validacao dos campos obrigatorios
            if (nomeFuncionario.getText().isEmpty() || cpfFuncionario.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha Todos os Campos Obrigatorios");
            } else {

                //atualiza a tabela cliente com os dados do formulario
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Funcionário Cadastrado Com Sucesso");

                    nomeFuncionario.setText(null);//nome
                    cpfFuncionario.setText(null);//cpf
                    dataDeNascimentoFuncionario.setText(null);//dataNascimento
                    nivelDeAcessoFuncionario.setText(null);//endereco
                    emailFuncionario.setText(null);//email
                    telefoneFuncionario.setText(null);//telefone
                    senhaFuncionario.setText(null);//cep
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomeFuncionario = new javax.swing.JTextField();
        dataDeNascimentoFuncionario = new javax.swing.JTextField();
        cpfFuncionario = new javax.swing.JTextField();
        telefoneFuncionario = new javax.swing.JTextField();
        emailFuncionario = new javax.swing.JTextField();
        nivelDeAcessoFuncionario = new javax.swing.JTextField();
        senhaFuncionario = new javax.swing.JTextField();
        confirmarFuncionario = new javax.swing.JButton();
        sexoFuncionario = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        fundoCadastroFuncionario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nomeFuncionario.setBackground(new java.awt.Color(204, 204, 204));
        nomeFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeFuncionarioActionPerformed(evt);
            }
        });
        getContentPane().add(nomeFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 220, 30));

        dataDeNascimentoFuncionario.setBackground(new java.awt.Color(204, 204, 204));
        dataDeNascimentoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataDeNascimentoFuncionarioActionPerformed(evt);
            }
        });
        getContentPane().add(dataDeNascimentoFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 220, 30));

        cpfFuncionario.setBackground(new java.awt.Color(204, 204, 204));
        cpfFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfFuncionarioActionPerformed(evt);
            }
        });
        getContentPane().add(cpfFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 382, 220, 30));

        telefoneFuncionario.setBackground(new java.awt.Color(204, 204, 204));
        telefoneFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefoneFuncionarioActionPerformed(evt);
            }
        });
        getContentPane().add(telefoneFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 468, 220, 30));

        emailFuncionario.setBackground(new java.awt.Color(204, 204, 204));
        emailFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFuncionarioActionPerformed(evt);
            }
        });
        getContentPane().add(emailFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 550, 220, 30));

        nivelDeAcessoFuncionario.setBackground(new java.awt.Color(204, 204, 204));
        nivelDeAcessoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nivelDeAcessoFuncionarioActionPerformed(evt);
            }
        });
        getContentPane().add(nivelDeAcessoFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 630, 220, 30));

        senhaFuncionario.setBackground(new java.awt.Color(204, 204, 204));
        senhaFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaFuncionarioActionPerformed(evt);
            }
        });
        getContentPane().add(senhaFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 712, 220, 30));

        confirmarFuncionario.setBackground(new java.awt.Color(0, 0, 0));
        confirmarFuncionario.setFont(new java.awt.Font("Artifakt Element Light", 0, 24)); // NOI18N
        confirmarFuncionario.setForeground(new java.awt.Color(255, 255, 255));
        confirmarFuncionario.setText("Confirmar");
        confirmarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarFuncionarioActionPerformed(evt);
            }
        });
        getContentPane().add(confirmarFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 810, 270, 30));

        sexoFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--------------", "Feminino", "Masculino", "Outros" }));
        sexoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexoFuncionarioActionPerformed(evt);
            }
        });
        getContentPane().add(sexoFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 220, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/botão voltar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 50, 50));

        fundoCadastroFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/cadastroFuncionarioImagem.jpg"))); // NOI18N
        getContentPane().add(fundoCadastroFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nomeFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeFuncionarioActionPerformed
        // Recebe nome do Funcionario.
    }//GEN-LAST:event_nomeFuncionarioActionPerformed

    private void cpfFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfFuncionarioActionPerformed
        // Recebe o CPF do Funncionario.
    }//GEN-LAST:event_cpfFuncionarioActionPerformed

    private void confirmarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarFuncionarioActionPerformed
        this.cadastrarClientes();
    }//GEN-LAST:event_confirmarFuncionarioActionPerformed

    private void telefoneFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefoneFuncionarioActionPerformed
        // Recebe o telefone do Funcionario.
    }//GEN-LAST:event_telefoneFuncionarioActionPerformed

    private void dataDeNascimentoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataDeNascimentoFuncionarioActionPerformed
        // Recebe a data de nascimento do Funcionario.
    }//GEN-LAST:event_dataDeNascimentoFuncionarioActionPerformed

    private void emailFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFuncionarioActionPerformed
        // Recebe o Email do Funcionario. 
    }//GEN-LAST:event_emailFuncionarioActionPerformed

    private void nivelDeAcessoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nivelDeAcessoFuncionarioActionPerformed
        // Recebe o nível de acesso do Funcionario.
    }//GEN-LAST:event_nivelDeAcessoFuncionarioActionPerformed

    private void senhaFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaFuncionarioActionPerformed
        // Recebe a senha do Funcionario.
    }//GEN-LAST:event_senhaFuncionarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.controller.FuncionarioVoltaMenu();// Volta para o menu inicial 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void sexoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexoFuncionarioActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_sexoFuncionarioActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaCadastroFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmarFuncionario;
    private javax.swing.JTextField cpfFuncionario;
    private javax.swing.JTextField dataDeNascimentoFuncionario;
    private javax.swing.JTextField emailFuncionario;
    private javax.swing.JLabel fundoCadastroFuncionario;
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField nivelDeAcessoFuncionario;
    private javax.swing.JTextField nomeFuncionario;
    private javax.swing.JTextField senhaFuncionario;
    private javax.swing.JComboBox<String> sexoFuncionario;
    private javax.swing.JTextField telefoneFuncionario;
    // End of variables declaration//GEN-END:variables
}
