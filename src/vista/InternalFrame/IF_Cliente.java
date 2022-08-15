/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista.InternalFrame;

import Validacion.Validacion;
import controlador.dao.ClienteDao;
import controlador.utiles.Utilidades;
import controlador.utiles.enums.TipoOrdenacion;
import java.awt.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.ModeloTablas.ModeloTablaCliente;

/**
 *
 * @author Gigabyte
 */
public class IF_Cliente extends javax.swing.JInternalFrame {

    private ClienteDao cc = new ClienteDao();
    private ModeloTablaCliente mtc = new ModeloTablaCliente();
    private Validacion validacion = new Validacion();
    private Integer seleccionar = -1;

    /**
     * Creates new form IF_Cliente
     */
    public IF_Cliente() {
        initComponents();
        combo();
        limpiar();
        buttonGroup1.add(radioA);
        buttonGroup1.add(radioD);
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
        mtc.setLista(cc.listar());
        tabla_clientes.setModel(mtc);
        mtc.fireTableStructureChanged();
        tabla_clientes.updateUI();

    }

    private void guardar() {

        if (txtRazonSocial.getText().trim().isEmpty() || txtCelular.getText().trim().isEmpty() || txtCorreo.getText().trim().isEmpty() || txtDireccion.getText().trim().isEmpty()
                || txtIdentificacion.getText().trim().isEmpty() || txtTelefono.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos vacios", "ERROR0", JOptionPane.ERROR_MESSAGE);
        } else {
            int select = cbxTipoIdentificacion.getSelectedIndex();
            switch (select) {
                case 0:
                        if (validacion.validaCorreo(txtCorreo.getText()) == true) {
                            cc.getCliente().setRazonSocial(txtRazonSocial.getText());
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
                        } else {
                            JOptionPane.showMessageDialog(null, "Correo invalido", "Ok", JOptionPane.INFORMATION_MESSAGE);
                        }
                   

                    break;
                case 1:
                    if (validacion.validarCedula(txtIdentificacion.getText())== true) {
                        if (validacion.validaCorreo(txtCorreo.getText()) == true) {
                            cc.getCliente().setRazonSocial(txtRazonSocial.getText());
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
                        } else {
                            JOptionPane.showMessageDialog(null, "Correo invalido", "Ok", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "CEDULA invalido", "Ok", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                    default:
            }
        }
    }
        private void modificarrrrr() throws Exception {

                if (txtRazonSocial.getText().trim().isEmpty() || txtCelular.getText().trim().isEmpty() || txtCorreo.getText().trim().isEmpty() || txtDireccion.getText().trim().isEmpty()
                || txtIdentificacion.getText().trim().isEmpty() || txtTelefono.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos vacios", "ERROR0", JOptionPane.ERROR_MESSAGE);

        } else {
            try {
                cc.getCliente().setRazonSocial(txtRazonSocial.getText());
                cc.getCliente().setCorreo(txtCorreo.getText());
                cc.getCliente().setCelular(txtCelular.getText());
                cc.getCliente().setTelefono(txtTelefono.getText());
                cc.getCliente().setTipoCliente(cbxTipoCliente.getSelectedItem().toString());
                cc.getCliente().setTipoIdentificacion(cbxTipoIdentificacion.getSelectedItem().toString());
                cc.getCliente().setIdentificacion(txtIdentificacion.getText());
                cc.getCliente().setDireccion(txtDireccion.getText());
                
              cc.modificarArreglado(
                cc.getCliente().getRazonSocial(), 
                cc.getCliente().getTelefono(),
                cc.getCliente().getCelular(),
                cc.getCliente().getCorreo(),
                cc.getCliente().getDireccion(),
                cc.getCliente().getTipoIdentificacion(),
                cc.getCliente().getIdentificacion(),
                cc.getCliente().getTipoCliente(),
                cc.getCliente().getId_cliente());
                JOptionPane.showMessageDialog(null, "Modificador Correctamente", "Ok", JOptionPane.INFORMATION_MESSAGE);
                cargarTabla();
            } catch (Exception ex) {
            }
        }
    }


    private void limpiar() {

        txtCelular.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
        txtIdentificacion.setText("");
        txtRazonSocial.setText("");
        txtTelefono.setText("");
        cc.setCliente(null);
        cargarTabla();

    }

    public void seleccionar() {
        int seleccionar = tabla_clientes.getSelectedRow();
        if (seleccionar >= 0) {
            Integer id = Integer.parseInt(String.valueOf(tabla_clientes.getValueAt(seleccionar, 0)));
            cc.getCliente().setId_cliente(id);
            txtRazonSocial.setText(String.valueOf(tabla_clientes.getValueAt(seleccionar, 1)));
            cbxTipoIdentificacion.setSelectedItem(String.valueOf(tabla_clientes.getValueAt(seleccionar, 2)));
            txtIdentificacion.setText(String.valueOf(tabla_clientes.getValueAt(seleccionar, 3)));
            cbxTipoCliente.setSelectedItem(String.valueOf(tabla_clientes.getValueAt(seleccionar, 4)));
            txtTelefono.setText(String.valueOf(tabla_clientes.getValueAt(seleccionar, 5)));
            txtCelular.setText(String.valueOf(tabla_clientes.getValueAt(seleccionar, 6)));
            txtCorreo.setText(String.valueOf(tabla_clientes.getValueAt(seleccionar, 7)));
            txtDireccion.setText(String.valueOf(tabla_clientes.getValueAt(seleccionar, 8)));

        } else {
            JOptionPane.showMessageDialog(null, "Seleccionar fila que desee cambiar", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void ordenar() throws Exception {
        String criterio = cbx_datoBusqueda.getSelectedItem().toString().toLowerCase();

        if (radioA.isSelected()) {
            mtc.setLista(cc.listar().shellListaEnlazada("razonSocial", TipoOrdenacion.ASCENDENTE));
            System.out.println("se ordeno ascendente");
        } else if (radioD.isSelected()) {
            mtc.setLista(cc.listar().shellListaEnlazada("razonSocial", TipoOrdenacion.DESCENDENTE));
            System.out.println("se ordeno ascendente");

        }
        tabla_clientes.setModel(mtc);
        tabla_clientes.updateUI();

    }

    private void buscar() throws Exception {
        String criterioBusqueda = cbx_datoBusqueda.getSelectedItem().toString().toLowerCase();
        String datoBusqueda = txt_busqueda.getText().trim().toLowerCase();

        mtc.setLista(cc.listar().buscarDatoPosicionObjetoBinaria(criterioBusqueda, datoBusqueda));
        System.out.println("se realizo busqueda");

        tabla_clientes.setModel(mtc);
        tabla_clientes.updateUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtRazonSocial = new javax.swing.JTextField();
        cbxTipoIdentificacion = new javax.swing.JComboBox<>();
        txtCorreo = new javax.swing.JTextField();
        cbxTipoCliente = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtIdentificacion = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        txtDireccion = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_clientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_busqueda = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        cbx_datoBusqueda = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        radioD = new javax.swing.JRadioButton();
        radioA = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setLayout(null);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(null);

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
        txtRazonSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazonSocialKeyTyped(evt);
            }
        });
        jPanel3.add(txtRazonSocial);
        txtRazonSocial.setBounds(10, 30, 210, 30);

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
        jPanel3.add(cbxTipoIdentificacion);
        cbxTipoIdentificacion.setBounds(10, 100, 210, 30);

        txtCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCorreoMouseClicked(evt);
            }
        });
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        jPanel3.add(txtCorreo);
        txtCorreo.setBounds(250, 30, 200, 30);

        cbxTipoCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cbxTipoCliente);
        cbxTipoCliente.setBounds(250, 90, 200, 30);

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(10, 190, 170, 30);

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);
        jButton2.setBounds(200, 190, 180, 30);

        txtIdentificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIdentificacionMouseClicked(evt);
            }
        });
        txtIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdentificacionKeyTyped(evt);
            }
        });
        jPanel3.add(txtIdentificacion);
        txtIdentificacion.setBounds(10, 140, 210, 30);

        txtCelular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCelularMouseClicked(evt);
            }
        });
        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });
        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularKeyTyped(evt);
            }
        });
        jPanel3.add(txtCelular);
        txtCelular.setBounds(250, 140, 210, 30);

        txtTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTelefonoMouseClicked(evt);
            }
        });
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel3.add(txtTelefono);
        txtTelefono.setBounds(490, 30, 220, 30);

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);
        jButton3.setBounds(390, 190, 150, 30);

        txtDireccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDireccionMouseClicked(evt);
            }
        });
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        jPanel3.add(txtDireccion);
        txtDireccion.setBounds(490, 90, 220, 30);

        jButton5.setText("Actualizar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5);
        jButton5.setBounds(550, 190, 160, 30);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Correo");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(250, 10, 210, 16);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Tipo de Cliente");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(250, 70, 210, 16);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Direccion");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(490, 70, 210, 16);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Tipo de Identificacion");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(10, 70, 210, 16);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Celular");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(250, 120, 210, 16);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Telefono");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(490, 10, 210, 16);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Razon Social ");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(10, 10, 210, 16);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(20, 80, 750, 240);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(null);

        tabla_clientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_clientesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_clientesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_clientes);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(10, 40, 730, 170);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Buscar por");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(10, 10, 100, 20);
        jPanel4.add(txt_busqueda);
        txt_busqueda.setBounds(250, 10, 180, 22);

        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4);
        jButton4.setBounds(440, 10, 100, 22);

        cbx_datoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "razonSocial", "identificacion" }));
        jPanel4.add(cbx_datoBusqueda);
        cbx_datoBusqueda.setBounds(90, 10, 150, 22);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Ordenar");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(10, 220, 80, 16);

        radioD.setText("Descendente");
        radioD.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioDItemStateChanged(evt);
            }
        });
        jPanel4.add(radioD);
        radioD.setBounds(180, 220, 98, 20);

        radioA.setText("Ascendente");
        radioA.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioAItemStateChanged(evt);
            }
        });
        jPanel4.add(radioA);
        radioA.setBounds(80, 220, 85, 20);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(12, 330, 760, 250);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setText("REGISTRO DE CLIENTES");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(180, 20, 430, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRazonSocialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRazonSocialMouseClicked
        txtRazonSocial.setText("");
        txtRazonSocial.setForeground(Color.BLACK); // TODO add your handling code here:
    }//GEN-LAST:event_txtRazonSocialMouseClicked

    private void txtRazonSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazonSocialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRazonSocialActionPerformed

    private void cbxTipoIdentificacionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxTipoIdentificacionMousePressed

        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipoIdentificacionMousePressed

    private void cbxTipoIdentificacionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxTipoIdentificacionMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipoIdentificacionMouseReleased

    private void cbxTipoIdentificacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxTipoIdentificacionKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipoIdentificacionKeyPressed

    private void txtCorreoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCorreoMouseClicked
        txtCorreo.setText("");
        txtCorreo.setForeground(Color.BLACK);    // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoMouseClicked

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        txtCorreo.setText("");
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        guardar();        //    guardar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                  int opcion = JOptionPane.showConfirmDialog(null, "¿Esta Seguro de modificar ?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION) {
                      try {
                          modificarrrrr();
                      } catch (Exception ex) {
                          Logger.getLogger(IF_Cliente.class.getName()).log(Level.SEVERE, null, ex);
                      }
            JOptionPane.showMessageDialog(null, "Se modifico correctamente", "OK", JOptionPane.INFORMATION_MESSAGE);
            cargarTabla();
        } else if (opcion == JOptionPane.NO_OPTION) {
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtIdentificacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdentificacionMouseClicked
        txtIdentificacion.setText("");
        txtIdentificacion.setForeground(Color.BLACK);        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdentificacionMouseClicked

    private void txtCelularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCelularMouseClicked
        txtCelular.setText("");
        txtCelular.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtCelularMouseClicked

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed

    }//GEN-LAST:event_txtCelularActionPerformed

    private void txtTelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefonoMouseClicked
        txtTelefono.setText("");
        txtTelefono.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtTelefonoMouseClicked

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        txtTelefono.setText("");
        txtTelefono.setForeground(Color.BLACK);        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        
               int opcion = JOptionPane.showConfirmDialog(null, "¿Esta Seguro de eliminar registro?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION) {
                 cc.eliminarmejorado(cc.getCliente().getId_cliente(), "id_cliente");
            JOptionPane.showMessageDialog(null, "Se elimino correctamente", "OK", JOptionPane.INFORMATION_MESSAGE);
            cargarTabla();
        } else if (opcion == JOptionPane.NO_OPTION) {
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtDireccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDireccionMouseClicked
        txtDireccion.setText("");
        txtDireccion.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtDireccionMouseClicked

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
//        Eliminar();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tabla_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_clientesMouseClicked
        try {
            seleccionar();        //        Eliminar();        // TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(IF_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tabla_clientesMouseClicked

    private void tabla_clientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_clientesMousePressed
        //  seleccionar();        // TODO add your handling code here:
    }//GEN-LAST:event_tabla_clientesMousePressed

    private void radioAItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioAItemStateChanged
        try {
            ordenar();        // TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(IF_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_radioAItemStateChanged

    private void radioDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioDItemStateChanged
        try {
            ordenar();// TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(IF_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_radioDItemStateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            buscar();        // TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(IF_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtRazonSocialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSocialKeyTyped
    char c = evt.getKeyChar();
        
        if ((c < 'a' || c > 'z')&&(c < 'A' || c > 'Z')) {
            evt.consume();
        }        
    }//GEN-LAST:event_txtRazonSocialKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
validacion.validaSeaNumero(evt, txtTelefono, 20);        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyTyped
validacion.validaSeaNumero(evt, txtCelular, 20);          // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularKeyTyped

    private void txtIdentificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdentificacionKeyTyped
validacion.validaSeaNumero(evt, txtIdentificacion, 20);          // TODO add your handling code here:
    }//GEN-LAST:event_txtIdentificacionKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxTipoCliente;
    private javax.swing.JComboBox<String> cbxTipoIdentificacion;
    private javax.swing.JComboBox<String> cbx_datoBusqueda;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioA;
    private javax.swing.JRadioButton radioD;
    private javax.swing.JTable tabla_clientes;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txt_busqueda;
    // End of variables declaration//GEN-END:variables
}
