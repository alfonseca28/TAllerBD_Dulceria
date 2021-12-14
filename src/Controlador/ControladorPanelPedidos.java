/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ModeloCompras;
import Modelo.ModeloPanelInicio;
import Modelo.Producto;
import Modelo.Proveedor;
import Modelo.SqlCompra;
import Modelo.SqlProducto;
import Modelo.SqlProveedor;
import Modelo.SqlVenta;
import Vistas.FormularioProducto;
import Vistas.FormularioProveedor;
import Vistas.VistaPanelInicio;
import java.sql.*;
import Vistas.VistaPanelPedidos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.String.valueOf;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Erick Gonzalez
 */
public class ControladorPanelPedidos implements ActionListener {

    private ModeloCompras modelo;
    private VistaPanelPedidos vista;

    private int vendedor;
    private String puesto_vendedor;

    private float total;
    DefaultTableModel tabla = new DefaultTableModel();

    public ControladorPanelPedidos(VistaPanelPedidos vista, ModeloCompras modelo) {
        this.modelo = modelo;
        this.vista = vista;

        
        
        vista.btnAgregarPedido.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        vista.btnCancelarProductoPedido.addActionListener(this);
        vista.btnCancelarTodoCompra.addActionListener(this);
        vista.btnCerrarPedido.addActionListener(this);
        vista.btnLimpiarCompra.addActionListener(this);
        vista.menuItemRegresarPedidos.addActionListener(this);
        vista.menuProveedor.addActionListener(this);
        vista.menuProductos.addActionListener(this);

    }

