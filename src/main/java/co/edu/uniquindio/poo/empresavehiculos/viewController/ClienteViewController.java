package co.edu.uniquindio.poo.empresavehiculos.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import co.edu.uniquindio.poo.empresavehiculos.App;
import co.edu.uniquindio.poo.empresavehiculos.controller.ClienteController;
import co.edu.uniquindio.poo.empresavehiculos.model.Cliente;



public class ClienteViewController {
    ClienteController clienteController;
    private App app;

    @FXML
    private Label lblTitulo;

    @FXML
    void initialize() {
        clienteController = new ClienteController(app.empresa);
    }


    public void setApp(App app) {
        this.app = app;
    }
}
