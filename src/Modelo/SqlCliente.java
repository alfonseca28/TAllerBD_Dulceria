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
import javax.swing.JOptionPane;

/**
 *
 * @author Erick Gonzalez
 */
public class SqlCliente extends Conexion{
    
       
        public boolean insertarCliente(Cliente cliente){

            CallableStatement ps = null;

            Connection conexion = getconnection();
            
            try{
                
                ps = conexion.prepareCall("{CALL altaCliente (?,?,?,?,?,?)}");
                ps.setString(1, cliente.getNombre());
                ps.setString(2, cliente.getApellidoPaterno());
                ps.setString(3, cliente.getApellidoMaterno());
                ps.setString(4, cliente.getTelefono());
                ps.setString(5, cliente.getDireccion());
                ps.setString(6, cliente.getEmail());                           


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
    
        public boolean bajaCliente(Cliente cliente){
            
            CallableStatement cs = null;

            Connection conexion = getconnection();
            
            try{
                
                cs = conexion.prepareCall("{CALL bajaCliente (?)}");
                cs.setInt(1, cliente.getIdCliente());
                
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
        
        
       public boolean actualizarCliente(Cliente cliente){
        
           CallableStatement cs = null;
           Connection conexion = getconnection();
           
           try{
                
                cs = conexion.prepareCall("{CALL actualizarCliente (?,?,?,?,?,?,?)}");
                cs.setInt(1, cliente.getIdCliente());
                cs.setString(2, cliente.getNombre());
                cs.setString(3,cliente.getApellidoPaterno());
                cs.setString(4,cliente.getApellidoMaterno());
                cs.setString(5,cliente.getTelefono());
                cs.setString(6,cliente.getDireccion());
                cs.setString(7,cliente.getEmail());
                
                
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
        
        
        
        public boolean reactivarCliente(Cliente cliente){
            
             CallableStatement cs = null;

            Connection conexion = getconnection();
            
            try{
                
                cs = conexion.prepareCall("{CALL reactivarCliente (?)}");
                cs.setInt(1, cliente.getIdCliente());
                
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
        
        
        public Cliente buscarCliente (int id){
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            Cliente cliente = new Cliente();
            Connection conexion = getconnection();
            
            try{
                
                ps = conexion.prepareStatement("select  nombre , apellidoPaterno, apellidoMaterno, telefono, direccion, email\n" +
"from cliente where idCliente =?");
                
                ps.setInt(1, id);
                
                rs = ps.executeQuery();
                
                if(rs.next()){
                    
                    cliente.setIdCliente(id);
                    cliente.setNombre(rs.getString("nombre"));
                    cliente.setApellidoPaterno(rs.getString("apellidoPaterno"));
                    cliente.setApellidoMaterno(rs.getString("apellidoMaterno"));
                    cliente.setDireccion(rs.getString("direccion"));
                    cliente.setEmail(rs.getString("email"));                    
                    cliente.setTelefono(rs.getString("telefono"));
                    
                    return cliente;
                    
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
        

    
    
    
}
