/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoData;

import entidades.Cliente;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
/**
 *
 * @author Jesica
 */
public class ClienteData {
    private Connection con = null;

    public ClienteData() {
        con = Conexion.getConexion();
    }
    public void cargarCliente(Cliente cliente){
        String sql = "INSERT INTO `cliente`(dni,nombre, apellido, fechaNacimiento, telefono, email, direccion, estado)"
                + "VALUES (?,?,?,?,?,?,?,?)";

        try {
            /*Este método de la conexión (con) crea un objeto PreparedStatement para enviar parámetros a la base de datos.*/
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cliente.getDni_cliente());
            ps.setString(2, cliente.getNombre_cliente());
            ps.setString(3, cliente.getApellido_cliente());
            ps.setDate(4,Date.valueOf(cliente.getFechaNacimiento_cliente()));
            ps.setInt(5, cliente.getTelefono_cliente());
            ps.setString(6, cliente.getCorreo_cliente());
            ps.setString(7, cliente.getDireccion_cliente());
            ps.setBoolean(8, cliente.isEstado_cliente());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                cliente.setId_cliente(rs.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Cliente agregado con exito!!!");
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla cliente");
//            Logger.getLogger(SocioData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void bajaCliente(int id) {
        String sql = "UPDATE cliente SET estado=0 WHERE idCliente=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "Cliente dado de Baja ");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente");
        }
    }
    public void altaCliente(int id){
        String sql="UPDATE cliente SET estado=1 WHERE idCliente=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            int resultado=ps.executeUpdate();
            if(resultado == 1){
                JOptionPane.showMessageDialog(null,"Cliente dado de alta ");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla cliente");
        }
    }
    
    public void modificarCliente(Cliente cliente) {

        String sql = "UPDATE cliente SET dni=?,nombre=?,apellido=?,fechaNacimiento=?,telefono=?,email=?,direccion=?,estado=? "
                + "WHERE idCliente = ?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getDni_cliente());
            ps.setString(2, cliente.getNombre_cliente());
            ps.setString(3, cliente.getApellido_cliente());
            ps.setDate(4,Date.valueOf(cliente.getFechaNacimiento_cliente()));
            ps.setInt(5, cliente.getTelefono_cliente());
            ps.setString(6, cliente.getCorreo_cliente());
            ps.setString(7, cliente.getDireccion_cliente());
            ps.setBoolean(8, cliente.isEstado_cliente());

            int resultado = ps.executeUpdate();
            if (resultado > 0) {

                JOptionPane.showMessageDialog(null, "Cliente modificado.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente. " + e);
        }
    }

    public Cliente buscarClienteDNI(int dni_cliente) {
        String sql = "SELECT idCliente,dni , nombre, apellido, fechaNacimiento, telefono, email, direccion, estado FROM cliente "
                + "WHERE dni= ?";
        Cliente cliente = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            /*en la consulta SQL, reemplaza el primer signo de interrogación (?) con el valor de id_socio*/
            ps.setInt(1, dni_cliente);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                cliente = new Cliente();
                cliente.setId_cliente(rs.getInt("idCliente"));
                cliente.setDni_cliente(rs.getInt("dni"));
                cliente.setNombre_cliente(rs.getString("nombre"));
                cliente.setApellido_cliente(rs.getString("apellido"));            
                cliente.setFechaNacimiento_cliente(rs.getDate("fechaNacimiento").toLocalDate());               
                cliente.setTelefono_cliente(rs.getInt("telefono"));
                cliente.setCorreo_cliente(rs.getString("email"));
                cliente.setDireccion_cliente(rs.getString("direccion"));                
                cliente.setEstado_cliente(rs.getBoolean("estado"));
                
            }
        } catch (SQLException ex) {
//            Logger.getLogger(SocioData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla cliente");

        }
        return cliente;
    }
    
    
    public List<Cliente> listarClientesActivos() {
        ArrayList<Cliente> clientes = new ArrayList<>();
       String sql = "SELECT idCliente, dni, nombre, apellido, fechaNacimiento, telefono, email, direccion, estado FROM cliente"
                + " WHERE estado=1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                
                cliente.setId_cliente(rs.getInt("idCliente"));
                cliente.setDni_cliente(rs.getInt("dni"));
                cliente.setNombre_cliente(rs.getString("nombre"));
                cliente.setApellido_cliente(rs.getString("apellido"));            
                cliente.setFechaNacimiento_cliente(rs.getDate("fechaNacimiento").toLocalDate());               
                cliente.setTelefono_cliente(rs.getInt("telefono"));
                cliente.setCorreo_cliente(rs.getString("email"));
                cliente.setDireccion_cliente(rs.getString("direccion"));                
                cliente.setEstado_cliente(true);

                clientes.add(cliente);
            }
        } catch (SQLException ex) {
//            Logger.getLogger(SocioData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla Socio");
        }
        return clientes;
    }
    public List<Cliente> listarClientesInactivos() {
        ArrayList<Cliente> clientes = new ArrayList<>();
       String sql = "SELECT idCliente, dni, nombre, apellido, fechaNacimiento, telefono, email, direccion, estado FROM cliente"
                + " WHERE estado=0";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                
                cliente.setId_cliente(rs.getInt("idCliente"));
                cliente.setDni_cliente(rs.getInt("dni"));
                cliente.setNombre_cliente(rs.getString("nombre"));
                cliente.setApellido_cliente(rs.getString("apellido"));            
                cliente.setFechaNacimiento_cliente(rs.getDate("fechaNacimiento").toLocalDate());               
                cliente.setTelefono_cliente(rs.getInt("telefono"));
                cliente.setCorreo_cliente(rs.getString("email"));
                cliente.setDireccion_cliente(rs.getString("direccion"));                
                cliente.setEstado_cliente(false);

                clientes.add(cliente);
            }
        } catch (SQLException ex) {
//            Logger.getLogger(SocioData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla Socio");
        }
        return clientes;
    }
}
