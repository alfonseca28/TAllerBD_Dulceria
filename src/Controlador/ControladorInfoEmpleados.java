/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Empleado;
import Modelo.ModeloInfoEmpleados;
import Vistas.FormularioEmpleado;
import Vistas.VistaInformacionEmpleados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Erick Gonzalez
 */
public class ControladorInfoEmpleados implements ActionListener{

    private VistaInformacionEmpleados vista;
    private ModeloInfoEmpleados modelo;
    
    private int vendedor;
    private String puesto_vendedor;
    
    
    public ControladorInfoEmpleados(VistaInformacionEmpleados vista, ModeloInfoEmpleados modelo) {
        this.vista = vista;
        this.modelo = modelo;
               
        
        
        vista.menuRegresarEmpleados.addActionListener(this);
        vista.btnEditarEmpleados.addActionListener(this);
        

       

    }
    
    
    public void iniciar(int vendedor, String puesto_vendedor) {
        this.vendedor = vendedor;
        this.puesto_vendedor = puesto_vendedor;

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        if(ae.getSource() == vista.menuRegresarEmpleados){
            vista.dispose();
        }
        
        
       
        
        if(ae.getSource() == vista.btnEditarEmpleados){
            
            FormularioEmpleado vistaFormularioEmpleado = new FormularioEmpleado();
            Empleado empleado = new Empleado();            
            ControladorFormularioEmpleado controladorFormularioEmpleado = new ControladorFormularioEmpleado(vistaFormularioEmpleado,empleado);
            
            controladorFormularioEmpleado.iniciar(vendedor, puesto_vendedor);
        }
        
        
    }
    
    
    
}

