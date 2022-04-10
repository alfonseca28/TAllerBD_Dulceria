/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Modelo.Conexion;
import Modelo.ReporteEmpleados;
import Modelo.ReporteVentas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 * @author Erick Gonzalez, Damian Cazarin & Aaron Alfonseca
 */
public class VistaInformacionEmpleados extends javax.swing.JFrame {

    /**
     * Creates new form VistaInformacionEmpleados
     */
    public VistaInformacionEmpleados() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtBuscarEmpleados = new javax.swing.JTextField();
        btnBuscarEmpleados = new javax.swing.JButton();
        btnCargarTodoEmpleados = new javax.swing.JButton();
        btnEditarEmpleados = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBarEmpleados = new javax.swing.JMenuBar();
        menuInformacionEmpleados = new javax.swing.JMenu();
        menuRegresarEmpleados = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Informacion Empleados");
        setPreferredSize(new java.awt.Dimension(838, 579));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel1.setText("Consulta empleados");

        tablaEmpleados.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "IdEmpleado", "Nombre", "ApPaterno", "ApMaterno", "Telefono", "Direccion", "Email", "Puesto", "Edad", "Contraseña"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaEmpleados);
        if (tablaEmpleados.getColumnModel().getColumnCount() > 0) {
            tablaEmpleados.getColumnModel().getColumn(0).setResizable(false);
            tablaEmpleados.getColumnModel().getColumn(0).setPreferredWidth(80);
            tablaEmpleados.getColumnModel().getColumn(1).setResizable(false);
            tablaEmpleados.getColumnModel().getColumn(2).setResizable(false);
            tablaEmpleados.getColumnModel().getColumn(3).setResizable(false);
            tablaEmpleados.getColumnModel().getColumn(4).setResizable(false);
            tablaEmpleados.getColumnModel().getColumn(5).setResizable(false);
            tablaEmpleados.getColumnModel().getColumn(5).setPreferredWidth(120);
            tablaEmpleados.getColumnModel().getColumn(6).setResizable(false);
            tablaEmpleados.getColumnModel().getColumn(6).setPreferredWidth(120);
            tablaEmpleados.getColumnModel().getColumn(7).setResizable(false);
            tablaEmpleados.getColumnModel().getColumn(8).setResizable(false);
            tablaEmpleados.getColumnModel().getColumn(8).setPreferredWidth(40);
            tablaEmpleados.getColumnModel().getColumn(9).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel2.setText("Buscar  por  IdEspecifico:");

        txtBuscarEmpleados.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        btnBuscarEmpleados.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnBuscarEmpleados.setText("Buscar");
        btnBuscarEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEmpleadosActionPerformed(evt);
            }
        });

        btnCargarTodoEmpleados.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnCargarTodoEmpleados.setText("Cagar todos los registros");
        btnCargarTodoEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarTodoEmpleadosActionPerformed(evt);
            }
        });

        btnEditarEmpleados.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnEditarEmpleados.setText("Añadir, Editar o Eliminar registros");

        jButton1.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jButton2.setText("Generar reporte de ventas mensuales por empleado");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        menuInformacionEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/icon_opciones16.png"))); // NOI18N
        menuInformacionEmpleados.setText("Opciones");
        menuInformacionEmpleados.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        menuRegresarEmpleados.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        menuRegresarEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/icon_regresar16.png"))); // NOI18N
        menuRegresarEmpleados.setText("Regresar");
        menuInformacionEmpleados.add(menuRegresarEmpleados);

        jMenuBarEmpleados.add(menuInformacionEmpleados);

        setJMenuBar(jMenuBarEmpleados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscarEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnCargarTodoEmpleados))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBuscarEmpleados)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEditarEmpleados)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))))
                    .addComponent(jLabel1))
                .addGap(0, 25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscarEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarEmpleados)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCargarTodoEmpleados)
                    .addComponent(btnEditarEmpleados)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEmpleadosActionPerformed
        DefaultTableModel modelotabla = new DefaultTableModel();
        tablaEmpleados.setModel(modelotabla);

        PreparedStatement ps = null;
        ResultSet rs = null;

        Conexion con = new Conexion();
        Connection conexion = con.getconnection();

        try {
            ps = conexion.prepareStatement("Select * from empleado where idEmpleado = ?");
            ps.setInt(1, Integer.parseInt(txtBuscarEmpleados.getText()));

            rs = ps.executeQuery();

            modelotabla.addColumn("IdCliente");
            modelotabla.addColumn("Nombre");
            modelotabla.addColumn("ApPaterno");
            modelotabla.addColumn("ApMaterno");
            modelotabla.addColumn("Telefono");
            modelotabla.addColumn("Direccion");
            modelotabla.addColumn("Email");
            modelotabla.addColumn("Puesto");
            modelotabla.addColumn("Edad");
            modelotabla.addColumn("Contraseña");
            modelotabla.addColumn("Estado");

            while (rs.next()) {
                Object fila[] = new Object[11];
                for (int i = 1; i <= 11; i++) {
                    fila[i - 1] = rs.getObject(i);
                }
                modelotabla.addRow(fila);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VistaInformacionClientes.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(VistaInformacionClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnBuscarEmpleadosActionPerformed

    private void btnCargarTodoEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarTodoEmpleadosActionPerformed
        DefaultTableModel modelotabla = new DefaultTableModel();
        tablaEmpleados.setModel(modelotabla);

        PreparedStatement ps = null;
        ResultSet rs = null;

        Conexion con = new Conexion();
        Connection conexion = con.getconnection();

        try {
            ps = conexion.prepareStatement("Select * from empleado");

            rs = ps.executeQuery();

            modelotabla.addColumn("IdCliente");
            modelotabla.addColumn("Nombre");
            modelotabla.addColumn("ApPaterno");
            modelotabla.addColumn("ApMaterno");
            modelotabla.addColumn("Telefono");
            modelotabla.addColumn("Direccion");
            modelotabla.addColumn("Email");
            modelotabla.addColumn("Puesto");
            modelotabla.addColumn("Edad");
            modelotabla.addColumn("Contraseña");
            modelotabla.addColumn("Estado");

            while (rs.next()) {
                Object fila[] = new Object[11];
                for (int i = 1; i <= 11; i++) {
                    fila[i - 1] = rs.getObject(i);
                }
                modelotabla.addRow(fila);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VistaInformacionClientes.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(VistaInformacionClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnCargarTodoEmpleadosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel modelotabla = new DefaultTableModel();
        tablaEmpleados.setModel(modelotabla);
        modelotabla.setNumRows(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el número del mes a generar el reporte", "Mensaje", JOptionPane.INFORMATION_MESSAGE));

        ReporteEmpleados reporte = new ReporteEmpleados();

        reporte.reporte(mes);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(VistaInformacionEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaInformacionEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaInformacionEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaInformacionEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(VistaInicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            //Logger.getLogger(VistaInicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            //Logger.getLogger(VistaInicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            // Logger.getLogger(VistaInicio.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaInformacionEmpleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarEmpleados;
    private javax.swing.JButton btnCargarTodoEmpleados;
    public javax.swing.JButton btnEditarEmpleados;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBarEmpleados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuInformacionEmpleados;
    public javax.swing.JMenuItem menuRegresarEmpleados;
    public javax.swing.JTable tablaEmpleados;
    private javax.swing.JTextField txtBuscarEmpleados;
    // End of variables declaration//GEN-END:variables
}
