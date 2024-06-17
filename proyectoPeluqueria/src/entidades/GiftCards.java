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
public class GiftCards {
    private int id_gift_cards;
    private String codigo_gift_cards;
    private double valor_gift_cards;
    private double valorRestante_gift_cards=valor_gift_cards;
    private LocalDate fechaExpiracion_gift_cards;
    private boolean estado_gift_cards;

    public GiftCards() {
    }

    public GiftCards(String codigo_gift_cards, double valor_gift_cards, LocalDate fechaExpiracion_gift_cards, boolean estado_gift_cards) {
        this.codigo_gift_cards = codigo_gift_cards;
        this.valor_gift_cards = valor_gift_cards;
        this.fechaExpiracion_gift_cards = fechaExpiracion_gift_cards;
        this.estado_gift_cards = estado_gift_cards;
    }

    public GiftCards(int id_gift_cards, String codigo_gift_cards, double valor_gift_cards, LocalDate fechaExpiracion_gift_cards, boolean estado_gift_cards) {
        this.id_gift_cards = id_gift_cards;
        this.codigo_gift_cards = codigo_gift_cards;
        this.valor_gift_cards = valor_gift_cards;
        this.fechaExpiracion_gift_cards = fechaExpiracion_gift_cards;
        this.estado_gift_cards = estado_gift_cards;
    }

    public int getId_gift_cards() {
        return id_gift_cards;
    }

    public void setId_gift_cards(int id_gift_cards) {
        this.id_gift_cards = id_gift_cards;
    }
    

    public String getCodigo_gift_cards() {
        return codigo_gift_cards;
    }

    public void setCodigo_gift_cards(String codigo_gift_cards) {
        this.codigo_gift_cards = codigo_gift_cards;
    }

    public double getValor_gift_cards() {
        return valor_gift_cards;
    }

    public void setValor_gift_cards(double valor_gift_cards) {
        this.valor_gift_cards = valor_gift_cards;
    }

    public double getValorRestante_gift_cards() {
        return valorRestante_gift_cards;
    }

    public void setValorRestante_gift_cards(double valorRestante_gift_cards) {
        this.valorRestante_gift_cards = valorRestante_gift_cards;
    }

    public LocalDate getFechaExpiracion_gift_cards() {
        return fechaExpiracion_gift_cards;
    }

    public void setFechaExpiracion_gift_cards(LocalDate fechaExpiracion_gift_cards) {
        this.fechaExpiracion_gift_cards = fechaExpiracion_gift_cards;
    }

    public boolean isEstado_gift_cards() {
        return estado_gift_cards;
    }

    public void setEstado_gift_cards(boolean estado_gift_cards) {
        this.estado_gift_cards = estado_gift_cards;
    }
    
    
}
