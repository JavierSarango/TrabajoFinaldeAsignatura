/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista.InternalFrame;

import Validacion.Validacion;
import controlador.Conexion;
import controlador.dao.VentaDao;
import controlador.tda.lista.ListaEnlazada;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.DetalleVenta;
import modelo.Producto;
import modelo.Venta;
import vista.Frm_Cliente;
import vista.Frm_Producto;
import vista.Frm_Ventas;
import static vista.Frm_Ventas.jScrollPaneTabla;
import static vista.Frm_Ventas.jTable_productos;
import static vista.Frm_Ventas.txt_total_pagar;

/**
 *
 * @author Gigabyte
 */
public class IF_Ventas extends javax.swing.JInternalFrame {

    fondoLabel logotipo = new fondoLabel();
    fondoPieLabel pie = new fondoPieLabel();
    private VentaDao vd = new VentaDao();
    private Validacion validacion = new Validacion();

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    // Ventanas
    Frm_Cliente ventanaCliente;
    Frm_Producto ventanaProducto;
    //Variables globales
    Double totalPa, subTotal, descuento, precio;
    Integer cantidad;
    Producto producto = new Producto();
    Venta venta = new Venta();
    DetalleVenta dv = new DetalleVenta();
    Cliente cliente = new Cliente();
    DefaultTableModel modelo = new DefaultTableModel();
    Integer idp = 0;
    Integer fila = -1;

    /**
     * Creates new form IF_Ventas
     */
    public IF_Ventas() {
        initComponents();
        personalizacionTabla();
        poputTable();
        obtenerFecha();
        generarSerie();
    }
 private void personalizacionTabla() {
        jTable_productos.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        jTable_productos.getTableHeader().setOpaque(false);
        jTable_productos.getTableHeader().setBackground(new Color(153, 153, 255));
        jTable_productos.getTableHeader().setForeground(new Color(0, 0, 0));
        jTable_productos.setRowHeight(25);
        jScrollPaneTabla.getViewport().setBackground(new Color(255, 255, 255));

    }

    private void generarSerie() {
        String serie = vd.nroSerieVenta();
        if (serie == null) {
            jLabelSerie.setText("0000001");
        } else {
            Integer incremento = Integer.parseInt(serie);
            incremento = incremento + 1;
            jLabelSerie.setText("000000" + incremento);
        }
    }

    public void obtenerFecha() {
        Calendar calendar = new GregorianCalendar();
        jLabelFecha.setText("" + calendar.get(calendar.YEAR) + "-" + (calendar.get(calendar.MONTH) + 1) + "-" + calendar.get(calendar.DAY_OF_MONTH));

    }

    public void limpiarAddProducto() {
        txtCodProducto.setText("");
        txtPrecioProducto.setText("");
        txtResultadoProducto.setText("");
        txtStock.setText("");
        jSpinner_Cantidad.setValue(1);
    }

    public void limpiarVenta() {
        txtCodProducto.setText("");
        txtPrecioProducto.setText("");
        txtResultadoProducto.setText("");
        txtStock.setText("");
        txt_cliente_buscar.setText("");
        txtResultadoCliente.setText("");
        modelo = (DefaultTableModel) jTable_productos.getModel();
        modelo.getDataVector().removeAllElements();
        modelo.fireTableDataChanged();
        jTable_productos.setModel(modelo);
        generarSerie();
    }

