/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.Empleado;
import Modelo.ModeloPanelInicio;
import Modelo.ModeloVentas;
import Modelo.Producto;
import Modelo.SqlCliente;
import Modelo.SqlEmpleado;
import Modelo.SqlProducto;
import Modelo.SqlVenta;
import Vistas.FormularioCliente;
import Vistas.FormularioEmpleado;
import Vistas.FormularioProducto;
import Vistas.VistaPanelInicio;
import Vistas.VistaVentas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.String.valueOf;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Erick Gonzalez, Damian Cazarin & Aaron Alfonseca
 */
public class ControladorVentas implements ActionListener {
 
    private VistaVentas vista;
    private ModeloVentas modelo;
    private int vendedor;
    private String puesto_vendedor;
    private float total;
    
    DefaultTableModel tabla = new DefaultTableModel();
       

    public ControladorVentas(VistaVentas vista, ModeloVentas modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        vista.btnAgregar.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        vista.btnBuscarCliente.addActionListener(this);
        vista.btnCancelarCliente.addActionListener(this);
        vista.btnCancelarProductoVenta.addActionListener(this);
        vista.btnCancelarTodoVenta.addActionListener(this);
        vista.btnCerrarVenta.addActionListener(this);
        vista.btnLimpiar.addActionListener(this);
        vista.menuFormularioCliente.addActionListener(this);
        vista.menuItemRegresarVentas.addActionListener(this);      
        vista.menuFormularioCliente.addActionListener(this);
        vista.menuFormularioProducto.addActionListener(this);
        
        
        
    }
    
