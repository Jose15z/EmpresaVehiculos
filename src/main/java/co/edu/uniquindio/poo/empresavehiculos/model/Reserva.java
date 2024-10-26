package co.edu.uniquindio.poo.empresavehiculos.model;

public class Reserva {
    private String id;
    private double costo;
    public Reserva(String id, double costo){
        this.costo = costo;
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public double getCosto() {
        return costo;
    }
    public void setCosto(double costo) {
        this.costo = costo;
    }

}
