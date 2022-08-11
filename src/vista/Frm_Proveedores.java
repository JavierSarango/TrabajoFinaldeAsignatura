/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import vista.ModeloTablas.ModeloTablaProveedores;
import Validacion.Validacion;
import controlador.dao.ProveedorDao;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nathaly
 */
public class Frm_Proveedores extends javax.swing.JFrame {

//    private ProveedorController proveedordao = new ProveedorController();
    private ProveedorDao proveedordao = new ProveedorDao();
    private ModeloTablaProveedores modelotablaproveedor = new ModeloTablaProveedores();
    private Validacion validacion = new Validacion();
    fondoLabel logotipo = new fondoLabel();
    fondoPieLabel pie = new fondoPieLabel();
    Object Persona;

    //Variables
    private int pos = -1;
    File fichero;
    private int fila = -1;
    //Iconos a botones
    ImageIcon guardar = new ImageIcon("src/RecursosMultimedia/fac_save.png");
    ImageIcon eliminar = new ImageIcon("src/RecursosMultimedia/fac_remove.png");
    ImageIcon modificar = new ImageIcon("src/RecursosMultimedia/Edit-Male-User-icon (1).png");
    ImageIcon nuevo = new ImageIcon("src/RecursosMultimedia/Actions-list-add-user-icon.png");
    ImageIcon cargar = new ImageIcon("src/RecursosMultimedia/jpeg-file-icon (1).png");
    ImageIcon lbl = new ImageIcon("src/RecursosMultimedia/user-icon.png");
    ImageIcon bu = new ImageIcon("src/RecursosMultimedia/buscar.gif");

    /**
     * Creates new form Prov
     */
    private Frm_Proveedores(java.awt.Frame parent, boolean modal) {
        super();
        initComponents();
        cargarTabla();
        Iconos();
        limpiar();

    }

    //Iconos
    private void Iconos() {
        BtnGuardar.setIcon(guardar);
        BtnEliminar.setIcon(eliminar);
        BtnModificar.setIcon(modificar);
        BtnNuevo.setIcon(nuevo);
        BtnCargarFoto.setIcon(cargar);
        Btnbuscar.setIcon(bu);
        icono.setIcon(lbl);
    }

    //Metodo Cargar Tabla
    private void cargarTabla() {
        modelotablaproveedor.setLista(proveedordao.listar());
        tbl_proveedores.setModel(modelotablaproveedor);
        tbl_proveedores.updateUI();
    }

    //Metodo Limpiar
    private void limpiar() {
        txtAresponsable.setText("Ingrese agente responsable");
        txtAresponsable.setForeground(Color.gray);
        txtcallep.setText("Ingrese direccion");
        txtcallep.setForeground(Color.gray);
        txtRuc.setText("Ingrese RUC");
        txtRuc.setForeground(Color.gray);
        txtRazonS.setText("Ingrese razón social");
        txtRazonS.setForeground(Color.gray);
        txttfijo.setText("Ingrese telefono fijo de proveedor");
        txttfijo.setForeground(Color.gray);
        txtcelular.setText("Ingrese celular de proveedor");
        txtcelular.setForeground(Color.gray);
        txtTelefonoop.setText("Ingrese telefono opcional");
        txtTelefonoop.setForeground(Color.gray);
        txtCuenta.setText("Ingrese numero de cuenta");
        txtCuenta.setForeground(Color.gray);
        txtemail.setText("Ingrese email de proveedor");
        txtemail.setForeground(Color.gray);
        txtpaginaweb.setText("Ingrese enlace pagina web");
        txtpaginaweb.setForeground(Color.gray);
        proveedordao.setProveedores(null);
    }

