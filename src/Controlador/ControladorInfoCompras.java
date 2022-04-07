/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.Conexion;
import Modelo.ModeloInfoCompras;

import Vistas.VistaInformacionCompras;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Erick Gonzalez, Damian Cazarin & Aaron Alfonseca
 */
public class ControladorInfoCompras extends Conexion implements ActionListener {

    private VistaInformacionCompras vista;
    private ModeloInfoCompras modelo;
    
    private int vendedor;
    private String puesto_vendedor;
    
    
    public ControladorInfoCompras(VistaInformacionCompras vista, ModeloInfoCompras modelo) {
        this.vista = vista;
        this.modelo = modelo;
                      
        
        vista.menuRegresarInformacionCompras.addActionListener(this);
        
        

       

    }
    
    
    public void iniciar(int vendedor, String puesto_vendedor) {
        this.vendedor = vendedor;
        this.puesto_vendedor = puesto_vendedor;

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        if(ae.getSource() == vista.menuRegresarInformacionCompras){
            vista.dispose();
        }
        
        
       
        
       
        
        
    }
    
    
    
}

