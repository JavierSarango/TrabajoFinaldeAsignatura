/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista.InternalFrame;

import controlador.dao.ProductoDao;
import controlador.services.ServicioProducto;
import controlador.utiles.enums.TipoOrdenacion;
import javax.swing.JOptionPane;
import vista.ModeloTablas.ModeloTablaProducto;

/**
 *
 * @author Gigabyte
 */
public class IF_Producto extends javax.swing.JInternalFrame {

    private ModeloTablaProducto mtp = new ModeloTablaProducto();
    private ServicioProducto sp = new ServicioProducto();
    private ProductoDao productoDao = new ProductoDao();
    /**
     * Creates new form IF_Producto
     */
    public IF_Producto() {
        initComponents();
        limpiar();

        buttonGroup1.add(radioA);
        buttonGroup1.add(radioD);
    }
private void cargarTabla() {
        mtp.setLista(sp.listar());
        tbl_producto.setModel(mtp);
        tbl_producto.updateUI();
    }

//    private void cargarTipo(){
//        cbx_proveedor.removeAllItems();
//        for (String aux : Utilidades.tiposProv()){
//            cbx_proveedor.addItem(aux);
//        }
//    }
    private void limpiar() {
        txt_codigo.setText("");
        txt_nombre.setText("");
        txt_descripcion.setText("");
        txt_unidades.setText("");
        txt_precioCompra.setText("");
        txt_precioVenta.setText("");
        txt_busqueda.setText("");
        cbx_proveedor.setSelectedIndex(0);
        cbx_datoBuscar.setSelectedIndex(0);
        cargarTabla();
    }

    private void guardar() throws Exception {
        if (txt_codigo.getText().trim().isEmpty() || txt_nombre.getText().trim().isEmpty()
                || txt_descripcion.getText().trim().isEmpty() || txt_precioCompra.getText().trim().isEmpty()
                || txt_precioVenta.getText().trim().isEmpty() || txt_unidades.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Porfavor llenar todos los campos requeridos", "Insertar Datos", JOptionPane.WARNING_MESSAGE);

        } else {
            sp.getProducto().setCodigo(Integer.parseInt(txt_codigo.getText()));
            sp.getProducto().setNombre(txt_nombre.getText());
            sp.getProducto().setDescripcion(txt_descripcion.getText());
            sp.getProducto().setUnidades(Integer.parseInt(txt_unidades.getText()));
            sp.getProducto().setPrecioCompra(Double.parseDouble(txt_precioCompra.getText()));
            sp.getProducto().setPrecioVenta(Double.parseDouble(txt_precioVenta.getText()));
//        sp.getProducto().setUpdatedAt(updateAt);

            if (sp.guardar_modificar()) {
                System.out.println("guardado correcto");
                Integer auxId = sp.listar().shellListaEnlazada("idProducto", TipoOrdenacion.ASCENDENTE).obtenerDato(0).getIdProducto();
                limpiar();
            }

            sp.setProducto(null);
            cargarTabla();
        }

    }
    
