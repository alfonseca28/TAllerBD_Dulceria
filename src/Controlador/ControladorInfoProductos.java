/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Producto;
import Modelo.Conexion;
import Modelo.ModeloInfoProductos;
import Vistas.FormularioProducto;
import Vistas.VistaInformacionProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Erick Gonzalez
 */
public class ControladorInfoProductos extends Conexion implements ActionListener {

    private VistaInformacionProductos vista;
    private ModeloInfoProductos modelo;
    
    private int vendedor;
    private String puesto_vendedor;
    
    
    public ControladorInfoProductos(VistaInformacionProductos vista, ModeloInfoProductos modelo) {
        this.vista = vista;
        this.modelo = modelo;
                      
        vista.btnEditarProductos.addActionListener(this);
        vista.menuRegresarInformacionProducto.addActionListener(this);
        
        

       

    }
    
    
    public void iniciar(int vendedor, String puesto_vendedor) {
        this.vendedor = vendedor;
        this.puesto_vendedor = puesto_vendedor;

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        if(ae.getSource() == vista.menuRegresarInformacionProducto){
            vista.dispose();
        }
        
        
       
        
        if(ae.getSource() == vista.btnEditarProductos){
            
            FormularioProducto vistaFormularioProducto = new FormularioProducto();
            Producto producto = new Producto();            
            ControladorFormularioProducto controladorFormularioProducto = new ControladorFormularioProducto(vistaFormularioProducto,producto);
            
            controladorFormularioProducto.iniciar(vendedor, puesto_vendedor);
        }
        
        
    }
    
    
    
}

