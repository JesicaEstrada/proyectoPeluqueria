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
public class Transacion {
    private int id_transaccion;
    private Cliente cliente;
    private LocalDate fecha_transaccion;
    private double total_transaccion;
    private boolean estado_transaccion;

    public Transacion() {
    }

    public Transacion(Cliente cliente, LocalDate fecha_transaccion, double total_transaccion, boolean estado_transaccion) {
        this.cliente = cliente;
        this.fecha_transaccion = fecha_transaccion;
        this.total_transaccion = total_transaccion;
        this.estado_transaccion = estado_transaccion;
    }

    public Transacion(int id_transaccion, Cliente cliente, LocalDate fecha_transaccion, double total_transaccion, boolean estado_transaccion) {
        this.id_transaccion = id_transaccion;
        this.cliente = cliente;
        this.fecha_transaccion = fecha_transaccion;
        this.total_transaccion = total_transaccion;
        this.estado_transaccion = estado_transaccion;
    }

    public int getId_transaccion() {
        return id_transaccion;
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
    
    
}
