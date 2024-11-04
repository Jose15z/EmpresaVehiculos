package co.edu.uniquindio.poo.empresavehiculos;

import java.time.Year;
import javafx.application.Application;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import co.edu.uniquindio.poo.empresavehiculos.model.Auto;
import co.edu.uniquindio.poo.empresavehiculos.model.Camioneta;
import co.edu.uniquindio.poo.empresavehiculos.model.Cliente;
import co.edu.uniquindio.poo.empresavehiculos.model.Empresa;
import co.edu.uniquindio.poo.empresavehiculos.model.Moto;
import co.edu.uniquindio.poo.empresavehiculos.model.Reserva;
import co.edu.uniquindio.poo.empresavehiculos.model.Transmision;
import co.edu.uniquindio.poo.empresavehiculos.model.Vehiculo;
import co.edu.uniquindio.poo.empresavehiculos.viewController.MenuController;
import co.edu.uniquindio.poo.empresavehiculos.viewController.ClienteViewController;
import co.edu.uniquindio.poo.empresavehiculos.viewController.ReservaViewController;
import co.edu.uniquindio.poo.empresavehiculos.viewController.VehiculoViewController;

public class App extends Application{

    private Stage primaryStage;
    public static Empresa empresa = new Empresa("Reservación");

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Gestion de Opciones");
        openViewPrincipal();
    }

    public void openViewPrincipal() {
        inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("menu.fxml"));
            Parent root = loader.load();

            MenuController menuController = loader.getController();
            menuController.setApp(this);

            Scene scene = new Scene(root);
            primaryStage.setScene(scene); // Usar el primaryStage aquí
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch();
    }



    public void openCrudClientes() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudCliente.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            ClienteViewController clienteViewController = loader.getController();
            clienteViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudReservas() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudReserva.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            ReservaViewController reservaViewController = loader.getController();
            reservaViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudVehiculos() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudVehiculo.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            VehiculoViewController vehiculoViewController = loader.getController();
            vehiculoViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void inicializarData(){
        Cliente cliente0 = new Cliente("Camilo", "12345", "323768");
        empresa.agregarCliente(cliente0);

        Cliente cliente1 = new Cliente("Juan", "0987", "231231");
        empresa.agregarCliente(cliente1);
        
        Auto auto0 = new Auto("GXP 748", "KIA", "Sportage", Year.of(2009), (short) 4);
        empresa.agregarVehiculo(auto0);

        Camioneta camioneta0 = new Camioneta("WZR 999", "toyota", "Hilux", Year.of(2022), 235.5);
        empresa.agregarVehiculo(camioneta0);

        Reserva reserva = new Reserva("01", cliente0, auto0, 1);
        empresa.agregarReserva(reserva);
    }
}
