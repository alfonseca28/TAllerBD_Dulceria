/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.ModeloInfoClientes;
import Modelo.ModeloPanelInformacion;
import Vistas.FormularioCliente;
import Vistas.VistaInformacionClientes;
import Vistas.VistaPanelInformacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Erick Gonzalez
 */
public class ControladorInfoClientes implements ActionListener{

    private VistaInformacionClientes vista;
    private ModeloInfoClientes modelo;
    
    private int vendedor;
    private String puesto_vendedor;
    
    
    public ControladorInfoClientes(VistaInformacionClientes vista, ModeloInfoClientes modelo) {
        this.vista = vista;
        this.modelo = modelo;
               
        vista.btnCargarTodoClientes.addActionListener(this);
        vista.btnEditarClientes.addActionListener(this);
        vista.menuRegresarInformacionClientes.addActionListener(this);
        //vista.btnBuscarClientes

       

    }
    
    
    public void iniciar(int vendedor, String puesto_vendedor) {
        this.vendedor = vendedor;
        this.puesto_vendedor = puesto_vendedor;

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        if(ae.getSource() == vista.menuRegresarInformacionClientes){
            vista.dispose();
        }
        
        
        if(ae.getSource() == vista.btnCargarTodoClientes){
            
            String atributo = "";
            
            switch(vista.BoxBuscarClientes.getSelectedIndex()){
                
                case 0:
                    atributo = "idCliente";
                    break;
                    
                case 1:
                    atributo = "nombre";
                    break;
                    
                case 2:
                    atributo = "apellidoPaterno";
                    break;
                    
                    
                case 3:
                    atributo = "apellidoMaterno";
                    break;
                    
                case 4 :
                    atributo = "telefono";
                    break;
                
                case 5 :
                     atributo = "direccion";
                     break;
                
                case 6:
                    atributo = "email";
                    break;
            }
            
        }
        
        
        if(ae.getSource() == vista.btnEditarClientes){
            
            FormularioCliente vistaFormularioCliente = new FormularioCliente();
            Cliente cliente = new Cliente();            
            ControladorFormularioCliente controladorFormularioCliente = new ControladorFormularioCliente(vistaFormularioCliente,cliente);
            
            controladorFormularioCliente.iniciar(vendedor, puesto_vendedor);
        }
        
        
    }
    
    
    
}
