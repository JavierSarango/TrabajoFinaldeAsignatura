/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

/**
 *
 * @author jona
 */
public class Frm_SoporteTectico extends javax.swing.JDialog {

     /**
      * Creates new form Frm_SoporteTectico
      */
     public Frm_SoporteTectico(java.awt.Frame parent, boolean modal) {
          super(parent, modal);
          initComponents();
     }

     /**
      * This method is called from within the constructor to initialize the
      * form. WARNING: Do NOT modify this code. The content of this method is
      * always regenerated by the Form Editor.
      */
     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          buttonGroup1 = new javax.swing.ButtonGroup();
          jPanel1 = new javax.swing.JPanel();
          jLabel2 = new javax.swing.JLabel();
          jLabel1 = new javax.swing.JLabel();
          jTextField1 = new javax.swing.JTextField();
          txttelefono = new javax.swing.JTextField();
          Apellidos1 = new javax.swing.JLabel();
          txtnombres = new javax.swing.JTextField();
          Apellidos2 = new javax.swing.JLabel();
          txtapellidos = new javax.swing.JTextField();
          Apellidos3 = new javax.swing.JLabel();
          txtcorreo = new javax.swing.JTextField();
          Apellidos4 = new javax.swing.JLabel();
          Apellidos5 = new javax.swing.JLabel();
          txtcelular = new javax.swing.JTextField();
          jComboBox1 = new javax.swing.JComboBox<>();
          jPanel2 = new javax.swing.JPanel();
          jLabel3 = new javax.swing.JLabel();
          jTextField2 = new javax.swing.JTextField();
          jLabel4 = new javax.swing.JLabel();
          jTextField3 = new javax.swing.JTextField();
          jCheckBox1 = new javax.swing.JCheckBox();
          jLabel5 = new javax.swing.JLabel();
          jComboBox2 = new javax.swing.JComboBox<>();
          jButton1 = new javax.swing.JButton();
          jScrollPane1 = new javax.swing.JScrollPane();
          jTable1 = new javax.swing.JTable();

          setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
          getContentPane().setLayout(null);

          jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));
          jPanel1.setLayout(null);

          jLabel2.setText("Nombres:");
          jPanel1.add(jLabel2);
          jLabel2.setBounds(20, 40, 80, 17);

          jLabel1.setText("Identificacion:");
          jPanel1.add(jLabel1);
          jLabel1.setBounds(20, 240, 90, 17);

          jTextField1.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTextField1ActionPerformed(evt);
               }
          });
          jPanel1.add(jTextField1);
          jTextField1.setBounds(120, 280, 170, 23);
          jPanel1.add(txttelefono);
          txttelefono.setBounds(120, 160, 170, 23);

          Apellidos1.setText("Apellidos:");
          jPanel1.add(Apellidos1);
          Apellidos1.setBounds(20, 80, 80, 17);
          jPanel1.add(txtnombres);
          txtnombres.setBounds(120, 40, 170, 23);

          Apellidos2.setText("Apellidos:");
          jPanel1.add(Apellidos2);
          Apellidos2.setBounds(20, 80, 80, 17);
          jPanel1.add(txtapellidos);
          txtapellidos.setBounds(120, 80, 170, 23);

          Apellidos3.setText("Correo:");
          jPanel1.add(Apellidos3);
          Apellidos3.setBounds(20, 120, 70, 17);
          jPanel1.add(txtcorreo);
          txtcorreo.setBounds(120, 120, 170, 23);

          Apellidos4.setText("Telefono:");
          jPanel1.add(Apellidos4);
          Apellidos4.setBounds(20, 160, 70, 17);

          Apellidos5.setText("Celular:");
          jPanel1.add(Apellidos5);
          Apellidos5.setBounds(20, 200, 70, 17);
          jPanel1.add(txtcelular);
          txtcelular.setBounds(120, 200, 170, 23);

          jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "RUC", "Pasaporte", "Cedula" }));
          jPanel1.add(jComboBox1);
          jComboBox1.setBounds(140, 240, 150, 23);

          getContentPane().add(jPanel1);
          jPanel1.setBounds(10, 10, 310, 320);

          jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Equipo Electronico"));
          jPanel2.setLayout(null);

          jLabel3.setText("Modelo:");
          jPanel2.add(jLabel3);
          jLabel3.setBounds(20, 70, 60, 17);
          jPanel2.add(jTextField2);
          jTextField2.setBounds(130, 70, 160, 23);

          jLabel4.setText("Marca:");
          jPanel2.add(jLabel4);
          jLabel4.setBounds(20, 30, 60, 17);
          jPanel2.add(jTextField3);
          jTextField3.setBounds(130, 30, 160, 23);

          jCheckBox1.setText("Cargador:");
          jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jCheckBox1ActionPerformed(evt);
               }
          });
          jPanel2.add(jCheckBox1);
          jCheckBox1.setBounds(130, 160, 97, 21);

          jLabel5.setText("Tipo de Problema");
          jPanel2.add(jLabel5);
          jLabel5.setBounds(20, 110, 130, 17);

          jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Hardware", "Software" }));
          jPanel2.add(jComboBox2);
          jComboBox2.setBounds(140, 110, 150, 23);

          getContentPane().add(jPanel2);
          jPanel2.setBounds(10, 340, 310, 200);

          jButton1.setText("Guardar");
          getContentPane().add(jButton1);
          jButton1.setBounds(20, 550, 120, 23);

          jTable1.setModel(new javax.swing.table.DefaultTableModel(
               new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
               },
               new String [] {
                    "Title 1", "Title 2", "Title 3", "Title 4"
               }
          ));
          jScrollPane1.setViewportView(jTable1);

          getContentPane().add(jScrollPane1);
          jScrollPane1.setBounds(330, 160, 510, 380);

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
          // TODO add your handling code here:
     }//GEN-LAST:event_jTextField1ActionPerformed

     private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
          // TODO add your handling code here:
     }//GEN-LAST:event_jCheckBox1ActionPerformed

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
               java.util.logging.Logger.getLogger(Frm_SoporteTectico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
               java.util.logging.Logger.getLogger(Frm_SoporteTectico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
               java.util.logging.Logger.getLogger(Frm_SoporteTectico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(Frm_SoporteTectico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          //</editor-fold>

          /* Create and display the dialog */
          java.awt.EventQueue.invokeLater(new Runnable() {
               public void run() {
                    Frm_SoporteTectico dialog = new Frm_SoporteTectico(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                         @Override
                         public void windowClosing(java.awt.event.WindowEvent e) {
                              System.exit(0);
                         }
                    });
                    dialog.setVisible(true);
               }
          });
     }

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JLabel Apellidos1;
     private javax.swing.JLabel Apellidos2;
     private javax.swing.JLabel Apellidos3;
     private javax.swing.JLabel Apellidos4;
     private javax.swing.JLabel Apellidos5;
     private javax.swing.ButtonGroup buttonGroup1;
     private javax.swing.JButton jButton1;
     private javax.swing.JCheckBox jCheckBox1;
     private javax.swing.JComboBox<String> jComboBox1;
     private javax.swing.JComboBox<String> jComboBox2;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JLabel jLabel5;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JPanel jPanel2;
     private javax.swing.JScrollPane jScrollPane1;
     private javax.swing.JTable jTable1;
     private javax.swing.JTextField jTextField1;
     private javax.swing.JTextField jTextField2;
     private javax.swing.JTextField jTextField3;
     private javax.swing.JTextField txtapellidos;
     private javax.swing.JTextField txtcelular;
     private javax.swing.JTextField txtcorreo;
     private javax.swing.JTextField txtnombres;
     private javax.swing.JTextField txttelefono;
     // End of variables declaration//GEN-END:variables
}
