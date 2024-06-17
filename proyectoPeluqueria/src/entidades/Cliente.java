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
public class Cliente {
    private int id_cliente;
    private int dni_cliente;
    private String nombre_cliente;
    private String apellido_cliente;
    private LocalDate fechaNacimiento_cliente;
    private String telefono_cliente;
    private String correo_cliente;
    private String direccion_cliente;
    private boolean estado_cliente;

    public Cliente() {
    }

    public Cliente(int dni_cliente, String nombre_cliente, String apellido_cliente, LocalDate fechaNacimiento_cliente, String telefono_cliente, String correo_cliente, String direccion_cliente, boolean estado_cliente) {
        this.dni_cliente = dni_cliente;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.fechaNacimiento_cliente = fechaNacimiento_cliente;
        this.telefono_cliente = telefono_cliente;
        this.correo_cliente = correo_cliente;
        this.direccion_cliente = direccion_cliente;
        this.estado_cliente = estado_cliente;
    }

    public Cliente(int id_cliente, int dni_cliente, String nombre_cliente, String apellido_cliente, LocalDate fechaNacimiento_cliente, String telefono_cliente, String correo_cliente, String direccion_cliente, boolean estado_cliente) {
        this.id_cliente = id_cliente;
        this.dni_cliente = dni_cliente;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.fechaNacimiento_cliente = fechaNacimiento_cliente;
        this.telefono_cliente = telefono_cliente;
        this.correo_cliente = correo_cliente;
        this.direccion_cliente = direccion_cliente;
        this.estado_cliente = estado_cliente;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    
    public int getDni_cliente() {
        return dni_cliente;
    }

    public void setDni_cliente(int dni_cliente) {
        this.dni_cliente = dni_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getApellido_cliente() {
        return apellido_cliente;
    }

    public void setApellido_cliente(String apellido_cliente) {
        this.apellido_cliente = apellido_cliente;
    }

    public LocalDate getFechaNacimiento_cliente() {
        return fechaNacimiento_cliente;
    }

    public void setFechaNacimiento_cliente(LocalDate fechaNacimiento_cliente) {
        this.fechaNacimiento_cliente = fechaNacimiento_cliente;
    }

    public String getTelefono_cliente() {
        return telefono_cliente;
    }

    public void setTelefono_cliente(String telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }

    public String getCorreo_cliente() {
        return correo_cliente;
    }

    public void setCorreo_cliente(String correo_cliente) {
        this.correo_cliente = correo_cliente;
    }

    public String getDireccion_cliente() {
        return direccion_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

    public boolean isEstado_cliente() {
        return estado_cliente;
    }

    public void setEstado_cliente(boolean estado_cliente) {
        this.estado_cliente = estado_cliente;
    }
    
    
    
    
}
