/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista.InternalFrame;

import Validacion.Validacion;
import controlador.dao.ProveedorDao;
import controlador.tda.lista.ListaEnlazada;
import controlador.tda.lista.exception.PosicionException;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import vista.CargarFoto;
import vista.ModeloTablas.ModeloTablaProveedores;

/**
 *
 * @author Gigabyte
 */
public class IF_Proveedores extends javax.swing.JInternalFrame {

//    private ProveedorController proveedordao = new ProveedorController();
    private ProveedorDao proveedordao = new ProveedorDao();
    private ModeloTablaProveedores modelotablaproveedor = new ModeloTablaProveedores();
    private Validacion validacion = new Validacion();
    fondoLabel logotipo = new fondoLabel();
    fondoPieLabel pie = new fondoPieLabel();

    //Variables
    private int pos = -1;
    File fichero;
    private int fila = -1;
       Connection con;
    PreparedStatement ps;
    ResultSet rs;
    //Iconos a botones
    ImageIcon guardar = new ImageIcon("src/RecursosMultimedia/fac_save.png");
    ImageIcon eliminar = new ImageIcon("src/RecursosMultimedia/fac_remove.png");
    ImageIcon nuevo = new ImageIcon("src/RecursosMultimedia/Actions-list-add-user-icon.png");
    ImageIcon cargar = new ImageIcon("src/RecursosMultimedia/jpeg-file-icon (1).png");
    ImageIcon lbl = new ImageIcon("src/RecursosMultimedia/user-icon.png");
    ImageIcon bu = new ImageIcon("src/RecursosMultimedia/buscar.gif");
    ImageIcon editar = new ImageIcon("src/RecursosMultimedia/Actions-user-properties-icon.png");

    /**
     * Creates new form IF_Proveedores
     */
    public IF_Proveedores() {
        initComponents();
         cargarTabla();
        Iconos();
    }
 /**
     *
     * Metodo Cargar iconos
     */
    private void Iconos() {
        BtnGuardar.setIcon(guardar);
        BtnEliminar.setIcon(eliminar);
        BtnModificar.setIcon(editar);
        BtnNuevo.setIcon(nuevo);
        BtnCargarFoto.setIcon(cargar);
        Btnbuscar.setIcon(bu);
        icono.setIcon(lbl);
    }

    /**
     *
     * Metodo Cargar tabla
     */
    private void cargarTabla() {
        modelotablaproveedor.setLista(proveedordao.listar());
        tbl_proveedores.setModel(modelotablaproveedor);
        tbl_proveedores.updateUI();
    }

    /**
     *
     * Metodo limpiar datos
     */
    private void limpiar() {
        txtAresponsable.setText("");
        txtdireccion.setText("");
        txtRuc.setText("");
        txtRazonS.setText("");
        txttfijo.setText("");
        txtcelular.setText("");
        txtTelefonoop.setText("");
        txtCuenta.setText("");
        txtemail.setText("");
        txtpaginaweb.setText("");
        BtnGuardar.setText("");
        proveedordao.setProveedores(null);
    }

