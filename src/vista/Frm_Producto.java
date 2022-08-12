/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import controlador.services.ServicioProducto;
import controlador.utiles.Utilidades;
import javax.swing.JOptionPane;
import modelo.Producto;
import vista.ModeloTablas.ModeloTablaProducto;

/**
 *
 * @author diego
 */
public class Frm_Producto extends javax.swing.JDialog {
    
    private ModeloTablaProducto mtp = new ModeloTablaProducto();
    private ServicioProducto sp = new ServicioProducto();

    /**
     * Creates new form Frm_Productos
     */
    public Frm_Producto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarTabla();
    }
    
    private void cargarTabla(){
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
    
    private void limpiar(){
        txt_codigo.setText("");
        txt_nombre.setText("");
        txt_descripcion.setText("");
        txt_precioCompra.setText("");
        txt_precioVenta.setText("");
        txt_busqueda.setText("");
        cbx_proveedor.setSelectedIndex(0);
        cbx_datoBusqueda.setSelectedIndex(0);
    }
    
    private void guardar(){
        sp.getProducto().setCodigo(Integer.parseInt(txt_codigo.getText()));
        sp.getProducto().setNombre(txt_nombre.getText());
        sp.getProducto().setDescripcion( txt_descripcion.getText());
        sp.getProducto().setPrecioCompra(Double.parseDouble(txt_precioCompra.getText()));
        sp.getProducto().setPrecioVenta(Double.parseDouble(txt_precioVenta.getText()));  
//        sp.getProducto().setUpdatedAt(updateAt);

        if (sp.guardar_modificar()) {
            System.out.println("guardado correcto");
            limpiar();
        }
        
        sp.setProducto(null);
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

        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_busqueda = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_producto = new javax.swing.JTable();
        cbx_datoBusqueda = new javax.swing.JComboBox<>();
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
        jCheckBox1 = new javax.swing.JCheckBox();

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Búsqueda");

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel3.setText("Código:");

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel4.setText("Nombre:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("PRODUCTOS"));
        jPanel1.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "BUSCAR PRODUCTOS"));
        jPanel2.setLayout(null);

        jLabel6.setText("Buscar según:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(30, 20, 100, 16);
        jPanel2.add(txt_busqueda);
        txt_busqueda.setBounds(170, 50, 300, 22);

        jButton2.setText("BUSCAR");
        jPanel2.add(jButton2);
        jButton2.setBounds(490, 50, 110, 22);

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
        jScrollPane1.setBounds(10, 90, 680, 210);

        cbx_datoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbx_datoBusqueda);
        cbx_datoBusqueda.setBounds(20, 50, 130, 22);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 150, 700, 310);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "AGREGAR PRODUCTOS"));
        jPanel3.setLayout(null);

        jLabel7.setText("Código:");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(20, 20, 60, 16);

        jLabel8.setText("Nombre:");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(110, 20, 60, 16);
        jPanel3.add(txt_nombre);
        txt_nombre.setBounds(100, 40, 160, 22);

        txt_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoActionPerformed(evt);
            }
        });
        jPanel3.add(txt_codigo);
        txt_codigo.setBounds(10, 40, 85, 22);

        jButton3.setText("AGREGAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);
        jButton3.setBounds(560, 90, 110, 22);
        jPanel3.add(txt_precioCompra);
        txt_precioCompra.setBounds(270, 40, 130, 22);

        jLabel9.setText("Precio Compra:");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(280, 20, 110, 16);

        jLabel10.setText("Descripción:");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(20, 70, 100, 16);
        jPanel3.add(txt_descripcion);
        txt_descripcion.setBounds(10, 90, 390, 22);
        jPanel3.add(txt_precioVenta);
        txt_precioVenta.setBounds(410, 40, 130, 22);

        jLabel11.setText("Precio Venta:");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(420, 20, 110, 16);

        jLabel12.setText("Proveedor:");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(420, 70, 80, 16);

        cbx_proveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cbx_proveedor);
        cbx_proveedor.setBounds(410, 90, 130, 22);

        jCheckBox1.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        jCheckBox1.setText("Precio Automático");
        jPanel3.add(jCheckBox1);
        jCheckBox1.setBounds(550, 40, 140, 20);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(20, 20, 700, 130);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 730, 470);

        setSize(new java.awt.Dimension(759, 517));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            guardar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar" +e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txt_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Frm_Producto dialog = new Frm_Producto(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cbx_datoBusqueda;
    private javax.swing.JComboBox<String> cbx_proveedor;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tbl_producto;
    private javax.swing.JTextField txt_busqueda;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precioCompra;
    private javax.swing.JTextField txt_precioVenta;
    // End of variables declaration//GEN-END:variables
}
