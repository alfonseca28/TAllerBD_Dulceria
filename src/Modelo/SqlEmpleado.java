/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.*;
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

            CallableStatement ps = null;

            Connection conexion = getconnection();
            
            try{
                
                ps = conexion.prepareCall("{CALL altaEmpleado (?,?,?,?,?,?,?,?,?)}");
                ps.setString(1, empleado.getNombre());
                ps.setString(2, empleado.getApellidoPaterno());
                ps.setString(3, empleado.getApellidoMaterno());
                ps.setString(4, empleado.getTelefono());
                ps.setString(5, empleado.getDireccion());
                ps.setString(6, empleado.getEmail());
                ps.setString(7, empleado.getPuesto());
                ps.setInt(8, empleado.getEdad());
                ps.setString(9, empleado.getContraseña());


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
    
        public boolean bajaEmpleado(Empleado empleado){
            
            CallableStatement cs = null;

            Connection conexion = getconnection();
            
            try{
                
                cs = conexion.prepareCall("{CALL bajaEmpleado (?)}");
                cs.setInt(1, empleado.getIdEmpleado());
                
                cs.execute();
                
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
        
        
       public boolean actualizarEmpleado(Empleado empleado){
        
           CallableStatement cs = null;
           Connection conexion = getconnection();
           
           try{
                
                cs = conexion.prepareCall("{CALL actualizarEmpleado (?,?,?,?,?,?,?,?,?,?)}");
                cs.setInt(1, empleado.getIdEmpleado());
                cs.setString(2, empleado.getNombre());
                cs.setString(3,empleado.getApellidoPaterno());
                cs.setString(4,empleado.getApellidoMaterno());
                cs.setString(5,empleado.getTelefono());
                cs.setString(6,empleado.getDireccion());
                cs.setString(7,empleado.getEmail());
                cs.setString(8,empleado.getPuesto());
                cs.setInt(9,empleado.getEdad());
                cs.setString(10,empleado.getContraseña());
                
                cs.execute();
                
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
        
        public boolean reactivarEmpleado(Empleado empleado){
            
             CallableStatement cs = null;

            Connection conexion = getconnection();
            
            try{
                
                cs = conexion.prepareCall("{CALL reactivarEmpleado (?)}");
                cs.setInt(1, empleado.getIdEmpleado());
                
                cs.execute();
                
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
        
        
        public Empleado buscarEmpleado (int id){
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            Empleado empleado = new Empleado();
            Connection conexion = getconnection();
            
            try{
                
                ps = conexion.prepareStatement("select  nombre , apellidoPaterno, apellidoMaterno, telefono, direccion, email, puesto, edad, contraseña \n" +
"from empleado where idEmpleado =?");
                
                ps.setInt(1, id);
                
                rs = ps.executeQuery();
                
                if(rs.next()){
                    
                    empleado.setIdEmpleado(id);
                    empleado.setNombre(rs.getString("nombre"));
                    empleado.setApellidoPaterno(rs.getString("apellidoPaterno"));
                    empleado.setApellidoMaterno(rs.getString("apellidoMaterno"));
                    empleado.setDireccion(rs.getString("direccion"));
                    empleado.setEmail(rs.getString("email"));
                    empleado.setPuesto(rs.getString("puesto"));
                    empleado.setTelefono(rs.getString("telefono"));
                    empleado.setEdad(rs.getInt("edad"));
                    empleado.setContraseña(rs.getString("contraseña"));
                    
                    return empleado;
                    
                }
                
                
                else{
                    return null;
                }
                
               
                
                
            }catch(SQLException ex){
                return null;
            }finally{
                try{
                    conexion.close();
                }catch(SQLException ex){
                    
                }
            }
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

