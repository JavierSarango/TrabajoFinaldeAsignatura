/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista.InternalFrame;

import Validacion.Validacion;
import controlador.dao.EquipoElectronicoDao;
import controlador.utiles.Utilidades;
import controlador.utiles.enums.TipoEquipo;
import controlador.utiles.enums.TipoOrdenacion;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.Frm_SoporteTectico;
import vista.ModeloTablas.ModeloTablaEquipos;

/**
 *
 * @author Gigabyte
 */
public class IF_SoporteTecnico extends javax.swing.JInternalFrame {

    private EquipoElectronicoDao ee = new EquipoElectronicoDao();
    private ModeloTablaEquipos mte = new ModeloTablaEquipos();
    private Integer id_equipo;
    private TipoEquipo tipoequipo;
    Validacion vali = new Validacion();
    /**
     * Creates new form IF_SoporteTecnico
     */
    public IF_SoporteTecnico() {
        initComponents();
        limpiar();
        cargaCombo();
    }

    public Integer getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(Integer id_equipo) {
        this.id_equipo = id_equipo;
    }

    public void limpiar() {
        ee.setEquipoElectronico(null);
        cargarTabla();

    }

    private void cargarTabla() {
        mte.setLista(ee.listar());
        tbl_tabla.setModel(mte);
        tbl_tabla.updateUI();
    }

