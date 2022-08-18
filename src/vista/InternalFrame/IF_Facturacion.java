/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista.InternalFrame;

import Validacion.Validacion;
import controlador.FacturaController;
import controlador.dao.FacturaDao;
import controlador.dao.ProductoDao;
import controlador.tda.lista.ListaEnlazada;
import java.awt.Graphics;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.DetalleFactura;
import modelo.DetalleVenta;
import modelo.Factura;
import modelo.Producto;
import modelo.Venta;
import vista.ModeloTablas.ModeloTablaVentas;

/**
 *
 * @author Gigabyte
 */
public class IF_Facturacion extends javax.swing.JInternalFrame {

    private FacturaDao fd = new FacturaDao();
    private FacturaController fc = new FacturaController();
    private ModeloTablaVentas MTVentas = new ModeloTablaVentas();
    private Validacion validar = new Validacion();
    private ProductoDao pd = new ProductoDao();
    foto f = new foto();
    ImageIcon bu = new ImageIcon("src/RecursosMultimedia/buscar.gif");

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
        btBuscar.setIcon(bu);
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
        DatosVentas(cliente);
        jTableVentas.setEnabled(true);
        jBFacturar.setEnabled(true);
    }

    public void DatosVentas(Cliente cliente) throws Exception {
        ListaEnlazada<Venta> listaVentas = fc.obtenerVentas(cliente.getId_cliente());
        ListaEnlazada<DetalleVenta> listaDetalleVenta = fc.obtenerDetallesVentas(listaVentas);
        ListaEnlazada<Producto> listaproducto = new ListaEnlazada<>();
        for (int i = 0; i < listaDetalleVenta.getSize(); i++) {
            listaproducto.insertar(pd.listarIDProducto(listaDetalleVenta.obtenerDato(i).getId_Producto()));
        }
        cargarTableVentas(listaVentas, listaDetalleVenta, listaproducto, cliente);
    }

    public void cargarTableVentas(ListaEnlazada lista1, ListaEnlazada lista2, ListaEnlazada lista3, Cliente cliente) {
        MTVentas.setListaVentas(lista1);
        MTVentas.setListaDetalle(lista2);
        MTVentas.setListaProducto(lista3);
        jTableVentas.setModel(MTVentas);
        jTableVentas.updateUI();
    }

    public void guardar() {
        if (jTNombre.getText().trim().isEmpty() || jTCedula.getText().trim().isEmpty() || jTEmail.getText().trim().isEmpty() || jTtelefono.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos vacios", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Cliente cliente1 = fc.consultaCliente(jTCedula.getText());
            SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
            Calendar calendar = Calendar.getInstance();

            Date dateObj = calendar.getTime();
            String formattedDate = dtf.format(dateObj);
            try {
                ListaEnlazada<Venta> listaVentas = fc.obtenerVentas(cliente1.getId_cliente());
                ListaEnlazada<DetalleVenta> listaDetalleVenta = fc.obtenerDetallesVentas(listaVentas);
                ListaEnlazada<Producto> listaproducto = new ListaEnlazada<>();
                for (int i = 0; i < listaDetalleVenta.getSize(); i++) {
                    listaproducto.insertar(pd.listarIDProducto(listaDetalleVenta.obtenerDato(i).getId_Producto()));
                }
                Factura fact = new Factura();
                fact.setCodigoFactura(String.valueOf(fd.listarfactura().getSize() + 1));
                DetalleFactura detalleFact = new DetalleFactura();
                detalleFact.setId_cliente(cliente1.getId_cliente());
                detalleFact.setFechaEmision(formattedDate);
                detalleFact.setId_factura(fd.listarfactura().getSize() + 1);
                detalleFact.setId_ventas(jTableVentas.getSelectedColumn() + 1);
                fd.GuardarFactura(fact);
                fd.GuardarDetalleFactura(detalleFact);
                fc.imprimirDatosFactura(listaproducto, cliente1, listaVentas, listaDetalleVenta, fact, detalleFact);
                limpiar();
            } catch (Exception ex) {
                Logger.getLogger(IF_Facturacion.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 =  new foto();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVentas = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jBFacturar = new javax.swing.JButton();
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

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(20, 80, 730, 20);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setLayout(null);

        jTableVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableVentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableVentas);

        jPanel8.add(jScrollPane1);
        jScrollPane1.setBounds(10, 40, 690, 110);

        jLabel6.setFont(new java.awt.Font("Sitka Heading", 1, 12)); // NOI18N
        jLabel6.setText("Ventas Realizadas al Cliente");
        jPanel8.add(jLabel6);
        jLabel6.setBounds(10, 10, 170, 16);

        jBFacturar.setBackground(new java.awt.Color(153, 204, 255));
        jBFacturar.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        jBFacturar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosMultimedia/invoice-icon.png"))); // NOI18N
        jBFacturar.setText("Facturar");
        jBFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFacturarActionPerformed(evt);
            }
        });
        jPanel8.add(jBFacturar);
        jBFacturar.setBounds(570, 170, 130, 38);

        jPanel2.add(jPanel8);
        jPanel8.setBounds(10, 250, 730, 230);

        jLabel5.setFont(new java.awt.Font("Sitka Heading", 1, 12)); // NOI18N
        jLabel5.setText("Telefono movil:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(460, 100, 150, 30);
        jPanel2.add(jTtelefono);
        jTtelefono.setBounds(460, 130, 260, 22);

        jLabel7.setFont(new java.awt.Font("Sitka Heading", 1, 12)); // NOI18N
        jLabel7.setText("E-mail:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(460, 150, 100, 30);

        jTEmail.setToolTipText("");
        jPanel2.add(jTEmail);
        jTEmail.setBounds(460, 180, 260, 30);
        jPanel2.add(jSeparator2);
        jSeparator2.setBounds(10, 230, 730, 20);

        jLabel9.setFont(new java.awt.Font("Sitka Heading", 1, 12)); // NOI18N
        jLabel9.setText("Dirección comprador:");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(20, 120, 160, 30);

        jLabel10.setFont(new java.awt.Font("Sitka Heading", 1, 12)); // NOI18N
        jLabel10.setText("Busqueda del Cliente");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(20, 10, 190, 30);

        jLabel3.setFont(new java.awt.Font("Sitka Heading", 1, 12)); // NOI18N
        jLabel3.setText("Identificación:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 40, 80, 30);

        jTCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTCedulaKeyTyped(evt);
            }
        });
        jPanel2.add(jTCedula);
        jTCedula.setBounds(110, 40, 280, 30);

        btBuscar.setBackground(new java.awt.Color(153, 204, 255));
        btBuscar.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
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

        jLabel2.setFont(new java.awt.Font("Sitka Heading", 1, 12)); // NOI18N
        jLabel2.setText("Nombre:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 90, 80, 20);

        jTNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNombreActionPerformed(evt);
            }
        });
        jPanel2.add(jTNombre);
        jTNombre.setBounds(110, 90, 280, 22);
        jPanel2.add(jSeparator3);
        jSeparator3.setBounds(20, 10, 730, 20);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(519, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVentasMouseClicked

    }//GEN-LAST:event_jTableVentasMouseClicked

    private void jBFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFacturarActionPerformed
        guardar();
    }//GEN-LAST:event_jBFacturarActionPerformed

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

    }//GEN-LAST:event_jTNombreActionPerformed

    class foto extends JLabel {

        private Image foto;

        @Override
        public void paint(Graphics g) {
            foto = new ImageIcon(getClass().getResource("/RecursosMultimedia/encabezados-07.jpg")).getImage();
            g.drawImage(foto, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton jBFacturar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
