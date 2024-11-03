package co.edu.uniquindio.poo.empresavehiculos.controller;

import co.edu.uniquindio.poo.empresavehiculos.model.Reserva;
import co.edu.uniquindio.poo.empresavehiculos.model.Cliente;
import co.edu.uniquindio.poo.empresavehiculos.model.Empresa;
import java.util.Collection;

public class ReservaController {
    Empresa empresa;

     public ReservaController(Empresa empresa) {
        this.empresa = empresa;
    }

    public void crearReserva(Reserva reserva) {
        empresa.agregarReserva(reserva);
    }

    public Collection<Reserva> obtenerListarReservas() {
        return empresa.getReservas();
    }

    public void eliminarReserva(String id) {
       empresa.eliminarReserva(id);
    }

    public void editarReserva(String id, Reserva reserva) {
       empresa.editarReserva(id, reserva);
    }

    
}

