/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

/**
 *
 * @author Erick Gonzalez
 */
public class SqlCompra extends Conexion{
    
    
    private int idCompra;
    private String fecha;
    private String hora;
    private float precio;
    private int cantidad;
    private int idEmpleado;
    private int idProducto;
    private int idProveedor;

    public SqlCompra() {
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
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

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    
    
    public boolean insertarVenta(){
        
        Connection conexion = getconnection();
        CallableStatement ps = null;        
        
        try{
            
            ps = conexion.prepareCall("{CALL compraProducto(?,?,?,?,?,?,?)}");
            
            ps.setDate(1, Date.valueOf((fecha)));
            ps.setTime(2, Time.valueOf((hora)));
            ps.setFloat(3, precio);
            ps.setInt(4, cantidad);
            ps.setInt(5, idEmpleado);
            ps.setInt(6, idProducto);
            ps.setInt(7, idProveedor);
            
            ps.execute();
            
            return true;
            
            
       

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
