/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick Gonzalez
 */
public class ModeloVentas extends Conexion{
    
    Producto  producto = new Producto();
    Cliente cliente = new Cliente();
    int cantidad;
    
    public boolean Buscar(int id){
        
        Connection conexion = getconnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            
            
            ps = conexion.prepareStatement("select * from producto where idProducto=? ");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                
                
                    
                
                producto.setIdProducto(id);                
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecioVenta(rs.getFloat("precioVenta"));
                producto.setStock(rs.getInt("stock"));
                
                
                return true;
                
            }
            else{
                return false;
            }
            
        }catch(SQLException ex){
            return false;
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ModeloVentas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    
    public boolean BuscarCliente(int id){
        
        Connection conexion = getconnection();       
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            
            ps = conexion.prepareStatement("select nombre, apellidoPaterno, apellidoMaterno from Cliente where IdCliente=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                
                cliente.setIdCliente(id);
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellidoPaterno(rs.getString("apellidoPaterno"));
                cliente.setApellidoMaterno(rs.getString("apellidoMaterno"));
                
                return true;
                
            }
            else{
                return false;
            }
            
        }catch(SQLException ex){
            return false;
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ModeloVentas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
    
    public String enviarNombreCliente(){
        return cliente.getNombre()+" "+cliente.getApellidoPaterno()+" "+cliente.getApellidoMaterno();
    }
    
    public  String enviarNombre(){
        return producto.getNombre();
    }
    
    public void limpiar(){
         producto.setIdProducto(0);                
         producto.setNombre("");
         producto.setPrecioVenta(0);
         producto.setStock(0);
    }
    
    public boolean comprobarStock(int s){
        
        if(s<=producto.getStock()){
            return true;
        }
        
        else return false;
        
    } 
    
    public int enviarId(){
        return producto.getIdProducto();                
    }
    
    public float enviarPrecio(){
        return producto.getPrecioVenta();                
    }
    
    public int enviarStock(){
        return producto.getStock();
    }
    
    public void limpiarCliente(){
        
        cliente.setIdCliente(0);
        cliente.setNombre("");
        cliente.setApellidoPaterno("");
        cliente.setApellidoMaterno("");
        
    }
    
    public int enviarIdCliente(){
        return cliente.getIdCliente();
    }


}
