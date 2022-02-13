/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.ufpr.tads.sis;

import java.util.List;
import br.ufpr.tads.sis.model.Curso;
import br.ufpr.tads.sis.ui.datamanager.ControleDados;
import br.ufpr.tads.sis.ui.datamanager.ControleDadosObserver;
import br.ufpr.tads.sis.ui.datamanager.EstadoControleDados;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class CursoFrame extends javax.swing.JFrame implements ControleDadosObserver {

    /**
     * Creates new form CursoFrame
     */
    ControleDados controle = new ControleDados();

    public CursoFrame() {

        initComponents();
        handleStatus();

        novoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // JOptionPane.showMessageDialog(null, "TESTE");
                antesDeAdicionar();

            }
        });

        primeiroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                movePrimeiro(controle);

            }
        });

        proximoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                moveProximo(controle);

            }
        });

        anteriorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                moveAnterior(controle);

            }
        });

        ultimoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                moveUltimo(controle);

            }
        });

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeTextField.getText();
                String sigla = siglaTextField.getText();
                String codigo = codigoTextField.getText();

                Curso nCurso = new Curso(nome, sigla, codigo);

                adiciona(nCurso, controle);

            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                antesEdicao(controle);

            }
        });

        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                remove(controle);

            }
        });

        cursoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                controle.setEstado(EstadoControleDados.CONSULTA);
                handleStatus();
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancela();
            }
        });

    }

    private void atualizaTabela() {

        controle.setEstado(EstadoControleDados.CARREGANDO);
        List<Curso> lista = controle.getList();
        String[][] cursosFormatados = new String[lista.size()][3];
        //System.out.println(lista.get(0).getNome());

        for (int i = 0; i < lista.size(); i++) {
            cursosFormatados[i][0] = lista.get(i).getNome();
            cursosFormatados[i][1] = lista.get(i).getCodigo();
            cursosFormatados[i][2] = lista.get(i).getSigla();

            System.out.println(lista.get(i).getNome());

        }

        cursoTable.setModel(new javax.swing.table.DefaultTableModel(
                cursosFormatados,
                new String[]{
                    "Código", "Nome", "Sigla"
                }
        ));

        handleStatus();

    }

    private void limpaFormulario() {

        nomeTextField.setText(" ");
        siglaTextField.setText(" ");
        codigoTextField.setText("");

    }

    private void handleStatus() {
        EstadoControleDados estado = this.controle.getEstado();
        anteriorButton.setEnabled(false);
        cancelarButton.setEnabled(false);
        novoButton.setEnabled(false);
        primeiroButton.setEnabled(false);
        proximoButton.setEnabled(false);
        salvarButton.setEnabled(false);
        ultimoButton.setEnabled(false);
        editButton.setEnabled(false);
        excluirButton.setEnabled(false);
        switch (estado) {
            case INATIVO:

                novoButton.setEnabled(true);

                break;

            case INCLUSAO:

                cancelarButton.setEnabled(true);

                salvarButton.setEnabled(true);

                break;

            case SALVANDO:
                limpaFormulario();
                break;

            case CARREGANDO:

                novoButton.setEnabled(true);

                jTabbedPane1.setSelectedIndex(0);
                break;

            case CONSULTA:

                consultaHelper();
                break;

            case EDICAO:

                editaHelper();

                break;

            case EXCLUINDO:
                controle.setEstado(EstadoControleDados.CONSULTA);

                break;

            case CANCELANDO:

                controle.setEstado(EstadoControleDados.CONSULTA);
                break;

        }

        defineBotoesDeConsulta();

        statusLabel.setText(estado.toString());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cursoTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nomeTextField = new javax.swing.JTextField();
        siglaTextField = new javax.swing.JTextField();
        codigoTextField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        statusLabel = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        primeiroButton = new javax.swing.JButton();
        anteriorButton = new javax.swing.JButton();
        proximoButton = new javax.swing.JButton();
        ultimoButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        novoButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        salvarButton = new javax.swing.JButton();
        excluirButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Curso");

        jPanel1.setLayout(new java.awt.BorderLayout());

        cursoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Nome", "Sigla"
            }
        ));
        jScrollPane1.setViewportView(cursoTable);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Listagem", jPanel1);

        jLabel1.setText("Código");

        jLabel2.setText("Nome");

        jLabel3.setText("Sigla");

        nomeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nomeTextField))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(siglaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(codigoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 438, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(siglaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(219, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Formulário", jPanel2);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        statusLabel.setText("status");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(592, Short.MAX_VALUE)
                .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(statusLabel)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        jToolBar1.setRollover(true);

        primeiroButton.setText("|<");
        primeiroButton.setFocusable(false);
        primeiroButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        primeiroButton.setMinimumSize(new java.awt.Dimension(50, 25));
        primeiroButton.setPreferredSize(new java.awt.Dimension(75, 28));
        primeiroButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(primeiroButton);

        anteriorButton.setText("<");
        anteriorButton.setFocusable(false);
        anteriorButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        anteriorButton.setMinimumSize(new java.awt.Dimension(50, 25));
        anteriorButton.setPreferredSize(new java.awt.Dimension(75, 28));
        anteriorButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(anteriorButton);

        proximoButton.setText(">");
        proximoButton.setFocusable(false);
        proximoButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        proximoButton.setMinimumSize(new java.awt.Dimension(50, 25));
        proximoButton.setPreferredSize(new java.awt.Dimension(75, 28));
        proximoButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(proximoButton);

        ultimoButton.setText(">|");
        ultimoButton.setFocusable(false);
        ultimoButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ultimoButton.setMinimumSize(new java.awt.Dimension(50, 25));
        ultimoButton.setPreferredSize(new java.awt.Dimension(75, 28));
        ultimoButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(ultimoButton);
        jToolBar1.add(jSeparator1);

        novoButton.setText("Novo");
        novoButton.setFocusable(false);
        novoButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        novoButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(novoButton);

        editButton.setText("Editar");
        editButton.setFocusable(false);
        editButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(editButton);

        cancelarButton.setText("Cancelar");
        cancelarButton.setFocusable(false);
        cancelarButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelarButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(cancelarButton);

        salvarButton.setText("Salvar");
        salvarButton.setFocusable(false);
        salvarButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        salvarButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(salvarButton);

        excluirButton.setText("Excluir");
        excluirButton.setFocusable(false);
        excluirButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        excluirButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(excluirButton);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeTextFieldActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CursoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CursoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CursoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CursoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CursoFrame().setVisible(true);
            }

        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anteriorButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JTextField codigoTextField;
    private javax.swing.JTable cursoTable;
    private javax.swing.JButton editButton;
    private javax.swing.JButton excluirButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JButton novoButton;
    private javax.swing.JButton primeiroButton;
    private javax.swing.JButton proximoButton;
    private javax.swing.JButton salvarButton;
    private javax.swing.JTextField siglaTextField;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JButton ultimoButton;
    // End of variables declaration//GEN-END:variables

    public void remove(ControleDados control) {
        controle.removeElement(cursoTable.getSelectedRow());
        jTabbedPane1.setSelectedIndex(1);
        controle.setEstado(EstadoControleDados.EDICAO);
        handleStatus();
        atualizaTabela();
        handleStatus();
    }

    public void adiciona(Curso nCurso, ControleDados controle) {
        if (nCurso.getNome().trim().length() == 0) {
            String erro = "Não é possível salvar um curso com nome vázio!";

            JOptionPane.showMessageDialog(this, erro);
            throw new Error(erro);

        }

        if (nCurso.getCodigo().trim().length() == 0) {
            String erro = "Não é possível salvar um curso com código vázio!";

            JOptionPane.showMessageDialog(this, erro);
            throw new Error(erro);

        }

        if (nCurso.getSigla().trim().length() == 0) {
            String erro = "Não é possível salvar um curso com sigla vázio!";

            JOptionPane.showMessageDialog(this, erro);
            throw new Error(erro);

        }

        if (controle.getEstado() == EstadoControleDados.EDICAO) {
            controle.setEstado(EstadoControleDados.SALVANDO);

            controle.setCurso(cursoTable.getSelectedRow(), nCurso);

        } else {
            controle.setEstado(EstadoControleDados.SALVANDO);

            controle.addElement(nCurso);

        }
        atualizaTabela();
        jTabbedPane1.setSelectedIndex(0);

        handleStatus();

    }

    public void editaHelper() {
        cancelarButton.setEnabled(true);

        salvarButton.setEnabled(true);
        nomeTextField.setText(controle.getEmFoco().getNome());
        siglaTextField.setText(controle.getEmFoco().getSigla());
        codigoTextField.setText(controle.getEmFoco().getCodigo());
    }

    public void moveProximo(ControleDados controle) {
        int teste = cursoTable.getSelectedRow();
        if (teste == controle.getList().size() - 1) {
            cursoTable.changeSelection(0, 0, false, false);
        } else {
            cursoTable.changeSelection(cursoTable.getSelectedRow() + 1, cursoTable.getSelectedRow() + 1, false, false);
        }
        controle.setEstado(EstadoControleDados.CONSULTA);
        handleStatus();
    }

    public void moveAnterior(ControleDados controle) {
        int teste = cursoTable.getSelectedRow();

        if (teste == 0) {
            cursoTable.changeSelection(controle.getList().size() - 1, controle.getList().size() - 1, false, false);
        } else {
            cursoTable.changeSelection(cursoTable.getSelectedRow() - 1, cursoTable.getSelectedRow() - 1, false, false);
        }
        controle.setEstado(EstadoControleDados.CONSULTA);
        handleStatus();
    }

    public void moveUltimo(ControleDados controle) {
        cursoTable.changeSelection(controle.getList().size() - 1, controle.getList().size() - 1, false, false);
        controle.setEstado(EstadoControleDados.CONSULTA);
        handleStatus();
    }

    public void movePrimeiro(ControleDados controle) {
        controle.setEstado(EstadoControleDados.CONSULTA);

        cursoTable.changeSelection(0, 0, false, false);
        handleStatus();

    }

    public void cancela() {
        controle.setEstado(EstadoControleDados.CANCELANDO);
        limpaFormulario();
        jTabbedPane1.setSelectedIndex(0);
        controle.setEstado(EstadoControleDados.CONSULTA);

        handleStatus();
    }

    public void antesDeAdicionar() {
        controle.setEstado(EstadoControleDados.INCLUSAO);
        jTabbedPane1.setSelectedIndex(1);
        handleStatus();
    }

    public void antesEdicao(ControleDados controle) {
        jTabbedPane1.setSelectedIndex(1);
        controle.setEstado(EstadoControleDados.EDICAO);
        handleStatus();
    }

    public void consultaHelper() {
        novoButton.setEnabled(true);
        excluirButton.setEnabled(true);

        editButton.setEnabled(true);
        int teste = cursoTable.getSelectedRow();
        controle.setEmFoco(teste);
        Curso teste2 = controle.getEmFoco();
        System.out.println(teste2.getNome());
    }

    public void defineBotoesDeConsulta() {
        int teste = controle.getList().size();
        if (teste > 0) {

            primeiroButton.setEnabled(true);
            ultimoButton.setEnabled(true);
        }

        if (teste > 1) {
            anteriorButton.setEnabled(true);
            proximoButton.setEnabled(true);
        }
    }
}
