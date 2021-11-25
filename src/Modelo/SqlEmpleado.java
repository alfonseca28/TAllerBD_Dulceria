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
public class SqlEmpleado extends Conexion {


    
    
        public boolean insertarEmpleado(Empleado empleado){

            PreparedStatement ps = null;

            Connection conexion = getconnection();
            
            try{
                
                ps = conexion.prepareStatement("insert into empleado(nombre,apellidoPaterno,apellidoMaterno,telefono"
                        + "direccion,email,puesto,edad,contraseña) values(?,?,?,?,?,?,?,?,?)");
                ps.setString(1, empleado.getNombre());
                ps.setString(2, empleado.getApellidoPaterno());
                ps.setString(3, empleado.getApellidoMaterno());
                ps.setString(4, empleado.getTelefono());
                ps.setString(5, empleado.getDireccion());
                ps.setString(6, empleado.getEmail());
                ps.setString(7, empleado.getPuesto());
                ps.setInt(8, empleado.getEdad());
                ps.setString(9, empleado.getContraseña());


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
    
    
        
        
        
        
        public boolean IniciarSesion(Empleado empleado){


           PreparedStatement ps = null;
           ResultSet rs = null;

           
           Connection conexion = getconnection();
           
           try{ 

               ps = conexion.prepareStatement("select contraseña from empleado where idEmpleado=?");
               ps.setInt(1, empleado.getIdEmpleado());

               rs = ps.executeQuery();

               if(rs.next()){
                    
                   
                   if(empleado.getContraseña().equals(rs.getString("contraseña"))){

                

                       return true;
                   }

                   else{
                       JOptionPane.showMessageDialog(null, "Contraseña incorrecta","Error",JOptionPane.ERROR_MESSAGE);
                   }

               }

               else{
                   JOptionPane.showMessageDialog(null, "Usuario no encontrado","Error",JOptionPane.ERROR_MESSAGE);
               }


           }catch(Exception ex){
               return false;
           }finally{
               try{
                   conexion.close();
               }catch(SQLException ex){
                   return false;
               }
           }

            return false;   

       }
        
        
        
        public String obtenerPuesto(int id){
         
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            Connection conexion = getconnection();
            
            
            try{
                
                ps = conexion.prepareStatement("select puesto from  empleado where idEmpleado=?");
                ps.setInt(1, id);
                
                rs = ps.executeQuery();
                
                if(rs.next()){
                   
                    return rs.getString("puesto");
                }
                
            }catch(SQLException ex){
               return null; 
            }finally{
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SqlEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return null;
            
        }
        
        
        
        
        
    
}
