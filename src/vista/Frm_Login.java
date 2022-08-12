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

public class Frm_Login extends javax.swing.JFrame {

    private ImageIcon fondo;
    private Icon icono;
    int xMouse, yMouse;
    fondoLabel logotipo = new fondoLabel();

    public Frm_Login() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        bg = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        JlabelLogo = new fondoLabel();
        city = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        userTxt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        passLabel = new javax.swing.JLabel();
        passTxt = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        JpanelEntrar = new javax.swing.JPanel();
        loginentrar = new javax.swing.JLabel();
        jPanelRegistrarse = new javax.swing.JPanel();
        loginregistrarse = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(null);

        exitBtn.setBackground(new java.awt.Color(102, 205, 211));

        exitTxt.setBackground(new java.awt.Color(153, 214, 243));
        exitTxt.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        exitTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitTxt.setText("X");
        exitTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        exitTxt.setPreferredSize(new java.awt.Dimension(40, 40));
        exitTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout exitBtnLayout = new javax.swing.GroupLayout(exitBtn);
        exitBtn.setLayout(exitBtnLayout);
        exitBtnLayout.setHorizontalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(exitTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        exitBtnLayout.setVerticalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(exitTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bg.add(exitBtn);
        exitBtn.setBounds(760, 0, 40, 40);

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosMultimedia/FxX5caie56yrFjfYij2Mbker1rh2G3LvYcCVVaVH1JRLha5fioGyDWmi5z58xZJVA7X2kn8pxcyY2uheSx1JsmyPjE8uxo7dKQ1hdGCT4EDb.gif"))); // NOI18N
        bg.add(logo);
        logo.setBounds(10, 0, 310, 450);
        bg.add(JlabelLogo);
        JlabelLogo.setBounds(340, 0, 460, 100);

        city.setBackground(new java.awt.Color(0, 134, 190));
        city.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosMultimedia/4k-gradient-blue-pink-wallpaper-preview.jpg"))); // NOI18N
        bg.add(city);
        city.setBounds(0, 0, 340, 450);

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        bg.add(header);
        header.setBounds(-10, -10, 770, 40);

        title.setFont(new java.awt.Font("Californian FB", 1, 24)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("INICIAR SESIÓN");
        bg.add(title);
        title.setBounds(460, 130, 230, 32);

        userLabel.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        userLabel.setText("USUARIO");
        bg.add(userLabel);
        userLabel.setBounds(430, 190, 90, 17);

        userTxt.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        userTxt.setForeground(new java.awt.Color(204, 204, 204));
        userTxt.setText("Ingrese su nombre de usuario");
        userTxt.setBorder(null);
        userTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userTxtMousePressed(evt);
            }
        });
        bg.add(userTxt);
        userTxt.setBounds(430, 220, 310, 30);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator1);
        jSeparator1.setBounds(430, 250, 310, 10);

        passLabel.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        passLabel.setText("CONTRASEÑA");
        bg.add(passLabel);
        passLabel.setBounds(430, 280, 120, 17);

        passTxt.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        passTxt.setForeground(new java.awt.Color(204, 204, 204));
        passTxt.setText("********");
        passTxt.setBorder(null);
        passTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passTxtMousePressed(evt);
            }
        });
        passTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passTxtKeyReleased(evt);
            }
        });
        bg.add(passTxt);
        passTxt.setBounds(430, 310, 310, 30);

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator2);
        jSeparator2.setBounds(430, 340, 310, 20);

        JpanelEntrar.setBackground(new java.awt.Color(102, 205, 211));

        loginentrar.setBackground(new java.awt.Color(153, 221, 247));
        loginentrar.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        loginentrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginentrar.setText("ENTRAR");
        loginentrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginentrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginentrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginentrarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout JpanelEntrarLayout = new javax.swing.GroupLayout(JpanelEntrar);
        JpanelEntrar.setLayout(JpanelEntrarLayout);
        JpanelEntrarLayout.setHorizontalGroup(
            JpanelEntrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginentrar, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        JpanelEntrarLayout.setVerticalGroup(
            JpanelEntrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpanelEntrarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(loginentrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bg.add(JpanelEntrar);
        JpanelEntrar.setBounds(400, 400, 150, 40);

        jPanelRegistrarse.setBackground(new java.awt.Color(102, 205, 211));

        loginregistrarse.setBackground(new java.awt.Color(153, 214, 243));
        loginregistrarse.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        loginregistrarse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginregistrarse.setText("REGISTRARSE");
        loginregistrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        loginregistrarse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginregistrarseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginregistrarseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginregistrarseMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelRegistrarseLayout = new javax.swing.GroupLayout(jPanelRegistrarse);
        jPanelRegistrarse.setLayout(jPanelRegistrarseLayout);
        jPanelRegistrarseLayout.setHorizontalGroup(
            jPanelRegistrarseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginregistrarse, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        jPanelRegistrarseLayout.setVerticalGroup(
            jPanelRegistrarseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistrarseLayout.createSequentialGroup()
                .addComponent(loginregistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bg.add(jPanelRegistrarse);
        jPanelRegistrarse.setBounds(630, 400, 140, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseClicked

        int opcion = JOptionPane.showConfirmDialog(null, "¿Esta Seguro de Cerrar?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else if (opcion == JOptionPane.NO_OPTION) {
        }
    }//GEN-LAST:event_exitTxtMouseClicked

    private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseEntered
        exitBtn.setBackground(Color.red);
        exitTxt.setForeground(Color.white);
    }//GEN-LAST:event_exitTxtMouseEntered

    private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseExited
        exitBtn.setBackground(Color.white);
        exitTxt.setForeground(Color.black);
    }//GEN-LAST:event_exitTxtMouseExited

    private void loginregistrarseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginregistrarseMouseEntered
        jPanelRegistrarse.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_loginregistrarseMouseEntered

    private void loginregistrarseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginregistrarseMouseExited
        jPanelRegistrarse.setBackground(new Color(0, 134, 190));
    }//GEN-LAST:event_loginregistrarseMouseExited

    private void userTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTxtMousePressed
        if (userTxt.getText().equals("Ingrese su nombre de usuario")) {
            userTxt.setText("");
            userTxt.setForeground(Color.black);
        }
        if (String.valueOf(passTxt.getPassword()).isEmpty()) {
            passTxt.setText("********");
            passTxt.setForeground(Color.gray);
        }
    }//GEN-LAST:event_userTxtMousePressed

    private void passTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passTxtMousePressed
        if (String.valueOf(passTxt.getPassword()).equals("********")) {
            passTxt.setText("");
            passTxt.setForeground(Color.black);
        }
        if (userTxt.getText().isEmpty()) {
            userTxt.setText("Ingrese su nombre de usuario");
            userTxt.setForeground(Color.gray);
        }
    }//GEN-LAST:event_passTxtMousePressed

    private void loginregistrarseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginregistrarseMouseClicked

    }//GEN-LAST:event_loginregistrarseMouseClicked

    private void loginentrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginentrarMouseClicked

    }//GEN-LAST:event_loginentrarMouseClicked

    private void loginentrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginentrarMouseEntered
        JpanelEntrar.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_loginentrarMouseEntered

    private void loginentrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginentrarMouseExited
        JpanelEntrar.setBackground(new Color(0, 134, 190));
    }//GEN-LAST:event_loginentrarMouseExited

    private void passTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passTxtKeyReleased

    }//GEN-LAST:event_passTxtKeyReleased
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
            java.util.logging.Logger.getLogger(Frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Login().setVisible(true);
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
    private javax.swing.JLabel JlabelLogo;
    private javax.swing.JPanel JpanelEntrar;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel city;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JPanel header;
    private javax.swing.JPanel jPanelRegistrarse;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel loginentrar;
    private javax.swing.JLabel loginregistrarse;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField passTxt;
    private javax.swing.JLabel title;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables
}
