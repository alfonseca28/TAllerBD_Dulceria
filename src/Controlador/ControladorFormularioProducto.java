/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Producto;
import Modelo.SqlProducto;
import Vistas.FormularioProducto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.String.valueOf;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author Erick Gonzalez, Damian Cazarin & Aaron Alfonseca
 */
public class ControladorFormularioProducto implements ActionListener {

    private FormularioProducto vista;
    private Producto producto;

    private int vendedor;
    private String puesto_vendedor;

    public ControladorFormularioProducto(FormularioProducto vista, Producto producto) {
        this.vista = vista;
        this.producto = producto;

        vista.btnInsertarProducto.addActionListener(this);
        vista.btnBuscarProducto.addActionListener(this);
        vista.btnActualizarProducto.addActionListener(this);
        vista.btnEliminarProducto.addActionListener(this);
        vista.btnReactivarProducto.addActionListener(this);
        vista.btnLimpiarProducto.addActionListener(this);
        vista.btnBuscarProveedor.addActionListener(this);

    }

    public void iniciar(int vendedor, String puesto_vendedor) {

        this.vendedor = vendedor;
        this.puesto_vendedor = puesto_vendedor;

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorInicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ControladorInicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControladorInicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ControladorInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == vista.btnInsertarProducto) {

            SqlProducto validacion = new SqlProducto();

            if (!"".equals(vista.txtNombreProducto.getText()) && !"".equals(vista.txtIdProveedorProducto.getText())
                    && !"".equals(vista.txtProveedorProducto.getText()) && !"".equals(vista.txtPrecioCompraProducto.getText())
                    && !"".equals(vista.txtPrecioVentaProducto.getText())
                    && validacion.validarNombre(vista.txtNombreProducto.getText())) {

                SqlProducto snt = new SqlProducto();

                float pVenta = Float.parseFloat(vista.txtPrecioVentaProducto.getText());
                float pCompra = Float.parseFloat(vista.txtPrecioCompraProducto.getText());

                if (pVenta > pCompra) {

                    producto.setNombre(vista.txtNombreProducto.getText());
                    producto.setIdProveedor(Integer.parseInt(vista.txtIdProveedorProducto.getText()));
                    producto.setPrecioCompra(Float.parseFloat(vista.txtPrecioCompraProducto.getText()));
                    producto.setPrecioVenta(Float.parseFloat(vista.txtPrecioVentaProducto.getText()));

                    if (snt.insertarProducto(producto)) {
                        JOptionPane.showMessageDialog(null, "Producto insertado con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                    JOptionPane.showMessageDialog(null, "El precio de venta debe ser mayor al de compra", "Error", JOptionPane.ERROR_MESSAGE);

                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese todos los datos para continuar", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        if (ae.getSource() == vista.btnActualizarProducto) {

            SqlProducto validacion = new SqlProducto();


            if (!"".equals(vista.txtNombreProducto.getText()) && !"".equals(vista.txtIdProducto.getText())
                    && !"".equals(vista.txtProveedorProducto.getText()) && !"".equals(vista.txtPrecioCompraProducto.getText())
                    && !"".equals(vista.txtPrecioVentaProducto.getText()) && !"".equals(vista.txtIdProveedorProducto.getText())
                    && validacion.validarNombreActualizar(vista.txtNombreProducto.getText(), Integer.parseInt(vista.txtIdProducto.getText()))) {

                float pVenta = Float.parseFloat(vista.txtPrecioVentaProducto.getText());
                float pCompra = Float.parseFloat(vista.txtPrecioCompraProducto.getText());

                SqlProducto snt = new SqlProducto();

                producto.setIdProducto(Integer.parseInt(vista.txtIdProducto.getText()));
                producto.setNombre(vista.txtNombreProducto.getText());
                producto.setIdProveedor(Integer.parseInt(vista.txtIdProveedorProducto.getText()));
                producto.setPrecioCompra(Float.parseFloat(vista.txtPrecioCompraProducto.getText()));
                producto.setPrecioVenta(Float.parseFloat(vista.txtPrecioVentaProducto.getText()));

                if (pVenta > pCompra) {

                    if (snt.actualizarProducto(producto)) {
                        JOptionPane.showMessageDialog(null, "Registro actualizado con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El precio de venta debe ser mayor al de compra", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese todos los datos para continuar", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        if (ae.getSource() == vista.btnEliminarProducto) {

            if (!vista.txtIdProducto.equals("")) {

                if (JOptionPane.showConfirmDialog(null, "¿Estas seguro?", "Mensaje", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                    producto.setIdProducto(Integer.parseInt(vista.txtIdProducto.getText()));
                    SqlProducto snt = new SqlProducto();
                    if (snt.bajaProducto(producto)) {

                        JOptionPane.showMessageDialog(null, "Producto dado de baja", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {

                JOptionPane.showMessageDialog(null, "Ingrese el Id para continuar", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        if (ae.getSource() == vista.btnReactivarProducto) {

            if (!vista.txtIdProducto.equals("")) {

                if (JOptionPane.showConfirmDialog(null, "¿Estas seguro?", "Mensaje", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                    producto.setIdProducto(Integer.parseInt(vista.txtIdProducto.getText()));
                    SqlProducto snt = new SqlProducto();
                    if (snt.reactivarProducto(producto)) {

                        JOptionPane.showMessageDialog(null, "Producto reactivado con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

                    } else {

                        JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);

                    }
                }
            } else {

                JOptionPane.showMessageDialog(null, "Ingrese el Id para continuar", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        if (ae.getSource() == vista.btnBuscarProducto) {

            if (!vista.txtIdProducto.equals("")) {
                SqlProducto snt = new SqlProducto();

                producto = snt.buscarProducto(Integer.parseInt(vista.txtIdProducto.getText()));
                String prove = null;

                if (producto != null) {

                    vista.txtNombreProducto.setText(producto.getNombre());
                    prove = snt.buscarProveedor(Integer.parseInt(vista.txtIdProducto.getText()));
                    vista.txtIdProveedorProducto.setText(valueOf(producto.getIdProveedor()));
                    vista.txtProveedorProducto.setText(prove);
                    vista.txtPrecioVentaProducto.setText(valueOf(producto.getPrecioVenta()));
                    vista.txtPrecioCompraProducto.setText(valueOf(producto.getPrecioCompra()));
                    vista.txtStockProducto.setText(valueOf(producto.getStock()));

                } else {
                    JOptionPane.showMessageDialog(null, "Producto no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese el Id para continuar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (ae.getSource() == vista.btnLimpiarProducto) {

            vista.txtIdProducto.setText("");
            vista.txtNombreProducto.setText("");
            vista.txtIdProveedorProducto.setText("");
            vista.txtPrecioCompraProducto.setText("");
            vista.txtPrecioVentaProducto.setText("");
            vista.txtProveedorProducto.setText("");
            vista.txtStockProducto.setText("");

        }

        if (ae.getSource() == vista.btnBuscarProveedor) {

            if (!vista.txtIdProveedorProducto.equals("")) {

                String prove = null;
                SqlProducto snt = new SqlProducto();

                prove = snt.buscarProveedor(Integer.parseInt(vista.txtIdProveedorProducto.getText()));

                if (prove != null) {

                    producto.setIdProveedor(Integer.parseInt(vista.txtIdProveedorProducto.getText()));
                    vista.txtProveedorProducto.setText(prove);
                } else {
                    JOptionPane.showMessageDialog(null, "Proveedor no encontrado", "Error", JOptionPane.ERROR_MESSAGE);

                }

            } else {
                JOptionPane.showMessageDialog(null, "Ingrese el id para continuar", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

}
