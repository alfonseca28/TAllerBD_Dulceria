/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ModeloInfoClientes;
import Modelo.ModeloPanelInformacion;
import Modelo.ModeloPanelInicio;
import Vistas.VistaInformacionClientes;
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
 * @author Erick Gonzalez
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
        
        
        
        
    }

}
