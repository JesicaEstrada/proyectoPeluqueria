/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopeluqueria;

import accesoData.ClienteData;
import entidades.Cliente;
import java.time.LocalDate;

/**
 *
 * @author Jesica
 */
public class ProyectoPeluqueria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ClienteData cliData=new ClienteData();
//        private int dni_cliente;
//    private String nombre_cliente;
//    private String apellido_cliente;
//    private LocalDate fechaNacimiento_cliente;
//    private int telefono_cliente;
//    private String correo_cliente;
//    private String direccion_cliente;
//    private boolean estado_cliente;
        Cliente juan=new Cliente(41000222, "Pedro", "Gomez",LocalDate.of(2024, 6, 1), 261456237, "pedro.gomez@example.com", "cualquiera", true);
        cliData.cargarCliente(juan);
    }
    
}
