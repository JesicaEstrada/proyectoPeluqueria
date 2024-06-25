/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoData;

import entidades.Empleado;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesica
 */
public class EmpleadoData {
    private Connection con = null;

    public EmpleadoData() {
        con = Conexion.getConexion();
    }
    public void cargarEmpleado(Empleado empleado){
        String sql = "INSERT INTO empleado(dni,nombre, apellido, telefono, email, cargo, estado)"
                + "VALUES (?,?,?,?,?,?,?)";

        try {
            /*Este método de la conexión (con) crea un objeto PreparedStatement para enviar parámetros a la base de datos.*/
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, empleado.getDni_empleado());
            ps.setString(2, empleado.getNombre_empleado());
            ps.setString(3, empleado.getApellido_empleado());
            ps.setInt(4, empleado.getTelefono_empleado());
            ps.setString(5, empleado.getCorreo_empleado());
            ps.setString(6, empleado.getCargo_empleado());
            ps.setBoolean(7, empleado.isEstado_empleado());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                empleado.setId_empleado(rs.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Empleado agregado con exito!!!");
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla empleado");
//            Logger.getLogger(SocioData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void bajaEmpleado(int id) {
        String sql = "UPDATE empleado SET estado=0 WHERE idEmpleado=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "Empleado dado de Baja ");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla empleado");
        }
    }
    public void altaEmpleado(int id){
        String sql = "UPDATE empleado SET estado=1 WHERE idEmpleado=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "Empleado dado de Baja ");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla empleado");
        }
    }
    
    public void modificarEmpleado(Empleado empleado) {

        String sql = "UPDATE cliente SET dni=?,nombre=?,apellido=?,telefono=?,email=?,cargo=?,estado=? "
                + "WHERE idEmpleado = ?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);
                
            ps.setInt(1, empleado.getDni_empleado());
            ps.setString(2, empleado.getNombre_empleado());
            ps.setString(3, empleado.getApellido_empleado());
            ps.setInt(4, empleado.getTelefono_empleado());
            ps.setString(5, empleado.getCorreo_empleado());
            ps.setString(6, empleado.getCargo_empleado());
            ps.setBoolean(7, empleado.isEstado_empleado());

            int resultado = ps.executeUpdate();
            if (resultado > 0) {

                JOptionPane.showMessageDialog(null, "Empleado modificado.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla empleado. " + e);
        }
    }

    public Empleado buscarEmpleadoDNI(int dni_empleado) {
        String sql = "SELECT idEmpleado,dni , nombre, apellido, telefono, email, cargo, estado FROM empleado"
                + "WHERE dni= ?";
        Empleado empleado = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, dni_empleado);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                empleado = new Empleado();
                empleado.setId_empleado(rs.getInt("idEmpleado"));
                empleado.setDni_empleado(rs.getInt("dni"));
                empleado.setNombre_empleado(rs.getString("nombre"));
                empleado.setApellido_empleado(rs.getString("apellido"));           
                empleado.setTelefono_empleado(rs.getInt("telefono"));
                empleado.setCorreo_empleado(rs.getString("email"));
                empleado.setCargo_empleado(rs.getString("cargo"));                
                empleado.setEstado_empleado(rs.getBoolean("estado"));
                
            }
        } catch (SQLException ex) {
//            Logger.getLogger(SocioData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla empleado");

        }
        return empleado;
    }
    
    public ArrayList<Empleado> ListabuscarEmpleadoXNombre(String nombre) {
        ArrayList<Empleado> empleados = new ArrayList<>();
        Empleado empleado = null;
        String sql = "SELECT idEmpleado, dni, nombre, apellido,telefono, email, cargo, estado"
                + " FROM empleado"
                + " WHERE nombre like LOWER(?)";
    
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%"+nombre.toLowerCase()+"%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Empleados(es) encontrado(s) con exito!!!");
                do {
                    empleado = new Empleado();
                    empleado.setId_empleado(rs.getInt("idEmpleado"));
                    empleado.setDni_empleado(rs.getInt("dni"));
                    empleado.setNombre_empleado(rs.getString("nombre"));
                    empleado.setApellido_empleado(rs.getString("apellido"));           
                    empleado.setTelefono_empleado(rs.getInt("telefono"));
                    empleado.setCorreo_empleado(rs.getString("email"));
                    empleado.setCargo_empleado(rs.getString("cargo"));                
                    empleado.setEstado_empleado(true);
                    
                    empleados.add(empleado);
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(null, "No existe ningun empleado con ese nombre");
            }
        } catch (SQLException ex) {
//            Logger.getLogger(EntrenadorData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla empleado");
        }
        return empleados;
    }
    
    public List<Empleado> listarEmpleadosActivos() {
        ArrayList<Empleado> empleados = new ArrayList<>();
       String sql = "SELECT idEmpleado, dni, nombre, apellido,telefono, mail, cargo, estado FROM empleado"
                + " WHERE estado=1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Empleado empleado = new Empleado();
                
                empleado.setId_empleado(rs.getInt("idEmpleado"));
                empleado.setDni_empleado(rs.getInt("dni"));
                empleado.setNombre_empleado(rs.getString("nombre"));
                empleado.setApellido_empleado(rs.getString("apellido"));           
                empleado.setTelefono_empleado(rs.getInt("telefono"));
                empleado.setCorreo_empleado(rs.getString("mail"));
                empleado.setCargo_empleado(rs.getString("cargo"));                
                empleado.setEstado_empleado(true);
                
                empleados.add(empleado);
            }
        } catch (SQLException ex) {
//            Logger.getLogger(SocioData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla empleado");
        }
        return empleados;
    }
    public List<Empleado> listarClientesInactivos() {
        ArrayList<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT idEmpleado, dni, nombre, apellido,telefono, email, cargo, estado FROM empleado"
                + " WHERE estado=0";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Empleado empleado = new Empleado();
                
                empleado.setId_empleado(rs.getInt("idEmpleado"));
                empleado.setDni_empleado(rs.getInt("dni"));
                empleado.setNombre_empleado(rs.getString("nombre"));
                empleado.setApellido_empleado(rs.getString("apellido"));           
                empleado.setTelefono_empleado(rs.getInt("telefono"));
                empleado.setCorreo_empleado(rs.getString("email"));
                empleado.setCargo_empleado(rs.getString("cargo"));                
                empleado.setEstado_empleado(true);
                
                empleados.add(empleado);
            }
        } catch (SQLException ex) {
//            Logger.getLogger(SocioData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla empleado");
        }
        return empleados;
        
    }
    
    
}
