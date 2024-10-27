package co.edu.uniquindio.poo.empresavehiculos.model;

import java.time.Year;

public class Auto extends Vehiculo {
    private short numPuertas;

    /**
     * Método constructor de la clase Camioneta
     * 
     * @param numeroMatricula
     * @param marca
     * @param modelo
     * @param anioFabricacion
     * @param numPuertas
     */
    public Auto(String numeroMatricula, String marca, String modelo, Year anioFabricacion, short numPuertas) {
        super(numeroMatricula, marca, modelo, anioFabricacion);
        this.numPuertas = numPuertas;
        setTarifa(30000);
    }

    /**
     * Método para obtener el número de puertas del auto
     * 
     * @return número de puertas del auto
     */
    public short getNumPuertas() {
        return numPuertas;
    }

    /**
     * Método para modificar el número de puertas del auto
     * 
     * @param numPuertas del auto
     */
    public void setNumPuertas(short numPuertas) {
        this.numPuertas = numPuertas;
    }

    /**
     * Método que se hereda de la clase vehiculo, en el caso de los autos, estos no
     * cuentan con una tarifa adicional
     */
    @Override
    public double calcularTarifaAdicional() {
        return 0;
    }

    /**
     * Método toString de la clase
     */
    @Override
    public String toString() {
        return "Auto" + super.toString() + "numPuertas=" + numPuertas + "]";
    }

}