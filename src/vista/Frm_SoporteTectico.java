/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.EquipoElectronicoController;
import controlador.dao.EquipoElectronicoDao;
import controlador.tda.lista.ListaEnlazada;
import controlador.utiles.Utilidades;
import controlador.utiles.enums.TipoEquipo;
import javax.swing.JOptionPane;
import vista.ModeloTablas.ModeloTablaEquipos;

/**
 *
 * @author jona
 */
public class Frm_SoporteTectico extends javax.swing.JDialog {

    private EquipoElectronicoDao eec = new EquipoElectronicoDao();
    private ModeloTablaEquipos mte = new ModeloTablaEquipos();
    private Integer id_equipo;
    private TipoEquipo tipoequipo;

    /**
     * Creates new form Frm_SoporteTectico
     */
    public Frm_SoporteTectico(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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
        eec.setEquipoElectronico(null);
        cargarTabla();

    }

    private void cargarTabla() {
        mte.setLista(eec.listar());
        tbl_tabla.setModel(mte);
        tbl_tabla.updateUI();
    }

    private void guardar() {
        eec.getEquipoElectronico().setId_equipo(5);
        eec.getEquipoElectronico().setRazon_social(txtRazonSocial.getText());
        eec.getEquipoElectronico().setMarca(txtmarca.getText());
        eec.getEquipoElectronico().setModelo(txtmodelo.getText());
        //tipoequipo =(cbxtipoEquipo.getSelectedItem().toString().equals("COMPUTADOR")? TipoEquipo.COMPUTADOR:TipoEquipo.IMPRESORA);
        eec.getEquipoElectronico().setTipo_equipo(TipoEquipo.COMPUTADOR);
        eec.getEquipoElectronico().setDescripcion_problema(txtdescripProblema.getText());
        eec.getEquipoElectronico().setEstado_ingreso(txtestadoIngreso.getText());
        eec.getEquipoElectronico().setPrecio_servicio(Float.parseFloat(txtprecioServicio.getText()));
        eec.getEquipoElectronico().setCargador(true);
        if (eec.getEquipoElectronico().getId_equipo() == null) {
            if (eec.guardar_modificar()) {
                JOptionPane.showMessageDialog(null, "Registro Completo", "Ok", JOptionPane.INFORMATION_MESSAGE);
//                   limpiar();
//                    cargarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        eec.setEquipoElectronico(null);
        cargarTabla();
    }

    private void cargaCombo() {
        this.cbxtipoEquipo.removeAllItems();
        for (String aux : Utilidades.tiposE()) {
            this.cbxtipoEquipo.addItem(aux);

        }
        cbxtipoEquipo.updateUI();

    }

    public void guargaaaaaaaar() {

        if (txtRazonSocial.getText().trim().isEmpty() || txtdescripProblema.getText().trim().isEmpty() || txtestadoIngreso.getText().trim().isEmpty()
                || txtestadoIngreso.getText().trim().isEmpty() || txtmarca.getText().trim().isEmpty() || txtmodelo.getText().trim().isEmpty() || txtprecioServicio.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos vacios", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            eec.getEquipoElectronico().setId_equipo(5);
            eec.getEquipoElectronico().setRazon_social(txtRazonSocial.getText());
            eec.getEquipoElectronico().setMarca(txtmarca.getText());
            eec.getEquipoElectronico().setModelo(txtmodelo.getText());
            //tipoequipo =(cbxtipoEquipo.getSelectedItem().toString().equals("COMPUTADOR")? TipoEquipo.COMPUTADOR:TipoEquipo.IMPRESORA);
            eec.getEquipoElectronico().setTipo_equipo(TipoEquipo.COMPUTADOR);
            eec.getEquipoElectronico().setDescripcion_problema(txtdescripProblema.getText());
            eec.getEquipoElectronico().setEstado_ingreso(txtestadoIngreso.getText());
            eec.getEquipoElectronico().setPrecio_servicio(Float.parseFloat(txtprecioServicio.getText()));
            eec.getEquipoElectronico().setCargador(true);
            System.out.print("Llega 3");
            if (eec.getEquipoElectronico().getId_equipo() == null) {
                if (eec.guardar_modificar()) {
                    JOptionPane.showMessageDialog(null, "Registro Completo", "Ok", JOptionPane.INFORMATION_MESSAGE);
                    limpiar();
                    cargarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar", "Error", JOptionPane.ERROR_MESSAGE);
                }
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

        buttonGroup1 = new javax.swing.ButtonGroup();
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
        btnguarnar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_tabla = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Equipo Electronico"));
        jPanel2.setLayout(null);

        jLabel4.setText("Marca:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(80, 90, 60, 19);

        jLabel3.setText("Precio Servicio:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(30, 340, 110, 30);
        jPanel2.add(txtmarca);
        txtmarca.setBounds(150, 90, 150, 25);

        checkCargador.setText("Cargador:");
        checkCargador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCargadorActionPerformed(evt);
            }
        });
        jPanel2.add(checkCargador);
        checkCargador.setBounds(150, 390, 97, 23);

        jLabel1.setText("Cliente:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(80, 50, 60, 19);
        jPanel2.add(txtRazonSocial);
        txtRazonSocial.setBounds(150, 50, 150, 25);

        jLabel5.setText("Modelo:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(80, 130, 60, 19);
        jPanel2.add(txtestadoIngreso);
        txtestadoIngreso.setBounds(150, 210, 150, 50);

        jLabel6.setText("Tipo Equipo:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(50, 170, 90, 30);
        jPanel2.add(txtprecioServicio);
        txtprecioServicio.setBounds(150, 350, 150, 25);
        jPanel2.add(txtdescripProblema);
        txtdescripProblema.setBounds(150, 280, 150, 50);

        jLabel7.setText("Descrip. Problema:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(10, 280, 130, 30);
        jPanel2.add(txtmodelo);
        txtmodelo.setBounds(150, 130, 150, 25);

        jLabel8.setText("Estado Ingreso:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(30, 210, 110, 30);

        cbxtipoEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbxtipoEquipo);
        cbxtipoEquipo.setBounds(150, 170, 150, 25);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(20, 70, 310, 430);

        btnguarnar.setText("Guardar");
        btnguarnar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguarnarActionPerformed(evt);
            }
        });
        getContentPane().add(btnguarnar);
        btnguarnar.setBounds(30, 520, 120, 25);

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
        jScrollPane1.setViewportView(tbl_tabla);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(350, 80, 480, 380);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Equipos Electronicos");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(260, 10, 243, 33);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 40, 840, 10);

        setBounds(0, 0, 862, 615);
    }// </editor-fold>//GEN-END:initComponents

     private void checkCargadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkCargadorActionPerformed
         // TODO add your handling code here:
     }//GEN-LAST:event_checkCargadorActionPerformed

    private void btnguarnarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguarnarActionPerformed

        guardar();
    }//GEN-LAST:event_btnguarnarActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_SoporteTectico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_SoporteTectico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_SoporteTectico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_SoporteTectico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Frm_SoporteTectico dialog = new Frm_SoporteTectico(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnguarnar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxtipoEquipo;
    private javax.swing.JCheckBox checkCargador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbl_tabla;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtdescripProblema;
    private javax.swing.JTextField txtestadoIngreso;
    private javax.swing.JTextField txtmarca;
    private javax.swing.JTextField txtmodelo;
    private javax.swing.JTextField txtprecioServicio;
    // End of variables declaration//GEN-END:variables
}
