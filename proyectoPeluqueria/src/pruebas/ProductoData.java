/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import entidades.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario1
 */
public class ProductoData {
    
    private Connection con = null;

    public ProductoData() {
         con = Conexion.getConexion();
    }
    public void cargarProduco(Producto producto) {
        String sql = "INSERT INTO producto (nombre, descrpcion, precio, stock, estado) "
                + "VALUES (?,?,?,?,?)";

        try {
            /*Este método de la conexión (con) crea un objeto PreparedStatement para enviar parámetros a la base de datos.*/
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,producto.getNombre_producto());
            ps.setString(2,producto.getDescripcion_producto());
            ps.setDouble(3, producto.getPrecio_producto());
            ps.setInt(4, producto.getStock_producto());
            ps.setBoolean(5, producto.isEstado_producto());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                producto.setId_Producto(rs.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "producto agregado con exito!!!");
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla producto");
//            Logger.getLogger(SocioData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Producto> listarProductosActivos() {
        ArrayList<Producto> productos = new ArrayList<>();
        String sql = "SELECT idProducto, nombre, descrpcion, precio, stock, estado"
                + " FROM producto WHERE estado=1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();                
                producto.setId_Producto(rs.getInt("idProducto"));                
                producto.setNombre_producto(rs.getString("nombre"));
                producto.setDescripcion_producto(rs.getString("descripcion"));
                producto.setPrecio_producto(rs.getDouble("precio"));
                producto.setStock_producto(rs.getInt("stock"));
                producto.setEstado_producto(true);

                productos.add(producto);
            }
        } catch (SQLException ex) {
//            Logger.getLogger(SocioData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla producto");
        }
        return productos;
    }
    
    public List<Producto> listarProductosActivosXNombre(String nombre) {
        ArrayList<Producto> productos = new ArrayList<>();
        
        String sql = "SELECT idProducto, nombre, descrpcion, precio, stock, estado FROM producto "
                + "WHERE LOWER(nombre) like LOWER(?)";
        Producto producto = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + nombre.toLowerCase() + "%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
//                JOptionPane.showMessageDialog(null, "Socio(s) encontrado(s) con exito!!!");

                do {
                    producto = new Producto();                
                    producto.setId_Producto(rs.getInt("idProducto"));                
                    producto.setNombre_producto(rs.getString("nombre"));
                    producto.setDescripcion_producto(rs.getString("descripcion"));
                    producto.setPrecio_producto(rs.getDouble("precio"));
                    producto.setStock_producto(rs.getInt("stock"));
                    producto.setEstado_producto(true);

                    productos.add(producto);
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(null, "No existe ningun producto con ese nombre");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla Socio");
//            Logger.getLogger(SocioData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productos;
    }
    
}
