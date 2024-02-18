package interfaz.inicio;

import ClienteDao.ClienteDao;
import ClienteDto.ClienteDto;
import Conexion.Conexion;
import Conexion.IConexion;
import Control.ControlCliente;
import Dominio.Clientes;
import Excepciones.PersistenciaExcepcion;
import interfaz.Usuario.InicioUsuario;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author jesus
 */
public class Inicio extends javax.swing.JFrame {

    String url = "jdbc:mysql://localhost:3306/Banco";
    String usuario = "root";
    String contraseña = "18931Mor";

    IConexion con = new Conexion(url, usuario, contraseña);

    private ClienteDao cliente = new ClienteDao(con);

    private ControlCliente control = new ControlCliente(cliente);

    private static final Logger LOG = Logger.getLogger(Inicio.class.getName());

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUsr = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JTextField();
        Continuar = new javax.swing.JButton();
        retiro = new javax.swing.JButton();
        retiro1 = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTree1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2KeyPressed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\tacot\\Documents\\GitHub\\Banco\\Banco\\BancoInterfaz\\src\\main\\resource\\usuario128.png")); // NOI18N

        jLabel2.setFont(new java.awt.Font("TeX Gyre Adventor", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(10, 80, 186));
        jLabel2.setText("¡Bienvenido!");

        jLabel3.setForeground(new java.awt.Color(10, 80, 186));
        jLabel3.setText("Usuario:");

        jLabel4.setForeground(new java.awt.Color(10, 80, 186));
        jLabel4.setText("Contraseña:");

        txtUsr.setBackground(new java.awt.Color(255, 255, 255));
        txtUsr.setForeground(new java.awt.Color(0, 0, 0));
        txtUsr.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(10, 80, 186)));

        txtContrasena.setBackground(new java.awt.Color(255, 255, 255));
        txtContrasena.setForeground(new java.awt.Color(0, 0, 0));
        txtContrasena.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(10, 80, 186)));

        Continuar.setBackground(new java.awt.Color(10, 80, 186));
        Continuar.setText("Continuar");
        Continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinuarActionPerformed(evt);
            }
        });
        Continuar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ContinuarKeyPressed(evt);
            }
        });

        retiro.setBackground(new java.awt.Color(255, 255, 255));
        retiro.setForeground(new java.awt.Color(10, 80, 186));
        retiro.setText("Retiro sin tarjeta");
        retiro.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        retiro.setBorderPainted(false);
        retiro.setContentAreaFilled(false);
        retiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retiroActionPerformed(evt);
            }
        });

        retiro1.setBackground(new java.awt.Color(255, 255, 255));
        retiro1.setForeground(new java.awt.Color(0, 0, 0));
        retiro1.setText("Registro");
        retiro1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        retiro1.setBorderPainted(false);
        retiro1.setContentAreaFilled(false);
        retiro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retiro1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsr, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(86, 86, 86))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(retiro1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Continuar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(retiro, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUsr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Continuar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(retiro1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(retiro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistroActionPerformed

    }//GEN-LAST:event_botonRegistroActionPerformed

    private void retiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_retiroActionPerformed

    private void botonContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonContinuarActionPerformed

    }//GEN-LAST:event_botonContinuarActionPerformed

    private void ContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinuarActionPerformed
        if (validarUsr(txtUsr.getText()) && validaContrasena(txtContrasena.getText())) {
            try {
                Clientes cli = control.login(txtUsr.getText(), txtContrasena.getText());
                if (cli == null) {
                    LOG.log(Level.SEVERE, "No se inicio sesión");
                } else {
                    LOG.log(Level.INFO, "se inicio sesión");
                    InicioUsuario inicioUsuario = new InicioUsuario(control, cli);
                    inicioUsuario.setVisible(true);
                    this.setVisible(false);
                }
            } catch (PersistenciaExcepcion e) {
                LOG.log(Level.SEVERE, "No se inicio sesión", e);
                JOptionPane.showMessageDialog(rootPane, "Usuario o contraseña incorrectos");
            }

        }else{
        JOptionPane.showMessageDialog(rootPane, "Usuario o contraseña incorrectos");
        this.txtContrasena.setText("");
        this.txtUsr.setText("");
        
        }
    }//GEN-LAST:event_ContinuarActionPerformed

    private void retiro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retiro1ActionPerformed
        Registro regi = new Registro(cliente);
        this.setVisible(false);
        regi.setVisible(true);
    }//GEN-LAST:event_retiro1ActionPerformed

    private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2KeyPressed

    private void ContinuarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ContinuarKeyPressed
        
    }//GEN-LAST:event_ContinuarKeyPressed

    public boolean validarUsr(String usr) {
        Pattern usuario = Pattern.compile("^[a-zA-Z0-9]+$");
        Matcher validaUsuario = usuario.matcher(usr);
        return validaUsuario.matches();
    }

    public boolean validaContrasena(String contrasena) {
        String expresionRegular = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-zA-Z0-9]).{8,}$";
        Pattern pattern = Pattern.compile(expresionRegular);
        Matcher matcher = pattern.matcher(contrasena);
        return matcher.matches();

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Continuar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JButton retiro;
    private javax.swing.JButton retiro1;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtUsr;
    // End of variables declaration//GEN-END:variables
}
