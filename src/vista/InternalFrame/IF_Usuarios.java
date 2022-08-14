/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista.InternalFrame;

import Validacion.Validacion;
import controlador.dao.UsuarioDao;
import controlador.utiles.Utilidades;
import controlador.utiles.enums.TipoOrdenacion;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.ModeloTablas.ModeloTablaUsuario;

/**
 *
 * @author Gigabyte
 */
public class IF_Usuarios extends javax.swing.JInternalFrame {

    private ModeloTablaUsuario mtu = new ModeloTablaUsuario();
    private UsuarioDao ud = new UsuarioDao();
    private Validacion validacion = new Validacion();

    /**
     * Creates new form IF_Usuarios
     */
    public IF_Usuarios() {
        initComponents();
        combo();
        limpiar();
    }

    private void combo() {
        this.cbxTipoIdentificacion.removeAllItems();

        for (String aux : Utilidades.tiposI()) {
            this.cbxTipoIdentificacion.addItem(aux);
        }

        cbxTipoIdentificacion.updateUI();

        this.cbxR.removeAllItems();
        for (String aux : Utilidades.tiposR()) {
            this.cbxR.addItem(aux);
        }
        cbxR.updateUI();
    }

    private void cargarTabla() {
        mtu.setLista(ud.listar());
        tablaUsuario.setModel(mtu);
        mtu.fireTableStructureChanged();
        tablaUsuario.updateUI();

    }

