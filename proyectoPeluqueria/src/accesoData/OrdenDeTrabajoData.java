/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoData;

import entidades.OrdenTrabajo;
import entidades.Producto;
import entidades.Servicio;
import java.util.List;
import java.sql.*;
import java.time.LocalTime;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesica
 */
public class OrdenDeTrabajoData {
    private Connection con = null;

    public OrdenDeTrabajoData() {
        con = Conexion.getConexion();
    }

//    public void insertarOrdenTrabajo(OrdenTrabajo ordenTrabajo, List<Producto> productos, List<Servicio> servicios,Integer idGiftCard) throws SQLException {
//        String sqlOrdenTrabajo = "INSERT INTO ordentrabajo (idCliente, idEmpleado, fecha, hora,servicios,productos, duracionTotal, costoTotal, descuentoGiftCard, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//        String sqlDetalleProducto = "INSERT INTO Detalle_Orden_Producto (ID_Orden, ID_Producto) VALUES (?, ?)";
//        String sqlDetalleServicio = "INSERT INTO Detalle_Orden_Servicio (ID_Orden, ID_Servicio) VALUES (?, ?)";
//        String sqlTransaccion = "INSERT INTO Transacciones (ID_Cliente, Fecha, Total, Tipo, ID_Gift_Card) VALUES (?, ?, ?, ?, ?)";
//        GiftCardsData gcd = new GiftCardsData();
//        
//      // Calcular costo total y duración total
//        double costoTotal = Calculos.calcularCostoTotal(productos, servicios);
//        int duracionTotal = Calculos.calcularDuracionTotal(servicios);
//        double descuentoGiftCard = 0.0;
//        if (idGiftCard != null) {
//                // Verificar y actualizar el saldo de la gift card
//                gcd.actualizarValor(idGiftCard, costoTotal);
//                descuentoGiftCard = costoTotal;
//              
//            }
//         double costoFinal = costoTotal - descuentoGiftCard;  
//            // Insertar orden de trabajo
//        try(PreparedStatement psOrdenTrabajo = con.prepareStatement(sqlOrdenTrabajo, Statement.RETURN_GENERATED_KEYS)){
//            
//            psOrdenTrabajo.setInt(1, ordenTrabajo.getCliente().getId_cliente());
//            psOrdenTrabajo.setInt(2, ordenTrabajo.getEmpleado().getId_empleado());
//            psOrdenTrabajo.setDate(3, Date.valueOf(ordenTrabajo.getFecha_orden_trabajo()));
//            psOrdenTrabajo.setTime(4, Time.valueOf(ordenTrabajo.getHora_orden_trabajo()));
//            psOrdenTrabajo.setInt(5, duracionTotal);
//            psOrdenTrabajo.setDouble(6, costoTotal);
//            psOrdenTrabajo.setDouble(7, descuentoGiftCard);
//            psOrdenTrabajo.setBoolean(8, ordenTrabajo.isEstado_orden_trabajo());
//            psOrdenTrabajo.executeUpdate();
//            
//            ResultSet rsOrden = psOrdenTrabajo.getGeneratedKeys();
//
//            if (rsOrden.next()) {
//                ordenTrabajo.setId_orden_trabajo(rsOrden.getInt(1));
//                int idOrdenTrabajo = rsOrden.getInt(1);
//               //productos
//                try(PreparedStatement psDetalleProducto = con.prepareStatement(sqlDetalleProducto)){
//                    
//                    for (Producto producto : productos) {
//                        psDetalleProducto.setInt(1, idOrdenTrabajo);
//                        psDetalleProducto.setInt(2, producto.getId_Producto());
//                        psDetalleProducto.addBatch();
//                    }
//                    psDetalleProducto.executeBatch();
//                }
//                //servicios
//                try (PreparedStatement psDetalleServicio = con.prepareStatement(sqlDetalleServicio)) {
//                    for (Servicio servicio : servicios) {
//                        psDetalleServicio.setInt(1, idOrdenTrabajo);
//                        psDetalleServicio.setInt(2, servicio.getId_servicio());
//                        psDetalleServicio.addBatch();
//                    }
//                    psDetalleServicio.executeBatch();
//                }
//                
//                
//                try (PreparedStatement psTransaccion = con.prepareStatement(sqlTransaccion)) {
//                    
//                    psTransaccion.setInt(1, ordenTrabajo.getCliente().getId_cliente());
//                    psOrdenTrabajo.setDate(2, Date.valueOf(ordenTrabajo.getFecha_orden_trabajo()));
//                    psTransaccion.setDouble(3, costoFinal);
//                    psTransaccion.setString(4, "Compra de Productos y Servicios");
//                     if (idGiftCard != null) {
//                            psTransaccion.setInt(5, idGiftCard);
//                        } else {
//                            psTransaccion.setNull(5, java.sql.Types.INTEGER);
//                        }
//                    psTransaccion.executeUpdate();
//                }
//            }
//  
//          //ALI FINAL
////            JOptionPane.showMessageDialog(null, "transaccion realizada!!!");
////            ps.close(); 
//
//
//            con.commit();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            con.rollback();
//        }
//        
//    }
}
    
