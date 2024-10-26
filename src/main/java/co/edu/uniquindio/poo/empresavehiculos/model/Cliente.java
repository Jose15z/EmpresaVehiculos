package co.edu.uniquindio.poo.empresavehiculos.model;
import java.util.LinkedList;
import java.util.Collection;
public class Cliente {
    private String nombre;
    private String cedula;
    private String telefono;
    private Collection<Reserva> reservas;
    public Cliente(String nombre, String cedula, String telefono){
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        reservas = new LinkedList<>();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Collection<Reserva> getReservas() {
        return reservas;
    }
    public void setReservas(Collection<Reserva> reservas) {
        this.reservas = reservas;
    }

}

