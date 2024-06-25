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
public class Producto {
    private int id_Producto;
    private String codigo_producto;
    private String nombre_producto;
    private String descripcion_producto;
    private double precio_producto;
    private int stock_producto;
    private boolean estado_producto;

    public Producto() {
    }

    public Producto(String codigo, String nombre_producto, String descripcion_producto, double precio_producto, int stock_producto, boolean estado_producto) {
        this.codigo_producto = codigo;
        this.nombre_producto = nombre_producto;
        this.descripcion_producto = descripcion_producto;
        this.precio_producto = precio_producto;
        this.stock_producto = stock_producto;
        this.estado_producto = estado_producto;
    }
    
    public Producto(int id_Producto, String codigo, String nombre_producto, String descripcion_producto, double precio_producto, int stock_producto, boolean estado_producto) {
        this.id_Producto = id_Producto;
        this.codigo_producto = codigo;
        this.nombre_producto = nombre_producto;
        this.descripcion_producto = descripcion_producto;
        this.precio_producto = precio_producto;
        this.stock_producto = stock_producto;
        this.estado_producto = estado_producto;
    }

    
    public int getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(int id_Producto) {
        this.id_Producto = id_Producto;
    }
    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public double getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(double precio_producto) {
        this.precio_producto = precio_producto;
    }

    public int getStock_producto() {
        return stock_producto;
    }

    public void setStock_producto(int stock_producto) {
        this.stock_producto = stock_producto;
    }

    public boolean isEstado_producto() {
        return estado_producto;
    }

    public void setEstado_producto(boolean estado_producto) {
        this.estado_producto = estado_producto;
    }

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo) {
        this.codigo_producto = codigo;
    }

    @Override
    public String toString() {
        return  "codigo: " + codigo_producto + ", nombre:" + nombre_producto + '}';
    }
    
    
    
}
