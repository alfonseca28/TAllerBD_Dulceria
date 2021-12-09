/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Empleado;
import Modelo.ModeloPanelInformacion;
import Modelo.ModeloPanelInicio;
import Modelo.ModeloCompras;
import Modelo.ModeloVentas;
import Modelo.SqlEmpleado;
import Vistas.FormularioEmpleado;
import Vistas.VistaInicio;
import Vistas.VistaPanelInformacion;
import Vistas.VistaPanelInicio;
import Vistas.VistaPanelPedidos;
import Vistas.VistaVentas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Erick Gonzalez
 */

public class ControladorPanelInicio implements ActionListener {
    
    private VistaPanelInicio vista;
    private ModeloPanelInicio modelo;
    private int vendedor;
    private String puesto_vendedor;

    public ControladorPanelInicio(VistaPanelInicio vista, ModeloPanelInicio modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        
        vista.btnVentas.addActionListener(this);
        vista.btnPedidos.addActionListener(this);
        vista.btnInformacion.addActionListener(this);
        vista.jMenuCerrarSesion.addActionListener(this);
        vista.jMenuCambiarContraseña.addActionListener(this);
        vista.jMenuFormulario.addActionListener(this);
        
    }


    
    public void iniciar(int vendedor, String puesto_vendedor){
        
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        
        
        this.vendedor = vendedor;
        this.puesto_vendedor = puesto_vendedor;
        
                
        if(puesto_vendedor.equals("Vendedor")){
            vista.btnPedidos.setVisible(false);
            vista.btnInformacion.setVisible(false);
            vista.jMenuFormulario.setVisible(false);
            vista.lblPedidos.setVisible(false);
            vista.lblInformacion.setVisible(false);
               
            }
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
        
        if(ae.getSource() == vista.btnVentas){
            VistaVentas  vistaVentas = new VistaVentas();
            ModeloVentas modeloVentas = new ModeloVentas();
            ControladorVentas controladorVentas = new ControladorVentas(vistaVentas,modeloVentas);
            
            vista.dispose();
            controladorVentas.iniciar(vendedor, puesto_vendedor);
        }
        
        if(ae.getSource() == vista.btnPedidos){
            
            VistaPanelPedidos vistaPedidos = new VistaPanelPedidos();
            ModeloCompras modeloPedidos = new ModeloCompras();
            ControladorPanelPedidos controladorPedidos = new ControladorPanelPedidos(vistaPedidos,modeloPedidos);
            
            vista.dispose();
            controladorPedidos.iniciar(vendedor, puesto_vendedor);
        }
        
        
        if(ae.getSource() == vista.btnInformacion){
            
            VistaPanelInformacion vistaPanelInformacion = new VistaPanelInformacion();
            ModeloPanelInformacion modeloPanelInformacion = new ModeloPanelInformacion();
            ControladorPanelInformacion controladorPanelInformacion = new ControladorPanelInformacion(vistaPanelInformacion,modeloPanelInformacion);
            
            vista.dispose();
            controladorPanelInformacion.iniciar(vendedor, puesto_vendedor);   
        }
        
        
        if(ae.getSource() == vista.jMenuCambiarContraseña){  
            modelo.CambiarContraseña(vendedor);
        }
        
        if(ae.getSource() == vista.jMenuCerrarSesion){
            VistaInicio vistaInicio = new VistaInicio();
            ControladorInicio controladorInicio = new ControladorInicio(vistaInicio);
            vista.dispose();
            controladorInicio.iniciar();            
        }
        
        if(ae.getSource() == vista.jMenuFormulario){
            FormularioEmpleado formularioEmpleado = new FormularioEmpleado();
            Empleado empleado = new Empleado();
            ControladorFormularioEmpleado controladorFormularioEmpleado = new ControladorFormularioEmpleado(formularioEmpleado,empleado);
            
            controladorFormularioEmpleado.iniciar(vendedor, puesto_vendedor);
        }
        
    }
}
