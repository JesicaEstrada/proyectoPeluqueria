/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoData;

import entidades.Empleado;
import entidades.EmpleadoServicio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario1
 */
public class EmpleadoServicioData {
    private Connection con = null;

    public EmpleadoServicioData() {
        con = Conexion.getConexion();
    }
    public void CargarRelacion(EmpleadoServicio empleadoServicio){
        String sql="INSERT INTO `empleadoservicio`(`idEmpleado`, `idServicio`)  VALUES (?,?)";
        try {
            /*Este método de la conexión (con) crea un objeto PreparedStatement para enviar parámetros a la base de datos.*/
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, empleadoServicio.getEmpleado().getId_empleado());
            ps.setInt(2, empleadoServicio.getServicio().getId_servicio());
           

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "relacion agregada con exito!!!");
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla empleadoServicio");
//            Logger.getLogger(SocioData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Empleado> listarEmpleadosXServicios(int idServicio) {
        ArrayList<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT e.dni , e.nombre, e.apellido "
                + "FROM empleadoservicio AS es "
                + "JOIN empleado AS e ON es.idEmpleado = e.idEmpleado "
                + "JOIN servicio AS s ON es.idServicio = s.idServicio "
                + "WHERE es.idServicio=? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Empleado empleado = new Empleado();
                
                empleado.setDni_empleado(rs.getInt("e.dni"));
                empleado.setNombre_empleado("e.nombre");
                empleado.setApellido_empleado("e.apellido");
                
                empleados.add(empleado);
            }
        } catch (SQLException ex) {
//            Logger.getLogger(SocioData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla servicioEmpleado");
        }
        return empleados;
    }
}
