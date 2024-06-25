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
public class Transaccion {
    private int id_transaccion;
    private Cliente cliente;
    private LocalDate fecha_transaccion;
    private double total_transaccion;
    private GiftCards giftCards;
    private String Tipo;
    private boolean estado_transaccion;

    public Transaccion() {
    }
//sin gift e id
    public Transaccion(Cliente cliente, LocalDate fecha_transaccion, double total_transaccion, String Tipo, boolean estado_transaccion) {
        this.cliente = cliente;
        this.fecha_transaccion = fecha_transaccion;
        this.total_transaccion = total_transaccion;
        this.Tipo = Tipo;
        this.estado_transaccion = estado_transaccion;
    }
//td sin id
    public Transaccion(Cliente cliente, LocalDate fecha_transaccion, double total_transaccion, GiftCards giftCards, String Tipo, boolean estado_transaccion) {
        this.cliente = cliente;
        this.fecha_transaccion = fecha_transaccion;
        this.total_transaccion = total_transaccion;
        this.giftCards = giftCards;
        this.Tipo = Tipo;
        this.estado_transaccion = estado_transaccion;
    }
//con id y sin gift
    public Transaccion(int id_transaccion, Cliente cliente, LocalDate fecha_transaccion, double total_transaccion, String Tipo, boolean estado_transaccion) {
        this.id_transaccion = id_transaccion;
        this.cliente = cliente;
        this.fecha_transaccion = fecha_transaccion;
        this.total_transaccion = total_transaccion;
        this.Tipo = Tipo;
        this.estado_transaccion = estado_transaccion;
    }
//con id y  gift    
    public Transaccion(int id_transaccion, Cliente cliente, LocalDate fecha_transaccion, double total_transaccion, GiftCards giftCards, String Tipo, boolean estado_transaccion) {
        this.id_transaccion = id_transaccion;
        this.cliente = cliente;
        this.fecha_transaccion = fecha_transaccion;
        this.total_transaccion = total_transaccion;
        this.giftCards = giftCards;
        this.Tipo = Tipo;
        this.estado_transaccion = estado_transaccion;
    }

    
    
    public int getId_transaccion() {
        return id_transaccion;
    }
    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }
    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFecha_transaccion() {
        return fecha_transaccion;
    }

    public void setFecha_transaccion(LocalDate fecha_transaccion) {
        this.fecha_transaccion = fecha_transaccion;
    }

    public double getTotal_transaccion() {
        return total_transaccion;
    }

    public void setTotal_transaccion(double total_transaccion) {
        this.total_transaccion = total_transaccion;
    }

    public boolean isEstado_transaccion() {
        return estado_transaccion;
    }

    public void setEstado_transaccion(boolean estado_transaccion) {
        this.estado_transaccion = estado_transaccion;
    }

    public GiftCards getGiftCards() {
        return giftCards;
    }

    public void setGiftCards(GiftCards giftCards) {
        this.giftCards = giftCards;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
    
}
