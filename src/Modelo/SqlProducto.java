/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.CallableStatement;
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
public class SqlProducto extends Conexion {
    
    public boolean insertarProducto(Producto producto) {
        
        CallableStatement ps = null;
        
        Connection conexion = getconnection();
        
        try {
            
            ps = conexion.prepareCall("{CALL altaProducto (?,?,?,?)}");
            
            ps.setInt(1, producto.getIdProveedor());
            ps.setString(2, producto.getNombre());            
            ps.setFloat(3, producto.getPrecioCompra());
            ps.setFloat(4, producto.getPrecioVenta());
            
            ps.execute();
            
            return true;
            
        } catch (SQLException ex) {
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                
            }
        }
        
    }
    
    public boolean bajaProducto(Producto producto) {
        
        CallableStatement cs = null;
        
        Connection conexion = getconnection();
        
        try {
            
            cs = conexion.prepareCall("{CALL bajaProducto (?)}");
            cs.setInt(1, producto.getIdProducto());
            
            cs.execute();
            
            return true;
            
        } catch (SQLException ex) {
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                
            }
        }
    }
    
    public boolean actualizarProducto(Producto producto) {
        
        CallableStatement cs = null;
        Connection conexion = getconnection();
        
        try {
            
            cs = conexion.prepareCall("{CALL actualizarProducto (?,?,?,?,?,?,?)}");
            cs.setInt(1, producto.getIdProducto());
            cs.setInt(2, producto.getIdProducto());
            cs.setString(3, producto.getNombre());
            cs.setFloat(4, producto.getPrecioVenta());
            cs.setFloat(5, producto.getPrecioCompra());
            
            cs.execute();
            
            return true;
            
        } catch (SQLException ex) {
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                
            }
        }
        
    }    
    
    public boolean reactivarProducto(Producto producto) {
        
        CallableStatement cs = null;
        
        Connection conexion = getconnection();
        
        try {
            
            cs = conexion.prepareCall("{CALL reactivarProducto (?)}");
            cs.setInt(1, producto.getIdProducto());
            
            cs.execute();
            
            return true;
            
        } catch (SQLException ex) {
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                
            }
        }
        
    }
    
    public Producto buscarProducto(int id) {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Producto producto = new Producto();
        Connection conexion = getconnection();
        
        try {
            
            ps = conexion.prepareStatement("select  idProveedor ,nombre , precioVenta, precioCompra, stock\n"
                    + "from producto where idProducto =?");
            
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                
                producto.setIdProducto(id);
                producto.setIdProveedor(rs.getInt("idProveedor"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecioVenta(rs.getFloat("precioVenta"));
                producto.setPrecioCompra(rs.getFloat("precioCompra"));
                producto.setStock(rs.getInt("stock"));
                
                return producto;
                
            } else {
                return null;
            }
            
        } catch (SQLException ex) {
            return null;
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                
            }
        }
    }
    
    public boolean actualizarStock(int id, int cantidad) {
        
        Connection conexion = getconnection();
        
        PreparedStatement ps = null;        
        ResultSet rs = null;
        
        try {
            
            ps = conexion.prepareStatement("select stock from producto where idProducto=?");
            ps.setInt(1, id);
            
            int nstock = 0;
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                
                nstock = rs.getInt("stock");
                nstock = nstock - cantidad;
                
                ps = conexion.prepareStatement("update producto set stock=? where idProducto=?");
                ps.setInt(1, nstock);
                ps.setInt(2, id);
                
                int resultado = ps.executeUpdate();
                
                if (resultado > 0) {
                    return true;
                } else {
                    return false;
                }
                
            } else {
                return false;
            }
            
        } catch (SQLException ex) {
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(SqlProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
