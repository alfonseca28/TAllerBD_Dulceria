/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Proveedor;
import Modelo.Conexion;
import Modelo.ModeloInfoProveedores;
import Vistas.FormularioProveedor;
import Vistas.VistaInformacionProveedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Erick Gonzalez
 */
public class ControladorInfoProveedores extends Conexion implements ActionListener {

    private VistaInformacionProveedores vista;
    private ModeloInfoProveedores modelo;
    
    private int vendedor;
    private String puesto_vendedor;
    
    
    public ControladorInfoProveedores(VistaInformacionProveedores vista, ModeloInfoProveedores modelo) {
        this.vista = vista;
        this.modelo = modelo;
                      
        vista.btnEditarProveedor.addActionListener(this);
        vista.menuRegresarInformacionProveedores.addActionListener(this);
        
        

       

    }
    
    
    public void iniciar(int vendedor, String puesto_vendedor) {
        this.vendedor = vendedor;
        this.puesto_vendedor = puesto_vendedor;

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        if(ae.getSource() == vista.menuRegresarInformacionProveedores){
            vista.dispose();
        }
        
        
       
        
        if(ae.getSource() == vista.btnEditarProveedor){
            
            FormularioProveedor vistaFormularioProveedor = new FormularioProveedor();
            Proveedor proveedor = new Proveedor();            
            ControladorFormularioProveedor controladorFormularioProveedor = new ControladorFormularioProveedor(vistaFormularioProveedor,proveedor);
            
            controladorFormularioProveedor.iniciar(vendedor, puesto_vendedor);
        }
        
        
    }
    
    
    
}

