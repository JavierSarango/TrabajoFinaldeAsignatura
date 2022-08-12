package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author Nathaly
 */

public class Frm_Inicio extends javax.swing.JFrame {

    private ImageIcon fondo;
    private Icon icono;
    int xMouse, yMouse;
    fondoLabel logotipo = new fondoLabel();

    public Frm_Inicio() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        bg = new javax.swing.JPanel();
        porcentaje = new javax.swing.JLabel();
        JlabelLogo = new fondoLabel();
        Ini = new javax.swing.JLabel();
        barra = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(null);

        porcentaje.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        porcentaje.setForeground(new java.awt.Color(255, 255, 255));
        porcentaje.setText("1%");
        bg.add(porcentaje);
        porcentaje.setBounds(290, 300, 50, 20);
        bg.add(JlabelLogo);
        JlabelLogo.setBounds(0, 0, 630, 290);

        Ini.setBackground(new java.awt.Color(0, 134, 190));
        Ini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosMultimedia/4k-gradient-blue-pink-wallpaper-preview.jpg"))); // NOI18N
        bg.add(Ini);
        Ini.setBounds(0, 0, 630, 350);

        barra.setBackground(new java.awt.Color(102, 205, 211));
        bg.add(barra);
        barra.setBounds(23, 320, 590, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void FondoJlabel(JLabel lbl, String ruta) {
        this.fondo = new ImageIcon(ruta);
        this.icono = new ImageIcon(
                this.fondo.getImage().getScaledInstance(
                        lbl.getWidth(),
                        lbl.getHeight(),
                        Image.SCALE_DEFAULT
                )
        );
        lbl.setIcon(this.icono);
        this.repaint();
    }

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
            java.util.logging.Logger.getLogger(Frm_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Inicio().setVisible(true);
            }
        });
    }
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Ini;
    private javax.swing.JLabel JlabelLogo;
    public javax.swing.JProgressBar barra;
    private javax.swing.JPanel bg;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JLabel porcentaje;
    // End of variables declaration//GEN-END:variables
}
