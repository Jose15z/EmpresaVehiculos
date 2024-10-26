package co.edu.uniquindio.poo.empresavehiculos.model;
import java.time.Year;
import java.util.LinkedList;
import java.util.Collection;
public class Vehiculo {
    private String numeroMatricula;
    private String marca;
    private String modelo;
    private Year anioFabricacion;
    private Collection<Reserva> reservas;

    public Vehiculo(String numeroMatricula, String marca, String modelo, Year anioFabricacion ){
        this.numeroMatricula = numeroMatricula;
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        reservas = new LinkedList<>();
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Year getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(Year anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public Collection<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Collection<Reserva> reservas) {
        this.reservas = reservas;
    }
}
