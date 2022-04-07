/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Modelo.Conexion;
import Modelo.ReporteProductos;

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
public class VistaInformacionProductos extends javax.swing.JFrame {

    /**
     * Creates new form VistaInformacionProductos
     */
    public VistaInformacionProductos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtBuscarProductos = new javax.swing.JTextField();
        btnBuscarProductos = new javax.swing.JButton();
        btnCargarTodoProducto = new javax.swing.JButton();
        btnEditarProductos = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        menuInformacionProductos = new javax.swing.JMenuBar();
        jMenuVistaInformacionProducto = new javax.swing.JMenu();
        menuRegresarInformacionProducto = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Informacion Productos");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Dulceria Itver");

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null}
                },
                new String[]{
                        "IdProducto", "Proveedor", "Nombre", "PrecioVenta", "PrecioCompra", "Stock"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaProductos);
        if (tablaProductos.getColumnModel().getColumnCount() > 0) {
            tablaProductos.getColumnModel().getColumn(0).setResizable(false);
            tablaProductos.getColumnModel().getColumn(1).setResizable(false);
            tablaProductos.getColumnModel().getColumn(2).setResizable(false);
            tablaProductos.getColumnModel().getColumn(3).setResizable(false);
            tablaProductos.getColumnModel().getColumn(4).setResizable(false);
            tablaProductos.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Buscar  por IdEspecifico:");

        btnBuscarProductos.setText("Buscar");
        btnBuscarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductosActionPerformed(evt);
            }
        });

        btnCargarTodoProducto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCargarTodoProducto.setText("Cagar todos los registros");
        btnCargarTodoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarTodoProductoActionPerformed(evt);
            }
        });

        btnEditarProductos.setText("Añadir, Eliminar o Agregar Productos");

        jButton1.setText("Mostrar Productos por Stock");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Mostar Productos más vendidos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Generar reporte");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jMenuVistaInformacionProducto.setText("Opciones");

        menuRegresarInformacionProducto.setText("Regresar");
        jMenuVistaInformacionProducto.add(menuRegresarInformacionProducto);

        menuInformacionProductos.add(jMenuVistaInformacionProducto);

        setJMenuBar(menuInformacionProductos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addComponent(jLabel2)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(txtBuscarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(btnBuscarProductos)
                                                                        .addGap(27, 27, 27)
                                                                        .addComponent(jButton3)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jButton4))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addComponent(btnCargarTodoProducto)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(btnEditarProductos)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(jButton1)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(jButton2))))
                                                .addGap(0, 140, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtBuscarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnBuscarProductos)
                                        .addComponent(jButton3)
                                        .addComponent(jButton4))
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCargarTodoProducto)
                                        .addComponent(btnEditarProductos)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(265, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductosActionPerformed
        DefaultTableModel modelotabla = new DefaultTableModel();
        tablaProductos.setModel(modelotabla);

        PreparedStatement ps = null;
        ResultSet rs = null;

        Conexion con = new Conexion();
        Connection conexion = con.getconnection();

        try {
            ps = conexion.prepareStatement("Select idProducto,  producto.nombre, proveedor.nombre,precioventa, preciocompra, stock,producto.estado from Producto inner join proveedor on proveedor.idProveedor = producto.idProveedor where idProducto = ?");
            ps.setInt(1, Integer.parseInt(txtBuscarProductos.getText()));

            rs = ps.executeQuery();

            modelotabla.addColumn("IdProducto");
            modelotabla.addColumn("Nombre");
            modelotabla.addColumn("Proveedor");
            modelotabla.addColumn("PrecioVenta");
            modelotabla.addColumn("PrecioCompra");
            modelotabla.addColumn("Stock");
            modelotabla.addColumn("Estado");


            while (rs.next()) {
                Object fila[] = new Object[7];
                for (int i = 1; i <= 7; i++) {
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
    }//GEN-LAST:event_btnBuscarProductosActionPerformed

    private void btnCargarTodoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarTodoProductoActionPerformed
        DefaultTableModel modelotabla = new DefaultTableModel();
        tablaProductos.setModel(modelotabla);

        PreparedStatement ps = null;
        ResultSet rs = null;


        Conexion con = new Conexion();
        Connection conexion = con.getconnection();

        try {
            ps = conexion.prepareStatement("Select idProducto,  producto.nombre, proveedor.nombre,precioventa, preciocompra, stock,producto.estado from Producto inner join proveedor on proveedor.idProveedor = producto.idProveedor\n" +
                    "order by idProducto");


            rs = ps.executeQuery();

            modelotabla.addColumn("IdProducto");
            modelotabla.addColumn("Nombre");
            modelotabla.addColumn("Proveedor");
            modelotabla.addColumn("PrecioVenta");
            modelotabla.addColumn("PrecioCompra");
            modelotabla.addColumn("Stock");
            modelotabla.addColumn("Estado");


            while (rs.next()) {
                Object fila[] = new Object[7];
                for (int i = 1; i <= 7; i++) {
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
    }//GEN-LAST:event_btnCargarTodoProductoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel modelotabla = new DefaultTableModel();
        tablaProductos.setModel(modelotabla);

        PreparedStatement ps = null;
        ResultSet rs = null;

        Conexion con = new Conexion();
        Connection conexion = con.getconnection();

        try {
            ps = conexion.prepareStatement("Select idProducto,  producto.nombre, proveedor.nombre,precioventa, preciocompra, stock,producto.estado from Producto inner join proveedor on proveedor.idProveedor = producto.idProveedor order by stock desc");


            rs = ps.executeQuery();

            modelotabla.addColumn("IdProducto");
            modelotabla.addColumn("Nombre");
            modelotabla.addColumn("Proveedor");
            modelotabla.addColumn("PrecioVenta");
            modelotabla.addColumn("PrecioCompra");
            modelotabla.addColumn("Stock");
            modelotabla.addColumn("Estado");


            while (rs.next()) {
                Object fila[] = new Object[7];
                for (int i = 1; i <= 7; i++) {
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel modelotabla = new DefaultTableModel();
        tablaProductos.setModel(modelotabla);
        modelotabla.setNumRows(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DefaultTableModel modelotabla = new DefaultTableModel();
        tablaProductos.setModel(modelotabla);

        PreparedStatement ps = null;
        ResultSet rs = null;

        Conexion con = new Conexion();
        Connection conexion = con.getconnection();

        try {
            ps = conexion.prepareStatement("SELECT v.idProducto AS Codigo, p.nombre AS Nombre, COUNT(v.idProducto) AS Vendidos FROM venta AS v\n" +
                    "INNER JOIN producto AS p ON v.idProducto = p.idProducto\n" +
                    "GROUP BY p.idproducto ORDER BY Vendidos DESC;");


            rs = ps.executeQuery();

            modelotabla.addColumn("IdProducto");
            modelotabla.addColumn("Nombre");
            modelotabla.addColumn("Total ventas");


            while (rs.next()) {
                Object fila[] = new Object[3];
                for (int i = 1; i <= 3; i++) {
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
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        int mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el número del mes a generar el reporte", "Mensaje", JOptionPane.INFORMATION_MESSAGE));

        ReporteProductos reporte = new ReporteProductos();

        reporte.reporte(mes);


    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(VistaInformacionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaInformacionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaInformacionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaInformacionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new VistaInformacionProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarProductos;
    private javax.swing.JButton btnCargarTodoProducto;
    public javax.swing.JButton btnEditarProductos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenuVistaInformacionProducto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuInformacionProductos;
    public javax.swing.JMenuItem menuRegresarInformacionProducto;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtBuscarProductos;
    // End of variables declaration//GEN-END:variables
}
