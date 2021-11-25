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

/**
 *
 * @author Erick Gonzalez
 */
public class SqlProducto extends Conexion{
    
    public boolean registrarProducto(Producto producto){
        Connection conexion = getconnection();
        PreparedStatement ps = null;
        
        try{
            
            ps = conexion.prepareStatement("insert into producto(idProveedor,nombre,precioVenta,precioCompra"
                    + "stock) values(?,?,?,?,?)");
            ps.setInt(1, producto.getIdProveedor());
            ps.setString(2, producto.getNombre());
            ps.setFloat(3,producto.getPrecioVenta());
            ps.setFloat(4,producto.getPrecioCompra());
            ps.setInt(5, producto.getStock());
        
            ps.executeUpdate();
            
            return true;
            
        }catch(SQLException ex){
            return false;
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(SqlProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean actualizarStock(int id,int cantidad){
        
        Connection conexion = getconnection();
      
        PreparedStatement ps = null;      
        ResultSet rs = null;
        
        
        try{
            
            ps = conexion.prepareStatement("select stock from producto where idProducto=?");
            ps.setInt(1, id);
            
            int nstock = 0;
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                
                nstock = rs.getInt("stock");
                nstock = nstock - cantidad;
                
                ps = conexion.prepareStatement("update producto set stock=? where idProducto=?");
                ps.setInt(1, nstock);
                ps.setInt(2, id);
                
                int resultado = ps.executeUpdate();
                
                if(resultado>0){
                    return true;
                }
                else{
                    return false;
                }
                                
            }
            else{
                return false;
            }
            
        }catch (SQLException ex){
            return false;
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(SqlProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
}
