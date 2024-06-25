/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoData;

import entidades.Servicio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesica
 */
public class ServicioData {
    private Connection con = null;

    public ServicioData() {
        con = Conexion.getConexion();
    }
//    private int id_servicio;
//    private String nombre_servicio;
//    private int duracion_servicio;
//    private double precio_servicio;
//    private String descripcion_servicio;
//    private boolean estado_servicio;
    public void cargarServicio(Servicio servicio){
        String sql="INSERT INTO servicio(nombre, duracion, precio, descripcion, estado) VALUES (?,?,?,?,?)";
        try {
            /*Este método de la conexión (con) crea un objeto PreparedStatement para enviar parámetros a la base de datos.*/
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, servicio.getNombre_servicio());
            ps.setInt(2, servicio.getDuracion_servicio());
            ps.setDouble(3, servicio.getPrecio_servicio());
            ps.setString(4,servicio.getDescripcion_servicio());
            ps.setBoolean(5, servicio.isEstado_servicio());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                servicio.setId_servicio(rs.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Servicio agregado con exito!!!");
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla servicio");
//            Logger.getLogger(SocioData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Servicio> ListabuscarServicioXNombre(String nombre) {
        ArrayList<Servicio> servicios = new ArrayList<>();

        Servicio servicio = null;
        String sql = "SELECT idServicio, nombre, duracion, precio, descripcion, estado FROM servicio"
                + "WHERE nombre LIKE LOWER(?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + nombre.toLowerCase() + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                servicio = new Servicio();
                servicio.setId_servicio(rs.getInt("idServicio"));
                servicio.setNombre_servicio(rs.getString("nombre"));
                servicio.setDuracion_servicio(rs.getInt("duracion"));
                servicio.setPrecio_servicio(rs.getDouble("precio"));
                servicio.setDescripcion_servicio(rs.getString("descripcion"));
                servicio.setEstado_servicio(true);
                servicios.add(servicio);
            }
        } catch (SQLException ex) {
//            Logger.getLogger(ClaseData.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error al acceder a la tabla de servicios");
        }
        return servicios;
    }
     public List<Servicio> listarServiciosActivos() {
        ArrayList<Servicio> servicios = new ArrayList<>();
        String sql = "SELECT idServicio, nombre, duracion, precio, descripcion, estado "
                + " FROM servicio WHERE estado=1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Servicio servicio = new Servicio();                
                servicio.setId_servicio(rs.getInt("idServicio"));
                servicio.setNombre_servicio(rs.getString("nombre"));
                servicio.setDuracion_servicio(rs.getInt("duracion"));
                servicio.setPrecio_servicio(rs.getDouble("precio"));
                servicio.setDescripcion_servicio(rs.getString("descripcion"));
                servicio.setEstado_servicio(true);

                servicios.add(servicio);
            }
        } catch (SQLException ex) {
//            Logger.getLogger(SocioData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla servicios");
        }
        return servicios;
    }
     
}
