package co.edu.uniquindio.poo.empresavehiculos.model;

import java.time.Year;

public class Camioneta extends Vehiculo{
    private double capacidadCarga;
    public Camioneta(String numeroMatricula, String marca, String modelo, Year anioFabricacion, double capacidadCarga){
        super(numeroMatricula, marca, modelo, anioFabricacion);
        this.capacidadCarga = capacidadCarga;
    }
    public double getCapacidadCarga() {
        return capacidadCarga;
    }
    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }
}