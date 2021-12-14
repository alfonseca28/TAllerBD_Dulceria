/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author Erick Gonzalez
 */
public class ReporteCompras extends Conexion {
    
      public  void reporte(int mes) {

        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Compras");
        Sheet sheet2 = book.createSheet("Egresos");

        try {
                        

            

            String[] cabecera = new String[]{"IdCompra", "Fecha", "Importe","Precio Unitario","Cantidad","Producto","Proveedor",
            "Nombre Empleado","ApPaterno","ApMaterno"};
            
            String[] cabecera2 = new String[]{"Total de gastos mensuales"};

            CellStyle headerStyle = book.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);

            Font font = book.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 12);
            headerStyle.setFont(font);

            Row filaEncabezados = sheet.createRow(9);
            
            Row filaEncabezados2 = sheet2.createRow(0);
            

            for (int i = 0; i < cabecera.length; i++) {
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i]);
            }
            
            
            for (int i = 0; i < cabecera2.length; i++) {
                Cell celdaEnzabezado = filaEncabezados2.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera2[i]);
            }
            
            

            
            PreparedStatement ps;
            ResultSet rs;
            Connection conexion = getconnection();

            int numFilaDatos = 10;
            int numFilaDatos2 = 1;

            CellStyle datosEstilo = book.createCellStyle();
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderRight(BorderStyle.THIN);
            datosEstilo.setBorderBottom(BorderStyle.THIN);

            ps = conexion.prepareStatement("SELECT idCompra as ID,\n" +
"Fecha,\n" +
"Importe,\n" +
"producto.precioCompra as PrecioUnitario,\n" +
"Cantidad,\n" +
"producto.nombre as Producto,\n" +
"proveedor.nombre as Proveedor,\n" +
"empleado.nombre as NombreEmpleado,\n" +
"empleado.apellidoPaterno as aPaterno,\n" +
"empleado.apellidoMaterno as aMaterno\n" +
"from compra\n" +
"inner join proveedor on compra.idProveedor = proveedor.idProveedor\n" +
"inner join producto on compra.idProducto = producto.idProducto\n" +
"inner join empleado on compra.idEmpleado = empleado.idEmpleado\n" +
"where  month(fecha) =?");
            
            ps.setInt(1, mes);
            rs = ps.executeQuery();

            int numCol = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                Row filaDatos = sheet.createRow(numFilaDatos);

                for (int a = 0; a < numCol; a++) {

                    Cell CeldaDatos = filaDatos.createCell(a);
                    CeldaDatos.setCellStyle(datosEstilo);

                    if (a == 1  ) {
                        CeldaDatos.setCellValue(rs.getDate(a + 1));
                    }
                    
                    if(a == 2 || a == 3){
                        
                        CeldaDatos.setCellValue(rs.getFloat(a + 1));
                        
                    }              
                    
                    if(a == 4){
                        
                        
                        CeldaDatos.setCellValue(rs.getInt(a + 1));
                    }
                    
                    else {
                        CeldaDatos.setCellValue(rs.getString(a + 1));
                    }
                }
               

                numFilaDatos++;

            }
            
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);
            sheet.autoSizeColumn(6);
            sheet.autoSizeColumn(7);
            sheet.autoSizeColumn(8);
            sheet.autoSizeColumn(9);
            sheet.autoSizeColumn(10);
            
            
            sheet.setZoom(150);
            
            
            ps = conexion.prepareStatement("select sum(importe) as TotalMensual from compra\n" +
"where month(fecha) = ?");
            
            ps.setInt(1, mes);
            
            rs = ps.executeQuery();
            int numCol2 = rs.getMetaData().getColumnCount();
            
            
            while (rs.next()) {
                Row filaDatos2 = sheet2.createRow(numFilaDatos2);

                for (int a = 0; a < numCol2; a++) {

                    Cell CeldaDatos = filaDatos2.createCell(a);
                    CeldaDatos.setCellStyle(datosEstilo);

                    if (a == 0 ) {
                        CeldaDatos.setCellValue(rs.getFloat(a + 1));
                    }
                    
                   
                }
               

                numFilaDatos2++;
                
                

            }
            
            sheet2.autoSizeColumn(0);
                sheet.setZoom(150);
            
            
            
            
            

            FileOutputStream fileOut = new FileOutputStream("ReporteCompras.xlsx");
            book.write(fileOut);
            fileOut.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReporteProductos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReporteProductos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReporteProductos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