    public void seleccionar() {
        
        int seleccionar = tbl_producto.getSelectedRow();
        //modelo.Producto nose =productoDao.obtener(seleccionar);
        if (seleccionar >= 0) {
            txt_codigo.setText(String.valueOf(tbl_producto.getValueAt(seleccionar, 1)));
            txt_unidades.setText(String.valueOf(tbl_producto.getValueAt(seleccionar, 2)));
            txt_nombre.setText(String.valueOf(tbl_producto.getValueAt(seleccionar, 3)));
            txt_descripcion.setText(String.valueOf(tbl_producto.getValueAt(seleccionar, 5)));
            txt_precioCompra.setText(String.valueOf(tbl_producto.getValueAt(seleccionar, 6)));
            txt_precioVenta.setText(String.valueOf(tbl_producto.getValueAt(seleccionar, 7)));
            //cbx_proveedor.setSelectedIndex((tbl_producto.getValueAt(seleccionar, 8)));
            
//            cbxcredito.setSelectedItem(String.valueOf(tbl_proveedores.getValueAt(seleccionar, 14)));
           // btn_modificar.setText("Actualizar");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccionar fila que desee cambiar", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    private void modificarrrrr() throws Exception{
        
        if (txt_codigo.getText().trim().isEmpty() || txt_nombre.getText().trim().isEmpty()
                || txt_descripcion.getText().trim().isEmpty() || txt_precioCompra.getText().trim().isEmpty()
                || txt_precioVenta.getText().trim().isEmpty() || txt_unidades.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Porfavor llenar todos los campos requeridos", "Insertar Datos", JOptionPane.WARNING_MESSAGE);

        } else {
            sp.getProducto().setCodigo(Integer.parseInt(txt_codigo.getText()));
            sp.getProducto().setNombre(txt_nombre.getText());
            sp.getProducto().setDescripcion(txt_descripcion.getText());
            sp.getProducto().setUnidades(Integer.parseInt(txt_unidades.getText()));
            sp.getProducto().setPrecioCompra(Double.parseDouble(txt_precioCompra.getText()));
            sp.getProducto().setPrecioVenta(Double.parseDouble(txt_precioVenta.getText()));
//        sp.getProducto().setUpdatedAt(updateAt);

            if (productoDao.modificarManualCliente()) {
                System.out.println("guardado correcto");
                //Integer auxId = sp.listar().shellListaEnlazada("idProducto", TipoOrdenacion.ASCENDENTE).obtenerDato(0).getIdProducto();
                limpiar();
            }

            sp.setProducto(null);
            tbl_producto.setModel(mtp); 
        }
    }

    public void calcularPrecioAutomatico() {
        if (check_automatico.isSelected() & txt_precioCompra.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el precio de compra del Producto\npara proceder con el cálculo automático.", "Precio Compra", JOptionPane.WARNING_MESSAGE);
        } else {
            if (check_automatico.isSelected()) {
                String aux = (txt_precioCompra.getText());
                Double aux1 = Double.parseDouble(aux);
                double pventa = aux1 * 1.50;
                String pventa1 = String.valueOf(pventa);

                txt_precioVenta.setText(pventa1);
            } else {
                txt_precioVenta.setText("");
            }
        }

    }

    private void ordenar() throws Exception {
        String criterio = cbx_datoOrdenar.getSelectedItem().toString().toLowerCase();

        if (radioA.isSelected()) {
            mtp.setLista(sp.listar().shellListaEnlazada(criterio, TipoOrdenacion.ASCENDENTE));
            System.out.println("se ordeno ascendente");
        } else if (radioD.isSelected()) {
            mtp.setLista(sp.listar().shellListaEnlazada(criterio, TipoOrdenacion.DESCENDENTE));
            System.out.println("se ordeno ascendente");

        }
        tbl_producto.setModel(mtp);
        tbl_producto.updateUI();
        
         
    }

    private void buscar() throws Exception {
        String criterioBusqueda = cbx_datoBuscar.getSelectedItem().toString().toLowerCase();
        String datoBusqueda = txt_busqueda.getText().trim().toLowerCase();

        mtp.setLista(sp.listar().buscarDatoPosicionObjetoBinaria(criterioBusqueda, datoBusqueda));
        System.out.println("se realizo busqueda");

        tbl_producto.setModel(mtp);
        tbl_producto.updateUI();
    }
    
    

//////////    private void eliminarDato() throws Exception {
//////////        Integer fila = Integer.valueOf(tbl_producto.getSelectedRow());
//////////        System.out.println("se selecciono la fila");
//////////         
//////////        productoDao
//////////        cargarTabla();
//////////        
//////////        System.out.println("se realizo busqueda");
//////////
//////////        tbl_producto.setModel(mtp);
//////////        tbl_producto.updateUI();
//////////        
//////////    }
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_producto = new javax.swing.JTable();
        bnt_eliminar = new javax.swing.JButton();
        btn_cargarrrr = new javax.swing.JButton();
        btn_modd = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_codigo = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        txt_precioCompra = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_descripcion = new javax.swing.JTextField();
        txt_precioVenta = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbx_proveedor = new javax.swing.JComboBox<>();
        check_automatico = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        txt_unidades = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txt_busqueda = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        cbx_datoBuscar = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        cbx_datoOrdenar = new javax.swing.JComboBox<>();
        radioA = new javax.swing.JRadioButton();
        radioD = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("PRODUCTOS"));
        jPanel1.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "STOCK PRODUCTOS"));
        jPanel2.setLayout(null);

        tbl_producto.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_producto);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 100, 1040, 160);

        bnt_eliminar.setFont(new java.awt.Font("NATS", 1, 14)); // NOI18N
        bnt_eliminar.setText("ELIMINAR");
        bnt_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_eliminarActionPerformed(evt);
            }
        });
        jPanel2.add(bnt_eliminar);
        bnt_eliminar.setBounds(310, 20, 110, 28);

        btn_cargarrrr.setFont(new java.awt.Font("NATS", 1, 14)); // NOI18N
        btn_cargarrrr.setText("cargar");
        btn_cargarrrr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargarrrrActionPerformed(evt);
            }
        });
        jPanel2.add(btn_cargarrrr);
        btn_cargarrrr.setBounds(600, 50, 84, 28);

        btn_modd.setFont(new java.awt.Font("NATS", 1, 14)); // NOI18N
        btn_modd.setText("modd");
        btn_modd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moddActionPerformed(evt);
            }
        });
        jPanel2.add(btn_modd);
        btn_modd.setBounds(580, 20, 72, 28);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 300, 1060, 270);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "AGREGAR PRODUCTOS"));
        jPanel3.setLayout(null);

        jLabel7.setFont(new java.awt.Font("NATS", 1, 14)); // NOI18N
        jLabel7.setText("Código:");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(10, 20, 60, 18);

        jLabel8.setFont(new java.awt.Font("NATS", 1, 14)); // NOI18N
        jLabel8.setText("Nombre:");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(110, 20, 60, 22);
        jPanel3.add(txt_nombre);
        txt_nombre.setBounds(110, 40, 130, 24);

        txt_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoActionPerformed(evt);
            }
        });
        jPanel3.add(txt_codigo);
        txt_codigo.setBounds(10, 40, 90, 24);

        jButton3.setFont(new java.awt.Font("NATS", 1, 14)); // NOI18N
        jButton3.setText("AGREGAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);
        jButton3.setBounds(270, 140, 90, 28);
        jPanel3.add(txt_precioCompra);
        txt_precioCompra.setBounds(10, 90, 90, 24);

        jLabel9.setFont(new java.awt.Font("NATS", 1, 14)); // NOI18N
        jLabel9.setText("Precio Compra:");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(10, 70, 110, 22);

        jLabel10.setFont(new java.awt.Font("NATS", 1, 14)); // NOI18N
        jLabel10.setText("Descripción:");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(250, 20, 100, 22);
        jPanel3.add(txt_descripcion);
        txt_descripcion.setBounds(250, 40, 150, 24);

        txt_precioVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_precioVentaActionPerformed(evt);
            }
        });
        jPanel3.add(txt_precioVenta);
        txt_precioVenta.setBounds(110, 90, 130, 24);

        jLabel11.setFont(new java.awt.Font("NATS", 1, 14)); // NOI18N
        jLabel11.setText("Precio Venta:");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(110, 70, 110, 22);

        jLabel12.setFont(new java.awt.Font("NATS", 1, 14)); // NOI18N
        jLabel12.setText("Proveedor:");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(110, 120, 80, 20);

        cbx_proveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cbx_proveedor);
        cbx_proveedor.setBounds(110, 140, 130, 24);

        check_automatico.setFont(new java.awt.Font("NATS", 1, 14)); // NOI18N
        check_automatico.setText("Precio Automatico");
        check_automatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_automaticoActionPerformed(evt);
            }
        });
        jPanel3.add(check_automatico);
        check_automatico.setBounds(260, 90, 130, 19);

        jLabel14.setFont(new java.awt.Font("NATS", 1, 14)); // NOI18N
        jLabel14.setText("Unidades:");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(10, 120, 70, 20);
        jPanel3.add(txt_unidades);
        txt_unidades.setBounds(10, 140, 90, 24);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 110, 420, 180);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "BUSCAR PRODUCTOS"));
        jPanel4.setLayout(null);

        jLabel13.setFont(new java.awt.Font("NATS", 1, 14)); // NOI18N
        jLabel13.setText("Dato a Buscar:");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(10, 70, 120, 18);
        jPanel4.add(txt_busqueda);
        txt_busqueda.setBounds(10, 90, 180, 24);

        jButton2.setFont(new java.awt.Font("NATS", 1, 14)); // NOI18N
        jButton2.setText("BUSCAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2);
        jButton2.setBounds(10, 140, 80, 28);

        jLabel21.setFont(new java.awt.Font("NATS", 1, 14)); // NOI18N
        jLabel21.setText("Criterio de Busqueda:");
        jPanel4.add(jLabel21);
        jLabel21.setBounds(10, 20, 120, 18);

        cbx_datoBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nombre", "Proveedor" }));
        jPanel4.add(cbx_datoBuscar);
        cbx_datoBuscar.setBounds(10, 40, 130, 24);

        jButton4.setFont(new java.awt.Font("NATS", 1, 14)); // NOI18N
        jButton4.setText("RECARGAR TABLA");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4);
        jButton4.setBounds(100, 140, 122, 28);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(440, 110, 240, 180);
        jPanel4.getAccessibleContext().setAccessibleName("BUSCAR PRODUCTOS");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "ORDENAR PRODUCTOS"));
        jPanel5.setLayout(null);

        jLabel22.setFont(new java.awt.Font("NATS", 1, 14)); // NOI18N
        jLabel22.setText("Criterio de Ordenación:");
        jPanel5.add(jLabel22);
        jLabel22.setBounds(10, 20, 150, 18);

        cbx_datoOrdenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nombre", "Proveedor" }));
        jPanel5.add(cbx_datoOrdenar);
        cbx_datoOrdenar.setBounds(10, 40, 130, 24);

        radioA.setText("Ascendentemente");
        radioA.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioAItemStateChanged(evt);
            }
        });
        radioA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAActionPerformed(evt);
            }
        });
        jPanel5.add(radioA);
        radioA.setBounds(50, 90, 150, 22);

        radioD.setText("Descendetemente");
        radioD.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioDItemStateChanged(evt);
            }
        });
        radioD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioDMouseClicked(evt);
            }
        });
        radioD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDActionPerformed(evt);
            }
        });
        jPanel5.add(radioD);
        radioD.setBounds(50, 120, 150, 22);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(690, 110, 240, 180);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1088, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1076, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 589, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            buscar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo buscar" + e, "Error Búsqueda", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bnt_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_eliminarActionPerformed
        // TODO add your handling code here:
        try {
            //eliminarDato();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_bnt_eliminarActionPerformed

    private void radioAItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioAItemStateChanged
        // TODO add your handling code here:
        try {
            ordenar();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_radioAItemStateChanged

    private void radioAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioAActionPerformed

    private void radioDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioDItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_radioDItemStateChanged

    private void radioDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioDMouseClicked
        // TODO add your handling code here:
        try {
            ordenar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo ordenar" + e, "Error Ordenar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_radioDMouseClicked

    private void radioDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioDActionPerformed

    private void btn_cargarrrrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargarrrrActionPerformed
        // TODO add your handling code here:
        seleccionar();
    }//GEN-LAST:event_btn_cargarrrrActionPerformed

    private void btn_moddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moddActionPerformed
        // TODO add your handling code here:
        try {
            modificarrrrr();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_moddActionPerformed

    private void txt_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            guardar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar" + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void check_automaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_automaticoActionPerformed
        // TODO add your handling code here:
        calcularPrecioAutomatico();
    }//GEN-LAST:event_check_automaticoActionPerformed

    private void txt_precioVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_precioVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_precioVentaActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        cargarTabla();
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnt_eliminar;
    private javax.swing.JButton btn_cargarrrr;
    private javax.swing.JButton btn_modd;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbx_datoBuscar;
    private javax.swing.JComboBox<String> cbx_datoOrdenar;
    private javax.swing.JComboBox<String> cbx_proveedor;
    private javax.swing.JCheckBox check_automatico;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioA;
    private javax.swing.JRadioButton radioD;
    private javax.swing.JTable tbl_producto;
    private javax.swing.JTextField txt_busqueda;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precioCompra;
    private javax.swing.JTextField txt_precioVenta;
    private javax.swing.JTextField txt_unidades;
    // End of variables declaration//GEN-END:variables
}