    private void guardar() {

        if (txtRazonSocial.getText().trim().isEmpty() || txtCelular.getText().trim().isEmpty() || txtCorreo.getText().trim().isEmpty() || txtDireccion.getText().trim().isEmpty()
                || txtTelefono.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos vacios", "ERROR0", JOptionPane.ERROR_MESSAGE);
        } else {
            if (validacion.validaCorreo(txtCorreo.getText()) == true) {
                ud.getUsuario().setRazonSocial(txtRazonSocial.getText());
                ud.getUsuario().setCorreo(txtCorreo.getText());
                ud.getUsuario().setCelular(txtCelular.getText());
                ud.getUsuario().setTelefono(txtTelefono.getText());
                ud.getUsuario().setNombreUsuario(txtNombreU.getText());
                ud.getUsuario().setContrasena(txtContraseña.getText());
                ud.getUsuario().setTipoRol(cbxR.getSelectedItem().toString());
                ud.getUsuario().setTipoIdentificacion(cbxTipoIdentificacion.getSelectedItem().toString());
                ud.getUsuario().setIdentificacion(txtIdentifiacion.getText());
                ud.getUsuario().setDireccion(txtDireccion.getText());
                if (ud.guardar()) {
                    limpiar();
                    JOptionPane.showMessageDialog(null, "Registro Completo", "Ok", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrarse", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        }

    }

    private void limpiar() {

        txtCelular.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
        txtIdentifiacion.setText("");
        txtRazonSocial.setText("");
        txtTelefono.setText("");
        ud.setUsuario(null);
        cargarTabla();

    }


    public void seleccionar() {
        int seleccionar = tablaUsuario.getSelectedRow();
        if (seleccionar >= 0) {
            Integer id = Integer.parseInt(String.valueOf(tablaUsuario.getValueAt(seleccionar, 0)));
            ud.getUsuario().setId_usuario(id);
            txtRazonSocial.setText(String.valueOf(tablaUsuario.getValueAt(seleccionar, 1)));
            cbxTipoIdentificacion.setSelectedItem(String.valueOf(tablaUsuario.getValueAt(seleccionar, 2)));
            txtIdentifiacion.setText(String.valueOf(tablaUsuario.getValueAt(seleccionar, 3)));
            cbxR.setSelectedItem(String.valueOf(tablaUsuario.getValueAt(seleccionar, 4)));
            txtTelefono.setText(String.valueOf(tablaUsuario.getValueAt(seleccionar, 5)));
            txtCelular.setText(String.valueOf(tablaUsuario.getValueAt(seleccionar, 6)));
            txtCorreo.setText(String.valueOf(tablaUsuario.getValueAt(seleccionar, 7)));
            txtDireccion.setText(String.valueOf(tablaUsuario.getValueAt(seleccionar, 8)));
            txtNombreU.setText(String.valueOf(tablaUsuario.getValueAt(seleccionar, 9)));
            txtContraseña.setText(String.valueOf(tablaUsuario.getValueAt(seleccionar, 10)));
        } else {
            JOptionPane.showMessageDialog(null, "Seleccionar fila que desee cambiar", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }


    private void ordenar() throws Exception {
        String criterio = cbx_datoBusqueda.getSelectedItem().toString().toLowerCase();

        if (radioA.isSelected()) {
            mtu.setLista(ud.listar().shellListaEnlazada(criterio, TipoOrdenacion.ASCENDENTE));
            System.out.println("se ordeno ascendente");
        } else if (radioD.isSelected()) {
            mtu.setLista(ud.listar().shellListaEnlazada(criterio, TipoOrdenacion.DESCENDENTE));
            System.out.println("se ordeno ascendente");

        }
        tablaUsuario.setModel(mtu);
        tablaUsuario.updateUI();

    }

    private void buscar() throws Exception {
        String criterioBusqueda = cbx_datoBusqueda.getSelectedItem().toString().toLowerCase();
        String datoBusqueda = txt_busqueda.getText().trim().toLowerCase();

        mtu.setLista(ud.listar().buscarDatoPosicionObjetoBinaria(criterioBusqueda, datoBusqueda));
        System.out.println("se realizo busqueda");

        tablaUsuario.setModel(mtu);
        tablaUsuario.updateUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtRazonSocial = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbxTipoIdentificacion = new javax.swing.JComboBox<>();
        txtCorreo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        txtTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbxR = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtIdentifiacion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNombreU = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtDireccion = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuario = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        txt_busqueda = new javax.swing.JTextField();
        cbx_datoBusqueda = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        radioA = new javax.swing.JRadioButton();
        radioD = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setLayout(null);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel3.setText("REGISTRO DE USUARIO");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(50, 20, 610, 50);
        jPanel3.add(txtRazonSocial);
        txtRazonSocial.setBounds(10, 120, 230, 22);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Tipo de Identificacion");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(10, 150, 190, 16);

        cbxTipoIdentificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR" }));
        cbxTipoIdentificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbxTipoIdentificacionMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cbxTipoIdentificacionMouseReleased(evt);
            }
        });
        cbxTipoIdentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoIdentificacionActionPerformed(evt);
            }
        });
        cbxTipoIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxTipoIdentificacionKeyPressed(evt);
            }
        });
        jPanel3.add(cbxTipoIdentificacion);
        cbxTipoIdentificacion.setBounds(10, 170, 230, 22);
        jPanel3.add(txtCorreo);
        txtCorreo.setBounds(10, 250, 230, 22);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Telefono");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(500, 160, 80, 16);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Nombre usuario");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(280, 100, 170, 16);
        jPanel3.add(txtContraseña);
        txtContraseña.setBounds(280, 170, 190, 22);
        jPanel3.add(txtTelefono);
        txtTelefono.setBounds(500, 180, 180, 22);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Tipo de Rol");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(500, 210, 130, 16);

        cbxR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cbxR);
        cbxR.setBounds(500, 230, 180, 22);

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(10, 280, 170, 30);

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);
        jButton2.setBounds(190, 280, 150, 30);
        jPanel3.add(txtIdentifiacion);
        txtIdentifiacion.setBounds(10, 200, 230, 22);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Correo");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(10, 230, 90, 16);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Celular");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(500, 100, 90, 16);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Contraseña");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(280, 150, 200, 16);
        jPanel3.add(txtNombreU);
        txtNombreU.setBounds(280, 120, 190, 22);
        jPanel3.add(txtCelular);
        txtCelular.setBounds(500, 120, 180, 22);

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);
        jButton3.setBounds(350, 280, 170, 30);

        jButton4.setText("Actualizar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);
        jButton4.setBounds(530, 280, 150, 30);
        jPanel3.add(txtDireccion);
        txtDireccion.setBounds(280, 220, 190, 22);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Direccion");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(280, 200, 80, 16);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Rason Social ");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(10, 100, 230, 16);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(14, 0, 750, 320);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(null);

        tablaUsuario.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuarioMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaUsuarioMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaUsuario);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(20, 60, 720, 152);

        jButton5.setText("Buscar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5);
        jButton5.setBounds(450, 30, 100, 22);
        jPanel4.add(txt_busqueda);
        txt_busqueda.setBounds(260, 30, 180, 22);

        cbx_datoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "razonSocial", "identificacion" }));
        jPanel4.add(cbx_datoBusqueda);
        cbx_datoBusqueda.setBounds(100, 30, 150, 22);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Buscar por");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(20, 30, 100, 20);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Ordenar");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(30, 220, 80, 16);

        radioA.setText("Ascendente");
        radioA.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioAItemStateChanged(evt);
            }
        });
        jPanel4.add(radioA);
        radioA.setBounds(100, 220, 85, 20);

        radioD.setText("Descendente");
        radioD.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioDItemStateChanged(evt);
            }
        });
        jPanel4.add(radioD);
        radioD.setBounds(200, 220, 98, 20);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(10, 340, 760, 250);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxTipoIdentificacionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxTipoIdentificacionMousePressed

        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipoIdentificacionMousePressed

    private void cbxTipoIdentificacionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxTipoIdentificacionMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipoIdentificacionMouseReleased

    private void cbxTipoIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoIdentificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipoIdentificacionActionPerformed

    private void cbxTipoIdentificacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxTipoIdentificacionKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipoIdentificacionKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        guardar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//    ud.modificarCliente(ud.getUsuario().getId_usuario(), "id_usuario");
//        cargarTabla();   
     //   modificar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ud.eliminarmejorado(ud.getUsuario().getId_usuario(), "id_usuario");
        cargarTabla();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tablaUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuarioMousePressed
        //  seleccionar();        // TODO add your handling code here:
    }//GEN-LAST:event_tablaUsuarioMousePressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            buscar();
        } catch (Exception ex) {
            Logger.getLogger(IF_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void radioAItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioAItemStateChanged
        try {
            ordenar();
        } catch (Exception ex) {
            Logger.getLogger(IF_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_radioAItemStateChanged

    private void radioDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioDItemStateChanged
        try {
            ordenar();
        } catch (Exception ex) {
            Logger.getLogger(IF_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_radioDItemStateChanged

    private void tablaUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuarioMouseClicked
        seleccionar();        // TODO add your handling code here:
    }//GEN-LAST:event_tablaUsuarioMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxR;
    private javax.swing.JComboBox<String> cbxTipoIdentificacion;
    private javax.swing.JComboBox<String> cbx_datoBusqueda;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioA;
    private javax.swing.JRadioButton radioD;
    private javax.swing.JTable tablaUsuario;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIdentifiacion;
    private javax.swing.JTextField txtNombreU;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txt_busqueda;
    // End of variables declaration//GEN-END:variables
}
