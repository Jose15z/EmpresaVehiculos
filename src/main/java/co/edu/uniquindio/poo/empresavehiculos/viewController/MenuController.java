package co.edu.uniquindio.poo.empresavehiculos.viewController;

import java.util.ResourceBundle;
import java.net.URL;
import co.edu.uniquindio.poo.empresavehiculos.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {

    @FXML
    private ResourceBundle resources;

    App app;
    @FXML
    private URL location;

    @FXML
    private Button btnAbrirCrudClientes;

    @FXML
    private Button btnAbrirCrudVehiculos;

    @FXML
    private Button btnAbrirCrudReservas;

    @FXML
    void onOpenCrudClientes() {
        app.openCrudClientes();

    }

    @FXML
    void onOpenCrudReservas() {
        app.openCrudReservas();
    }

    @FXML
    void onOpenCrudVehiculos() {
        app.openCrudVehiculos();
    }

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void initialize() {

    }

}