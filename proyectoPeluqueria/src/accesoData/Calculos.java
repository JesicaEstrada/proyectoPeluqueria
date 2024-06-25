/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoData;

import entidades.Producto;
import entidades.Servicio;
import java.util.List;

/**
 *
 * @author Jesica
 */
public class Calculos {
    
    public static double calcularCostoTotal(List<Producto> productos, List<Servicio> servicios) {
        double costoTotal = 0.0;
        for (Producto producto : productos) {
            costoTotal += producto.getPrecio_producto();
        }
        for (Servicio servicio : servicios) {
            costoTotal += servicio.getPrecio_servicio();
        }
        return costoTotal;
    }

    public static int calcularDuracionTotal(List<Servicio> servicios) {
        int duracionTotal = 0;
        for (Servicio servicio : servicios) {
            duracionTotal += servicio.getDuracion_servicio();
        }
        return duracionTotal;
    }
    
}
