/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Date;
import java.sql.Time;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick Gonzalez
 */
public class SqlVenta extends Conexion {
    
    private int idVenta;
    private String fecha;
    private String hora;
    private float precio;
    private int cantidad;
    private int idEmpleado;
    private int idProducto;
    private int idCliente;

    public SqlVenta() {
        
    }

    
    
    
    

    
    
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    
    public boolean insertarVenta(){
        
        Connection conexion = getconnection();
        PreparedStatement ps = null;        
        
        try{
            
            ps = conexion.prepareStatement("insert into venta (fecha, hora, precio, cantidad, idEmpleado, idProducto, idCliente)"
                    + "values (?,?,?,?,?,?,?)");
            
            ps.setDate(1, Date.valueOf((fecha)));
            ps.setTime(2, Time.valueOf((hora)));
            ps.setFloat(3, precio);
            ps.setInt(4, cantidad);
            ps.setInt(5, idEmpleado);
            ps.setInt(6, idProducto);
            ps.setInt(7, idCliente);
            
            int resultado = ps.executeUpdate();
            
        if(resultado>0)return true;
                
                else{
                    JOptionPane.showMessageDialog(null,"Error","Error",JOptionPane.ERROR_MESSAGE);
                    return false;
                }

            }catch(SQLException ex){
                return false;
            }finally{
                try{
                    conexion.close();
                }catch(SQLException ex){
                    
                }
            }
        
    }
    
    
    
}
