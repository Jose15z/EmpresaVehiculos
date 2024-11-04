package co.edu.uniquindio.poo.empresavehiculos.controller;

import co.edu.uniquindio.poo.empresavehiculos.model.Cliente;
import co.edu.uniquindio.poo.empresavehiculos.model.Empresa;
import java.util.Collection;

public class ClienteController {

    Empresa empresa;

    public ClienteController(Empresa empresa) {
        this.empresa = empresa;
    }

    public void crearCliente(Cliente cliente) {
        empresa.agregarCliente(cliente);
    }

    public Collection<Cliente> obtenerListaClientes() {
        return empresa.getClientes();
    }

    public void eliminarCliente(String cedula) {
       empresa.eliminarCliente(cedula);
    }

    public void editarCliente(String cedula, Cliente cliente) {
       empresa.editarCliente(cedula, cliente);
    }

    
}