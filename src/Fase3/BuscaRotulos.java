/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fase3;

/**
 *
 * @author Rafael
 */
public class BuscaRotulos extends javax.swing.JFrame {

    /**
     * Creates new form BuscaRotulos
     */
    public BuscaRotulos() {
        initComponents();
        listaImagens = new ListaImagens();
        arquivo = new Arquivo();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        listaImagensComRotulo = new javax.swing.JList<String>();
        buscaAnotacoes = new javax.swing.JTextField();
        jButtonBuscaAnotacoes = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listInstantSearch = new javax.swing.JList();
        jButtonAbrirProjeto = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(930, 709));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaImagensComRotulo.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listaImagensComRotulo);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 290, 310));

        buscaAnotacoes.setPreferredSize(new java.awt.Dimension(200, 28));
        buscaAnotacoes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscaAnotacoesKeyReleased(evt);
            }
        });
        jPanel1.add(buscaAnotacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 220, -1));

        jButtonBuscaAnotacoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/buscar2.png"))); // NOI18N
        jButtonBuscaAnotacoes.setFocusable(false);
        jButtonBuscaAnotacoes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonBuscaAnotacoes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonBuscaAnotacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscaAnotacoesActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBuscaAnotacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        jScrollPane1.setBorder(null);

        listInstantSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listInstantSearchMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listInstantSearch);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 220, 110));

        jButtonAbrirProjeto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonAbrirProjeto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/abrir_projeto.png"))); // NOI18N
        jButtonAbrirProjeto.setText("Abrir Projeto");
        jButtonAbrirProjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirProjetoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAbrirProjeto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, 130, -1));

        jTabbedPane1.addTab("Busca de Rótulos", jPanel1);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 76, 340, 570));

        jLabel3.setPreferredSize(new java.awt.Dimension(930, 709));
        jScrollPane3.setViewportView(jLabel3);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 580, 560));

        jLabel1.setFont(new java.awt.Font("MV Boli", 0, 18)); // NOI18N
        jLabel1.setText("Projeto: ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, -1, -1));

        jLabel2.setText("\"nome da imagem atual\"");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 140, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setPreferredSize(new java.awt.Dimension(331, 77));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel8.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 153));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Analise Mitotica1.png"))); // NOI18N
        jPanel2.add(jLabel8, new java.awt.GridBagConstraints());

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 331, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void jButtonBuscaAnotacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscaAnotacoesActionPerformed

    }//GEN-LAST:event_jButtonBuscaAnotacoesActionPerformed

    private void listInstantSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listInstantSearchMouseClicked

    }//GEN-LAST:event_listInstantSearchMouseClicked

    private void buscaAnotacoesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscaAnotacoesKeyReleased

    }//GEN-LAST:event_buscaAnotacoesKeyReleased

    private void jButtonAbrirProjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirProjetoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAbrirProjetoActionPerformed
    private ListaImagens listaImagens;
    private Arquivo arquivo;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscaAnotacoes;
    private javax.swing.JButton jButtonAbrirProjeto;
    private javax.swing.JButton jButtonBuscaAnotacoes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList listInstantSearch;
    private javax.swing.JList<String> listaImagensComRotulo;
    // End of variables declaration//GEN-END:variables
}
