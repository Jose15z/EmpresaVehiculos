package co.edu.uniquindio.poo.empresavehiculos.model;
import java.util.Collection;
import java.util.LinkedList;
public class Empresa {
    private String nombre;
    private Collection<Vehiculo> vehiculos;
    private Collection<Reserva> reservas;
    private Collection<Cliente> clientes;
    public Empresa(String nombre){
        this.nombre = nombre;
        vehiculos = new LinkedList<>();
        reservas = new LinkedList<>();
        clientes = new LinkedList<>();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Collection<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    public void setVehiculos(Collection<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    public Collection<Reserva> getReservas() {
        return reservas;
    }
    public void setReservas(Collection<Reserva> reservas) {
        this.reservas = reservas;
    }
    public Collection<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(Collection<Cliente> clientes) {
        this.clientes = clientes;
    }
    public boolean verificarVehiculo(String placa){
        boolean estaVehiculo = false;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getNumeroMatricula().equals(placa)){
                estaVehiculo = true;
            }
        }
        return estaVehiculo;
    }

}
