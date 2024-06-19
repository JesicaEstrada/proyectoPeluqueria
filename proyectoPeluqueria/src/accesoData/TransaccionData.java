/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoData;


import entidades.Cliente;
import entidades.Transaccion;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
            JOptionPane.showMessageDialog(null, "transaccion realizada!!!");
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla transaccion");
//            Logger.getLogger(SocioData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void cancelarTransaccion(int idCliente, LocalDate fecha){
        String sql = "UPDATE transaccion" 
                +"SET estado = 0" +
                "WHERE idCliente = ? AND fecha = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCliente);
            ps.setDate(2,Date.valueOf(fecha));
            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "transaccion cancelada ");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla transaccion");
        }
    }
    public List<Transaccion> listarTransaccionesXCliente(int idCliente) {
        ArrayList<Transaccion> transacciones = new ArrayList<>();
        String sql = "SELECT `idTransaccion`, `idCliente`, `fecha`, `total`, `estado` FROM `transaccion` WHERE idCliente=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Transaccion transaccion= new Transaccion();
                                
                transaccion.setId_transaccion(rs.getInt("idTransaccion"));
                transaccion.setId_transaccion(rs.getInt("idCliente"));          
                transaccion.setFecha_transaccion(rs.getDate("fecha").toLocalDate());               
                transaccion.setTotal_transaccion(rs.getInt("total"));                              
                transaccion.setEstado_transaccion(true);
                transacciones.add(transaccion);
            }
        } catch (SQLException ex) {
//            Logger.getLogger(SocioData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla transaccion");
        }
        return transacciones;
    }
}
