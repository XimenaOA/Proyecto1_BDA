/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz.Usuario;

import ClienteDao.ClienteDao;
import ClienteDao.iCliente;
import ClienteDto.CuentaDto;
import ClienteDto.TransferenciasDto;
import Conexion.Conexion;
import Conexion.IConexion;
import Control.ControlCliente;
import Control.iControl;
import Dominio.Clientes;
import Excepciones.PersistenciaExcepcion;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * Interfaz grafica para hacer una transferencia de una cuenta a otra
 *
 * @author Jesús Alberto Morales Rojas - 245335, Ximena Oliva Andrade - 247563
 */
public class transferencia extends javax.swing.JFrame {

    //Atributos de la clase
    private InicioUsuario ini;
    private long numeroCuneta;
    private int saldoT = 1;
    private final ControlCliente control;
    private final Clientes cli;

    /**
     * Constructor de la clase Transferencia.
     *
     * @param control ControlCliente utilizado para realizar operaciones relacionadas con los clientes.
     * @param cli Cliente actual que realiza la transferencia.
     */
    public transferencia(ControlCliente control, Clientes cli) {
        initComponents();

        this.control = control;
        this.cli = cli;
        this.llenarCuentas(cli.getId());

    }

    /**
     * Método privado para llenar el JComboBox con las cuentas asociadas al cliente.
     *
     * @param id ID del cliente del cual se obtienen las cuentas asociadas.
     */
    private void llenarCuentas(int id) {
        try {
            List<String> cuentas = control.ConsultarNumeroCuentas(id);

            DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

            for (String cuenta : cuentas) {
                comboBoxModel.addElement(cuenta);
            }

            this.jCB.setModel(comboBoxModel);
        } catch (PersistenciaExcepcion ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jCB = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSaldoCuenta = new javax.swing.JTextField();
        monto = new com.toedter.components.JSpinField();
        jLabel8 = new javax.swing.JLabel();
        txtCuenta = new javax.swing.JTextField();
        Volver = new javax.swing.JButton();
        Aceptar = new javax.swing.JButton();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(10, 80, 186));

        jLabel3.setFont(new java.awt.Font("TeX Gyre Adventor", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("transferencia");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jCB.setBackground(new java.awt.Color(255, 255, 255));
        jCB.setForeground(new java.awt.Color(0, 0, 0));
        jCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCB.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(10, 80, 186)));
        jCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("TeX Gyre Adventor", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Selecciona una cuenta");

        jLabel6.setFont(new java.awt.Font("TeX Gyre Adventor", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Monto a transferir");

        jLabel7.setFont(new java.awt.Font("TeX Gyre Adventor", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("   Saldo");

        txtSaldoCuenta.setEditable(false);
        txtSaldoCuenta.setBackground(new java.awt.Color(255, 255, 255));
        txtSaldoCuenta.setForeground(new java.awt.Color(0, 0, 0));
        txtSaldoCuenta.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(10, 80, 186)));
        txtSaldoCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoCuentaActionPerformed(evt);
            }
        });

        monto.setBackground(new java.awt.Color(204, 204, 204));
        monto.setToolTipText("");
        monto.setMaximum(10000);
        monto.setMaximumSize(new java.awt.Dimension(0, 10000));
        monto.setMinimum(0);

        jLabel8.setFont(new java.awt.Font("TeX Gyre Adventor", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Escribe una cuenta");

        txtCuenta.setBackground(new java.awt.Color(255, 255, 255));
        txtCuenta.setForeground(new java.awt.Color(0, 0, 0));
        txtCuenta.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(10, 80, 186)));
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 39, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCB, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(10, 10, 10)))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(monto, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(txtSaldoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCB, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSaldoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(monto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        Volver.setBackground(new java.awt.Color(10, 80, 186));
        Volver.setForeground(new java.awt.Color(255, 255, 255));
        Volver.setText("Volver");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });

        Aceptar.setBackground(new java.awt.Color(10, 80, 186));
        Aceptar.setForeground(new java.awt.Color(255, 255, 255));
        Aceptar.setText("Aceptar");
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(Volver)
                        .addGap(18, 18, 18)
                        .addComponent(Aceptar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Volver)
                    .addComponent(Aceptar))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSaldoCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoCuentaActionPerformed

    /**
     * Método que maneja el evento de clic en el botón "Volver".
     *
     * @param evt Evento de acción generado al hacer clic en el botón.
     */
    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        ini = new InicioUsuario(control, cli);
        setVisible(false);
        ini.setVisible(true);
    }//GEN-LAST:event_VolverActionPerformed

    /**
     * Método que maneja el evento de clic en el botón "Aceptar". Realiza la transferencia de fondos entre cuentas.
     *
     * @param evt Evento de acción generado al hacer clic en el botón.
     */
    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        if (!this.txtCuenta.getText().equals("")) {

            try {
                LocalDate localDate = LocalDate.now();
                Date date = java.sql.Date.valueOf(localDate);
                SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = simple.format(date);

                long numCuenta = Long.parseLong(txtCuenta.getText());

                long Cuenta = Long.parseLong(String.valueOf(this.jCB.getSelectedItem()));

                double cantidad = this.monto.getValue();

                TransferenciasDto trans = new TransferenciasDto("Tranferencia", cantidad, Cuenta, numCuenta, fecha, cli.getId());

                control.transeferencia(trans);
                ini = new InicioUsuario(control, cli);
                setVisible(false);
                ini.setVisible(true);

            } catch (PersistenciaExcepcion ex) {
                Logger.getLogger(AgregarCuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "La cuenta tiene que ser de 10 digitos");
        }
    }//GEN-LAST:event_AceptarActionPerformed

    private void txtCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCuentaActionPerformed

    /**
     * Método que maneja el evento de selección de un elemento en el JComboBox "jCB". Actualiza el saldo de la cuenta seleccionada en el JTextField "txtSaldoCuenta".
     *
     * @param evt Evento de acción generado al seleccionar un elemento en el JComboBox.
     */
    private void jCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBActionPerformed
        try {
            this.numeroCuneta = Long.parseLong(String.valueOf(this.jCB.getSelectedItem()));

            this.txtSaldoCuenta.setText(String.valueOf(control.consultarSaldo(numeroCuneta)));
        } catch (PersistenciaExcepcion ex) {
            Logger.getLogger(Deposito.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jCBActionPerformed

    /**
     * Método que maneja el evento de ingreso de teclas en el JTextField "txtCuenta". Valida que solo se ingresen números y muestra un mensaje de advertencia en caso contrario.
     *
     * @param evt Evento de tecla ingresada.
     */
    private void txtCuentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuentaKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Solo se aceptan numeros");
        }
    }//GEN-LAST:event_txtCuentaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JButton Volver;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jCB;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private com.toedter.components.JSpinField monto;
    private javax.swing.JTextField txtCuenta;
    private javax.swing.JTextField txtSaldoCuenta;
    // End of variables declaration//GEN-END:variables
}