/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import entidades.Cliente;
import entidades.Transaccion;
import java.sql.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario1
 */
public class TransaccionData {
//    private int id_transaccion;
//    private Cliente cliente;
//    private LocalDate fecha_transaccion;
//    private double total_transaccion;
//    private boolean estado_transaccion;
     private Connection con = null;

    public TransaccionData() {
        con = Conexion.getConexion();
    }
    public void cargarTransaccion(Transaccion transaccion){
        String sql = "INSERT INTO transaccion (idCliente,fecha,total,estado) "
                + "VALUES (?,?,?,?)";
        

        try {
            /*Este método de la conexión (con) crea un objeto PreparedStatement para enviar parámetros a la base de datos.*/
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, transaccion.getCliente().getId_cliente());
            ps.setDate(2, Date.valueOf(transaccion.getFecha_transaccion()));
            ps.setDouble(3, transaccion.getTotal_transaccion());
            ps.setBoolean(4, transaccion.isEstado_transaccion());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                transaccion.setId_transaccion(rs.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "transaccion agregada con exito!!!");
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla transaccion");
//            Logger.getLogger(SocioData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void cancelarTransaccion(int idCliente){
        String sql = "UPDATE transaccion SET estado=0 WHERE idTransaccion=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Socio eliminado ");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla socio");
        }
        
    }
}
