/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Jesica
 */
public class OrdenTrabajo {
    private int id_orden_trabajo;
    private Cliente cliente;
    private Empleado empleado;
    private LocalDate fecha_orden_trabajo;
    private LocalTime hora_orden_trabajo;
    private String servicios_orden_trabajo;
    private String productos_orden_trabajo;
    private int duracion_orden_trabajo;
    private double costo_total_orden_trabajo;
    private CompraGiftCards compraGiftCard_orden_trabajo;
    private double descuentoGiftCard_orden_trabajo;
    private boolean estado_orden_trabajo;

    public OrdenTrabajo() {
    }
//sin GIFT CARDS
    public OrdenTrabajo(Cliente cliente, Empleado empleado, LocalDate fecha_orden_trabajo, LocalTime hora_orden_trabajo, String servicios_orden_trabajo, String productos_orden_trabajo, int duracion_orden_trabajo, double costo_total_orden_trabajo, boolean estado_orden_trabajo) {
        this.cliente = cliente;
        this.empleado = empleado;
        this.fecha_orden_trabajo = fecha_orden_trabajo;
        this.hora_orden_trabajo = hora_orden_trabajo;
        this.servicios_orden_trabajo = servicios_orden_trabajo;
        this.productos_orden_trabajo = productos_orden_trabajo;
        this.duracion_orden_trabajo = duracion_orden_trabajo;
        this.costo_total_orden_trabajo = costo_total_orden_trabajo;
        this.estado_orden_trabajo = estado_orden_trabajo;
    }
//CON GIFTCard
    public OrdenTrabajo(Cliente cliente, Empleado empleado, LocalDate fecha_orden_trabajo, LocalTime hora_orden_trabajo, String servicios_orden_trabajo, String productos_orden_trabajo, int duracion_orden_trabajo, double costo_total_orden_trabajo, CompraGiftCards compraGiftCard_orden_trabajo, double descuentoGiftCard_orden_trabajo, boolean estado_orden_trabajo) {
        this.cliente = cliente;
        this.empleado = empleado;
        this.fecha_orden_trabajo = fecha_orden_trabajo;
        this.hora_orden_trabajo = hora_orden_trabajo;
        this.servicios_orden_trabajo = servicios_orden_trabajo;
        this.productos_orden_trabajo = productos_orden_trabajo;
        this.duracion_orden_trabajo = duracion_orden_trabajo;
        this.costo_total_orden_trabajo = costo_total_orden_trabajo;
        this.compraGiftCard_orden_trabajo = compraGiftCard_orden_trabajo;
        this.descuentoGiftCard_orden_trabajo = descuentoGiftCard_orden_trabajo;
        this.estado_orden_trabajo = estado_orden_trabajo;
    }
// con id
    public OrdenTrabajo(int id_orden_trabajo, Cliente cliente, Empleado empleado, LocalDate fecha_orden_trabajo, LocalTime hora_orden_trabajo, String servicios_orden_trabajo, String productos_orden_trabajo, int duracion_orden_trabajo, double costo_total_orden_trabajo, CompraGiftCards compraGiftCard_orden_trabajo, double descuentoGiftCard_orden_trabajo, boolean estado_orden_trabajo) {
        this.id_orden_trabajo = id_orden_trabajo;
        this.cliente = cliente;
        this.empleado = empleado;
        this.fecha_orden_trabajo = fecha_orden_trabajo;
        this.hora_orden_trabajo = hora_orden_trabajo;
        this.servicios_orden_trabajo = servicios_orden_trabajo;
        this.productos_orden_trabajo = productos_orden_trabajo;
        this.duracion_orden_trabajo = duracion_orden_trabajo;
        this.costo_total_orden_trabajo = costo_total_orden_trabajo;
        this.compraGiftCard_orden_trabajo = compraGiftCard_orden_trabajo;
        this.descuentoGiftCard_orden_trabajo = descuentoGiftCard_orden_trabajo;
        this.estado_orden_trabajo = estado_orden_trabajo;
    }

    public int getId_orden_trabajo() {
        return id_orden_trabajo;
    }

    public void setId_orden_trabajo(int id_orden_trabajo) {
        this.id_orden_trabajo = id_orden_trabajo;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public LocalDate getFecha_orden_trabajo() {
        return fecha_orden_trabajo;
    }

    public void setFecha_orden_trabajo(LocalDate fecha_orden_trabajo) {
        this.fecha_orden_trabajo = fecha_orden_trabajo;
    }

    public LocalTime getHora_orden_trabajo() {
        return hora_orden_trabajo;
    }

    public void setHora_orden_trabajo(LocalTime hora_orden_trabajo) {
        this.hora_orden_trabajo = hora_orden_trabajo;
    }

    public String getServicios_orden_trabajo() {
        return servicios_orden_trabajo;
    }

    public void setServicios_orden_trabajo(String servicios_orden_trabajo) {
        this.servicios_orden_trabajo = servicios_orden_trabajo;
    }

    public String getProductos_orden_trabajo() {
        return productos_orden_trabajo;
    }

    public void setProductos_orden_trabajo(String productos_orden_trabajo) {
        this.productos_orden_trabajo = productos_orden_trabajo;
    }

    public int getDuracion_orden_trabajo() {
        return duracion_orden_trabajo;
    }

    public void setDuracion_orden_trabajo(int duracion_orden_trabajo) {
        this.duracion_orden_trabajo = duracion_orden_trabajo;
    }

    public double getCosto_total_orden_trabajo() {
        return costo_total_orden_trabajo;
    }

    public void setCosto_total_orden_trabajo(double costo_total_orden_trabajo) {
        this.costo_total_orden_trabajo = costo_total_orden_trabajo;
    }

    public CompraGiftCards getCompraGiftCard_orden_trabajo() {
        return compraGiftCard_orden_trabajo;
    }

    public void setCompraGiftCard_orden_trabajo(CompraGiftCards compraGiftCard_orden_trabajo) {
        this.compraGiftCard_orden_trabajo = compraGiftCard_orden_trabajo;
    }

    public double getDescuentoGiftCard_orden_trabajo() {
        return descuentoGiftCard_orden_trabajo;
    }

    public void setDescuentoGiftCard_orden_trabajo(double descuentoGiftCard_orden_trabajo) {
        this.descuentoGiftCard_orden_trabajo = descuentoGiftCard_orden_trabajo;
    }

    public boolean isEstado_orden_trabajo() {
        return estado_orden_trabajo;
    }

    public void setEstado_orden_trabajo(boolean estado_orden_trabajo) {
        this.estado_orden_trabajo = estado_orden_trabajo;
    }
    
    
    
}
