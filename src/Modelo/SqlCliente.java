/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Erick Gonzalez
 */
public class SqlCliente {
    
    public boolean registrarEmpleado(Cliente cliente){
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        
        try{
            Connection conexion = con.getconnection();
            ps = conexion.prepareStatement("insert into cliente(nombre,apellidoPaterno,apellidoMaterno,telefono"
                    + "direccion,email) values(?,?,?,?,?,?)");
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellidoPaterno());
            ps.setString(3, cliente.getApellidoMaterno());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getDireccion());
            ps.setString(6, cliente.getEmail());
            
            ps.executeUpdate();
            
            return true;
            
        }catch(SQLException ex){
            return false;
        }
    }
    
    
    
}
