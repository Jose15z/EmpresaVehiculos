package co.edu.uniquindio.poo.empresavehiculos.model;

import java.time.Year;

public class Camioneta extends Vehiculo {
    private double capacidadCarga;

    /**
     * Método constructor de la clase Camioneta
     * 
     * @param numeroMatricula
     * @param marca
     * @param modelo
     * @param anioFabricacion
     * @param capacidadCarga
     */
    public Camioneta(String numeroMatricula, String marca, String modelo, Year anioFabricacion, double capacidadCarga) {
        super(numeroMatricula, marca, modelo, anioFabricacion);
        this.capacidadCarga = capacidadCarga;
        setTarifa(50000);
    }

    /**
     * Método para obtener la capacidad de carga de la camioneta
     * 
     * @return capacidad de carga de la Camioneta
     */
    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    /**
     * Método para modificar la capacidad de carga de la camioneta
     * 
     * @param capacidadCarga de la Camioneta
     */
    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    /**
     * Método para calcular la tarifa adicional de la camioneta según su capacidad
     * de carga y una tarifa fija
     */
    @Override
    public double calcularTarifaAdicional() {
        double tarifaAdicional = capacidadCarga * 5000;
        return tarifaAdicional;
    }

    /**
     * Método toString de la clase
     */
    @Override
    public String toString() {
        return "Camioneta" + super.toString() + ", capacidadCarga=" + capacidadCarga + "]";
    }

}