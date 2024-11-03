package co.edu.uniquindio.poo.empresavehiculos.viewController;

import co.edu.uniquindio.poo.empresavehiculos.App;
import co.edu.uniquindio.poo.empresavehiculos.model.Cliente;
import co.edu.uniquindio.poo.empresavehiculos.model.Reserva;
import co.edu.uniquindio.poo.empresavehiculos.model.Vehiculo;
import co.edu.uniquindio.poo.empresavehiculos.controller.ClienteController;
import co.edu.uniquindio.poo.empresavehiculos.controller.ReservaController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class ReservaViewController {

    ReservaController reservaController;
    ObservableList<Reserva> listReservas = FXCollections.observableArrayList();
    Reserva selectedReserva;
    private App app;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Reserva, String> tbcId;

    @FXML
    private Label lblDias;

    @FXML
    private TableColumn<Reserva, Vehiculo> tbcVehiculo;

    @FXML
    private TextField txfCosto;

    @FXML
    private TextField txfId;

    @FXML
    private TableColumn<Reserva, Integer> tbcDias;

    @FXML
    private Button btnEditar;

    @FXML
    private TextField txfDias;

    @FXML
    private Label lblId;

    @FXML
    private Label lblReserbas;

    @FXML
    private TableColumn<Reserva, Double> tbcCosto;

    @FXML
    private TextField txfClienteReserva;

    @FXML
    private TableView<Reserva> tblListaReservas;

    @FXML
    private Label lblCliente;

    @FXML
    private TableColumn<?, ?> tbcCliente;

    @FXML
    private Button btnAgregarReserva;

    @FXML
    private Button btnEliminarReserva;

    @FXML
    private Label lblVehiculo;

    @FXML
    private TextField txfVehiculo;

    @FXML
    private Label lblCosto;

    @FXML
    void onAgregarReservaCliente() {
        agregarReserva();
    }

    @FXML
    void onEditarReserva() {
        editarReserva();
    }

    @FXML
    void onEliminarReservaCliente() {
        eliminarReserva();
    }


    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerReservas();

        // Limpiar la tabla
        tblListaReservas.getItems().clear();

        // Agregar los elementos a la tabla
        tblListaReservas.setItems(listClientes);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    @FXML
    void initialize() {
        reservaController = new ReservaController(app.empresa);
        initView();
    }

    public void setApp(App app) {
        this.app = app;
    }

}