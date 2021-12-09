/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {
    
    public  static final String URL = "jdbc:mysql://localhost:3306/dulceria?autoReconnet=true&useSSL=false";
    public static final String  usuario = "root";
    public static final String contraseña = "1234";
    
    public Connection getconnection(){
        
        Connection conexion =null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion= DriverManager.getConnection(URL,usuario,contraseña);
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos","Error",JOptionPane.ERROR_MESSAGE);
        }
        return conexion;
    }  
}
