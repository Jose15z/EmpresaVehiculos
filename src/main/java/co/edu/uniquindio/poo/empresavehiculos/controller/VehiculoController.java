package co.edu.uniquindio.poo.empresavehiculos.controller;
import co.edu.uniquindio.poo.empresavehiculos.model.Vehiculo;
import co.edu.uniquindio.poo.empresavehiculos.model.Empresa;
import java.util.Collection;

public class VehiculoController {
    Empresa empresa;

    public VehiculoController(Empresa empresa){
        this.empresa = empresa;
    }

    public void crearVehiculo(Vehiculo vehiculo){
        empresa.agregarVehiculo(vehiculo);
    }

    public Collection<Vehiculo> obtenerListaVehiculos(){
        return empresa.getVehiculos();
    }

    public void eliminarVehiculo(String placa){
        empresa.eliminarVehiculo(placa);
    }

    public void EditarVehiculo(String placa, Vehiculo vehiculo){
        empresa.editarVehiculo(placa,vehiculo);
    }
}
