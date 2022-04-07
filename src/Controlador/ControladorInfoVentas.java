/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.Conexion;
import Modelo.ModeloInfoVentas;

import Vistas.VistaInformacionVentas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Erick Gonzalez, Damian Cazarin & Aaron Alfonseca
 */
public class ControladorInfoVentas extends Conexion implements ActionListener {

    private VistaInformacionVentas vista;
    private ModeloInfoVentas modelo;

    private int vendedor;
    private String puesto_vendedor;


    public ControladorInfoVentas(VistaInformacionVentas vista, ModeloInfoVentas modelo) {
        this.vista = vista;
        this.modelo = modelo;


        vista.menuRegresarVentas.addActionListener(this);


    }


    public void iniciar(int vendedor, String puesto_vendedor) {
        this.vendedor = vendedor;
        this.puesto_vendedor = puesto_vendedor;

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {


        if (ae.getSource() == vista.menuRegresarVentas) {
            vista.dispose();
        }


    }


}

