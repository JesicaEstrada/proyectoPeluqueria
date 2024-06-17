/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.time.LocalDate;

/**
 *
 * @author Jesica
 */
public class CompraGiftCards {
    private int id_compra;
    private GiftCards giftCards;
    private LocalDate fecha_compra;
    private double valor_compra;

    public CompraGiftCards() {
    }

    public CompraGiftCards(GiftCards giftCards, LocalDate fecha_compra, double valor_compra) {
        this.giftCards = giftCards;
        this.fecha_compra = fecha_compra;
        this.valor_compra = valor_compra;
    }

    public CompraGiftCards(int id_compra, GiftCards giftCards, LocalDate fecha_compra) {
        this.id_compra = id_compra;
        this.giftCards = giftCards;
        this.fecha_compra = fecha_compra;
    }

    public GiftCards getGiftCards() {
        return giftCards;
    }

    public void setGiftCards(GiftCards giftCards) {
        this.giftCards = giftCards;
    }

    public LocalDate getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(LocalDate fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public double getValor_compra() {
        return valor_compra;
    }

    public void setValor_compra(double valor_compra) {
        this.valor_compra = valor_compra;
    }

    public int getId_compra() {
        return id_compra;
    }
    
    
}