    public void iniciar(int vendedor,String puesto_vendedor){
      
        
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        
        this.vendedor= vendedor;
        this.puesto_vendedor = puesto_vendedor;
        
        
        if(puesto_vendedor.equals("Vendedor")){
            
            vista.menuFormularioProducto.setVisible(false);            
        }
        
        
        Empleado nombre = new Empleado();
        SqlEmpleado busqueda = new SqlEmpleado();
        
        nombre = busqueda.buscarEmpleado(vendedor);
        
        vista.lblUsuarioProducto.setText(nombre.getNombre()+" "+nombre.getApellidoPaterno()+" "+nombre.getApellidoMaterno());
        
        Calendar fecha = new GregorianCalendar();
        
       int mes;
        
       String anho = Integer.toString(fecha.get(Calendar.YEAR));
       
       mes = fecha.get(Calendar.MONTH);
       mes++;
       
       String dia = Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
       String comp = dia + " / "+mes+" / " + anho;
       
       vista.lblFechaProducto.setText(comp);
     
       tabla.addColumn("IdProducto");
       tabla.addColumn("Nombre");
       tabla.addColumn("Precio Unitario");
       tabla.addColumn("Cantidad");
       tabla.addColumn("Subtotal");
       
       vista.tablaPanelVentas.setModel(tabla);
       
       total = 0;
        
        
    }
    
    
    public static void main(String[]args){
        
        
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
        
        if(ae.getSource()== vista.btnBuscar){
            
            
            if(!"".equals(vista.txtIdProductoVenta.getText())){
                
            SqlProducto validar = new SqlProducto();
            
                    if(modelo.Buscar(Integer.parseInt(vista.txtIdProductoVenta.getText())) && validar.comprobarEstado(Integer.parseInt(vista.txtIdProductoVenta.getText()))){
                      vista.txtMostrarProductoVenta.setText(modelo.enviarNombre());
                    }

                    else{
                        JOptionPane.showMessageDialog(null,"Producto no encontrado","Error",JOptionPane.ERROR_MESSAGE);
                    }
            }
            else{
                JOptionPane.showMessageDialog(null,"Ingrese el Id del producto para continuar","Error",JOptionPane.ERROR_MESSAGE);
            }
            
        }
        
        
        if(ae.getSource()== vista.btnLimpiar){
            vista.txtIdProductoVenta.setText("");
            vista.txtMostrarProductoVenta.setText("");
            vista.txtCantidadVenta.setText("");
            modelo.limpiar();
        }
        
        
        if(ae.getSource() == vista.btnAgregar){
            
            String a=vista.txtIdProductoVenta.getText();
            String b=vista.txtCantidadVenta.getText();
                        
            
            if(!a.equals("") && !b.equals("")){
                
                if(Integer.parseInt(vista.txtCantidadVenta.getText())>=1){
                    
                    
                    if(modelo.comprobarStock(Integer.parseInt(vista.txtCantidadVenta.getText()))){
                        
                        int cantidad = Integer.parseInt(vista.txtCantidadVenta.getText());
                        int clave = modelo.enviarId();
                        String nombre = modelo.enviarNombre();
                        int stock = modelo.enviarStock();
                        float subtotal = cantidad * modelo.enviarPrecio();
                        
                        String info [] = new String[5];
                        info [0] = valueOf(clave);
                        info [1] = nombre;
                        info [2] = valueOf(modelo.enviarPrecio());
                        info [3] = valueOf(cantidad);
                        info [4] = valueOf(subtotal);
                        
                        tabla.addRow(info);
                        
                        total += subtotal;
                        
                        vista.txtTotalVenta.setText(valueOf(total));
                        vista.txtIdProductoVenta.setText("");
                        vista.txtCantidadVenta.setText("");
                        vista.txtMostrarProductoVenta.setText("");
                        
                        modelo.limpiar();                
                    }
                    
                    else{
                            JOptionPane.showMessageDialog(null,"La cantidad seleccionada sobrepasa el stock","Error",JOptionPane.ERROR_MESSAGE);
                    }                    
                }
                
                else{
                        JOptionPane.showMessageDialog(null,"No permitido","Error",JOptionPane.ERROR_MESSAGE);
                }
                
            }
            
            else{
                    JOptionPane.showMessageDialog(null,"Rellene todos los campos para continuar","Error",JOptionPane.ERROR_MESSAGE);
            }            
        }
        
        if(ae.getSource() == vista.btnCancelarProductoVenta){
            
            int fsel =  vista.tablaPanelVentas.getSelectedRow();
            
            if(fsel == -1){
                
                JOptionPane.showMessageDialog(null,"Ningun producto seleccionado", "Error",JOptionPane.ERROR_MESSAGE);
            }
            
            else if(JOptionPane.showConfirmDialog(null, "¿Estas seguro?", "Confirmar",JOptionPane.WARNING_MESSAGE,
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            
                total = total - Float.parseFloat((String) vista.tablaPanelVentas.getValueAt(fsel, 4));
                tabla.removeRow(fsel);
                modelo.limpiar();
                vista.txtTotalVenta.setText(valueOf(total));
            }
            
        }
        
        if(ae.getSource() == vista.btnCancelarTodoVenta){
            
            
            if(tabla.getRowCount()>0){
                
            if(JOptionPane.showConfirmDialog(null, "¿Estas seguro?", "Confirmar",JOptionPane.WARNING_MESSAGE,
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                
                tabla.setNumRows(0);
                total = 0;
                vista.txtTotalVenta.setText("");
                modelo.limpiar();                
            }

            }
            
            else{
                JOptionPane.showMessageDialog(null, "No hay productos agregados","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        
        
        if(ae.getSource() == vista.btnBuscarCliente){
            
            SqlCliente comprobar = new SqlCliente();
            
            if(!"".equals(vista.txtIdCliente.getText())){
                if(modelo.BuscarCliente(Integer.parseInt(vista.txtIdCliente.getText())) && comprobar.comprobarEstado(Integer.parseInt(vista.txtIdCliente.getText())) ){
                    
                    vista.txtMostrarCliente.setText(modelo.enviarNombreCliente());
                    vista.txtIdCliente.setText("");
                    
                }
                
                else{
                    JOptionPane.showMessageDialog(null,"Cliente no encontrado","Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        }
        
        if(ae.getSource()== vista.btnCancelarCliente){
            
            if(!vista.txtIdCliente.equals("")){
                
                if(JOptionPane.showConfirmDialog(null, "¿Estas seguro?","Confirmacion",JOptionPane.WARNING_MESSAGE,
                        JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION){
                    
                    modelo.limpiarCliente();
                    vista.txtIdCliente.setText("");
                    vista.txtMostrarCliente.setText("");
                }
                
            }
            
            else{
                
                JOptionPane.showMessageDialog(null,"No se ha agregado un cliente","Error", JOptionPane.ERROR_MESSAGE);
                
            }
            
        }
        
        if(ae.getSource()== vista.btnCerrarVenta){
            
            if(total>0 && !"".equals(vista.txtMostrarCliente.getText())){
                
                if(JOptionPane.showConfirmDialog(null, "Confimar Venta","Confirmar",
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
                
                SqlVenta venta = new SqlVenta();
                SqlProducto actualizar = new SqlProducto();
                
                venta.setFecha(sqlFecha);
                venta.setHora(sqlHora);
                venta.setIdEmpleado(vendedor);
                venta.setIdCliente(modelo.enviarIdCliente());
                                
                while(vista.tablaPanelVentas.getRowCount()>=1){
                    
                    String dato = "";

                    dato = valueOf(tabla.getValueAt(0, 0));
                    venta.setIdProducto(Integer.parseInt(dato));
                    
                    dato = valueOf(tabla.getValueAt(0, 3));
                    venta.setCantidad(Integer.parseInt(dato));
                                                           
                    
                    dato = valueOf(tabla.getValueAt(0, 4));
                    venta.setPrecio(Float.parseFloat(dato));
                    
                    if(venta.insertarVenta()){
                        tabla.removeRow(0);
                       
                    }
                                        
                    
                }
                
                modelo.limpiar();
                modelo.limpiarCliente();
                vista.txtTotalVenta.setText("");
                vista.txtMostrarCliente.setText("");
                
                JOptionPane.showMessageDialog(null,"¡Venta realizada con éxito!","Venta",JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null,"Cambio: $"+cambio,"Cambio",JOptionPane.INFORMATION_MESSAGE);
                
                
                
                    
                }
                
                else{
                     JOptionPane.showMessageDialog(null,"El pago debe ser igual o mayor al total","Error", JOptionPane.ERROR_MESSAGE);
                }
                
                }
                
                
                
            }
            
            else{
                JOptionPane.showMessageDialog(null,"Llenar todos los campos para continuar","Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        
            
        
        if(ae.getSource()== vista.menuItemRegresarVentas){
            
            ModeloPanelInicio modeloInicio = new ModeloPanelInicio();
            VistaPanelInicio vistaInicio = new VistaPanelInicio();
            ControladorPanelInicio controladorInicio = new ControladorPanelInicio(vistaInicio,modeloInicio);
            
            controladorInicio.iniciar(vendedor, puesto_vendedor);
            
            vista.dispose();
            
        }
        
        if(ae.getSource() == vista.menuFormularioCliente){
            
            FormularioCliente formularioCliente = new FormularioCliente();
            Cliente cliente = new Cliente();
            ControladorFormularioCliente controladorFormularioCliente = new ControladorFormularioCliente(formularioCliente,cliente);
            
            controladorFormularioCliente.iniciar(vendedor, puesto_vendedor);
            
            
        }
        
        if(ae.getSource()== vista.menuFormularioProducto){
            
            
            FormularioProducto formularioProducto = new FormularioProducto();
            Producto producto  = new Producto();
            ControladorFormularioProducto controladorFormularioProducto = new ControladorFormularioProducto(formularioProducto,producto);
            
            controladorFormularioProducto.iniciar(vendedor, puesto_vendedor);
            
        }
        
        
        
        
    }
    
}
