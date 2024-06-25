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
public class Servicio {
    private int id_servicio;
    private String nombre_servicio;
    private int duracion_servicio;
    private double precio_servicio;
    private String descripcion_servicio;
    private boolean estado_servicio;

    public Servicio() {
    }

    public Servicio(String nombre_servicio, int duracion_servicio, double precio_servicio, String descripcion_servicio, boolean estado_servicio) {
        this.nombre_servicio = nombre_servicio;
        this.duracion_servicio = duracion_servicio;
        this.precio_servicio = precio_servicio;
        this.descripcion_servicio = descripcion_servicio;
        this.estado_servicio = estado_servicio;
    }

    public Servicio(int id_servicio, String nombre_servicio, int duracion_servicio, double precio_servicio, String descripcion_servicio, boolean estado_servicio) {
        this.id_servicio = id_servicio;
        this.nombre_servicio = nombre_servicio;
        this.duracion_servicio = duracion_servicio;
        this.precio_servicio = precio_servicio;
        this.descripcion_servicio = descripcion_servicio;
        this.estado_servicio = estado_servicio;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    
    public String getNombre_servicio() {
        return nombre_servicio;
    }

    public void setNombre_servicio(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
    }

    public int getDuracion_servicio() {
        return duracion_servicio;
    }

    public void setDuracion_servicio(int duracion_servicio) {
        this.duracion_servicio = duracion_servicio;
    }

    public double getPrecio_servicio() {
        return precio_servicio;
    }

    public void setPrecio_servicio(double precio_servicio) {
        this.precio_servicio = precio_servicio;
    }

    public String getDescripcion_servicio() {
        return descripcion_servicio;
    }

    public void setDescripcion_servicio(String descripcion_servicio) {
        this.descripcion_servicio = descripcion_servicio;
    }

    public boolean isEstado_servicio() {
        return estado_servicio;
    }

    public void setEstado_servicio(boolean estado_servicio) {
        this.estado_servicio = estado_servicio;
    }

    @Override
    public String toString() {
        return  nombre_servicio + ", "+ descripcion_servicio + '}';
    }
    
    
}
