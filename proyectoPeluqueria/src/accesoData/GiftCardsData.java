/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoData;


import entidades.GiftCards;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author Usuario1
 */
public class GiftCardsData {
//    private int id_gift_cards;
//    private String codigo_gift_cards;
//    private double valor_gift_cards;
//    private double valorRestante_gift_cards=valor_gift_cards;
//    private LocalDate fechaExpiracion_gift_cards;
//    private boolean estado_gift_cards;
    private Connection con = null;

    public GiftCardsData() {
        con = Conexion.getConexion();
    }
    public void cargarGiftCard(GiftCards gifCards){
        String sql="INSERT INTO `giftcards`(codigo,valor,valorRestante,fechaExpiracion,estado)  VALUES (?,?,?,?,?)";
        try {
            /*Este método de la conexión (con) crea un objeto PreparedStatement para enviar parámetros a la base de datos.*/
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, gifCards.getCodigo_gift_cards());
            ps.setDouble(2, gifCards.getValor_gift_cards());
            ps.setDouble(3, gifCards.getValorRestante_gift_cards());
            ps.setDate(2, Date.valueOf(gifCards.getFechaExpiracion_gift_cards()));
            ps.setBoolean(5, gifCards.isEstado_gift_cards());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                gifCards.setId_gift_cards(rs.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "GiftCards agregada con exito!!!");
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla gifCards");
//            Logger.getLogger(SocioData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void bajaGiftCards(int id){
        String sql = "UPDATE `giftcards` SET`estado`=0 WHERE idGiftCards=1" ;             
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "Gift Cards dado de Baja ");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Gift Cards");
        }
    }
    public void altaGiftCards(int id){
        String sql = "UPDATE `giftcards` SET`estado`=1 WHERE idGiftCards=1" ;             
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "Gift Cards dado de alta ");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Gift Cards");
        }
    }
    public List<GiftCards> listarGiftCardsActivas() {
        ArrayList<GiftCards> giftCards = new ArrayList<>();
       String sql = "SELECT  `idGiftCards`,`codigo`, `valor`, `valorRestante`, `fechaExpiracion`, `estado` FROM `giftcards` WHERE estado=1";
       
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                GiftCards giftCard = new GiftCards();
                
                giftCard.setId_gift_cards(rs.getInt("idGiftCards"));
                giftCard.setCodigo_gift_cards(rs.getString("codigo"));
                giftCard.setValor_gift_cards(rs.getDouble("valor"));
                giftCard.setValorRestante_gift_cards(rs.getDouble("valorRestante"));
                giftCard.setFechaExpiracion_gift_cards(rs.getDate("fechaExpiracion").toLocalDate());     
                giftCard.setEstado_gift_cards(true);
                giftCards.add(giftCard);
            }
        } catch (SQLException ex) {
//            Logger.getLogger(SocioData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla giftCards");
        }
        return giftCards;
    }
    
    public void actualizarValor(int id,double valor){
        String sqlObtenerMontoGiftCard = "SELECT ValorRestante FROM giftcards WHERE IdGiftCards = ?";
        String sqlActualizar="UPDATE giftcards SET ValorRestante = ValorRestante - ? WHERE IdGiftCards = ?;";
        
        try {
            PreparedStatement psObtenerMontoGiftCard = con.prepareStatement(sqlObtenerMontoGiftCard);
            PreparedStatement psActualizar = con.prepareStatement(sqlActualizar);
            
            psObtenerMontoGiftCard.setInt(1, id);
            ResultSet rs = psObtenerMontoGiftCard.executeQuery();
            if (rs.next()) {
                double disponible = rs.getDouble("valorRestante");
                if (disponible < valor) {
                    throw new SQLException("Saldo insuficiente en la gift card.");
                }
                
                psActualizar.setDouble(1, valor);
                psActualizar.setInt(2, id);
                psActualizar.executeUpdate();
            }else {
                
                JOptionPane.showMessageDialog(null,"Gift card no encontrada.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Gift Cards");
        }
    }
}
