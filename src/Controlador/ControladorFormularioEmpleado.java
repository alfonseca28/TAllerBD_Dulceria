package Controlador;

import Modelo.Empleado;
import Modelo.SqlEmpleado;
import Vistas.FormularioEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.String.valueOf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ControladorFormularioEmpleado implements ActionListener {

    private FormularioEmpleado vista;
    private Empleado empleado;

    private int vendedor;
    private String puesto_vendedor;

    public ControladorFormularioEmpleado(FormularioEmpleado vista, Empleado empleado) {
        this.vista = vista;
        this.empleado = empleado;

        vista.btnInsertar.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        vista.btnActualizar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnReactivar.addActionListener(this);
        vista.btnLimpiar.addActionListener(this);
        

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

        if (ae.getSource() == vista.btnInsertar) {

            if (!"".equals(vista.txtNombre.getText()) && !"".equals(vista.txtApPaterno.getText())
                    && !"".equals(vista.txtApMaterno.getText()) && !"".equals(vista.txtDireccion.getText())
                    && !"".equals(vista.txtEmail.getText()) && !"".equals(vista.txtTelefono.getText())
                    && !"".equals(vista.txtEdad) && !"".equals(vista.txtContraseña.getPassword()) && (vista.btnGerente.isSelected() || vista.btnVendedor.isSelected())) {

                String spuesto = "";

                if (vista.btnVendedor.isSelected()) {
                    spuesto = "Vendedor";
                }

                if (vista.btnGerente.isSelected()) {
                    spuesto = "Gerente";
                }

                SqlEmpleado snt = new SqlEmpleado();

                String contra = String.valueOf(vista.txtContraseña.getPassword());

                empleado.setNombre(vista.txtNombre.getText());
                empleado.setApellidoPaterno(vista.txtApPaterno.getText());
                empleado.setApellidoPaterno(vista.txtApMaterno.getText());
                empleado.setDireccion(vista.txtDireccion.getText());
                empleado.setEmail(vista.txtEmail.getText());
                empleado.setTelefono(vista.txtTelefono.getText());
                empleado.setPuesto(spuesto);
                empleado.setEdad(Integer.parseInt(vista.txtEdad.getText()));
                empleado.setContraseña(contra);

                if (snt.insertarEmpleado(empleado)) {
                    JOptionPane.showMessageDialog(null, "Empleado insertado con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        }

        if (ae.getSource() == vista.btnActualizar) {

            if (!"".equals(vista.txtNombre.getText()) && !"".equals(vista.txtApPaterno.getText())
                    && !"".equals(vista.txtApMaterno.getText()) && !"".equals(vista.txtDireccion.getText())
                    && !"".equals(vista.txtEmail.getText()) && !"".equals(vista.txtTelefono.getText())
                    && !"".equals(vista.txtEdad) && !"".equals(vista.txtContraseña.getPassword()) && (vista.btnGerente.isSelected() || vista.btnVendedor.isSelected())) {

                String spuesto = "";

                if (vista.btnVendedor.isSelected()) {
                    spuesto = "Vendedor";
                }

                if (vista.btnGerente.isSelected()) {
                    spuesto = "Gerente";
                }

                SqlEmpleado snt = new SqlEmpleado();

                String contra = String.valueOf(vista.txtContraseña.getPassword());

                empleado.setNombre(vista.txtNombre.getText());
                empleado.setApellidoPaterno(vista.txtApPaterno.getText());
                empleado.setApellidoPaterno(vista.txtApMaterno.getText());
                empleado.setDireccion(vista.txtDireccion.getText());
                empleado.setEmail(vista.txtEmail.getText());
                empleado.setTelefono(vista.txtTelefono.getText());
                empleado.setPuesto(spuesto);
                empleado.setEdad(Integer.parseInt(vista.txtEdad.getText()));
                empleado.setContraseña(contra);

                if (snt.actualizarEmpleado(empleado)) {
                    JOptionPane.showMessageDialog(null, "Registro actualizado con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        }

        if (ae.getSource() == vista.btnEliminar) {

            if (!vista.txtIdEmpleado.equals("")) {

                if (JOptionPane.showConfirmDialog(null, "¿Estas seguro?", "Mensaje", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                    empleado.setIdEmpleado(Integer.parseInt(vista.txtIdEmpleado.getText()));
                    SqlEmpleado snt = new SqlEmpleado();
                    snt.bajaEmpleado(empleado);
                }
            } else {

                JOptionPane.showMessageDialog(null, "Ingrese el Id para continuar", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        if (ae.getSource() == vista.btnReactivar) {

            if (!vista.txtIdEmpleado.equals("")) {

                if (JOptionPane.showConfirmDialog(null, "¿Estas seguro?", "Mensaje", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                    empleado.setIdEmpleado(Integer.parseInt(vista.txtIdEmpleado.getText()));
                    SqlEmpleado snt = new SqlEmpleado();
                    snt.reactivarEmpleado(empleado);
                }
            } else {

                JOptionPane.showMessageDialog(null, "Ingrese el Id para continuar", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        if (ae.getSource() == vista.btnBuscar) {

            if (!vista.txtIdEmpleado.equals("")) {
                SqlEmpleado snt = new SqlEmpleado();

                empleado = snt.buscarEmpleado(Integer.parseInt(vista.txtIdEmpleado.getText()));

                if (empleado != null) {

                    vista.txtNombre.setText(empleado.getNombre());
                    vista.txtApPaterno.setText(empleado.getApellidoPaterno());
                    vista.txtApMaterno.setText(empleado.getApellidoMaterno());
                    vista.txtDireccion.setText(empleado.getDireccion());
                    vista.txtTelefono.setText(empleado.getTelefono());
                    vista.txtEmail.setText(empleado.getEmail());
                    vista.txtContraseña.setText(empleado.getContraseña());
                    vista.txtEdad.setText(valueOf(empleado.getEdad()));

                    String puesto = empleado.getPuesto();

                    if (empleado.getPuesto().equals("Gerente")) {

                        vista.btnGerente.setSelected(true);
                    } else {
                        vista.btnVendedor.setSelected(true);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Empleado no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese el Id para continuar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (ae.getSource() == vista.btnLimpiar) {

            vista.txtIdEmpleado.setText("");
            vista.txtNombre.setText("");
            vista.txtApPaterno.setText("");
            vista.txtApMaterno.setText("");
            vista.txtDireccion.setText("");
            vista.txtTelefono.setText("");
            vista.txtEmail.setText("");
            vista.txtContraseña.setText("");
            vista.txtEdad.setText("");

        }

    }

}
