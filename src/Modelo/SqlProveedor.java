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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
            ps.setString(3, proveedor.getTelefono());
            ps.setString(2, proveedor.getDireccion());
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

            JOptionPane.showMessageDialog(null, "Proveedor dado de baja", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Favor de cambiar el proveedor a los productos, ya que de lo contrario no se podran adquirir más productos", "Mensaje", JOptionPane.WARNING_MESSAGE);

            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
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
            cs.setString(4, proveedor.getTelefono());
            cs.setString(3, proveedor.getDireccion());
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

            JOptionPane.showMessageDialog(null, "Proveedor reactivado con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
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

            ps = conexion.prepareStatement("select  nombre , telefono, direccion, email\n"
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

    public boolean comprobarEstado(int id) {

        PreparedStatement ps = null;
        ResultSet rs = null;

        Connection conexion = getconnection();

        try {

            ps = conexion.prepareStatement("Select estado from proveedor where idProveedor = ?");
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {

                if (rs.getInt("estado") == 0) {
                    JOptionPane.showMessageDialog(null, "Proveedor no activo", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                } else {
                    return true;
                }

            }

            return false;

        } catch (Exception ex) {
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(SqlEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public boolean validarTodo(String correo, String direccion, String telefono, String nombre) {

        PreparedStatement ps = null;
        ResultSet rs = null;

        Connection conexion = getconnection();

        try {

            ps = conexion.prepareStatement("Select email from proveedor where email = ?");
            ps.setString(1, correo);

            rs = ps.executeQuery();

            if (rs.next()) {

                JOptionPane.showMessageDialog(null, "El correo ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                return false;

            } else {

                ps = conexion.prepareStatement("Select direccion from proveedor where direccion = ?");
                ps.setString(1, direccion);

                rs = ps.executeQuery();

                if (rs.next()) {

                    JOptionPane.showMessageDialog(null, "La direccion ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;

                } else {

                    ps = conexion.prepareStatement("Select telefono from proveedor where telefono = ?");
                    ps.setString(1, telefono);

                    rs = ps.executeQuery();

                    if (rs.next()) {

                        JOptionPane.showMessageDialog(null, "El telefono ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                        return false;

                    } else {
                        ps = conexion.prepareStatement("Select nombre from proveedor where nombre = ?");
                        ps.setString(1, nombre);

                        rs = ps.executeQuery();

                        if (rs.next()) {

                            JOptionPane.showMessageDialog(null, "El nombre ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                            return false;

                        } else {
                            return true;
                        }
                    }

                }

            }

        } catch (SQLException ex) {
            return false;

        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                return false;

            }
        }
    }

    public boolean validarTodoActualizar(int id, String correo, String direccion, String telefono, String nombre) {

        PreparedStatement ps = null;
        ResultSet rs = null;

        Connection conexion = getconnection();

        try {

            ps = conexion.prepareStatement("Select email from proveedor where email = ? AND idProveedor != ?");
            ps.setString(1, correo);
            ps.setInt(2, id);

            rs = ps.executeQuery();

            if (rs.next()) {

                JOptionPane.showMessageDialog(null, "El correo ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                return false;

            } else {

                ps = conexion.prepareStatement("Select direccion from proveedor where direccion = ? AND idProveedor != ?");
                ps.setString(1, direccion);
                ps.setInt(2, id);

                rs = ps.executeQuery();

                if (rs.next()) {

                    JOptionPane.showMessageDialog(null, "La direccion ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;

                } else {

                    ps = conexion.prepareStatement("Select telefono from proveedor where telefono = ? AND idProveedor !=?");
                    ps.setString(1, telefono);
                    ps.setInt(2, id);

                    rs = ps.executeQuery();

                    if (rs.next()) {

                        JOptionPane.showMessageDialog(null, "El telefono ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                        return false;

                    } else {
                        ps = conexion.prepareStatement("Select nombre from proveedor where nombre = ? AND idProveedor !=?");
                        ps.setString(1, nombre);
                        ps.setInt(2, id);

                        rs = ps.executeQuery();

                        if (rs.next()) {

                            JOptionPane.showMessageDialog(null, "El nombre ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                            return false;

                        } else {
                            return true;
                        }
                    }

                }

            }

        } catch (SQLException ex) {
            return false;

        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                return false;

            }
        }
    }

    public boolean validarFormato(String correo) {

        if (correo.contains("@")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "El correo no tiene un formato aceptado ", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    public Proveedor limpiar(Proveedor proveedor) {

        proveedor.setDireccion("");
        proveedor.setEmail("");
        proveedor.setIdProveedor(0);
        proveedor.setNombre("");
        proveedor.setTelefono("");

        return proveedor;

    }

}
