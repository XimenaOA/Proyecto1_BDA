/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz.Usuario;

import ClienteDao.ClienteDao;
import ClienteDao.iCliente;
import ClienteDto.ClienteDto;
import Conexion.Conexion;
import Conexion.IConexion;
import Control.ControlCliente;
import Dominio.Clientes;
import Dominio.Cuentas;
import Dominio.Retiros;
import Dominio.Transferencias;
//import Dominio.Movimientos;
import Excepciones.PersistenciaExcepcion;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * Interfaz grafica para ver el historial de movimientos de un cliente
 *
 * @author Jesús Alberto Morales Rojas - 245335, Ximena Oliva Andrade - 247563
 */
public class Historial extends javax.swing.JFrame {

    //Atributos de la clase
    private static final Logger LOG = Logger.getLogger(Connection.class.getName());
    private final ControlCliente control;
    private final Clientes cli;

    /**
     * Constructor que inicializa las variables
     *
     * @param control Control
     * @param cli Cliente
     * @throws PersistenciaExcepcion Excepcion
     */
    public Historial(ControlCliente control, Clientes cli) throws PersistenciaExcepcion {
        initComponents();

        this.cli = cli;
        this.control = control;
        this.llenarT();

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtH = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(10, 80, 186));
        jPanel1.setForeground(new java.awt.Color(10, 80, 186));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("TeX Gyre Adventor", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Detalles");

        jtH.setBackground(new java.awt.Color(255, 255, 255));
        jtH.setForeground(new java.awt.Color(0, 0, 0));
        jtH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Movimiento", "Cuenta", "Fecha", "Monto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtH.setGridColor(new java.awt.Color(10, 80, 186));
        jtH.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jtH.setSelectionForeground(new java.awt.Color(10, 80, 186));
        jScrollPane1.setViewportView(jtH);

        jButton1.setBackground(new java.awt.Color(10, 80, 186));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Volver al inicio");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jButton1)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("TeX Gyre Adventor", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Historial");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que abre la ventana de inicio de usuario y la muestra, ocultando la ventana actual.
     *
     * @param evt Evento de acción generado al hacer clic en el botón "jButton1".
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        InicioUsuario ini = new InicioUsuario(control, cli);
        ini = new InicioUsuario(control, cli);
        setVisible(false);
        ini.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Método que llena la tabla de transferencias y retiros con los datos obtenidos del cliente.
     *
     * @throws PersistenciaExcepcion si ocurre un error durante la consulta de transferencias o retiros.
     */
    public void llenarT() throws PersistenciaExcepcion {
        List<Transferencias> listatransferencias = control.ConsultarTransferencias(cli.getId());

        DefaultTableModel modeloTabla = (DefaultTableModel) this.jtH.getModel();

        modeloTabla.setRowCount(0);

        listatransferencias.forEach(Transferencias -> {
            Object[] filas = new Object[4];
            filas[0] = Transferencias.getTipo();
            filas[1] = Transferencias.getRemitente();
            filas[2] = Transferencias.getFechaDeTransferencia();
            filas[3] = Transferencias.getConcepto();
            modeloTabla.addRow(filas);
        });

        List<Retiros> listaretiros = control.ConsultarRetiros(cli.getId());

        listaretiros.forEach(Retiros -> {
            try {
                Cuentas cuenta = control.ConsultarCuenta(Retiros.getIdCuenta());

                Object[] filas = new Object[4];
                filas[0] = Retiros.getTipo();
                filas[1] = Retiros.getNumCuenta();
                filas[2] = Retiros.getFecha();
                filas[3] = Retiros.getMonto();
                modeloTabla.addRow(filas);
            } catch (PersistenciaExcepcion ex) {
                Logger.getLogger(Historial.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtH;
    // End of variables declaration//GEN-END:variables
}
