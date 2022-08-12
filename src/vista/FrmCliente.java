/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Validacion.Validacion;
import controlador.dao.ClienteDao;
import controlador.utiles.Utilidades;
import java.awt.Color;
import javax.swing.JOptionPane;
//import vista.ModeloTablas.ModeloTablaCliente;

/**
 *
 * @author Pc
 */
public class FrmCliente extends javax.swing.JFrame {

    private ClienteDao cc = new ClienteDao();
//    private ModeloTablaCliente mtc = new ModeloTablaCliente();
    private Validacion validacion = new Validacion();
    private Integer id = -1;

    public FrmCliente() {
        initComponents();
        setLocationRelativeTo(null);
        combo();
        limpiar();

    }

    private void combo() {
        this.cbxTipoIdentificacion.removeAllItems();

        for (String aux : Utilidades.tiposI()) {
            this.cbxTipoIdentificacion.addItem(aux);
        }

        cbxTipoIdentificacion.updateUI();

        this.cbxTipoCliente.removeAllItems();
        for (String aux : Utilidades.tiposC()) {
            this.cbxTipoCliente.addItem(aux);
        }
        cbxTipoCliente.updateUI();
    }

    private void cargarTabla() {
//        mtc.setLista(cc.listar());
//        tabla.setModel(mtc);
//        mtc.fireTableStructureChanged();
        tabla.updateUI();

    }

    private void guardar() {

        if (txtRazonSocial.getText().trim().isEmpty() || txtCelular.getText().trim().isEmpty() || txtCorreo.getText().trim().isEmpty() || txtDireccion.getText().trim().isEmpty()
                || txtFechaNa.getText().trim().isEmpty() || txtIdentificacion.getText().trim().isEmpty() || txtTelefono.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos vacios", "ERROR0", JOptionPane.ERROR_MESSAGE);
        } else {
            if (validacion.validaCorreo(txtCorreo.getText()) == true) {
                cc.getCliente().setRazonSocial(txtRazonSocial.getText());
                cc.getCliente().setFechaNacimiento(txtFechaNa.getText());
                cc.getCliente().setCorreo(txtCorreo.getText());
                cc.getCliente().setCelular(txtCelular.getText());
                cc.getCliente().setTelefono(txtTelefono.getText());
                cc.getCliente().setTipoCliente(cbxTipoCliente.getSelectedItem().toString());
                cc.getCliente().setTipoIdentificacion(cbxTipoIdentificacion.getSelectedItem().toString());
                cc.getCliente().setIdentificacion(txtIdentificacion.getText());
                cc.getCliente().setDireccion(txtDireccion.getText());
                if (cc.guardar()) {
                    limpiar();
                    JOptionPane.showMessageDialog(null, "Registro Completo", "Ok", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrarse", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }

    private void limpiar() {

        txtCelular.setText("Ingrese su numero celular");
        txtCelular.setForeground(Color.gray);
        txtCorreo.setText("Ingrese su correo electronico");
        txtCorreo.setForeground(Color.gray);
        txtDireccion.setText("Ingrese su direccion");
        txtDireccion.setForeground(Color.gray);
        txtFechaNa.setText("Ingrese fecha ");
        txtFechaNa.setForeground(Color.gray);
        txtIdentificacion.setText("Ingrese indetificacion RUC/CEDULA");
        txtIdentificacion.setForeground(Color.gray);
        txtRazonSocial.setText("Ingrese su nombre persona/Empresa");
        txtRazonSocial.setForeground(Color.gray);
        txtTelefono.setText("Ingrese telefono ");
        txtTelefono.setForeground(Color.gray);
        cc.setCliente(null);
        cargarTabla();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtRazonSocial = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbxTipoIdentificacion = new javax.swing.JComboBox<>();
        txtCorreo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtFechaNa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbxTipoCliente = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtIdentificacion = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Razon Social");

        txtRazonSocial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRazonSocialMouseClicked(evt);
            }
        });
        txtRazonSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRazonSocialActionPerformed(evt);
            }
        });

        jLabel4.setText("Tipo de Identificacion");

        cbxTipoIdentificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR" }));
        cbxTipoIdentificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbxTipoIdentificacionMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cbxTipoIdentificacionMouseReleased(evt);
            }
        });
        cbxTipoIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxTipoIdentificacionKeyPressed(evt);
            }
        });

        jLabel9.setText("Correo");

        jLabel7.setText("Fecha Nacimiento");

        jLabel6.setText("Tipo Cliente");

        cbxTipoCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtIdentificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIdentificacionMouseClicked(evt);
            }
        });

        jLabel11.setText("Celular");

        jLabel12.setText("Telefono");

        jButton3.setText("Actualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Seleccionar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel13.setText("Direccion");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTipoIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaNa, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(2, 2, 2)
                        .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(2, 2, 2)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6)
                        .addGap(2, 2, 2)
                        .addComponent(cbxTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(2, 2, 2)
                        .addComponent(cbxTipoIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(2, 2, 2)
                        .addComponent(txtFechaNa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel11))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel12)
                        .addGap(2, 2, 2)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel13)))
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(458, 458, 458)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        guardar();        //    guardar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbxTipoIdentificacionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxTipoIdentificacionMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipoIdentificacionMouseReleased

    private void cbxTipoIdentificacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxTipoIdentificacionKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipoIdentificacionKeyPressed

    private void cbxTipoIdentificacionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxTipoIdentificacionMousePressed

        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipoIdentificacionMousePressed

    private void tablaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMousePressed
        //  seleccionar();        // TODO add your handling code here:
    }//GEN-LAST:event_tablaMousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtRazonSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazonSocialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRazonSocialActionPerformed

    private void txtRazonSocialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRazonSocialMouseClicked
        txtRazonSocial.setText("");
        txtRazonSocial.setForeground(Color.BLACK); // TODO add your handling code here:
    }//GEN-LAST:event_txtRazonSocialMouseClicked

    private void txtIdentificacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdentificacionMouseClicked
        txtIdentificacion.setText("");
        txtIdentificacion.setForeground(Color.BLACK);        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdentificacionMouseClicked
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
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxTipoCliente;
    private javax.swing.JComboBox<String> cbxTipoIdentificacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFechaNa;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
