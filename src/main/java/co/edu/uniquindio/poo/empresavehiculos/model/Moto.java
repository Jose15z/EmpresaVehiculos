package co.edu.uniquindio.poo.empresavehiculos.model;

import java.time.Year;

public class Moto extends Vehiculo {
    private Transmision transmision;

    /**
     * Método constructor de la Clase Moto
     * 
     * @param numeroMatricula
     * @param marca
     * @param modelo
     * @param anioFabricacion
     * @param transmision
     */
    public Moto(String numeroMatricula, String marca, String modelo, Year anioFabricacion, Transmision transmision) {
        super(numeroMatricula, marca, modelo, anioFabricacion);
        this.transmision = transmision;
        setTarifa(10000);
    }

    /**
     * Método para obtener el tipo de transmisión de la moto
     * 
     * @return tipo de transmisión de la moto
     */
    public Transmision getTransmision() {
        return transmision;
    }

    /**
     * Método para modificar el tipo de transmisión de la moto
     * 
     * @param transmision de la moto
     */
    public void setTransmision(Transmision transmision) {
        this.transmision = transmision;
    }

    /**
     * Método para calcular la tarifa adicional de la moto según el tipo de
     * transmisión
     */
    @Override
    public double calcularTarifaAdicional() {
        double tarifaAdicional;

        if (transmision == transmision.AUTOMATICA) {
            tarifaAdicional = 5000;
        } else {
            tarifaAdicional = 0;
        }

        return tarifaAdicional;
    }

    /**
     * Método toString de la clase
     */
    @Override
    public String toString() {
        return "Moto" + super.toString() + ", transmisión=" + transmision + "]";
    }

}
