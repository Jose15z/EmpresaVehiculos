package co.edu.uniquindio.poo.empresavehiculos.model;

import java.util.LinkedList;
import java.util.Collection;

public class Cliente {
    private String nombre;
    private String cedula;
    private String telefono;
    private Collection<Reserva> reservas;

    /**
     * Método constructor de la clase Cliente
     * @param nombre
     * @param cedula
     * @param telefono
     */
    public Cliente(String nombre, String cedula, String telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        reservas = new LinkedList<>();
    }

    /**
     * Método para obtener el nombre de un cliente
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para modificar el nombre de un cliente
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener la cédula de un cliente
     * @return
     */
    public String getCedula() {
        return cedula;
    }

    /**Método para modificar la cédula de un cliente
     * 
     * @param cedula
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Método para obtener el teléfono de un cliente
     * @return
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Método para modificar el teléfono de un cliente
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Método para obtener la lista de reservas de un cliente
     * @return
     */
    public Collection<Reserva> getReservas() {
        return reservas;
    }

    /**
     * Método para modificar la lista de reservas de un cliente
     * @param reservas
     */
    public void setReservas(Collection<Reserva> reservas) {
        this.reservas = reservas;
    }

    /**
     * Método toString de la clase
     */
    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + ", cedula=" + cedula + ", telefono=" + telefono + ", reservas=" + reservas
                + "]";
    }
    
}
