package co.edu.uniquindio.poo.empresavehiculos.viewController;

import co.edu.uniquindio.poo.empresavehiculos.App;
import co.edu.uniquindio.poo.empresavehiculos.model.Cliente;
import co.edu.uniquindio.poo.empresavehiculos.model.Reserva;
import co.edu.uniquindio.poo.empresavehiculos.model.Vehiculo;
import co.edu.uniquindio.poo.empresavehiculos.controller.ClienteController;
import co.edu.uniquindio.poo.empresavehiculos.controller.ReservaController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
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
    private TableColumn<Reserva, String> tbcVehiculo;

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
    private TableColumn<Reserva, String> tbcCliente;

    @FXML
    private Button btnAgregarReserva;

    @FXML
    private Button btnEliminarReserva;

    @FXML
    private Label lblVehiculo;

    @FXML
    private TextField txfVehiculo;

   

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
        tblListaReservas.setItems(listReservas);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void obtenerReservas() {
        listReservas.addAll(reservaController.obtenerListarReservas());
    }

    private void listenerSelection(){
        tblListaReservas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedReserva = newSelection;
            mostrarInformacionReserva(selectedReserva);
        });
    }

    private void mostrarInformacionReserva(Reserva reserva){
        if(reserva != null){
            txfId.setText(reserva.getId());
            txfClienteReserva.setText(reserva.getCliente().getCedula());
            txfVehiculo.setText(reserva.getVehiculo().getNumeroMatricula());
            txfDias.setText(String.valueOf(reserva.getDias()));
        }
    }

    private void agregarReserva(){
        Reserva reserva = buildReserva();
        reservaController.crearReserva(reserva);
        listReservas.add(reserva);
        limpiarCamposReserva();
    }

    private void editarReserva(){

        reservaController.editarReserva(selectedReserva.getId(), buildReserva());

        int index = listReservas.indexOf(selectedReserva);
        if(index>=0){
            listReservas.set(index, buildReserva());
        }

        tblListaReservas.refresh();
        limpiarSeleccion();
        
    }

    private void limpiarSeleccion() {
        tblListaReservas.getSelectionModel().clearSelection();
        limpiarCamposReserva();
    }

    private Reserva buildReserva(){
        Reserva reserva = new Reserva(txfId.getText(), app.empresa.buscarCliente(txfClienteReserva.getText()) , app.empresa.buscarVehiculo(txfVehiculo.getText()), Integer.parseInt(txfDias.getText()));
        return reserva;
    }

    private void eliminarReserva(){

        reservaController.eliminarReserva(txfId.getText());
        listReservas.remove(selectedReserva);
        limpiarSeleccion();
    }
    private void limpiarCamposReserva(){
        txfClienteReserva.clear();
        txfDias.clear();
        txfId.clear();
        txfVehiculo.clear();
    }
    private void initDataBinding(){
        tbcCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCliente().getCedula()));
        tbcId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        tbcVehiculo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVehiculo().getNumeroMatricula()));
        tbcDias.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getDias()));
        tbcCosto.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getVehiculo().calcularTarifaAdicional()));
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