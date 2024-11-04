package co.edu.uniquindio.poo.empresavehiculos.controller;

import co.edu.uniquindio.poo.empresavehiculos.model.Auto;
import co.edu.uniquindio.poo.empresavehiculos.model.Camioneta;
import co.edu.uniquindio.poo.empresavehiculos.model.Moto;
import co.edu.uniquindio.poo.empresavehiculos.model.Vehiculo;
import co.edu.uniquindio.poo.empresavehiculos.model.Transmision; // Asegúrate de importar Transmision
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class VehiculoController {

    private List<Vehiculo> vehiculos;

    public VehiculoController() {
        vehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(String marca, String modelo, String matricula, String año, String tipo, List<Node> specificFields) {
        Vehiculo nuevoVehiculo = null;
        Year anioFabricacion = Year.parse(año);
    
        switch (tipo) {
            case "Moto":
                if (specificFields.get(1) instanceof ComboBox) {
                    // Suponiendo que el ComboBox contiene valores del enum Transmision
                    Transmision transmision = ((ComboBox<Transmision>) specificFields.get(1)).getValue();
                    if (transmision != null) {
                        nuevoVehiculo = new Moto(matricula, marca, modelo, anioFabricacion, transmision);
                    } else {
                        System.out.println("Transmisión no seleccionada.");
                    }
                }
                break;
            case "Auto":
                if (specificFields.get(1) instanceof TextField) {
                    short numPuertas = Short.parseShort(((TextField) specificFields.get(1)).getText());
                    nuevoVehiculo = new Auto(matricula, marca, modelo, anioFabricacion, numPuertas);
                }
                break;
            case "Camioneta":
                if (specificFields.get(1) instanceof TextField) {
                    double capacidadCarga = Double.parseDouble(((TextField) specificFields.get(1)).getText());
                    nuevoVehiculo = new Camioneta(matricula, marca, modelo, anioFabricacion, capacidadCarga);
                }
                break;
        }
    
        if (nuevoVehiculo != null) {
            crearVehiculo(nuevoVehiculo);
        } else {
            System.out.println("Error al crear el vehículo: verifique los datos de entrada.");
        }
    }
    

    public void crearVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public boolean eliminarVehiculo(Vehiculo vehiculo) {
        return vehiculos.remove(vehiculo);
    }

    public boolean editarVehiculo(Vehiculo vehiculoActualizado) {
        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo vehiculo = vehiculos.get(i);
            if (vehiculo.getNumeroMatricula().equals(vehiculoActualizado.getNumeroMatricula())) {
                vehiculos.set(i, vehiculoActualizado);
                return true;
            }
        }
        return false;
    }

    public List<Vehiculo> obtenerListaVehiculos() {
        return new ArrayList<>(vehiculos);
    }

    public Vehiculo crearVehiculo(String marca, String modelo, String matricula, int año, String tipo,
            ObservableList<Node> children) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearVehiculo'");
    }
}
