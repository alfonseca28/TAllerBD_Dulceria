/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Erick Gonzalez
 */
public class SqlProveedor extends Conexion {

    public boolean insertarProveedor(Proveedor proveedor) {

        CallableStatement ps = null;

        Connection conexion = getconnection();

        try {

            ps = conexion.prepareCall("{CALL altaProveedor (?,?,?,?)}");
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getTelefono());
            ps.setString(3, proveedor.getDireccion());
            ps.setString(4, proveedor.getEmail());

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

    public boolean bajaProveedor(Proveedor proveedor) {

        CallableStatement cs = null;

        Connection conexion = getconnection();

        try {

            cs = conexion.prepareCall("{CALL bajaProveedor (?)}");
            cs.setInt(1, proveedor.getIdProveedor());

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

    public boolean actualizarProveedor(Proveedor proveedor) {

        CallableStatement cs = null;
        Connection conexion = getconnection();

        try {

            cs = conexion.prepareCall("{CALL actualizarProveedor (?,?,?,?,?)}");
            cs.setInt(1, proveedor.getIdProveedor());
            cs.setString(2, proveedor.getNombre());
            cs.setString(3, proveedor.getTelefono());
            cs.setString(4, proveedor.getDireccion());
            cs.setString(5, proveedor.getEmail());

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

    public boolean reactivarProveedor(Proveedor proveedor) {

        CallableStatement cs = null;

        Connection conexion = getconnection();

        try {

            cs = conexion.prepareCall("{CALL reactivarProveedor (?)}");
            cs.setInt(1, proveedor.getIdProveedor());

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

    public Proveedor buscarProveedor(int id) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Proveedor proveedor = new Proveedor();
        Connection conexion = getconnection();

        try {

            ps = conexion.prepareStatement("select  nombre , apellidoPaterno, apellidoMaterno, telefono, direccion, email\n"
                    + "from proveedor where idProveedor =?");

            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {

                proveedor.setIdProveedor(id);
                proveedor.setNombre(rs.getString("nombre"));
                proveedor.setDireccion(rs.getString("direccion"));
                proveedor.setEmail(rs.getString("email"));
                proveedor.setTelefono(rs.getString("telefono"));

                return proveedor;

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

}
