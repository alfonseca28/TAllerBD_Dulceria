/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.SqlCliente;
import Vistas.FormularioCliente;
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
public class ControladorFormularioCliente implements ActionListener {

    private FormularioCliente vista;
    private Cliente cliente;

    private int vendedor;
    private String puesto_vendedor;

    public ControladorFormularioCliente(FormularioCliente vista, Cliente cliente) {
        this.vista = vista;
        this.cliente = cliente;

        vista.btnInsertarCliente.addActionListener(this);
        vista.btnBuscarCliente.addActionListener(this);
        vista.btnActualizarCliente.addActionListener(this);
        vista.btnEliminarCliente.addActionListener(this);
        vista.btnReactivarCliente.addActionListener(this);
        vista.btnLimpiarCliente.addActionListener(this);

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

        if (ae.getSource() == vista.btnInsertarCliente) {

            SqlCliente validacion = new SqlCliente();

            if (!"".equals(vista.txtNombreCliente.getText()) && !"".equals(vista.txtApPaternoCliente.getText())
                    && !"".equals(vista.txtApMaternoCliente.getText())
                    && !"".equals(vista.txtEmailCliente.getText()) && !"".equals(vista.txtTelefonoCliente.getText())
                    && validacion.validarCorreo(vista.txtEmailCliente.getText()) && validacion.validarFormato(vista.txtEmailCliente.getText())) {

                SqlCliente snt = new SqlCliente();

                cliente.setNombre(vista.txtNombreCliente.getText());
                cliente.setApellidoPaterno(vista.txtApPaternoCliente.getText());
                cliente.setApellidoMaterno(vista.txtApMaternoCliente.getText());
                cliente.setDireccion(vista.txtDireccionCliente.getText());
                cliente.setEmail(vista.txtEmailCliente.getText());
                cliente.setTelefono(vista.txtTelefonoCliente.getText());

                if (snt.insertarCliente(cliente)) {
                    JOptionPane.showMessageDialog(null, "Cliente insertado con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Rellene correctamente los campos para continuar", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        if (ae.getSource() == vista.btnActualizarCliente) {

            SqlCliente validacion = new SqlCliente();

            if (!"".equals(vista.txtIdCliente.getText()) && !"".equals(vista.txtNombreCliente.getText()) && !"".equals(vista.txtApPaternoCliente.getText())
                    && !"".equals(vista.txtApMaternoCliente.getText()) && !"".equals(vista.txtDireccionCliente.getText())
                    && !"".equals(vista.txtEmailCliente.getText()) && !"".equals(vista.txtTelefonoCliente.getText())
                    && validacion.validarCorreoActualizar(vista.txtEmailCliente.getText(), Integer.parseInt(vista.txtIdCliente.getText()))
                    && validacion.validarFormato(vista.txtEmailCliente.getText())) {

                SqlCliente snt = new SqlCliente();

                cliente.setIdCliente(Integer.parseInt(vista.txtIdCliente.getText()));
                cliente.setNombre(vista.txtNombreCliente.getText());
                cliente.setApellidoPaterno(vista.txtApPaternoCliente.getText());
                cliente.setApellidoMaterno(vista.txtApMaternoCliente.getText());
                cliente.setDireccion(vista.txtDireccionCliente.getText());
                cliente.setEmail(vista.txtEmailCliente.getText());
                cliente.setTelefono(vista.txtTelefonoCliente.getText());

                if (snt.actualizarCliente(cliente)) {
                    JOptionPane.showMessageDialog(null, "Registro actualizado con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Rellene correctamente los campos para continuar", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        if (ae.getSource() == vista.btnEliminarCliente) {

            if (!vista.txtIdCliente.equals("")) {

                if (JOptionPane.showConfirmDialog(null, "¿Estas seguro?", "Mensaje", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                    cliente.setIdCliente(Integer.parseInt(vista.txtIdCliente.getText()));
                    SqlCliente snt = new SqlCliente();
                    if (snt.bajaCliente(cliente)) {

                        JOptionPane.showMessageDialog(null, "Cliente dado de baja", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

                    } else {

                        JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);

                    }
                }
            } else {

                JOptionPane.showMessageDialog(null, "Ingrese el Id para continuar", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        if (ae.getSource() == vista.btnReactivarCliente) {

            if (!vista.txtIdCliente.equals("")) {

                if (JOptionPane.showConfirmDialog(null, "¿Estas seguro?", "Mensaje", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                    cliente.setIdCliente(Integer.parseInt(vista.txtIdCliente.getText()));
                    SqlCliente snt = new SqlCliente();
                    if (snt.reactivarCliente(cliente)) {

                        JOptionPane.showMessageDialog(null, "Cliente reactivado con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

                    } else {

                        JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);

                    }
                }
            } else {

                JOptionPane.showMessageDialog(null, "Ingrese el Id para continuar", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        if (ae.getSource() == vista.btnBuscarCliente) {

            if (!vista.txtIdCliente.equals("")) {
                SqlCliente snt = new SqlCliente();

                cliente = snt.buscarCliente(Integer.parseInt(vista.txtIdCliente.getText()));

                if (cliente != null) {

                    vista.txtNombreCliente.setText(cliente.getNombre());
                    vista.txtApPaternoCliente.setText(cliente.getApellidoPaterno());
                    vista.txtApMaternoCliente.setText(cliente.getApellidoMaterno());
                    vista.txtDireccionCliente.setText(cliente.getDireccion());
                    vista.txtTelefonoCliente.setText(cliente.getTelefono());
                    vista.txtEmailCliente.setText(cliente.getEmail());

                } else {
                    JOptionPane.showMessageDialog(null, "Cliente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese el Id para continuar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (ae.getSource() == vista.btnLimpiarCliente) {

            vista.txtIdCliente.setText("");
            vista.txtNombreCliente.setText("");
            vista.txtApPaternoCliente.setText("");
            vista.txtApMaternoCliente.setText("");
            vista.txtDireccionCliente.setText("");
            vista.txtTelefonoCliente.setText("");
            vista.txtEmailCliente.setText("");

            SqlCliente snt = new SqlCliente();

            cliente = snt.limpiar(cliente);

        }

    }

}
