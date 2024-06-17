/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Jesica
 */
public class DetalleTransaccionGftCard {
    private int id_detalleTransaccionGftCard;
    private GiftCards giftCards;
    private CompraGiftCards compraGiftCards;
    private double montoUtilizado;

    public DetalleTransaccionGftCard() {
    }

    public DetalleTransaccionGftCard(GiftCards giftCards, CompraGiftCards compraGiftCards, double montoUtilizado) {
        this.giftCards = giftCards;
        this.compraGiftCards = compraGiftCards;
        this.montoUtilizado = montoUtilizado;
    }
    
    
    public DetalleTransaccionGftCard(int id_detalleTransaccionGftCard, GiftCards giftCards, CompraGiftCards compraGiftCards, double montoUtilizado) {
        this.id_detalleTransaccionGftCard = id_detalleTransaccionGftCard;
        this.giftCards = giftCards;
        this.compraGiftCards = compraGiftCards;
        this.montoUtilizado = montoUtilizado;
    }

    public int getId_detalleTransaccionGftCard() {
        return id_detalleTransaccionGftCard;
    }

  
    public GiftCards getGiftCards() {
        return giftCards;
    }

    public void setGiftCards(GiftCards giftCards) {
        this.giftCards = giftCards;
    }

    public CompraGiftCards getCompraGiftCards() {
        return compraGiftCards;
    }

    public void setCompraGiftCards(CompraGiftCards compraGiftCards) {
        this.compraGiftCards = compraGiftCards;
    }

    public double getMontoUtilizado() {
        return montoUtilizado;
    }

    public void setMontoUtilizado(double montoUtilizado) {
        this.montoUtilizado = montoUtilizado;
    }
    
    
}