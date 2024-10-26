package co.edu.uniquindio.poo.empresavehiculos.model;

import java.time.Year;

public class Auto extends Vehiculo{
    private short numPuertas;
    public Auto(String numeroMatricula, String marca, String modelo, Year anioFabricacion, short numPuertas){
        super(numeroMatricula, marca, modelo, anioFabricacion);
        this.numPuertas = numPuertas;
    }
    public short getNumPuertas() {
        return numPuertas;
    }
    public void setNumPuertas(short numPuertas) {
        this.numPuertas = numPuertas;
    }


}