    public void iniciar(int vendedor, String puesto_vendedor) {
        this.vendedor = vendedor;
        this.puesto_vendedor = puesto_vendedor;
        
        if (puesto_vendedor.equals("Vendedor")) {
            vista.menuProductos.setVisible(false);
            vista.menuProductos.setVisible(false);
        }

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        vista.lblUsuarioPedidos.setText(valueOf(vendedor));

        Calendar fecha = new GregorianCalendar();

        int mes;

        String anho = Integer.toString(fecha.get(Calendar.YEAR));

        mes = fecha.get(Calendar.MONTH);
        mes++;

        String dia = Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
        String comp = dia + " / " + mes + " / " + anho;

        vista.lblFechaPedidos.setText(comp);

        tabla.addColumn("IdProducto");
        tabla.addColumn("Proveedor");
        tabla.addColumn("Nombre");
        tabla.addColumn("Precio Unitario");
        tabla.addColumn("Cantidad");
        tabla.addColumn("Subtotal");

        vista.tablaPanelPedidos.setModel(tabla);

        total = 0;

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

        if (ae.getSource() == vista.btnBuscar) {

            
            
            if (!"".equals(vista.txtIdProductoPedidos.getText())) {
                

                if (modelo.Buscar(Integer.parseInt(vista.txtIdProductoPedidos.getText()))) {
                    
                    
                    
                    vista.txtMostrarProductoPedidos.setText(modelo.enviarNombre());
                } else {
                    JOptionPane.showMessageDialog(null, "Producto no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese el Id del producto para continuar", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        if (ae.getSource() == vista.btnLimpiarCompra) {
            vista.txtIdProductoPedidos.setText("");
            vista.txtMostrarProductoPedidos.setText("");
            vista.txtCantidadCompra.setText("");
            modelo.limpiar();
        }

        if (ae.getSource() == vista.btnAgregarPedido) {

            String a = vista.txtIdProductoPedidos.getText();
            String b = vista.txtCantidadCompra.getText();
            
            SqlProveedor validacion = new SqlProveedor();

            if (!a.equals("") && !b.equals("")) {

                if (Integer.parseInt(vista.txtCantidadCompra.getText()) >= 1) {

                    
                    if(validacion.comprobarEstado(modelo.enviarIdProveedor())){
                    
                    int cantidad = Integer.parseInt(vista.txtCantidadCompra.getText());
                    int clave = modelo.enviarId();
                    String nombre = modelo.enviarNombre();
                    float subtotal = cantidad * modelo.enviarPrecio();
                    String nombreProv = modelo.enviarNombreProveedor();
                    
                    String info[] = new String[6];
                    info[0] = valueOf(clave);
                    info[1] = nombreProv;
                    info[2] = nombre;
                    info[3] = valueOf(modelo.enviarPrecio());
                    info[4] = valueOf(cantidad);
                    info[5] = valueOf(subtotal);

                    tabla.addRow(info);

                    total += subtotal;

                    vista.txtTotalPedido.setText(valueOf(total));
                    vista.txtIdProductoPedidos.setText("");
                    vista.txtCantidadCompra.setText("");
                    vista.txtMostrarProductoPedidos.setText("");

                    modelo.limpiar();

                }
                    else{                        
                        JOptionPane.showMessageDialog(null, "No se puede agregar el producto debido a que el proveedor no esta activo", "Error",JOptionPane.WARNING_MESSAGE);
                    }
                
                
                } else {
                    JOptionPane.showMessageDialog(null, "No permitido", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Rellene todos los campos para continuar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        
         if(ae.getSource() == vista.btnCancelarProductoPedido){
            
            int fsel =  vista.tablaPanelPedidos.getSelectedRow();
            
            if(fsel == -1){
                
                JOptionPane.showMessageDialog(null,"Ningun producto seleccionado", "Error",JOptionPane.ERROR_MESSAGE);
            }
            
            else if(JOptionPane.showConfirmDialog(null, "¿Estas seguro?", "Confirmar",JOptionPane.WARNING_MESSAGE,
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            
                total = total - Float.parseFloat((String) vista.tablaPanelPedidos.getValueAt(fsel, 5));
                tabla.removeRow(fsel);
                modelo.limpiar();
                vista.txtTotalPedido.setText(valueOf(total));
            }
            
        }
         
         if(ae.getSource() == vista.btnCancelarTodoCompra){
            
            
            if(tabla.getRowCount()>0){
                
            if(JOptionPane.showConfirmDialog(null, "¿Estas seguro?", "Confirmar",JOptionPane.WARNING_MESSAGE,
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                
                tabla.setNumRows(0);
                total = 0;
                vista.txtTotalPedido.setText("");
                modelo.limpiar();                
            }

            }
            
            else{
                JOptionPane.showMessageDialog(null, "No hay productos agregados","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
         
         
        if(ae.getSource()== vista.btnCerrarPedido){
            
            if(total>0 ){
                
                if(JOptionPane.showConfirmDialog(null, "Confimar Compra","Confirmar",
                        JOptionPane.INFORMATION_MESSAGE,JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                    
                    
                float pago;    
                float cambio;
                    
                pago = Float.parseFloat(JOptionPane.showInputDialog(null,"Ingrese el pago","Pago",JOptionPane.INFORMATION_MESSAGE));
                
                
                if(pago>=total){
                
                cambio = pago - total;
                
                Calendar fecha = new GregorianCalendar();
                String sqlFecha = "";
                String sqlHora = "";
                int mes = 0;                
                
                sqlFecha+= valueOf(fecha.get(Calendar.YEAR));
                sqlFecha+= "-";
                mes = (fecha.get(Calendar.MONTH))+1;
                sqlFecha+=valueOf(mes);
                sqlFecha+= "-";
                sqlFecha+= valueOf(fecha.get(Calendar.DAY_OF_MONTH));
                
                sqlHora+= valueOf(fecha.get(Calendar.HOUR_OF_DAY));
                sqlHora+= ":";
                sqlHora+= valueOf(fecha.get(Calendar.MINUTE));
                sqlHora+= ":";
                sqlHora+= valueOf(fecha.get(Calendar.SECOND));
                
                SqlCompra compra = new SqlCompra();
                
                
                compra.setFecha(sqlFecha);
                compra.setHora(sqlHora);
                compra.setIdEmpleado(vendedor);
                compra.setIdProveedor(modelo.enviarIdProveedor());
                                
                while(vista.tablaPanelPedidos.getRowCount()>=1){
                    
                    String dato = "";

                    dato = valueOf(tabla.getValueAt(0, 0));
                    compra.setIdProducto(Integer.parseInt(dato));
                    
                    dato = valueOf(tabla.getValueAt(0, 4));
                    compra.setCantidad(Integer.parseInt(dato));
                                                           
                    
                    dato = valueOf(tabla.getValueAt(0, 5));
                    compra.setPrecio(Float.parseFloat(dato));
                    
                    if(compra.insertarVenta()){
                        tabla.removeRow(0);                        
                    }
                    
                    else{
                        JOptionPane.showMessageDialog(null,"Error","Error",JOptionPane.ERROR_MESSAGE);
                    }
                                        
                    
                }
                
                modelo.limpiar();
                modelo.limpiarProveedor();
                vista.txtTotalPedido.setText("");
                
                JOptionPane.showMessageDialog(null,"¡Compra realizada con éxito!","Venta",JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null,"Cambio: $"+cambio,"Cambio",JOptionPane.INFORMATION_MESSAGE);
                   
                }
                
                else{
                    JOptionPane.showMessageDialog(null,"El pago debe ser mayor al total","Error",JOptionPane.ERROR_MESSAGE);
                }
                }
                
            }
            
            else{
                JOptionPane.showMessageDialog(null,"Llenar todos los campos para continuar","Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        
        if(ae.getSource() == vista.menuItemRegresarPedidos){
            
            VistaPanelInicio vistaInicio = new VistaPanelInicio();
            ModeloPanelInicio modeloInicio = new ModeloPanelInicio();
            
             ControladorPanelInicio controladorInicio = new   ControladorPanelInicio(vistaInicio,modeloInicio);
             
             controladorInicio.iniciar(vendedor, puesto_vendedor);
             
             vista.dispose();
        }
        
        if(ae.getSource() == vista.menuProveedor){
            
            FormularioProveedor vistaProveedor = new FormularioProveedor();
            Proveedor proveedor = new Proveedor();
            
            ControladorFormularioProveedor formularioProveedor = new ControladorFormularioProveedor(vistaProveedor,proveedor);
            
            formularioProveedor.iniciar(vendedor, puesto_vendedor);
            
        }
        
        if(ae.getSource() == vista.menuProductos){
            
            FormularioProducto formularioProducto = new FormularioProducto();
            Producto producto  = new Producto();
            ControladorFormularioProducto controladorFormularioProducto = new ControladorFormularioProducto(formularioProducto,producto);
            
            controladorFormularioProducto.iniciar(vendedor, puesto_vendedor);
            
        }

    }

}
