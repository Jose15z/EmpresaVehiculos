package co.edu.uniquindio.poo.empresavehiculos.model;

import java.time.Year;
import java.util.LinkedList;
import java.util.Collection;

public abstract class Vehiculo {
    private double tarifa;
    private String numeroMatricula;
    private String marca;
    private String modelo;
    private Year anioFabricacion;
    private Collection<Reserva> reservas;

    /**
     * Método constructor de la clase Vehiculo
     * 
     * @param numeroMatricula
     * @param marca
     * @param modelo
     * @param anioFabricacion
     */
    public Vehiculo(String numeroMatricula, String marca, String modelo, Year anioFabricacion) {
        this.numeroMatricula = numeroMatricula;
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        reservas = new LinkedList<>();
    }

    // ----------------MÉTODOS GET Y SET DE LA CLASE-----------------//

    /**
     * Método para obtener la tarifa base del vehiculo
     * @return tarifa base del vehiculo
     */
    public double getTarifa() {
        return tarifa;
    }

    /**
     * Método para modificar la tarifa base del vehiculo
     * @param tarifa nueva
     */
    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    /**
     * Método para obtener el número de matrícula de un vehiculo
     * @return número de matrícula de un vehiculo
     */
    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    /**
     * Método para modificar el número de matrícula de un vehiculo
     * @param numeroMatricula nuevo
     */
    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    /**
     * Método para obtener la marca del vehículo
     * @return marca del vehículo
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Método para modificar la marca del vehículo
     * @param marca nueva
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Método para obtener el modelo del vehículo
     * @return modelo del vehículo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Método para modificar el modelo del vehículo
     * @param modelo nuevo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Método para obtener el año de fabricación del vehículo
     * @return año de fabricación del vehículo
     */
    public Year getAnioFabricacion() {
        return anioFabricacion;
    }

    /**
     * Método para modificar el año de fabricación del vehículo
     * @param anioFabricacion nuevo
     */
    public void setAnioFabricacion(Year anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    /**
     * Método para obtener las reservas en las que se incluye el vehículo
     * @return reservas que incluyen al vehículo
     */
    public Collection<Reserva> getReservas() {
        return reservas;
    }

    /**
     * Método para modificar las reservas en las que se incluye el vehículo
     * @param reservas nuevas
     */
    public void setReservas(Collection<Reserva> reservas) {
        this.reservas = reservas;
    }

    // --------------------------------------------------------------//

    /**
     * Método abstracto de la clase Vehiculo para calcular la tarifa adicional del
     * servicio según el tipo de vehiculo 
     * 
     */
    public abstract double calcularTarifaAdicional();

    /**
     * Método toString de la clase Vehiculo
     */
    @Override
    public String toString() {
        return " [numeroMatricula=" + numeroMatricula + ", marca=" + marca + ", modelo=" + modelo
                + ", anioFabricacion=" + anioFabricacion;
    }

}
