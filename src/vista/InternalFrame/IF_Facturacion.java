/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista.InternalFrame;

import Validacion.Validacion;
import controlador.FacturaController;
import controlador.tda.lista.ListaEnlazada;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.DetalleVenta;
import modelo.Venta;
import vista.ModeloTablas.ModeloTablaVentas;

/**
 *
 * @author Gigabyte
 */
public class IF_Facturacion extends javax.swing.JInternalFrame {
    
    private FacturaController fc = new FacturaController();
    private ModeloTablaVentas MTVentas = new ModeloTablaVentas();
    private Validacion validar = new Validacion();

    /**
     * Creates new form IF_Facturacion
     */
    public IF_Facturacion() {
        initComponents();
        jTNombre.setEnabled(false);
        jTtelefono.setEnabled(false);
        jTDireccionCliente.setEnabled(false);
        jTEmail.setEnabled(false);
        jTableVentas.setEnabled(false);
        jBFacturar.setEnabled(false);
        jBProforma.setEnabled(false);
    }
    
    public void limpiar() {
        jTCedula.setText(" ");
        jTNombre.setText(" ");
        jTDireccionCliente.setText(" ");
        jTEmail.setText(" ");
        jTtelefono.setText(" ");
    }
    
    public void DatosCliente() throws Exception {
        String cedula = jTCedula.getText();
        Cliente cliente = fc.consultaCliente(cedula);
        jTNombre.setText(cliente.getRazonSocial());
        jTDireccionCliente.setText(cliente.getDireccion());
        jTEmail.setText(cliente.getIdentificacion());
        jTtelefono.setText(cliente.getTelefono());
        DatosVentas(cliente.getId_cliente());
    }
    
    public void DatosVentas(Integer id) throws Exception {
        ListaEnlazada<Venta> listaVentas = fc.obtenerVentas(id);
        ListaEnlazada<DetalleVenta> listaDetalleVenta = fc.obtenerDetallesVentas(listaVentas);
        cargarTableVentas(listaVentas, listaDetalleVenta);
    }
    
    public void cargarTableVentas(ListaEnlazada lista1, ListaEnlazada lista2) {
        MTVentas.setListaVentas(lista1);
        MTVentas.setListaDetalle(lista2);
        jTableVentas.setModel(MTVentas);
        jTableVentas.updateUI();
    }
    
    public void guardar() {
        if (jTNombre.getText().trim().isEmpty() || jTCedula.getText().trim().isEmpty() || jTDireccionCliente.getText().trim().isEmpty()
                || jTEmail.getText().trim().isEmpty() || jTtelefono.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos vacios", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (validar.validarCedula(jTCedula.getText())) {
//                    if (proveedordao.getProveedores().getId_Proveedor() == null) {
//                        if (proveedordao.guardar()) {
//                            JOptionPane.showMessageDialog(null, "Registro Completo", "Ok", JOptionPane.INFORMATION_MESSAGE);
//                            limpiar();
//                            cargarTableVentas(fc.getVenta().get);
//                        } else {
//                            JOptionPane.showMessageDialog(null, "Error al registrar", "Error", JOptionPane.ERROR_MESSAGE);
//                        }
//                    }

            } else {
                JOptionPane.showMessageDialog(null, "Cedula no valida", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
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

        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVentas = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jBProforma = new javax.swing.JButton();
        jBFacturar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTtelefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTEmail = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTCedula = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTDireccionCliente = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jTNombre = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel2.setLayout(null);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(20, 80, 730, 20);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setLayout(null);

        jTableVentas.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableVentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableVentas);

        jPanel8.add(jScrollPane1);
        jScrollPane1.setBounds(10, 40, 690, 270);

        jLabel6.setText("Ventas Realizadas al Cliente");
        jPanel8.add(jLabel6);
        jLabel6.setBounds(10, 10, 170, 16);

        jBProforma.setText("Proformar");
        jBProforma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBProformaActionPerformed(evt);
            }
        });
        jPanel8.add(jBProforma);
        jBProforma.setBounds(610, 330, 90, 25);

        jBFacturar.setText("Facturar");
        jBFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFacturarActionPerformed(evt);
            }
        });
        jPanel8.add(jBFacturar);
        jBFacturar.setBounds(470, 330, 90, 25);

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton1);
        jButton1.setBounds(340, 330, 90, 25);

        jPanel2.add(jPanel8);
        jPanel8.setBounds(10, 240, 730, 370);

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        jLabel5.setText("TELEFONO MOVIL:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(460, 100, 150, 30);
        jPanel2.add(jTtelefono);
        jTtelefono.setBounds(460, 130, 160, 22);

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        jLabel7.setText("EMAIL:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(460, 150, 100, 30);

        jTEmail.setToolTipText("");
        jPanel2.add(jTEmail);
        jTEmail.setBounds(460, 180, 260, 30);
        jPanel2.add(jSeparator2);
        jSeparator2.setBounds(10, 230, 730, 20);

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        jLabel9.setText("DIRECCIÓN COMPRADOR:");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(20, 120, 160, 30);

        jLabel10.setText("Busqueda del Cliente");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(20, 10, 190, 30);

        jLabel3.setText("Identificador:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 40, 80, 30);

        jTCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTCedulaKeyTyped(evt);
            }
        });
        jPanel2.add(jTCedula);
        jTCedula.setBounds(110, 40, 280, 30);

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btBuscar);
        btBuscar.setBounds(420, 40, 100, 30);

        jTDireccionCliente.setColumns(20);
        jTDireccionCliente.setRows(5);
        jScrollPane3.setViewportView(jTDireccionCliente);

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(20, 150, 410, 70);

        jLabel2.setText("Nombre:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 90, 50, 16);

        jTNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNombreActionPerformed(evt);
            }
        });
        jPanel2.add(jTNombre);
        jTNombre.setBounds(110, 90, 280, 22);
        jPanel2.add(jSeparator3);
        jSeparator3.setBounds(20, 10, 730, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 792, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 636, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVentasMouseClicked
        //        editarCarrito();
    }//GEN-LAST:event_jTableVentasMouseClicked

    private void jBProformaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBProformaActionPerformed

    }//GEN-LAST:event_jBProformaActionPerformed

    private void jBFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFacturarActionPerformed
        //        guardar(true);
    }//GEN-LAST:event_jBFacturarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //        limpiar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCedulaKeyTyped
        validar.validaSeaNumero(evt, jTCedula, 10);
    }//GEN-LAST:event_jTCedulaKeyTyped

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        try {
            DatosCliente();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "fallo al obtener cliente y ventas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void jTNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton jBFacturar;
    private javax.swing.JButton jBProforma;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTCedula;
    private javax.swing.JTextArea jTDireccionCliente;
    private javax.swing.JTextField jTEmail;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTable jTableVentas;
    private javax.swing.JTextField jTtelefono;
    // End of variables declaration//GEN-END:variables
}