    /**
     *
     * Metodo guardar
     */
    private void guardar() {
        if (txtAresponsable.getText().trim().isEmpty() || txtdireccion.getText().trim().isEmpty() || txtcelular.getText().trim().isEmpty()
                || txtCuenta.getText().trim().isEmpty() || txtRuc.getText().trim().isEmpty() || txttfijo.getText().trim().isEmpty() || txtTelefonoop.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos vacios", "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            if (validacion.validaCorreo(txtemail.getText()) == true) {
                JOptionPane.showMessageDialog(null, "Correo Valido", "Ok", JOptionPane.INFORMATION_MESSAGE);
            }else{ 
                 JOptionPane.showMessageDialog(null, "Correo no valido", "Error", JOptionPane.ERROR_MESSAGE);
            }
                proveedordao.getProveedores().setAgente_responsable(txtAresponsable.getText());
                proveedordao.getProveedores().setProvincia(cbxProvincia.getSelectedItem().toString());
                proveedordao.getProveedores().setDireccion(txtdireccion.getText());
                proveedordao.getProveedores().setIdentificacion(txtRuc.getText());
                proveedordao.getProveedores().setRazonSocial(txtRazonS.getText());
                proveedordao.getProveedores().setTelefono(txttfijo.getText());
                proveedordao.getProveedores().setTelefono_opcional(txtTelefonoop.getText());
                proveedordao.getProveedores().setCelular(txtcelular.getText());
                proveedordao.getProveedores().setCorreo(txtemail.getText());
                proveedordao.getProveedores().setPagina_web(txtpaginaweb.getText());
                proveedordao.getProveedores().setBanco(cbxBanco.getSelectedItem().toString());
                proveedordao.getProveedores().setTipocuenta(cbxTipo.getSelectedItem().toString());
                proveedordao.getProveedores().setNro_cuenta(txtCuenta.getText());
                proveedordao.getProveedores().setCredito((cbxcredito.getSelectedItem().toString()));
                System.out.print("Llega 3");
                if ((BtnGuardar.getText().equalsIgnoreCase("GUARDAR"))) {
                    if (proveedordao.getProveedores().getId_Proveedor() == null) {
                        if (proveedordao.guardar()) {
                            JOptionPane.showMessageDialog(null, "Registro Completo", "Ok", JOptionPane.INFORMATION_MESSAGE);
                            limpiar();
                            cargarTabla();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al registrar", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {//ACTUALIZA LOS DATOS
                    try {
                        if(proveedordao.modificar()){
                        JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
                        limpiar();
                        cargarTabla();
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "NO SE HA PODIDO ACTUALIZAR LOS DATOS");
                    }
                }
           

        }
    }

    /**
     *
     * Metodo Cargar Imagen
     */
    private void CargarFoto() {
        int resultado;
        CargarFoto ventana = new CargarFoto();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG", "jpg", "png");
        ventana.jfchCargarfoto.setFileFilter(filtro);
        resultado = ventana.jfchCargarfoto.showOpenDialog(null);

        if (JFileChooser.APPROVE_OPTION == resultado) {
            fichero = ventana.jfchCargarfoto.getSelectedFile();
            try {
                ImageIcon icon = new ImageIcon(fichero.toString());
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
                lblFoto.setText(null);
                lblFoto.setIcon(icono);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error abriendo la imagen " + ex);
            }
        }
    }

    /**
     *
     * Metodo eliminar registro
     */
    private void Eliminar() {
        fila = tbl_proveedores.getSelectedRow();
        try {
            if (fila >= 0) {
                System.out.println(fila + "se selecciono la fila");
                proveedordao.eliminaras(fila);
                int opcion = JOptionPane.showConfirmDialog(null, "¿Esta Seguro de eliminar registro?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opcion == JOptionPane.YES_OPTION) {
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
    
    private void modi() throws SQLException{
        Connection con = null;
         String sql = ("UPDATE proveedor SET agente_responsable =?, provincia =?, direccion =?, identificacion =?, razonSocial =?, "
                + "telefono =?, celular =?,telefono_opcional =?, correo=?, pagina_web=?, banco=?, tipocuenta=?, nro_cuenta=?, credito=? WHERE id_Proveedor =?");
         ps = con.prepareStatement(sql);
         try {
            ps.setInt(1, proveedor.getId_Proveedor());
            ps.setString(2, proveedor.getAgente_responsable());
            ps.setString(3, proveedor.getProvincia());
            ps.setString(4, proveedor.getDireccion());
            ps.setString(5, proveedor.getIdentificacion());
            ps.setString(6, proveedor.getRazonSocial());
            ps.setString(7, proveedor.getTelefono());
            ps.setString(8, proveedor.getCelular());
            ps.setString(9, proveedor.getTelefono());
            ps.setString(10, proveedor.getCorreo());
            ps.setString(11, proveedor.getPagina_web());
            ps.setString(12, proveedor.getBanco());
            ps.setString(13, proveedor.getTipocuenta());
            ps.setString(14, proveedor.getNro_cuenta());
            ps.setString(15, proveedor.getCredito());
            ps.executeUpdate();
            ps.close();
//            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
//            return false;
        }
         
        
    }
    
    /**
     *
     * Metodo para buscar datos
     */
    private void buscar() throws PosicionException {
        int select = Cbxcriterio.getSelectedIndex();
        ListaEnlazada aux = new ListaEnlazada();
        switch (select) {
            case 0:
                aux = proveedordao.busquedasecuencial(txtbuscar.getText(), 1);
                break;
            case 1:
                aux = proveedordao.busquedasecuencial(txtbuscar.getText(), 2);
                break;
            case 2:
                aux = proveedordao.busquedasecuencial(txtbuscar.getText(), 3);
            case 3:
                aux = proveedordao.busquedasecuencial(txtbuscar.getText(), 4);
                break;
            default:
                proveedordao.ordenar();
                aux = modelotablaproveedor.getLista();
        }
        modelotablaproveedor.setLista(aux);
        tbl_proveedores.setModel(modelotablaproveedor);
        tbl_proveedores.updateUI();
    }

    /**
     *
     * Metodo para seleccionar datos
     */
    public void seleccionar() throws Exception {
        limpiar();
        int seleccionar = tbl_proveedores.getSelectedRow();
        if (seleccionar >= 0) {
            txtAresponsable.setText(String.valueOf(tbl_proveedores.getValueAt(seleccionar, 1)));
            cbxProvincia.setSelectedItem(String.valueOf(tbl_proveedores.getValueAt(seleccionar, 2)));
            txtdireccion.setText(String.valueOf(tbl_proveedores.getValueAt(seleccionar, 3)));
            txtRuc.setText(String.valueOf(tbl_proveedores.getValueAt(seleccionar, 4)));
            txtRazonS.setText(String.valueOf(tbl_proveedores.getValueAt(seleccionar, 5)));
            txttfijo.setText(String.valueOf(tbl_proveedores.getValueAt(seleccionar, 6)));
            txtTelefonoop.setText(String.valueOf(tbl_proveedores.getValueAt(seleccionar, 7)));
            txtcelular.setText(String.valueOf(tbl_proveedores.getValueAt(seleccionar, 8)));
            txtemail.setText(String.valueOf(tbl_proveedores.getValueAt(seleccionar, 9)));
            txtpaginaweb.setText(String.valueOf(tbl_proveedores.getValueAt(seleccionar, 10)));
            cbxBanco.setSelectedItem(String.valueOf(tbl_proveedores.getValueAt(seleccionar, 11)));
            cbxTipo.setSelectedItem(String.valueOf(tbl_proveedores.getValueAt(seleccionar, 12)));
            txtCuenta.setText(String.valueOf(tbl_proveedores.getValueAt(seleccionar, 13)));
            cbxcredito.setSelectedItem(String.valueOf(tbl_proveedores.getValueAt(seleccionar, 14)));
            BtnGuardar.setText("Actualizar");
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
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtAresponsable = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbxProvincia = new javax.swing.JComboBox<>();
        BtnGuardar = new javax.swing.JButton();
        BtnNuevo = new javax.swing.JButton();
        txtdireccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        lblFoto = new javax.swing.JLabel();
        BtnCargarFoto = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtcelular = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtpaginaweb = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txttfijo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTelefonoop = new javax.swing.JTextField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCuenta = new javax.swing.JTextField();
        cbxTipo = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cbxcredito = new javax.swing.JComboBox<>();
        cbxBanco = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtRazonS = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_proveedores = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        icono = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JlabelLogo = new fondoLabel();
        jlabelPie = new fondoPieLabel();
        jLabel14 = new javax.swing.JLabel();
        Cbxcriterio = new javax.swing.JComboBox<>();
        txtbuscar = new javax.swing.JTextField();
        Btnbuscar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Agente responsable:");
        jPanel5.add(jLabel1);
        jLabel1.setBounds(150, 20, 116, 20);

        txtAresponsable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAresponsableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtAresponsableMousePressed(evt);
            }
        });
        txtAresponsable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAresponsableActionPerformed(evt);
            }
        });
        txtAresponsable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAresponsableKeyTyped(evt);
            }
        });
        jPanel5.add(txtAresponsable);
        txtAresponsable.setBounds(280, 20, 188, 26);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Provincia:");
        jPanel5.add(jLabel2);
        jLabel2.setBounds(150, 70, 92, 30);

        cbxProvincia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Azuay", "Bolívar", "Cañar", "Carchi", "Chimborazo", "Cotopaxi", "El Oro", "Esmeraldas", "Galápagos", "Guayas", "Imbabura", "Loja", "Los Rios", " Manabí", "Morona Santiago", "Napo", "Orellana ", "Pastaza", "Pichincha", "Santa Elena", "Santo Domingo de los Tsáchilas", "Sucumbíos", "Tungurahua", "Zamora Chinchipe" }));
        cbxProvincia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(cbxProvincia);
        cbxProvincia.setBounds(280, 70, 188, 32);

        BtnGuardar.setBackground(new java.awt.Color(153, 204, 255));
        BtnGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnGuardar.setText("GUARDAR");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });
        jPanel5.add(BtnGuardar);
        BtnGuardar.setBounds(10, 270, 144, 51);

        BtnNuevo.setBackground(new java.awt.Color(153, 204, 255));
        BtnNuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnNuevo.setText("NUEVO");
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });
        jPanel5.add(BtnNuevo);
        BtnNuevo.setBounds(220, 270, 150, 53);

        txtdireccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtdireccionMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtdireccionMousePressed(evt);
            }
        });
        txtdireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdireccionActionPerformed(evt);
            }
        });
        jPanel5.add(txtdireccion);
        txtdireccion.setBounds(280, 120, 188, 26);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Direcccion:");
        jPanel5.add(jLabel4);
        jLabel4.setBounds(150, 120, 92, 32);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("RUC:");
        jPanel5.add(jLabel5);
        jLabel5.setBounds(150, 170, 80, 23);

        txtRuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRucMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtRucMousePressed(evt);
            }
        });
        txtRuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRucActionPerformed(evt);
            }
        });
        txtRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucKeyTyped(evt);
            }
        });
        jPanel5.add(txtRuc);
        txtRuc.setBounds(280, 170, 188, 26);

        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setText("Foto");
        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFotoMouseClicked(evt);
            }
        });
        jPanel5.add(lblFoto);
        lblFoto.setBounds(10, 40, 115, 136);

        BtnCargarFoto.setBackground(new java.awt.Color(153, 204, 255));
        BtnCargarFoto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnCargarFoto.setText("CARGAR");
        BtnCargarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCargarFotoActionPerformed(evt);
            }
        });
        jPanel5.add(BtnCargarFoto);
        BtnCargarFoto.setBounds(10, 190, 115, 32);

        BtnEliminar.setBackground(new java.awt.Color(153, 204, 255));
        BtnEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnEliminar.setText("ELIMINAR");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });
        jPanel5.add(BtnEliminar);
        BtnEliminar.setBounds(640, 270, 152, 53);

        BtnModificar.setBackground(new java.awt.Color(153, 204, 255));
        BtnModificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnModificar.setText("EDITAR");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });
        jPanel5.add(BtnModificar);
        BtnModificar.setBounds(420, 270, 160, 53);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Email:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Celular:");

        txtcelular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtcelularMouseClicked(evt);
            }
        });
        txtcelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcelularKeyTyped(evt);
            }
        });

        txtemail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtemailMouseClicked(evt);
            }
        });
        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Pagina Web:");

        txtpaginaweb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtpaginawebMouseClicked(evt);
            }
        });
        txtpaginaweb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpaginawebActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Telefono fijo:");

        txttfijo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txttfijoMouseClicked(evt);
            }
        });
        txttfijo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttfijoKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Telefono opcional:");

        txtTelefonoop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTelefonoopMouseClicked(evt);
            }
        });
        txtTelefonoop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoopKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel18))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtpaginaweb)
                            .addComponent(txtemail)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefonoop)
                            .addComponent(txtcelular)
                            .addComponent(txttfijo))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttfijo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefonoop, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpaginaweb, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Datos contacto", jPanel2);

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Nro cuenta:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Banco:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Tipo cuenta:");

        txtCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCuentaMouseClicked(evt);
            }
        });
        txtCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCuentaActionPerformed(evt);
            }
        });
        txtCuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuentaKeyTyped(evt);
            }
        });

        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Corriente", "Ahorros" }));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Credito:");

        cbxcredito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aplica", "No aplica" }));

        cbxBanco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Banco Solidario", "Banco Produbanco", "Banco Pichincha", "Banco Internacional", "Banco Amazonas", "Banco Procredit", "Banco de Guayaquil", "Banco General Rumiñahui", "Banco del Pacífico", "Banco de Loja", "Banco del Austro", "Banco Bolivariano", "Banco de Machala", "Banco Diners Club del Ecuador", "Banco De Desarrollo", "Corporación Financiera Nacional BP", "BanEcuador", "Banco del Instituto Ecuatoriano de Seguridad Social (BIESS)", "Banco Central del Ecuador", "Banco del Pacífico", "Coop. CACPECO", "Coop. Mushuc Runa", "Coop. Jardín Azuayo", "Coop. Alianza del Valle", "Coop. Cooprogreso", "CoopMego", "Coop. Santa Rosa", "Coop. Policía Nacional", "CACPE Pastaza", "Coop. Juventud Ecuatoriana Progresista (Jeep)" }));
        cbxBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxBancoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCuenta, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbxcredito, javax.swing.GroupLayout.Alignment.TRAILING, 0, 195, Short.MAX_VALUE)
                    .addComponent(cbxBanco, 0, 0, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxBanco, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cbxTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxcredito, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jDesktopPane1.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Datos Bancarios", jDesktopPane1);

        jPanel5.add(jTabbedPane1);
        jTabbedPane1.setBounds(490, 20, 327, 230);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Razón social:");
        jPanel5.add(jLabel9);
        jLabel9.setBounds(150, 220, 116, 23);

        txtRazonS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRazonSMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtRazonSMousePressed(evt);
            }
        });
        txtRazonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRazonSActionPerformed(evt);
            }
        });
        txtRazonS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazonSKeyTyped(evt);
            }
        });
        jPanel5.add(txtRazonS);
        txtRazonS.setBounds(280, 220, 187, 26);

        tbl_proveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_proveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_proveedoresMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_proveedores);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("REGISTRO DE PROVEEDORES");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("PUNTO DE VENTA OMICRON");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(JlabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(JlabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Buscar:");

        Cbxcriterio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Agente Responsable", "Provincia", "RUC", "Razon Social" }));

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });

        Btnbuscar.setBackground(new java.awt.Color(153, 204, 255));
        Btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnbuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 49, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlabelPie, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Cbxcriterio, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(Btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Btnbuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Cbxcriterio, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabelPie, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAresponsableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAresponsableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAresponsableMouseClicked

    private void txtAresponsableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAresponsableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAresponsableMousePressed

    private void txtAresponsableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAresponsableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAresponsableActionPerformed

    private void txtAresponsableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAresponsableKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAresponsableKeyTyped

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        limpiar();
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void txtdireccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtdireccionMouseClicked

    }//GEN-LAST:event_txtdireccionMouseClicked

    private void txtdireccionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtdireccionMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdireccionMousePressed

    private void txtdireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdireccionActionPerformed

    private void txtRucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRucMouseClicked

    }//GEN-LAST:event_txtRucMouseClicked

    private void txtRucMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRucMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRucMousePressed

    private void txtRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRucActionPerformed

    private void txtRucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyTyped
        // TODO add your handling code here:
        validacion.validaSeaNumero(evt, txtRuc, 13);
    }//GEN-LAST:event_txtRucKeyTyped

    private void lblFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFotoMouseClicked

    }//GEN-LAST:event_lblFotoMouseClicked

    private void BtnCargarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCargarFotoActionPerformed
        CargarFoto();
    }//GEN-LAST:event_BtnCargarFotoActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        Eliminar();
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        try {
            // TODO add your handling code here:
            seleccionar();
        } catch (Exception ex) {
            Logger.getLogger(IF_Proveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void txtcelularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcelularMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcelularMouseClicked

    private void txtcelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcelularKeyTyped
        // TODO add your handling code here:
        validacion.validaSeaNumero(evt, txtcelular, 10);
    }//GEN-LAST:event_txtcelularKeyTyped

    private void txtemailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtemailMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailMouseClicked

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

    private void txtpaginawebMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtpaginawebMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpaginawebMouseClicked

    private void txtpaginawebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpaginawebActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpaginawebActionPerformed

    private void txttfijoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txttfijoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txttfijoMouseClicked

    private void txttfijoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttfijoKeyTyped
        // TODO add your handling code here:
        validacion.validaSeaNumero(evt, txttfijo, 10);
    }//GEN-LAST:event_txttfijoKeyTyped

    private void txtTelefonoopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefonoopMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoopMouseClicked

    private void txtTelefonoopKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoopKeyTyped
        // TODO add your handling code here:
        validacion.validaSeaNumero(evt, txtTelefonoop, 10);
    }//GEN-LAST:event_txtTelefonoopKeyTyped

    private void txtCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCuentaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCuentaMouseClicked

    private void txtCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCuentaActionPerformed

    private void txtCuentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuentaKeyTyped
        // TODO add your handling code here:
        validacion.validaSeaNumero(evt, txtCuenta, 20);
    }//GEN-LAST:event_txtCuentaKeyTyped

    private void cbxBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxBancoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxBancoActionPerformed

    private void txtRazonSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRazonSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRazonSMouseClicked

    private void txtRazonSMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRazonSMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRazonSMousePressed

    private void txtRazonSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazonSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRazonSActionPerformed

    private void txtRazonSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSKeyTyped
        // TODO add your handling code here:
        validacion.convetMayusculaSoloLetras(evt, txtRazonS, 50);
    }//GEN-LAST:event_txtRazonSKeyTyped

    private void tbl_proveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_proveedoresMouseClicked

    }//GEN-LAST:event_tbl_proveedoresMouseClicked

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void BtnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnbuscarActionPerformed
        try {
            buscar();
        } catch (PosicionException ex) {
            Logger.getLogger(IF_Proveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnbuscarActionPerformed
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
    private javax.swing.JButton BtnCargarFoto;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JButton Btnbuscar;
    private javax.swing.JComboBox<String> Cbxcriterio;
    private javax.swing.JLabel JlabelLogo;
    private javax.swing.JComboBox<String> cbxBanco;
    private javax.swing.JComboBox<String> cbxProvincia;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JComboBox<String> cbxcredito;
    private javax.swing.JLabel icono;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jlabelPie;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JTable tbl_proveedores;
    private javax.swing.JTextField txtAresponsable;
    private javax.swing.JTextField txtCuenta;
    private javax.swing.JTextField txtRazonS;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtTelefonoop;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcelular;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtpaginaweb;
    private javax.swing.JTextField txttfijo;
    // End of variables declaration//GEN-END:variables
}