    //Metodo Guardar
    private void guardar() {
        if (txtAresponsable.getText().trim().isEmpty() || txtcallep.getText().trim().isEmpty() || txtcelular.getText().trim().isEmpty()
                || txtCuenta.getText().trim().isEmpty() || txtRuc.getText().trim().isEmpty() || txttfijo.getText().trim().isEmpty() || txtTelefonoop.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos vacios", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (validacion.validaCorreo(txtemail.getText()) == true) {
                proveedordao.getProveedores().setAgenteResponsable(txtAresponsable.getText());
                proveedordao.getProveedores().setProvincia(cbxProvincia.getSelectedItem().toString());
                proveedordao.getProveedores().setDireccion(txtcallep.getText());
                proveedordao.getProveedores().setIdentificacion(txtRuc.getText());
                proveedordao.getProveedores().setRazonSocial(txtRazonS.getText());
                proveedordao.getProveedores().setTelefono(txttfijo.getText());
                proveedordao.getProveedores().setTelefonoO(txtTelefonoop.getText());
                proveedordao.getProveedores().setCelular(txtcelular.getText());
                proveedordao.getProveedores().setCorreo(txtemail.getText());
                proveedordao.getProveedores().setPaginaweb(txtpaginaweb.getText());
                proveedordao.getProveedores().setBanco(cbxBanco.getSelectedItem().toString());
                proveedordao.getProveedores().setTipocuenta(cbxTipo.getSelectedItem().toString());
                proveedordao.getProveedores().setNrocuenta(txtCuenta.getText());
                proveedordao.getProveedores().setCredito((cbxcredito.getSelectedItem().toString()));
                System.out.print("Llega 3");
                if (proveedordao.guardar()) {
                    JOptionPane.showMessageDialog(null, "Registro Completo", "Ok", JOptionPane.INFORMATION_MESSAGE);
                    limpiar();
                    cargarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar", "Error", JOptionPane.ERROR_MESSAGE);
                }

            
                } else {
//                    if (proveedordao.Actualizar()) {
//
//                        JOptionPane.showMessageDialog(null, "Se ha modificado correctamente", "OK", JOptionPane.INFORMATION_MESSAGE);
//                        limpiar();
//                    } else {
//                        JOptionPane.showMessageDialog(null, "No se pudo modificar", "Error", JOptionPane.ERROR_MESSAGE);
//                    }
//                
//            }
//        }
        }
    }
    }
    //Metodo CargarFoto

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

    //Metodo eliminar registro
    public void Eliminar() {
        fila = tbl_proveedores.getSelectedRow();
        try {
            if (fila >= 0) {
//                proveedordao.eliminar(fila);
                JOptionPane.showMessageDialog(null, "Se elimino correctamente", "OK", JOptionPane.INFORMATION_MESSAGE);
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error del sistema", "Error", JOptionPane.ERROR_MESSAGE);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtAresponsable = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbxProvincia = new javax.swing.JComboBox<>();
        BtnGuardar = new javax.swing.JButton();
        BtnNuevo = new javax.swing.JButton();
        txtcallep = new javax.swing.JTextField();
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
        jLabel14 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        Btnbuscar = new javax.swing.JButton();
        jlabelPie = new fondoPieLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Agente responsable:");
        jPanel5.add(jLabel1);
        jLabel1.setBounds(150, 50, 116, 20);

        txtAresponsable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAresponsableMouseClicked(evt);
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
        txtAresponsable.setBounds(270, 50, 188, 26);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Provincia:");
        jPanel5.add(jLabel2);
        jLabel2.setBounds(150, 97, 92, 30);

        cbxProvincia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Azuay", "Bolívar", "Cañar", "Carchi", "Chimborazo", "Cotopaxi", "El Oro", "Esmeraldas", "Galápagos", "Guayas", "Imbabura", "Loja", "Los Rios", " Manabí", "Morona Santiago", "Napo", "Orellana ", "Pastaza", "Pichincha", "Santa Elena", "Santo Domingo de los Tsáchilas", "Sucumbíos", "Tungurahua", "Zamora Chinchipe" }));
        cbxProvincia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(cbxProvincia);
        cbxProvincia.setBounds(270, 100, 188, 32);

        BtnGuardar.setBackground(new java.awt.Color(153, 204, 255));
        BtnGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnGuardar.setText("GUARDAR");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });
        jPanel5.add(BtnGuardar);
        BtnGuardar.setBounds(24, 298, 144, 51);

        BtnNuevo.setBackground(new java.awt.Color(153, 204, 255));
        BtnNuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnNuevo.setText("NUEVO");
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });
        jPanel5.add(BtnNuevo);
        BtnNuevo.setBounds(219, 297, 150, 53);

        txtcallep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtcallepMouseClicked(evt);
            }
        });
        txtcallep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcallepActionPerformed(evt);
            }
        });
        jPanel5.add(txtcallep);
        txtcallep.setBounds(270, 150, 188, 26);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Direcccion:");
        jPanel5.add(jLabel4);
        jLabel4.setBounds(150, 150, 92, 32);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("RUC:");
        jPanel5.add(jLabel5);
        jLabel5.setBounds(152, 204, 80, 23);

        txtRuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRucMouseClicked(evt);
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
        txtRuc.setBounds(270, 201, 188, 26);

        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setText("Foto");
        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFotoMouseClicked(evt);
            }
        });
        jPanel5.add(lblFoto);
        lblFoto.setBounds(10, 70, 115, 136);

        BtnCargarFoto.setBackground(new java.awt.Color(153, 204, 255));
        BtnCargarFoto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnCargarFoto.setText("CARGAR");
        BtnCargarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCargarFotoActionPerformed(evt);
            }
        });
        jPanel5.add(BtnCargarFoto);
        BtnCargarFoto.setBounds(10, 210, 115, 32);

        BtnEliminar.setBackground(new java.awt.Color(153, 204, 255));
        BtnEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnEliminar.setText("ELIMINAR");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });
        jPanel5.add(BtnEliminar);
        BtnEliminar.setBounds(634, 297, 152, 53);

        BtnModificar.setBackground(new java.awt.Color(153, 204, 255));
        BtnModificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnModificar.setText("MODIFICAR");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });
        jPanel5.add(BtnModificar);
        BtnModificar.setBounds(426, 297, 160, 53);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(cbxBanco))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cbxTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
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
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Datos Bancarios", jDesktopPane1);

        jPanel5.add(jTabbedPane1);
        jTabbedPane1.setBounds(476, 34, 327, 243);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Razón social:");
        jPanel5.add(jLabel9);
        jLabel9.setBounds(152, 254, 116, 23);

        txtRazonS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRazonSMouseClicked(evt);
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
        txtRazonS.setBounds(271, 251, 187, 26);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JlabelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Buscar:");

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });

        Btnbuscar.setBackground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 40, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(Btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(238, Short.MAX_VALUE))
            .addComponent(jlabelPie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlabelPie, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(568, 568, 568))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAresponsableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAresponsableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAresponsableActionPerformed

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        limpiar();
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void txtcallepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcallepActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtcallepActionPerformed

    private void txtRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRucActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        Eliminar();
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void lblFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFotoMouseClicked

    }//GEN-LAST:event_lblFotoMouseClicked

    private void BtnCargarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCargarFotoActionPerformed
        CargarFoto();
    }//GEN-LAST:event_BtnCargarFotoActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

    private void txtCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCuentaActionPerformed

    private void txtAresponsableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAresponsableMouseClicked
        // TODO add your handling code here:
        txtAresponsable.setText("");
        txtAresponsable.setForeground(Color.black);
    }//GEN-LAST:event_txtAresponsableMouseClicked

    private void txtTelefonoopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefonoopMouseClicked
        // TODO add your handling code here:
        txtTelefonoop.setText("");
        txtTelefonoop.setForeground(Color.black);
    }//GEN-LAST:event_txtTelefonoopMouseClicked

    private void txtcallepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcallepMouseClicked
        txtcallep.setText("");
        txtcallep.setForeground(Color.black);
    }//GEN-LAST:event_txtcallepMouseClicked

    private void txtRucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRucMouseClicked
        txtRuc.setText("");
        txtRuc.setForeground(Color.black);
    }//GEN-LAST:event_txtRucMouseClicked

    private void txtRazonSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRazonSMouseClicked
        // TODO add your handling code here:
        txtRazonS.setText("");
        txtRazonS.setForeground(Color.black);
    }//GEN-LAST:event_txtRazonSMouseClicked

    private void txtRazonSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazonSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRazonSActionPerformed

    private void txtpaginawebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpaginawebActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpaginawebActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void cbxBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxBancoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxBancoActionPerformed

    private void txtAresponsableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAresponsableKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtAresponsableKeyTyped

    private void txtCuentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuentaKeyTyped
        // TODO add your handling code here:
        validacion.validaSeaNumero(evt, txtCuenta, 20);
    }//GEN-LAST:event_txtCuentaKeyTyped

    private void txttfijoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttfijoKeyTyped
        // TODO add your handling code here:
        validacion.validaSeaNumero(evt, txttfijo, 10);
    }//GEN-LAST:event_txttfijoKeyTyped

    private void txtcelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcelularKeyTyped
        // TODO add your handling code here:
        validacion.validaSeaNumero(evt, txtcelular, 10);
    }//GEN-LAST:event_txtcelularKeyTyped

    private void txtTelefonoopKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoopKeyTyped
        // TODO add your handling code here:
        validacion.validaSeaNumero(evt, txtTelefonoop, 10);
    }//GEN-LAST:event_txtTelefonoopKeyTyped

    private void txtRucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyTyped
        // TODO add your handling code here:
        validacion.validaSeaNumero(evt, txtRuc, 13);
    }//GEN-LAST:event_txtRucKeyTyped

    private void txtRazonSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSKeyTyped
        // TODO add your handling code here:
        validacion.convetMayusculaSoloLetras(evt, txtRazonS, 50);
    }//GEN-LAST:event_txtRazonSKeyTyped

    private void txttfijoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txttfijoMouseClicked
        // TODO add your handling code here:
        txttfijo.setText("");
        txttfijo.setForeground(Color.black);
    }//GEN-LAST:event_txttfijoMouseClicked

    private void txtemailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtemailMouseClicked
        // TODO add your handling code here:
        txtemail.setText("");
        txtemail.setForeground(Color.black);
    }//GEN-LAST:event_txtemailMouseClicked

    private void txtcelularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcelularMouseClicked
        // TODO add your handling code here:
        txtcelular.setText("");
        txtcelular.setForeground(Color.black);
    }//GEN-LAST:event_txtcelularMouseClicked

    private void txtpaginawebMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtpaginawebMouseClicked
        // TODO add your handling code here:
        txtpaginaweb.setText("");
        txtpaginaweb.setForeground(Color.black);
    }//GEN-LAST:event_txtpaginawebMouseClicked

    private void txtCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCuentaMouseClicked
        // TODO add your handling code here:
        txtCuenta.setText("");
        txtCuenta.setForeground(Color.black);
    }//GEN-LAST:event_txtCuentaMouseClicked

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
            java.util.logging.Logger.getLogger(Frm_Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Frm_Proveedores dialog = new Frm_Proveedores(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel JlabelLogo;
    private javax.swing.ButtonGroup buttonGroup1;
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
    private javax.swing.JTextField txtcallep;
    private javax.swing.JTextField txtcelular;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtpaginaweb;
    private javax.swing.JTextField txttfijo;
    // End of variables declaration//GEN-END:variables

}
