/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Proveedor;
import Modelo.SqlProveedor;
import Vistas.FormularioProveedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Erick Gonzalez
 */
public class ControladorFormularioProveedor implements ActionListener {

    private FormularioProveedor vista;
    private Proveedor proveedor;

    private int vendedor;
    private String puesto_vendedor;

    public ControladorFormularioProveedor(FormularioProveedor vista, Proveedor proveedor) {
        this.vista = vista;
        this.proveedor = proveedor;

        vista.btnInsertarProveedor.addActionListener(this);
        vista.btnBuscarProveedor.addActionListener(this);
        vista.btnActualizarProveedor.addActionListener(this);
        vista.btnEliminarProveedor.addActionListener(this);
        vista.btnReactivarProveedor.addActionListener(this);
        vista.btnLimpiarProveedor.addActionListener(this);

    }

    public void iniciar(int vendedor, String puesto_vendedor) {

        this.vendedor = vendedor;
        this.puesto_vendedor = puesto_vendedor;

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorInicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ControladorInicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControladorInicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ControladorInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == vista.btnInsertarProveedor) {

            if (!"".equals(vista.txtNombreProveedor.getText()) && !"".equals(vista.txtTelefonoProveedor.getText())
                    && !"".equals(vista.txtEmailProveedor.getText()) && !"".equals(vista.txtTelefonoProveedor.getText())) {

                SqlProveedor snt = new SqlProveedor();

                proveedor.setNombre(vista.txtNombreProveedor.getText());
                proveedor.setDireccion(vista.txtDireccionProveedor.getText());
                proveedor.setEmail(vista.txtEmailProveedor.getText());
                proveedor.setTelefono(vista.txtTelefonoProveedor.getText());

                if (snt.insertarProveedor(proveedor)) {
                    JOptionPane.showMessageDialog(null, "Proveedor insertado con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        }

        if (ae.getSource() == vista.btnActualizarProveedor) {

            if (!"".equals(vista.txtNombreProveedor.getText()) && !"".equals(vista.txtDireccionProveedor.getText())
                    && !"".equals(vista.txtEmailProveedor.getText()) && !"".equals(vista.txtTelefonoProveedor.getText())) {

                SqlProveedor snt = new SqlProveedor();

                proveedor.setIdProveedor(Integer.parseInt(vista.txtIdProveedor.getText()));
                proveedor.setNombre(vista.txtNombreProveedor.getText());
                proveedor.setDireccion(vista.txtDireccionProveedor.getText());
                proveedor.setEmail(vista.txtEmailProveedor.getText());
                proveedor.setTelefono(vista.txtTelefonoProveedor.getText());

                if (snt.actualizarProveedor(proveedor)) {
                    JOptionPane.showMessageDialog(null, "Registro actualizado con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        }

        if (ae.getSource() == vista.btnEliminarProveedor) {

            if (!vista.txtIdProveedor.equals("")) {

                if (JOptionPane.showConfirmDialog(null, "¿Estas seguro?", "Mensaje", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                    proveedor.setIdProveedor(Integer.parseInt(vista.txtIdProveedor.getText()));
                    SqlProveedor snt = new SqlProveedor();
                    snt.bajaProveedor(proveedor);
                }
            } else {

                JOptionPane.showMessageDialog(null, "Ingrese el Id para continuar", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        if (ae.getSource() == vista.btnReactivarProveedor) {

            if (!vista.txtIdProveedor.equals("")) {

                if (JOptionPane.showConfirmDialog(null, "¿Estas seguro?", "Mensaje", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                    proveedor.setIdProveedor(Integer.parseInt(vista.txtIdProveedor.getText()));
                    SqlProveedor snt = new SqlProveedor();
                    snt.reactivarProveedor(proveedor);
                }
            } else {

                JOptionPane.showMessageDialog(null, "Ingrese el Id para continuar", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        if (ae.getSource() == vista.btnBuscarProveedor) {

            if (!vista.txtIdProveedor.equals("")) {
                SqlProveedor snt = new SqlProveedor();

                proveedor = snt.buscarProveedor(Integer.parseInt(vista.txtIdProveedor.getText()));

                if (proveedor != null) {

                    vista.txtNombreProveedor.setText(proveedor.getNombre());
                    vista.txtDireccionProveedor.setText(proveedor.getDireccion());
                    vista.txtTelefonoProveedor.setText(proveedor.getTelefono());
                    vista.txtEmailProveedor.setText(proveedor.getEmail());

                } else {
                    JOptionPane.showMessageDialog(null, "Proveedor no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese el Id para continuar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (ae.getSource() == vista.btnLimpiarProveedor) {

            vista.txtIdProveedor.setText("");
            vista.txtNombreProveedor.setText("");
            vista.txtDireccionProveedor.setText("");
            vista.txtTelefonoProveedor.setText("");
            vista.txtEmailProveedor.setText("");

        }

    }

}
