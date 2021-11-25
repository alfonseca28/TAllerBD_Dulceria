/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Erick Gonzalez
 */
public class SqlProveedor {
    
    public boolean registrarProveedor(Proveedor proveedor){
        
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        
        
        try{
            
            Connection conexion = con.getconnection();
            ps = conexion.prepareStatement("insert into proveedor (nombre,direccion,telefono,email) values(?,?,?,?)");
            
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getDireccion());
            ps.setString(3, proveedor.getTelefono());
            ps.setString(4, proveedor.getEmail());
            
            ps.executeUpdate();
            
            
        }catch(SQLException ex){
            return false;
        }
        
        return true;
        
    }
    
    
}
