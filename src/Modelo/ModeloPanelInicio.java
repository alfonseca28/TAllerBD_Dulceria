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
 * @author Erick Gonzalez, Damian Cazarin & Aaron Alfonseca
 */
public class ModeloPanelInicio extends Conexion {


    public boolean CambiarContraseña(int id) {

        String contraseña = "";
        String contraseñaNueva = "";
        String confirmarContraseña = "";
        int bandera = 0;
        int bandera2 = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Connection conexion = getconnection();

        try {

            while (bandera < 1) {


                ps = conexion.prepareStatement("select contraseña from empleado where idEmpleado=?");
                ps.setInt(1, id);

                rs = ps.executeQuery();

                if (rs.next()) {


                    contraseña = JOptionPane.showInputDialog(null, "Ingresa tu contraseña actual", "Cambiar Contraseña", JOptionPane.INFORMATION_MESSAGE);
                    if (contraseña == null) return false;

                    if (contraseña.equals(rs.getString("contraseña"))) {

                        bandera = 1;

                        while (bandera2 < 1) {


                            contraseñaNueva = JOptionPane.showInputDialog(null, "Ingresa tu nueva contraseña", "Cambiar Contraseña", JOptionPane.INFORMATION_MESSAGE);
                            if (contraseñaNueva == null) return false;
                            confirmarContraseña = JOptionPane.showInputDialog(null, "Confirma tu contraseña", "Cambiar contraseña", JOptionPane.INFORMATION_MESSAGE);
                            if (confirmarContraseña == null) return false;
                            if (contraseñaNueva.equals(confirmarContraseña) && !"".equals(contraseñaNueva)) {
                                bandera2 = 1;

                                ps = conexion.prepareStatement("update empleado set contraseña=? where IdEmpleado=?");
                                ps.setString(1, contraseñaNueva);
                                ps.setInt(2, id);


                                int resultado = ps.executeUpdate();

                                if (resultado > 0) {
                                    JOptionPane.showMessageDialog(null, "Contraseña Cambiada", "Cambiar Contraseña", JOptionPane.INFORMATION_MESSAGE);
                                    return true;
                                } else {
                                    return false;
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        } catch (SQLException ex) {
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ModeloPanelInicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


        return false;
    }

}
