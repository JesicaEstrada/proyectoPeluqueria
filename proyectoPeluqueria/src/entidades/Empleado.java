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
public class Empleado {
    private int id_empleado;
    private int dni_empleado;
    private String nombre_empleado;
    private String apellido_empleado;
    private int telefono_empleado;
    private String correo_empleado;
    private String cargo_empleado;
    private boolean estado_empleado;

    public Empleado() {
    }

    public Empleado(int dni_empleado, String nombre_empleado, String apellido_empleado, int telefono_empleado, String correo_empleado, String cargo_empleado, boolean estado_empleado) {
        this.dni_empleado = dni_empleado;
        this.nombre_empleado = nombre_empleado;
        this.apellido_empleado = apellido_empleado;
        this.telefono_empleado = telefono_empleado;
        this.correo_empleado = correo_empleado;
        this.cargo_empleado = cargo_empleado;
        this.estado_empleado = estado_empleado;
    }

    public Empleado(int id_empleado, int dni_empleado, String nombre_empleado, String apellido_empleado, int telefono_empleado, String correo_empleado, String cargo_empleado, boolean estado_empleado) {
        this.id_empleado = id_empleado;
        this.dni_empleado = dni_empleado;
        this.nombre_empleado = nombre_empleado;
        this.apellido_empleado = apellido_empleado;
        this.telefono_empleado = telefono_empleado;
        this.correo_empleado = correo_empleado;
        this.cargo_empleado = cargo_empleado;
        this.estado_empleado = estado_empleado;
    }

    public int getDni_empleado() {
        return dni_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }
    
    public void setDni_empleado(int dni_empleado) {
        this.dni_empleado = dni_empleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getApellido_empleado() {
        return apellido_empleado;
    }

    public void setApellido_empleado(String apellido_empleado) {
        this.apellido_empleado = apellido_empleado;
    }

    public int getTelefono_empleado() {
        return telefono_empleado;
    }

    public void setTelefono_empleado(int telefono_empleado) {
        this.telefono_empleado = telefono_empleado;
    }

    public String getCorreo_empleado() {
        return correo_empleado;
    }

    public void setCorreo_empleado(String correo_empleado) {
        this.correo_empleado = correo_empleado;
    }

    public String getCargo_empleado() {
        return cargo_empleado;
    }

    public void setCargo_empleado(String cargo_empleado) {
        this.cargo_empleado = cargo_empleado;
    }

    public boolean isEstado_empleado() {
        return estado_empleado;
    }

    public void setEstado_empleado(boolean estado_empleado) {
        this.estado_empleado = estado_empleado;
    }

    public int getId_empleado() {
        return id_empleado;
    }

  
    
}
