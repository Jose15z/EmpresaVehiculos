package co.edu.uniquindio.poo.empresavehiculos.model;

import java.time.Year;

public class Moto extends Vehiculo {
    private Transmision transmision;
    public Moto(String numeroMatricula, String marca, String modelo, Year anioFabricacion, Transmision transmision){
        super(numeroMatricula, marca, modelo, anioFabricacion);
        this.transmision = transmision;
    }
    public Transmision getTransmision() {
        return transmision;
    }
    public void setTransmision(Transmision transmision) {
        this.transmision = transmision;
    }
}
