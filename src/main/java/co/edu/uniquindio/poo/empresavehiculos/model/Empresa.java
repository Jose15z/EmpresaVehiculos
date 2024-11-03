package co.edu.uniquindio.poo.empresavehiculos.model;

import java.util.Collection;
import java.util.LinkedList;

public class Empresa {
    private String nombre;
    private Collection<Vehiculo> vehiculos;
    private Collection<Reserva> reservas;
    private Collection<Cliente> clientes;

    /**
     * Método constructor de la clase Empresa
     * @param nombre
     */
    public Empresa(String nombre) {
        this.nombre = nombre;
        vehiculos = new LinkedList<>();
        reservas = new LinkedList<>();
        clientes = new LinkedList<>();
    }

    // ----------------MÉTODOS GET Y SET DE LA CLASE-----------------//

    /**
     * Método para obtener el nombre de la empresa
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para modificar el nombre de la empresa
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener la lista de vehículos de la empresa
     * @return
     */
    public Collection<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Método para modificar la lista de vehículos de la empresa
     * @param vehiculos
     */
    public void setVehiculos(Collection<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * Método para obtener la lista de reservas de la empresa
     * @return
     */
    public Collection<Reserva> getReservas() {
        return reservas;
    }

    /**
     * Método para modificar la lista de reservas de la empresa
     * @param reservas
     */
    public void setReservas(Collection<Reserva> reservas) {
        this.reservas = reservas;
    }

    /**
     * Método para obtener la lista de clientes de la empresa
     * @return
     */
    public Collection<Cliente> getClientes() {
        return clientes;
    }

    /**
     * Método para modificar la lista de clientes de la empresa
     * @param clientes
     */
    public void setClientes(Collection<Cliente> clientes) {
        this.clientes = clientes;
    }

    // --------------------------------------------------------------//

    //---------------------------CRUD Vehiculo-----------------------//

    /**
     * Método para evitar la creación de vehiculos duplicados
     * @param placa
     * @return
     */
    public boolean verificarVehiculo(String placa) {
        boolean estaVehiculo = false;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getNumeroMatricula().equals(placa)) {
                estaVehiculo = true;
            }
        }
        return estaVehiculo;
    }

    /**
     * Método para agregar un nuevo vehículo
     * @param vehiculo a agregar
     */
    public void agregarVehiculo(Vehiculo vehiculo){
        if(!verificarVehiculo(vehiculo.getNumeroMatricula())){
            vehiculos.add(vehiculo);
        }
    }

    /**
     * Método para buscar un vehículo
     * @param numeroMatricula del vehículo deseado
     * @return Vehiculo deseado
     */
    public Vehiculo buscarVehiculo(String numeroMatricula){
        Vehiculo vehiculoEncontrado = null;
        for(Vehiculo vehiculo : vehiculos){
            if(vehiculo.getNumeroMatricula().equals(numeroMatricula)){
                vehiculoEncontrado = vehiculo;
            }
        }
        return vehiculoEncontrado;
    }

    /**
     * Método para editar los datos de un vehículo existente
     * @param numeroMatricula del vehículo que se desea editar
     * @param actualizado 
     */
    public void editarVehiculo(String numeroMatricula, Vehiculo actualizado){
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getNumeroMatricula().equals(numeroMatricula)) {
                vehiculo.setNumeroMatricula(actualizado.getNumeroMatricula());
                vehiculo.setMarca(actualizado.getMarca());
                vehiculo.setModelo(actualizado.getModelo());
                vehiculo.setAnioFabricacion(actualizado.getAnioFabricacion());
                break;
            }
        }
    }

    /**
     * Método para eliminar un vehículo
     * @param numeroMatricula del vehículo que se desea eliminar
     */
    public void eliminarVehiculo(String numeroMatricula){
        for(Vehiculo vehiculo : vehiculos){
            if(vehiculo.getNumeroMatricula().equals(numeroMatricula)){
                vehiculos.remove(vehiculo);
                break;
            }
        }
    }

    //-------------------------CRUD Reserva-------------------------//

    /**
     * Método para evitar la creación de reservas duplicadas
     * @param id de la reserva
     * @return 
     */
    public boolean verificarReserva(String id) {
        boolean estaReserva = false;
        for (Reserva reserva : reservas) {
            if (reserva.getId().equals(id)) {
                estaReserva = true;
            }
        }
        return estaReserva;
    }

    /**
     * Método para agregar una nueva reserva
     * @param reserva nueva
     */
    public void agregarReserva(Reserva reserva){
        if(!verificarReserva(reserva.getId())){
            reservas.add(reserva);
        }
    }

    /**
     * Método para buscar una reserva por su id
     * @param id de la reserva deseada
     * @return reserva deseada
     */
    public Reserva buscarReserva(String id){
        Reserva reservaEncontrada = null;
        for(Reserva reserva : reservas){
            if(reserva.getId().equals(id)){
                reservaEncontrada = reserva;
            }
        }
        return reservaEncontrada;
    }

    /**
     * Método para editar una reserva existente
     * @param id de la reserva a editar
     * @param actualizado
     */
    public void editarReserva(String id, Reserva actualizado){
        for (Reserva reserva : reservas) {
            if (reserva.getId().equals(id)) {
                reserva.setId(actualizado.getId());
                reserva.setCliente(actualizado.getCliente());
                reserva.setVehiculo(actualizado.getVehiculo());
                reserva.setDias(actualizado.getDias());
                break;
            }
        }
    }

    /**
     * Método para eliminar una reserva
     * @param id de la reserva a eliminar
     */
    public void eliminarReserva(String id){
        for(Reserva reserva : reservas){
            if(reserva.getId().equals(id)){
                reservas.remove(reserva);
                break;
            }
        }
    }

    //--------------------------------------------------------------//

    //-------------------------CRUD Cliente-------------------------//

    /**
     * Método para evitar la creación de clientes duplicados
     * @param cedula del cliente
     * @return
     */
    public boolean verificarCliente(String cedula) {
        boolean estaCliente = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                estaCliente = true;
            }
        }
        return estaCliente;
    }

    /**
     * Método para agregar un nuevo cliente
     * @param cliente nuevo
     */
    public void agregarCliente(Cliente cliente){
        if(!verificarCliente(cliente.getCedula())){
            clientes.add(cliente);
        }
    }

    /**
     * Método para buscar un cliente
     * @param cedula del cliente deseado
     * @return cliente deseado
     */
    public Cliente buscarCliente(String cedula){
        Cliente clienteEncontrado = null;
        for(Cliente cliente : clientes){
            if(cliente.getCedula().equals(cedula)){
                clienteEncontrado = cliente;
            }
        }
        return clienteEncontrado;
    }

    

    

    /**
     * Método para editar los datos de un cliente existente
     */
    public void editarCliente(String cedula, Cliente actualizado){
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                cliente.setNombre(actualizado.getNombre());
                cliente.setCedula(actualizado.getCedula());
                cliente.setTelefono(actualizado.getTelefono());
                break;
            }
        }
    }
    
    public void eliminarCliente(String cedula){
        for(Cliente cliente : clientes){
            if(cliente.getCedula().equals(cedula)){
                clientes.remove(cliente);
                break;
            }
        }
    }

    //--------------------------------------------------------------//

}
