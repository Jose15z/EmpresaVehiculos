package co.edu.uniquindio.poo.empresavehiculos.viewController;

import co.edu.uniquindio.poo.empresavehiculos.App;
import co.edu.uniquindio.poo.empresavehiculos.model.Cliente;
import co.edu.uniquindio.poo.empresavehiculos.model.Reserva;
import co.edu.uniquindio.poo.empresavehiculos.model.Vehiculo;
import co.edu.uniquindio.poo.empresavehiculos.controller.ClienteController;
import co.edu.uniquindio.poo.empresavehiculos.controller.ReservaController;
import co.edu.uniquindio.poo.empresavehiculos.controller.VehiculoController;

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

public class VehiculoViewController {

    VehiculoController vehiculoController;
    ObservableList<Vehiculo> listVehiculos = FXCollections.observableArrayList();
    Vehiculo selectedVehiculo;
    private App app;

    @FXML
    private TextField txfAño;

    @FXML
    private Button btnVerReservasCliente;

    @FXML
    private TableColumn<Vehiculo, String> tbcMarca;

    @FXML
    private TableColumn<Vehiculo, String> tbcMatricula;

    @FXML
    private Label lblAño;

    @FXML
    private Button btnEditarVehiculo;

    @FXML
    private TableColumn<Vehiculo, String> tbcAño;

    @FXML
    private Label lblMarca;

    @FXML
    private Button btnAgregarVehiculo;

    @FXML
    private TextField txfMatricula;

    @FXML
    private TextField txfModelo;

    @FXML
    private TableView<Vehiculo> tblListVehiculos;

    @FXML
    private Button btnEliminarCliente;

    @FXML
    private TableColumn<Vehiculo, String> tbcModelo;

    @FXML
    private Button btnVerReservasCliente1;

    @FXML
    private TextField txfMarca;

    @FXML
    private Label lblMatricula;

    @FXML
    private Label lblModelo;

    @FXML
    void onAgregarVehiculo(ActionEvent event) {
        agregarVehiculo();
    }

    @FXML
    void onVerVehiculo(ActionEvent event) {
        
    }

    @FXML
    void onEliminarVehiculo(ActionEvent event) {

    }

    @FXML
    void onEditarVehiculo(ActionEvent event) {

    }

    public void agregarVehiculo(){
        Vehiculo vehiculo = buildVehiculo();
        vehiculoController.crearVehiculo(vehiculo);
        listVehiculos.add(vehiculo);
        limpiarCamposVehiculo();
        
    }
    
    

    public void limpiarCamposVehiculo(){
        txfAño.clear();
        txfMarca.clear();
        txfMatricula.clear();
        txfModelo.clear();
    }
    
    @FXML
    void initialize() {
        vehiculoController = new VehiculoController(app.empresa);
        initView();
    }

    public void setApp(App app) {
        this.app = app;
    }

    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerVehiculos();

        // Limpiar la tabla
        tblListVehiculos.getItems().clear();

        // Agregar los elementos a la tabla
        tblListVehiculos.setItems(listVehiculos);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void obtenerVehiculos() {
        listVehiculos.addAll(vehiculoController.obtenerListaVehiculos());
    }

    private void listenerSelection(){
        tblListVehiculos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedVehiculo = newSelection;
            mostrarInformacionVehiculo(selectedVehiculo);
        });
    }

    private void mostrarInformacionVehiculo(Vehiculo vehiculo){
        if(vehiculo != null){
            txfMarca.setText(vehiculo.getMarca());
            txfModelo.setText(vehiculo.getModelo());
            txfMatricula.setText(vehiculo.getNumeroMatricula());
            txfAño.setText(String.valueOf(vehiculo.getAnioFabricacion()));
        }
    }

    private void initDataBinding(){
        tbcMarca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
        tbcModelo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
        tbcMatricula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumeroMatricula()));
        tbcAño.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getAnioFabricacion()).asObject());
    }

    

}
