/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista.InternalFrame;

import Validacion.Validacion;
import controlador.dao.ClienteDao;
import controlador.utiles.Utilidades;
import java.awt.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.Frm_Cliente;
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
    }
 private void cargarCampos() {
        Calendar calendar = new GregorianCalendar();
        jLabelFecha.setText("" + calendar.get(Calendar.YEAR) + " / " + calendar.get(Calendar.MONTH + 1) + " / " + calendar.get(Calendar.DAY_OF_MONTH));

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
        tbl_usuario.setModel(mtc);
        mtc.fireTableStructureChanged();
        tbl_usuario.updateUI();

    }

    private void guardar() {

        if (txtRazonSocial.getText().trim().isEmpty() || txtCelular.getText().trim().isEmpty() || txtCorreo.getText().trim().isEmpty() || txtDireccion.getText().trim().isEmpty()
                || txtIdentificacion.getText().trim().isEmpty() || txtTelefono.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos vacios", "ERROR0", JOptionPane.ERROR_MESSAGE);
        } else {
            if (validacion.validaCorreo(txtCorreo.getText()) == true) {
                cc.getCliente().setRazonSocial(txtRazonSocial.getText());
                cc.getCliente().setFechaNacimiento(jLabelFecha.getText());
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

    private void Eliminar() {
        seleccionar = tbl_usuario.getSelectedRow();
        System.out.println("se selecciono la fila");
        try {
            if (seleccionar >= 0) {
                System.out.println(seleccionar + " se selecciono la fila");

                int opcion = JOptionPane.showConfirmDialog(null, "¿Esta Seguro de eliminar registro?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opcion == JOptionPane.YES_OPTION) {
                    cc.delete(seleccionar);
                    JOptionPane.showMessageDialog(null, "Se elimino correctamente", "OK", JOptionPane.INFORMATION_MESSAGE);
                    cargarTabla();
                } else if (opcion == JOptionPane.NO_OPTION) {
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {

        }
    }

    private void Eliminara() {
        seleccionar = tbl_usuario.getSelectedRow();
        try {
            if (seleccionar >= 0) {
                cc.delete(seleccionar);
                JOptionPane.showMessageDialog(null, "Se elimino correctamente", "OK", JOptionPane.INFORMATION_MESSAGE);
                cargarTabla();

            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {

        }
    }

    private void limpiar() {

        txtCelular.setText("Ingrese su numero celular");
        txtCelular.setForeground(Color.gray);
        txtCorreo.setText("Ingrese su correo electronico");
        txtCorreo.setForeground(Color.gray);
        txtDireccion.setText("Ingrese su direccion");
        txtDireccion.setForeground(Color.gray);
        jLabelFecha.setText("Ingrese fecha ");
        jLabelFecha.setForeground(Color.BLACK);
        txtIdentificacion.setText("Ingrese indetificacion RUC/CEDULA");
        txtIdentificacion.setForeground(Color.gray);
        txtRazonSocial.setText("Ingrese su nombre persona/Empresa");
        txtRazonSocial.setForeground(Color.gray);
        txtTelefono.setText("Ingrese telefono ");
        txtTelefono.setForeground(Color.gray);
        cc.setCliente(null);
        cargarTabla();

    }

    public void seleccionar() throws Exception {
        limpiar();
        seleccionar = tbl_usuario.getSelectedRow();
        if (seleccionar >= 0) {
            txtCelular.setText(String.valueOf(tbl_usuario.getValueAt(seleccionar, 1)));
            cbxTipoCliente.setSelectedItem(String.valueOf(tbl_usuario.getValueAt(seleccionar, 2)));
            txtDireccion.setText(String.valueOf(tbl_usuario.getValueAt(seleccionar, 3)));
            txtCorreo.setText(String.valueOf(tbl_usuario.getValueAt(seleccionar, 4)));
            txtIdentificacion.setText(String.valueOf(tbl_usuario.getValueAt(seleccionar, 5)));
            txtRazonSocial.setText(String.valueOf(tbl_usuario.getValueAt(seleccionar, 6)));
            txtTelefono.setText(String.valueOf(tbl_usuario.getValueAt(seleccionar, 7)));
            cbxTipoIdentificacion.setSelectedItem(String.valueOf(tbl_usuario.getValueAt(seleccionar, 8)));
        } else {
            JOptionPane.showMessageDialog(null, "Seleccionar fila que desee cambiar", "Error", JOptionPane.ERROR_MESSAGE);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtRazonSocial = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbxTipoIdentificacion = new javax.swing.JComboBox<>();
        txtCorreo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
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
        jLabelFecha = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_usuario = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setLayout(null);

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

        jLabel11.setText("Celular");

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

        jLabelFecha.setText("jLabel1");

        jButton5.setText("Eliminar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
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
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxTipoIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(60, 60, 60))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabelFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(50, 50, 50)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jButton3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(50, 50, 50)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxTipoIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelFecha))
                        .addGap(6, 6, 6)
                        .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(42, 42, 42)
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
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 30, 880, 250);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbl_usuario.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_usuarioMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_usuarioMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_usuario);

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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(458, 458, 458)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(12, 310, 880, 220);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
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
        Eliminara();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            seleccionar();
            // TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(Frm_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtDireccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDireccionMouseClicked
        txtDireccion.setText("");
        txtDireccion.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtDireccionMouseClicked

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Eliminar();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tbl_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_usuarioMouseClicked
        //        Eliminar();        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_usuarioMouseClicked

    private void tbl_usuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_usuarioMousePressed
        //  seleccionar();        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_usuarioMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxTipoCliente;
    private javax.swing.JComboBox<String> cbxTipoIdentificacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_usuario;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