    private void actualizarStock(Integer cantidad, Integer idproduct) {
    
        String sql = "UPDATE producto SET unidades = ? WHERE codigo = ?";
        try {
            con = Conexion.getConecction();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cantidad);
            ps.setInt(2, idproduct);
//            ps.executeQuery();
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar stock");
            e.printStackTrace();
        }

       
    }
    private void buscarCliente() {
        String idCliente = txt_cliente_buscar.getText();
        Integer respuesta;
        if (txt_cliente_buscar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe Ingresar el id de Cliente");
        } else {
            cliente = listarIDCliente(Integer.parseInt(idCliente));
            if (cliente.getId_cliente() != null) {
                txtResultadoCliente.setText(cliente.getRazonSocial());
                txtCodProducto.setRequestFocusEnabled(true);
            } else {
                respuesta = JOptionPane.showConfirmDialog(this, "El cliente no esta Registrado, ¿Desea Hacerlo?");
                if (respuesta == 0) {
                   ventanaCliente = new Frm_Cliente();
                    ventanaCliente.setVisible(true);
                    ventanaCliente.transferFocus();
                    this.dispose();
                    
                   
                }
            }

        }

    }

    private void buscarProducto() {
        Integer cod = Integer.parseInt(txtCodProducto.getText());
        if (txtCodProducto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe Ingresar el codigo del Producto");

        } else {
            producto = listarIDProducto(cod);

            if (producto.getCodigo() != 0) {
                txtResultadoProducto.setText(producto.getNombre());
                txtPrecioProducto.setText("" + producto.getPrecioVenta());
                txtStock.setText("" + producto.getUnidades());

                if (producto.getUnidades() == 0) {
                    txtStock.setBackground(Color.red);
                    txtStock.setForeground(Color.WHITE);
                } else if (producto.getUnidades() == 1) {
                    txtStock.setBackground(Color.ORANGE);

                } else if (producto.getUnidades() == 5) {
                    txtStock.setBackground(Color.YELLOW);
                }

            } else {
                JOptionPane.showMessageDialog(null, "No hay registro del producto");
                txtCodProducto.requestFocus();

            }
        }

    }

    private void agregarProducto() {
        Integer item = 0;
        Double total = 0.00;
        modelo = (DefaultTableModel) jTable_productos.getModel();
        item = item + 1;
        idp = producto.getCodigo();
        String nombre = txtResultadoProducto.getText();
        precio = Double.parseDouble(txtPrecioProducto.getText());
        cantidad = Integer.parseInt(jSpinner_Cantidad.getValue().toString());
        Integer stock = Integer.parseInt(txtStock.getText());
        total = cantidad * precio;
        ListaEnlazada lista = new ListaEnlazada();
        try {
            if (stock > 0) {
                lista.insertar(item);
                lista.insertar(idp);
                lista.insertar(nombre);
                lista.insertar(cantidad);
                lista.insertar(precio);
                lista.insertar(total);
                Object[] ob = new Object[6];
                ob[0] = lista.obtenerDato(0);
                ob[1] = lista.obtenerDato(1);
                ob[2] = lista.obtenerDato(2);
                ob[3] = lista.obtenerDato(3);
                ob[4] = lista.obtenerDato(4);
                ob[5] = lista.obtenerDato(5);
                modelo.addRow(ob);
                jTable_productos.setModel(modelo);
                calcularSubtotal();
                calcularTotal();
                limpiarAddProducto();
                JOptionPane.showMessageDialog(this,"Producto Agregado");
                       

            } else {
//                txtStock.setBackground(Color.red);
                JOptionPane.showMessageDialog(this, "Sin stock Disponible");
            }
        } catch (Exception e) {
        }

    }

    public Cliente listarIDCliente(Integer id) {
        String sql = "Select * from cliente where id_Cliente = ?";
        Cliente c = new Cliente();
        try {
            con = Conexion.getConecction();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setId_cliente(rs.getInt(1));
                c.setRazonSocial(rs.getString(2));
                c.setTelefono(rs.getString(3));
                c.setCelular(rs.getString(4));
                c.setCorreo(rs.getString(5));
                c.setDireccion(rs.getString(6));
                c.setIdentificacion(rs.getString(7));
                c.setTipoCliente(rs.getString(8));
                c.setFechaNacimiento(rs.getString(9));
            }
        } catch (Exception e) {
            System.out.println("Error en listar Id cliente");
            e.printStackTrace();
        }
        return c;

    }

    public Producto listarIDProducto(Integer codigo) {
        Producto p = new Producto();
        String sql = "Select * from producto where codigo = ?";

        try {
            con = Conexion.getConecction();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setIdProducto(rs.getInt(1));
                p.setCodigo(rs.getInt(2));
                p.setNombre(rs.getString(3));
                p.setDescripcion(rs.getString(4));
                p.setPrecioCompra(rs.getDouble(5));
                p.setPrecioVenta(rs.getDouble(6));
                p.setId_Proveedor(rs.getInt(7));
                p.setUnidades(rs.getInt(8));
            }
        } catch (Exception e) {
            System.out.println("Error en listar Id producto");
            e.printStackTrace();
        }
        return p;

    }

    private Double calcularSubtotal() {
        subTotal = 0.00;
        for (int i = 0; i < jTable_productos.getRowCount(); i++) {
            cantidad = Integer.parseInt(jTable_productos.getValueAt(i, 3).toString());
            precio = Double.parseDouble(jTable_productos.getValueAt(i, 4).toString());
            subTotal = subTotal + (cantidad * precio);
        }
        txt_subtotal.setText("" + subTotal);
        return subTotal;
    }

    private void calcularTotal() {
        descuento = 0.00;
        //Calcula el total si hay descuento y no se ha seleccionado un valor diferente de IVa
        //valor de iva por defecto es 12%
        if (jCheckDescuento.isSelected() && !jCheckIva.isSelected()) {
            Double des = Double.parseDouble(cbxDescuento.getSelectedItem().toString()) / 100;
            Double iva = 0.12;
            //Se calcula el descuento del subtotal sin iva 
            descuento = (subTotal * des);
            //Se obtiene el subTotal con el descuento
            Double subTconDescuento = subTotal - descuento;
            //Se calcula el subTotalconiva a partir del valor con el descuento realizado
            Double subTotalconIva12 = (subTconDescuento * iva);
            totalPa = subTconDescuento + subTotalconIva12;
            txt_total_pagar.setText("" + totalPa);
        } else if (!jCheckDescuento.isSelected() && !jCheckIva.isSelected()) {
            //Calcula el total si no hay descuento con el 12% de IVA por defecto
            Double iva = 0.12;
            Double subTotalconIva12 = (subTotal * iva);
            Double subTcalculado = subTotal + subTotalconIva12;
            totalPa = 0.00;
            totalPa = subTcalculado;
            txt_total_pagar.setText("" + totalPa);

        } else if (jCheckDescuento.isSelected() && jCheckIva.isSelected()) {
            //Calcula el total si hay descuento y el valor del IVA es diferente a 12 %
            Double des = Double.parseDouble(cbxDescuento.getSelectedItem().toString()) / 100;
            Double iva = Double.parseDouble(cbxIVA.getSelectedItem().toString()) / 100;
            descuento = (subTotal * des);

            Double subTconDescuento = subTotal - descuento;

            Double IvadelDescuento = (subTconDescuento * iva);
            Double subTotalconIvaX = subTconDescuento + IvadelDescuento;

            totalPa = subTotalconIvaX;
            txt_total_pagar.setText("" + totalPa);
        } else if (!jCheckDescuento.isSelected() && jCheckIva.isSelected()) {
            Double iva = Double.parseDouble(cbxIVA.getSelectedItem().toString()) / 100;
            Double subTotalconIvaX = subTotal + (subTotal * iva);
            totalPa = 0.00;
            totalPa = subTotalconIvaX;
            txt_total_pagar.setText("" + totalPa);

        }
    }
  public void guardarVenta() {
        Integer idC = cliente.getId_cliente();
        String serie = jLabelSerie.getText();
        String fecha = jLabelFecha.getText();
        Double monto = totalPa;
        venta.setId_Cliente(idC);
        venta.setNrodeSerieVenta(serie);
        venta.setFechaVenta(fecha);
        venta.setMonto(monto);
        vd.GuardarVenta(venta);
        guardarDetalleVenta();
        actualizarStock();

    }

    public void guardarDetalleVenta() {
        String idv = vd.id_Venta();
        Integer idventa = Integer.parseInt(idv);
        for (int i = 0; i < jTable_productos.getRowCount(); i++) {
            Integer idproducto = Integer.parseInt(jTable_productos.getValueAt(i, 1).toString());
            Integer cant = Integer.parseInt(jTable_productos.getValueAt(i, 3).toString());
            Double prec = Double.parseDouble(jTable_productos.getValueAt(i, 4).toString());
            dv.setId_Venta(idventa);
            dv.setId_Producto(idproducto);
            dv.setCantidad(cant);
            dv.setPrecioVenta(prec);
            vd.GuardarDetalleVenta(dv);
        }

    }

    public void poputTable() {
        JPopupMenu popuMenu = new JPopupMenu();
        JMenuItem menuItem1 = new JMenuItem("Quitar Producto", new ImageIcon(getClass().getResource("/RecursosMultimedia/icon_cancel.png")));

        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                fila = jTable_productos.getSelectedRow();
                modelo.removeRow(fila);
                modelo.fireTableDataChanged();
                jTable_productos.setModel(modelo);
                calcularSubtotal();
                calcularTotal();

            }
        });

        popuMenu.add(menuItem1);

        jTable_productos.setComponentPopupMenu(popuMenu);
    }
    private void actualizarStock() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            Producto pr = new Producto();
            idp = Integer.parseInt(jTable_productos.getValueAt(i, 1).toString());
            cantidad = Integer.parseInt(jTable_productos.getValueAt(i, 3).toString());
            pr = listarIDProducto(idp);
            System.out.println("Lo que hay en listar producto acStock: "+listarIDProducto(idp));
            System.out.println("Unidades: "+pr.getUnidades());
            System.out.println("Cantidad: "+cantidad);
            System.out.println("IdProducto: "+idp);
                
            Integer stockActual = pr.getUnidades() - cantidad;
            actualizarStock(stockActual, idp);
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
        jButton_calcular_cambio = new javax.swing.JButton();
        btnCalcular = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_cliente_buscar = new javax.swing.JTextField();
        jButton_busca_cliente = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPaneTabla = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_subtotal = new javax.swing.JTextField();
        txt_total_pagar = new javax.swing.JTextField();
        txt_efectivo = new javax.swing.JTextField();
        txt_cambio = new javax.swing.JTextField();
        cbxDescuento = new javax.swing.JComboBox<>();
        jCheckDescuento = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jCheckIva = new javax.swing.JCheckBox();
        cbxIVA = new javax.swing.JComboBox<>();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtResultadoCliente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCodProducto = new javax.swing.JTextField();
        jButton_busca_producto = new javax.swing.JButton();
        jSpinner_Cantidad = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        txtPrecioProducto = new javax.swing.JTextField();
        jButton_busca_cliente2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtResultadoProducto = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabelSerie = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        JLabelLogo = new fondoLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnGuardarVenta = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jlabelPie = new fondoPieLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        btnVerClientes = new javax.swing.JButton();
        btnVerProductos = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jButton_calcular_cambio.setBackground(new java.awt.Color(51, 255, 255));
        jButton_calcular_cambio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_calcular_cambio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosMultimedia/coin-icon.png"))); // NOI18N
        jButton_calcular_cambio.setText("Cobrar");
        jButton_calcular_cambio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton_calcular_cambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_calcular_cambioActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_calcular_cambio);
        jButton_calcular_cambio.setBounds(370, 580, 110, 40);

        btnCalcular.setBackground(new java.awt.Color(51, 255, 255));
        btnCalcular.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosMultimedia/coin-search-icon.png"))); // NOI18N
        btnCalcular.setText("Calcular");
        btnCalcular.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });
        jPanel1.add(btnCalcular);
        btnCalcular.setBounds(500, 580, 120, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Cliente");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(360, 140, 50, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Precio Producto:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 240, 110, 30);

        txt_cliente_buscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_cliente_buscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cliente_buscar.setBorder(null);
        txt_cliente_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cliente_buscarKeyTyped(evt);
            }
        });
        jPanel1.add(txt_cliente_buscar);
        txt_cliente_buscar.setBounds(120, 140, 120, 30);

        jButton_busca_cliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_busca_cliente.setText("Buscar");
        jButton_busca_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_busca_clienteActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_busca_cliente);
        jButton_busca_cliente.setBounds(250, 140, 90, 30);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(null);

        jScrollPaneTabla.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPaneTabla.setBorder(null);

        jTable_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NRO", "COD. P", "PRODUCTO", "CANT.", "PRECIO U.", "TOTAL"
            }
        ));
        jTable_productos.setFocusable(false);
        jTable_productos.setGridColor(new java.awt.Color(255, 255, 255));
        jTable_productos.setRowHeight(25);
        jTable_productos.setSelectionBackground(new java.awt.Color(153, 153, 255));
        jTable_productos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable_productos.setShowHorizontalLines(true);
        jTable_productos.getTableHeader().setReorderingAllowed(false);
        jScrollPaneTabla.setViewportView(jTable_productos);

        jPanel3.add(jScrollPaneTabla);
        jScrollPaneTabla.setBounds(10, 10, 440, 220);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 330, 460, 240);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Subtotal:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(0, 30, 58, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Descuento:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(0, 70, 69, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Iva:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(0, 110, 50, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Total a pagar:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(0, 160, 100, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Efectivo:");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(0, 210, 70, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Cambio:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(0, 260, 60, 30);

        txt_subtotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_subtotal.setBorder(null);
        txt_subtotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_subtotal.setEnabled(false);
        txt_subtotal.setOpaque(true);
        jPanel2.add(txt_subtotal);
        txt_subtotal.setBounds(100, 30, 120, 30);

        txt_total_pagar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_total_pagar.setBorder(null);
        txt_total_pagar.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_total_pagar.setEnabled(false);
        txt_total_pagar.setOpaque(true);
        jPanel2.add(txt_total_pagar);
        txt_total_pagar.setBounds(110, 160, 120, 30);

        txt_efectivo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_efectivo.setBorder(null);
        txt_efectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_efectivoKeyTyped(evt);
            }
        });
        jPanel2.add(txt_efectivo);
        txt_efectivo.setBounds(110, 210, 120, 30);

        txt_cambio.setEditable(false);
        txt_cambio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_cambio.setBorder(null);
        txt_cambio.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_cambio.setEnabled(false);
        jPanel2.add(txt_cambio);
        txt_cambio.setBounds(110, 260, 120, 30);

        cbxDescuento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "20", "30", "40", "50", "75" }));
        cbxDescuento.setEnabled(false);
        jPanel2.add(cbxDescuento);
        cbxDescuento.setBounds(110, 70, 60, 30);

        jCheckDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckDescuentoActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckDescuento);
        jCheckDescuento.setBounds(200, 70, 20, 30);

        jLabel18.setText("%");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(180, 110, 20, 30);

        jLabel19.setText("%");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(180, 70, 20, 30);

        jCheckIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckIvaActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckIva);
        jCheckIva.setBounds(200, 120, 20, 19);

        cbxIVA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12", "14" }));
        cbxIVA.setEnabled(false);
        jPanel2.add(cbxIVA);
        cbxIVA.setBounds(110, 110, 60, 30);
        jPanel2.add(jSeparator7);
        jSeparator7.setBounds(100, 60, 120, 10);
        jPanel2.add(jSeparator8);
        jSeparator8.setBounds(120, 170, 0, 3);
        jPanel2.add(jSeparator9);
        jSeparator9.setBounds(110, 190, 120, 10);
        jPanel2.add(jSeparator10);
        jSeparator10.setBounds(110, 240, 120, 10);
        jPanel2.add(jSeparator11);
        jSeparator11.setBounds(110, 290, 120, 10);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(460, 280, 240, 300);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Cod. Producto");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 190, 100, 30);

        txtResultadoCliente.setEditable(false);
        txtResultadoCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtResultadoCliente.setBorder(null);
        jPanel1.add(txtResultadoCliente);
        txtResultadoCliente.setBounds(460, 140, 140, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Fecha:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(360, 100, 60, 30);

        txtCodProducto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodProducto.setBorder(null);
        txtCodProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodProductoKeyTyped(evt);
            }
        });
        jPanel1.add(txtCodProducto);
        txtCodProducto.setBounds(120, 190, 120, 30);

        jButton_busca_producto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_busca_producto.setText("Buscar");
        jButton_busca_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_busca_productoActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_busca_producto);
        jButton_busca_producto.setBounds(250, 190, 90, 30);

        jSpinner_Cantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jPanel1.add(jSpinner_Cantidad);
        jSpinner_Cantidad.setBounds(120, 290, 120, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Cantidad:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(10, 290, 80, 30);

        txtPrecioProducto.setEditable(false);
        txtPrecioProducto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioProducto.setBorder(null);
        jPanel1.add(txtPrecioProducto);
        txtPrecioProducto.setBounds(120, 240, 120, 30);

        jButton_busca_cliente2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_busca_cliente2.setText("Agregar");
        jButton_busca_cliente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_busca_cliente2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_busca_cliente2);
        jButton_busca_cliente2.setBounds(250, 240, 90, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Descripción:");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(360, 190, 80, 30);

        txtResultadoProducto.setEditable(false);
        txtResultadoProducto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtResultadoProducto.setBorder(null);
        jPanel1.add(txtResultadoProducto);
        txtResultadoProducto.setBounds(460, 190, 140, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Stock:");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(360, 240, 70, 30);

        txtStock.setEditable(false);
        txtStock.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStock.setBorder(null);
        jPanel1.add(txtStock);
        txtStock.setBounds(460, 240, 140, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("CI. Cliente");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(10, 140, 80, 30);
        jPanel1.add(jLabelSerie);
        jLabelSerie.setBounds(120, 100, 120, 30);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Nro:");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(10, 100, 60, 30);
        jPanel1.add(jLabelFecha);
        jLabelFecha.setBounds(460, 100, 220, 30);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setOpaque(false);
        jPanel4.setLayout(null);
        jPanel4.add(JLabelLogo);
        JLabelLogo.setBounds(10, 10, 300, 70);

        jLabel15.setText("VENTA DE ARTICULOS TECNOLÓGICOS");
        jPanel4.add(jLabel15);
        jLabel15.setBounds(380, 40, 230, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PUNTO DE VENTA OMICRON");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(360, 10, 270, 22);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(10, 10, 670, 90);

        btnGuardarVenta.setBackground(new java.awt.Color(51, 255, 255));
        btnGuardarVenta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGuardarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosMultimedia/coin-add-icon.png"))); // NOI18N
        btnGuardarVenta.setText("Guardar Venta");
        btnGuardarVenta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGuardarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarVentaActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardarVenta);
        btnGuardarVenta.setBounds(20, 580, 170, 40);

        btnCancelar.setBackground(new java.awt.Color(51, 255, 255));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosMultimedia/coin-delete-icon.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(btnCancelar);
        btnCancelar.setBounds(210, 580, 140, 40);
        jPanel1.add(jlabelPie);
        jlabelPie.setBounds(0, 560, 700, 70);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(120, 170, 120, 10);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(120, 220, 120, 10);
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(120, 270, 120, 10);
        jPanel1.add(jSeparator4);
        jSeparator4.setBounds(460, 170, 140, 10);
        jPanel1.add(jSeparator5);
        jSeparator5.setBounds(460, 220, 140, 10);
        jPanel1.add(jSeparator6);
        jSeparator6.setBounds(460, 270, 140, 10);

        btnVerClientes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerClientes.setText("Ver");
        btnVerClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerClientesActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerClientes);
        btnVerClientes.setBounds(610, 140, 80, 30);

        btnVerProductos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerProductos.setText("Ver");
        btnVerProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerProductosActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerProductos);
        btnVerProductos.setBounds(610, 190, 80, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cliente_buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cliente_buscarKeyTyped
        // TODO add your handling code here:
        //        validacion.validaSeaNumero(evt, txt_cliente_buscar, 10);
    }//GEN-LAST:event_txt_cliente_buscarKeyTyped

    private void jButton_busca_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_busca_clienteActionPerformed
        buscarCliente();
    }//GEN-LAST:event_jButton_busca_clienteActionPerformed

    private void txt_efectivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_efectivoKeyTyped
        // TODO add your handling code here:
        //        validacion.valNumReal(evt, txt_efectivo, 20);
    }//GEN-LAST:event_txt_efectivoKeyTyped

    private void jButton_calcular_cambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_calcular_cambioActionPerformed
        if (!txt_efectivo.getText().isEmpty()) {
            //validamos que el usuario no ingrese otros caracteres no numericos
            boolean val = this.validacion.validarDouble(txt_efectivo.getText());
            if (val == true) {
                //validar que el efectivo sea mayor a cero

                Double efc = Double.parseDouble(txt_efectivo.getText());
                Double top = Double.parseDouble(txt_total_pagar.getText().trim());

                if (efc < top) {
                    JOptionPane.showMessageDialog(null, "El Dinero en efectivo no es suficiente");
                } else {
                    double cambio = (efc - top);
                    double cambi = (double) Math.round(cambio * 100d) / 100;
                    String camb = String.valueOf(cambi);
                    txt_cambio.setText(camb);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No de admiten caracteres no numericos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese dinero en efectivo para calcular cambio");
        }
    }//GEN-LAST:event_jButton_calcular_cambioActionPerformed

    private void jCheckDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckDescuentoActionPerformed
        // TODO add your handling code here:
        if (jCheckDescuento.isSelected()) {
            cbxDescuento.setEnabled(true);

        } else if (!jCheckDescuento.isSelected()) {
            cbxDescuento.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckDescuentoActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        // TODO add your handling code here:
        calcularTotal();
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void jCheckIvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckIvaActionPerformed
        // TODO add your handling code here:
        if (jCheckIva.isSelected()) {
            cbxIVA.setEnabled(true);

        } else if (!jCheckIva.isSelected()) {
            cbxIVA.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckIvaActionPerformed

    private void txtCodProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodProductoKeyTyped
        // TODO add your handling code here:
        //        validacion.validaSeaNumero(evt, txtCodProducto, 10);
    }//GEN-LAST:event_txtCodProductoKeyTyped

    private void jButton_busca_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_busca_productoActionPerformed
        // TODO add your handling code here:
        buscarProducto();
    }//GEN-LAST:event_jButton_busca_productoActionPerformed

    private void jButton_busca_cliente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_busca_cliente2ActionPerformed
        // TODO add your handling code here:
        agregarProducto();
    }//GEN-LAST:event_jButton_busca_cliente2ActionPerformed

    private void btnGuardarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarVentaActionPerformed
        // TODO add your handling code here:
        if (txt_total_pagar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Se deben ingresar datos en los campos");
        } else {
            guardarVenta();
            limpiarVenta();
            //            actualizarStock();
            JOptionPane.showMessageDialog(this, "Venta realizada con Éxito");
        }
    }//GEN-LAST:event_btnGuardarVentaActionPerformed

    private void btnVerClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerClientesActionPerformed
        // TODO add your handling code here:
        ventanaCliente = new Frm_Cliente();
        ventanaProducto.setVisible(true);
    }//GEN-LAST:event_btnVerClientesActionPerformed

    private void btnVerProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerProductosActionPerformed
        // TODO add your handling code here:
        ventanaProducto = new Frm_Producto(new javax.swing.JFrame(), true);
        ventanaProducto.setVisible(true);
    }//GEN-LAST:event_btnVerProductosActionPerformed
    /*
    Agrega una imagen al JLabel
     */
    class fondoLabel extends JLabel {

        private Image logo;

        @Override
        public void paint(Graphics g) {
            logo = new ImageIcon(getClass().getResource("/RecursosMultimedia/OmicronLogo.jpg")).getImage();
            g.drawImage(logo, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }

    }

    class fondoPieLabel extends JLabel {

        private Image logo;

        @Override
        public void paint(Graphics g) {
            logo = new ImageIcon(getClass().getResource("/RecursosMultimedia/pieFondo.jpg")).getImage();
            g.drawImage(logo, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelLogo;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardarVenta;
    private javax.swing.JButton btnVerClientes;
    private javax.swing.JButton btnVerProductos;
    private javax.swing.JComboBox<String> cbxDescuento;
    private javax.swing.JComboBox<String> cbxIVA;
    private javax.swing.JButton jButton_busca_cliente;
    private javax.swing.JButton jButton_busca_cliente2;
    private javax.swing.JButton jButton_busca_producto;
    private javax.swing.JButton jButton_calcular_cambio;
    private javax.swing.JCheckBox jCheckDescuento;
    private javax.swing.JCheckBox jCheckIva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelSerie;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JScrollPane jScrollPaneTabla;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JSpinner jSpinner_Cantidad;
    public static javax.swing.JTable jTable_productos;
    private javax.swing.JLabel jlabelPie;
    private javax.swing.JTextField txtCodProducto;
    private javax.swing.JTextField txtPrecioProducto;
    private javax.swing.JTextField txtResultadoCliente;
    private javax.swing.JTextField txtResultadoProducto;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txt_cambio;
    private javax.swing.JTextField txt_cliente_buscar;
    private javax.swing.JTextField txt_efectivo;
    private javax.swing.JTextField txt_subtotal;
    public static javax.swing.JTextField txt_total_pagar;
    // End of variables declaration//GEN-END:variables
}
