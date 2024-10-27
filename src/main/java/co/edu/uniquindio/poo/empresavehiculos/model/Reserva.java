package co.edu.uniquindio.poo.empresavehiculos.model;

public class Reserva {
    private String id;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private int dias;
    private double costo;

    /**
     * Método constructor de la clase Reserva
     * 
     * @param id
     * @param cliente
     * @param vehiculo
     * @param dias
     */
    public Reserva(String id, Cliente cliente, Vehiculo vehiculo, int dias) {
        this.id = id;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.dias = dias;
        this.costo = calcularCosto(vehiculo, dias);
    }

    // ----------------MÉTODOS GET Y SET DE LA CLASE-----------------//

    /**
     * Método para obtener el id de una Reserva
     * 
     * @return id asignado a la reserva
     */
    public String getId() {
        return id;
    }

    /**
     * Método para modificar el id de una Reserva
     * 
     * @param id id asignado a la reserva
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Método para obtener el Cliente asociado a una Reserva
     * 
     * @return Cliente asociado a la Reserva
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Método para modificar el Cliente asociado a una Reserva
     * 
     * @param cliente asociado a la Reserva
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Método para obtener el Vehiculo asociado a una Reserva
     * 
     * @return Vehículo asociado a la Reserva
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Método para modificar el Vehiculo asociado a una Reserva
     * 
     * @param vehiculo asociado a la Reserva
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Método para obtener los días de una Reserva
     * 
     * @return días de Reserva
     */
    public int getDias() {
        return dias;
    }

    /**
     * Método para modificar los días de una Reserva
     * 
     * @param dias de Reserva
     */
    public void setDias(int dias) {
        this.dias = dias;
    }

    /**
     * Método para obtener el costo de una Reserva
     * 
     * @return costo total de la Reserva
     */
    public double getCosto() {
        return costo;
    }

    /**
     * Método para modificar el costo de una Reserva
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

    // --------------------------------------------------------------//

    /**
     * Método para calcular el costo total de una reserva según la tarifa base del
     * Vehículo asociado, los días de Reserva y la tarifa adicional correspondiente
     * 
     * @param vehiculo asociado a la Reserva
     * @param dias de Reserva
     * @return costo total de la Reserva
     */
    public double calcularCosto(Vehiculo vehiculo, int dias) {
        double costo = (dias * vehiculo.getTarifa()) + vehiculo.calcularTarifaAdicional();
        return costo;
    }

}
