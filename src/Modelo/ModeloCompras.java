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
 * @author Erick Gonzalez, Damian Cazarin & Aaron Alfonseca
 */
public class ModeloCompras extends Conexion {

    Producto producto = new Producto();
    Proveedor proveedor = new Proveedor();
    int cantidad;


    public boolean Buscar(int id) {

        Connection conexion = getconnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {


            ps = conexion.prepareStatement("select * from producto where idProducto=? ");
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {


                producto.setIdProducto(id);
                producto.setIdProveedor(Integer.parseInt(rs.getString("idProveedor")));
                BuscarProveedor((producto.getIdProveedor()));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecioCompra(rs.getFloat("precioCompra"));


                return true;

            } else {
                return false;
            }

        } catch (SQLException ex) {
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ModeloVentas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public boolean BuscarProveedor(int id) {

        Connection conexion = getconnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            ps = conexion.prepareStatement("select nombre from Proveedor where IdProveedor=?");
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {

                proveedor.setIdProveedor(id);
                proveedor.setNombre(rs.getString("nombre"));


                return true;

            } else {
                return false;
            }

        } catch (SQLException ex) {
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ModeloVentas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    public String enviarNombreProveedor() {
        return proveedor.getNombre();
    }

    public String enviarNombre() {
        return producto.getNombre();
    }

    public void limpiar() {
        producto.setIdProducto(0);
        producto.setNombre("");
        producto.setPrecioCompra(0);
    }

    public int enviarId() {
        return producto.getIdProducto();
    }

    public float enviarPrecio() {
        return producto.getPrecioCompra();
    }


    public void limpiarProveedor() {

        proveedor.setIdProveedor(0);
        proveedor.setNombre("");


    }

    public int enviarIdProveedor() {
        return proveedor.getIdProveedor();
    }


}