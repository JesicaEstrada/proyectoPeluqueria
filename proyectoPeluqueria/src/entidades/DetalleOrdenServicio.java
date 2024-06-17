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
public class DetalleOrdenServicio {
    private OrdenTrabajo ordenTrabajo;
    private Servicio servicio;

    public DetalleOrdenServicio(OrdenTrabajo ordenTrabajo, Servicio servicio) {
        this.ordenTrabajo = ordenTrabajo;
        this.servicio = servicio;
    }

    public OrdenTrabajo getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    
    
    
}