    private void guardar() {
        
        try {
             
//        ee.getEquipoElectronico().setId_equipo(5);
        ee.getEquipoElectronico().setRazon_social(txtRazonSocial.getText());
        ee.getEquipoElectronico().setMarca(txtmarca.getText());
        ee.getEquipoElectronico().setModelo(txtmodelo.getText());
        tipoequipo =(cbxtipoEquipo.getSelectedItem().toString().equals("COMPUTADOR")? TipoEquipo.COMPUTADOR:TipoEquipo.IMPRESORA);
        ee.getEquipoElectronico().setTipo_equipo(tipoequipo);
        ee.getEquipoElectronico().setDescripcion_problema(txtdescripProblema.getText());
        ee.getEquipoElectronico().setEstado_ingreso(txtestadoIngreso.getText());
        ee.getEquipoElectronico().setPrecio_servicio(Double.parseDouble(txtprecioServicio.getText()));
        ee.getEquipoElectronico().setCargador(true);
        if (ee.getEquipoElectronico().getId_equipo() == null) {
            if (ee.guardar_modificar()) {
                JOptionPane.showMessageDialog(null, "Registro Completo", "Ok", JOptionPane.INFORMATION_MESSAGE);
//                   limpiar();
//                    cargarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        ee.setEquipoElectronico(null);
        cargarTabla();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
    public void seleccionar() throws Exception {
        limpiar();
        int seleccionar = tbl_tabla.getSelectedRow();
        modelo.equipo nose =ee.obtener(seleccionar);
        if (seleccionar >= 0) {
            txtRazonSocial.setText(String.valueOf(tbl_tabla.getValueAt(seleccionar, 1)));
//            txtRazonSocial.setText(nose.getRazon_social());
            txtmodelo.setText(String.valueOf(tbl_tabla.getValueAt(seleccionar, 2)));
            txtmarca.setText(String.valueOf(tbl_tabla.getValueAt(seleccionar, 3)));
            txtestadoIngreso.setText(String.valueOf(tbl_tabla.getValueAt(seleccionar, 5)));
            txtdescripProblema.setText(String.valueOf(tbl_tabla.getValueAt(seleccionar, 6)));
            cbxtipoEquipo.setSelectedItem(String.valueOf(tbl_tabla.getValueAt(seleccionar, 7)));
            txtprecioServicio.setText(String.valueOf(tbl_tabla.getValueAt(seleccionar, 8)));
            
//            cbxcredito.setSelectedItem(String.valueOf(tbl_proveedores.getValueAt(seleccionar, 14)));
            btnmodificar.setText("Actualizar");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccionar fila que desee cambiar", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void cargaCombo() {
        this.cbxtipoEquipo.removeAllItems();
        for (String aux : Utilidades.tiposE()) {
            this.cbxtipoEquipo.addItem(aux);
        }
        cbxtipoEquipo.updateUI();

    }
     private void buscar() throws Exception {
        String criterioBusqueda = cbx_datoBusqueda.getSelectedItem().toString().toLowerCase();
        String datoBusqueda = txt_busqueda.getText().trim().toLowerCase();

        mte.setLista(ee.listar().buscarDatoPosicionObjetoBinaria(criterioBusqueda, datoBusqueda));
        System.out.println("se realizo busqueda");

        tbl_tabla.setModel(mte);
        tbl_tabla.updateUI();
    }
    private void ordenar() throws Exception {
        String criterio = cbx_datoBusqueda.getSelectedItem().toString().toLowerCase();

        if (radioA.isSelected()) {
            mte.setLista(ee.listar().shellListaEnlazada(criterio, TipoOrdenacion.ASCENDENTE));
            System.out.println("se ordeno ascendente");
        } else if (radioD.isSelected()) {
            mte.setLista(ee.listar().shellListaEnlazada(criterio, TipoOrdenacion.DESCENDENTE));
            System.out.println("se ordeno ascendente");

        }
        tbl_tabla.setModel(mte);
        tbl_tabla.updateUI();

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
        jLabel15 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtmarca = new javax.swing.JTextField();
        checkCargador = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        txtRazonSocial = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtestadoIngreso = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtprecioServicio = new javax.swing.JTextField();
        txtdescripProblema = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtmodelo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbxtipoEquipo = new javax.swing.JComboBox<>();
        btnmodificar = new javax.swing.JButton();
        btnguarnar1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_tabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cbx_datoBusqueda = new javax.swing.JComboBox<>();
        txt_busqueda = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        radioA = new javax.swing.JRadioButton();
        radioD = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setLayout(null);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Equipos Electronicos");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(290, 10, 243, 33);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(30, 40, 840, 10);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        jLabel4.setText("Marca:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(20, 50, 60, 19);

        jLabel3.setText("Precio Servicio:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(590, 50, 110, 30);
        jPanel2.add(txtmarca);
        txtmarca.setBounds(90, 50, 150, 25);

        checkCargador.setText("Cargador:");
        checkCargador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCargadorActionPerformed(evt);
            }
        });
        jPanel2.add(checkCargador);
        checkCargador.setBounds(590, 90, 97, 23);

        jLabel1.setText("Cliente:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(20, 10, 60, 19);
        jPanel2.add(txtRazonSocial);
        txtRazonSocial.setBounds(90, 10, 150, 25);

        jLabel5.setText("Modelo:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 90, 60, 19);
        jPanel2.add(txtestadoIngreso);
        txtestadoIngreso.setBounds(410, 10, 150, 50);

        jLabel6.setText("Tipo Equipo:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(590, 10, 90, 30);

        txtprecioServicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprecioServicioKeyTyped(evt);
            }
        });
        jPanel2.add(txtprecioServicio);
        txtprecioServicio.setBounds(700, 50, 150, 25);
        jPanel2.add(txtdescripProblema);
        txtdescripProblema.setBounds(410, 80, 150, 50);

        jLabel7.setText("Descrip. Problema:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(270, 80, 130, 30);
        jPanel2.add(txtmodelo);
        txtmodelo.setBounds(90, 90, 150, 25);

        jLabel8.setText("Estado Ingreso:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(290, 10, 110, 30);

        cbxtipoEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbxtipoEquipo);
        cbxtipoEquipo.setBounds(700, 10, 150, 25);

        btnmodificar.setText("Modificar");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });
        jPanel2.add(btnmodificar);
        btnmodificar.setBounds(370, 140, 120, 25);

        btnguarnar1.setText("Guardar");
        btnguarnar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguarnar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnguarnar1);
        btnguarnar1.setBounds(20, 150, 120, 25);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(550, 150, 83, 25);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 60, 860, 200);

        tbl_tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_tabla);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 340, 780, 210);

        jLabel2.setText("Buscar segun:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 260, 100, 20);

        cbx_datoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Razon_Social", "Tipo_Equipo", "Marca", "Modelo" }));
        jPanel1.add(cbx_datoBusqueda);
        cbx_datoBusqueda.setBounds(20, 290, 120, 25);
        jPanel1.add(txt_busqueda);
        txt_busqueda.setBounds(170, 290, 130, 25);

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnbuscar);
        btnbuscar.setBounds(310, 290, 100, 25);

        radioA.setText("A");
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
        jPanel1.add(radioA);
        radioA.setBounds(450, 290, 32, 23);

        radioD.setText("D");
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
        jPanel1.add(radioD);
        radioD.setBounds(510, 290, 50, 23);

        jButton3.setText("ordenar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(570, 290, 82, 25);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkCargadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkCargadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkCargadorActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed

        try {
            seleccionar();
        } catch (Exception ex) {
            Logger.getLogger(Frm_SoporteTectico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btnguarnar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguarnar1ActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_btnguarnar1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ee.modificarManualCliente();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl_tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tablaMouseClicked
        // TODO add your handling code here:
        
        try {
            seleccionar();
        } catch (Exception ex) {
            Logger.getLogger(Frm_SoporteTectico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbl_tablaMouseClicked

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

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        try {
            // TODO add your handling code here:
            buscar();
        } catch (Exception ex) {
            Logger.getLogger(IF_SoporteTecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtprecioServicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioServicioKeyTyped
        // TODO add your handling code here:
        vali.validaSeaNumero(evt, txtprecioServicio, 10);
        
    }//GEN-LAST:event_txtprecioServicioKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnguarnar1;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JComboBox<String> cbx_datoBusqueda;
    private javax.swing.JComboBox<String> cbxtipoEquipo;
    private javax.swing.JCheckBox checkCargador;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton radioA;
    private javax.swing.JRadioButton radioD;
    private javax.swing.JTable tbl_tabla;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txt_busqueda;
    private javax.swing.JTextField txtdescripProblema;
    private javax.swing.JTextField txtestadoIngreso;
    private javax.swing.JTextField txtmarca;
    private javax.swing.JTextField txtmodelo;
    private javax.swing.JTextField txtprecioServicio;
    // End of variables declaration//GEN-END:variables
}
