package co.edu.uniquindio.poo.empresavehiculos.viewController;

import co.edu.uniquindio.poo.empresavehiculos.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ReservaViewController {
    private App app;

    public void setApp(App app) {
        this.app = app;
    }
    @FXML
    private TableColumn<?, ?> tbcId;

    @FXML
    private Label lblDias;

    @FXML
    private TableColumn<?, ?> tbcVehiculo;

    @FXML
    private Label lblNombreCliente;

    @FXML
    private TextField txfCosto;

    @FXML
    private TextField txfId;

    @FXML
    private TableView<?> tblReservas;

    @FXML
    private TableColumn<?, ?> tbcDIas;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEditar;

    @FXML
    private TextField txfDias;

    @FXML
    private Label lblId;

    @FXML
    private Label lblReserbas;

    @FXML
    private TableColumn<?, ?> tbcCosto;

    @FXML
    private Label lblCliente;

    @FXML
    private Button btnEliminar;

    @FXML
    private Label lblVehiculo;

    @FXML
    private TextField txfVehiculo;

    @FXML
    private Label lblCosto;

    @FXML
    void onAgregarReservaCliente(ActionEvent event) {

    }

    @FXML
    void onEditarReservaCliente(ActionEvent event) {

    }

    @FXML
    void onEliminarReservaCliente(ActionEvent event) {

    }

    @FXML
    void initialize(){
        
    }
}