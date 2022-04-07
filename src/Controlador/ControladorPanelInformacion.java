/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ModeloInfoClientes;
import Modelo.ModeloInfoCompras;
import Modelo.ModeloInfoEmpleados;
import Modelo.ModeloInfoProductos;
import Modelo.ModeloInfoProveedores;
import Modelo.ModeloInfoVentas;
import Modelo.ModeloPanelInformacion;
import Modelo.ModeloPanelInicio;
import Vistas.VistaInformacionClientes;
import Vistas.VistaInformacionCompras;
import Vistas.VistaInformacionEmpleados;
import Vistas.VistaInformacionProductos;
import Vistas.VistaInformacionProveedores;
import Vistas.VistaInformacionVentas;
import Vistas.VistaPanelInformacion;
import Vistas.VistaPanelInicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Erick Gonzalez, Damian Cazarin & Aaron Alfonseca
 */
public class ControladorPanelInformacion implements ActionListener {

    private VistaPanelInformacion vista;
    private ModeloPanelInformacion modelo;

    private int vendedor;
    private String puesto_vendedor;

    public ControladorPanelInformacion(VistaPanelInformacion vista, ModeloPanelInformacion modelo) {
        this.vista = vista;
        this.modelo = modelo;

        vista.btnInformacionClientes.addActionListener(this);
        vista.btnInformacionCompras.addActionListener(this);
        vista.btnInformacionEmpleados.addActionListener(this);
        vista.btnInformacionProductos.addActionListener(this);
        vista.btnInformacionProveedores.addActionListener(this);
        vista.btnInformacionVentas.addActionListener(this);
        vista.menuItemRegresarPanelInformacion.addActionListener(this);

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

        if (ae.getSource() == vista.menuItemRegresarPanelInformacion) {
            
            VistaPanelInicio panelInicio = new VistaPanelInicio();
            ModeloPanelInicio modeloInicio = new ModeloPanelInicio();
            ControladorPanelInicio Inicio = new ControladorPanelInicio( panelInicio,modeloInicio);
            
            Inicio.iniciar(vendedor, puesto_vendedor);
            vista.dispose();
            
        }
        
        
        if(ae.getSource() == vista.btnInformacionClientes){
            
            VistaInformacionClientes vistaInfoClientes  = new VistaInformacionClientes();
            ModeloInfoClientes modeloInfoClientes = new ModeloInfoClientes();
            
            ControladorInfoClientes controladorInfoClientes = new ControladorInfoClientes(vistaInfoClientes,modeloInfoClientes);
            
            controladorInfoClientes.iniciar(vendedor, puesto_vendedor);
            
            
        }
        
        
        if(ae.getSource()==vista.btnInformacionCompras){
            
            VistaInformacionCompras vistaInfoCompras  = new VistaInformacionCompras();
            ModeloInfoCompras modeloInfoCompras = new ModeloInfoCompras();
            
            ControladorInfoCompras controladorInfoCompras = new ControladorInfoCompras(vistaInfoCompras,modeloInfoCompras);
            
            controladorInfoCompras.iniciar(vendedor, puesto_vendedor);
            
            
        }
        
        if(ae.getSource()==vista.btnInformacionEmpleados){
            
            VistaInformacionEmpleados vistaInfoEmpleados  = new VistaInformacionEmpleados();
            ModeloInfoEmpleados modeloInfoEmpleados = new ModeloInfoEmpleados();
            
            ControladorInfoEmpleados controladorInfoEmpleados = new ControladorInfoEmpleados(vistaInfoEmpleados,modeloInfoEmpleados);
            
            controladorInfoEmpleados.iniciar(vendedor, puesto_vendedor);
            
            
        }
        
         if(ae.getSource()==vista.btnInformacionProductos){
            
            VistaInformacionProductos vistaInfoProductos  = new VistaInformacionProductos();
            ModeloInfoProductos modeloInfoProductos = new ModeloInfoProductos();
            
            ControladorInfoProductos controladorInfoProductos = new ControladorInfoProductos(vistaInfoProductos,modeloInfoProductos);
            
            controladorInfoProductos.iniciar(vendedor, puesto_vendedor);
            
            
        }
         
         
         if(ae.getSource()==vista.btnInformacionProveedores){
            
            VistaInformacionProveedores vistaInfoProveedores  = new VistaInformacionProveedores();
            ModeloInfoProveedores modeloInfoProveedores = new ModeloInfoProveedores();
            
            ControladorInfoProveedores controladorInfoProveedores = new ControladorInfoProveedores(vistaInfoProveedores,modeloInfoProveedores);
            
            controladorInfoProveedores.iniciar(vendedor, puesto_vendedor);
            
            
        }
        
         if(ae.getSource()==vista.btnInformacionVentas){
            
            VistaInformacionVentas vistaInfoVentas  = new VistaInformacionVentas();
            ModeloInfoVentas modeloInfoVentas = new ModeloInfoVentas();

            
            ControladorInfoVentas controladorInfoVentas = new ControladorInfoVentas(vistaInfoVentas,modeloInfoVentas);
            
            controladorInfoVentas.iniciar(vendedor, puesto_vendedor);
            
            
        }
        
    }

}
