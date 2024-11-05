package co.edu.uniquindio.poo.empresavehiculos.viewController;

import co.edu.uniquindio.poo.empresavehiculos.App;
import co.edu.uniquindio.poo.empresavehiculos.model.*;
import co.edu.uniquindio.poo.empresavehiculos.controller.VehiculoController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.time.Year;

public class VehiculoViewController {

    @FXML
    private Button btnInicio;
    @FXML
    private TextField txfMarca, txfModelo, txfMatricula, txfAño;
    @FXML
    private ComboBox<String> cmbTipoVehiculo;
    @FXML
    private VBox vboxSpecificFields;
    @FXML
    private TableView<Vehiculo> tblListVehiculos;
    @FXML
    private TableColumn<Vehiculo, String> tbcMarca, tbcModelo, tbcMatricula, tbcAño;

    private ObservableList<Vehiculo> listVehiculos = FXCollections.observableArrayList();
    private VehiculoController vehiculoController;
    private Vehiculo selectedVehiculo;
    private App app;

    private ComboBox<Transmision> comboBoxTransmision;

    @FXML
    void onAbrirMenu() {
        app.openViewPrincipal();
    }

    @FXML
    public void initialize() {
        vehiculoController = new VehiculoController(app.empresa);
        cmbTipoVehiculo.getItems().addAll("Moto", "Auto", "Camioneta");
        cmbTipoVehiculo.setOnAction(event -> actualizarCamposEspecificos());
        initView();
    }

    private void actualizarCamposEspecificos() {
        vboxSpecificFields.getChildren().clear();
        String tipoVehiculo = cmbTipoVehiculo.getValue();

        switch (tipoVehiculo) {
            case "Moto":
                agregarCampoTransmision();
                break;
            case "Auto":
                agregarCampoNumPuertas();
                break;
            case "Camioneta":
                agregarCampoCapacidadCarga();
                break;
        }
    }

    private void agregarCampoTransmision() {
        Label label = new Label("Transmisión:");
        comboBoxTransmision = new ComboBox<>();

        comboBoxTransmision.getItems().addAll(Transmision.values());

        vboxSpecificFields.getChildren().addAll(label, comboBoxTransmision);
    }

    private void agregarCampoNumPuertas() {
        Label label = new Label("Número de Puertas:");
        TextField textField = new TextField();
        vboxSpecificFields.getChildren().addAll(label, textField);
    }

    private void agregarCampoCapacidadCarga() {
        Label label = new Label("Capacidad de Carga:");
        TextField textField = new TextField();
        vboxSpecificFields.getChildren().addAll(label, textField);
    }

    @FXML
    public void onAgregarVehiculo() {
        String marca = txfMarca.getText();
        String modelo = txfModelo.getText();
        String matricula = txfMatricula.getText();
        String año = txfAño.getText();
        String tipo = cmbTipoVehiculo.getValue();

        vehiculoController.agregarVehiculo(marca, modelo, matricula, año, tipo, vboxSpecificFields.getChildren());
        obtenerVehiculos();
        limpiarCamposVehiculo();
    }

    @FXML
    public void onEliminarVehiculo() {
        if (selectedVehiculo != null) {
            vehiculoController.eliminarVehiculo(selectedVehiculo);
            obtenerVehiculos();
            limpiarCamposVehiculo();
        }
    }

    @FXML
    public void onEditarVehiculo() {
        if (selectedVehiculo != null) {
            Vehiculo vehiculoActualizado = buildVehiculo();
            vehiculoController.editarVehiculo(vehiculoActualizado);
            obtenerVehiculos();
            limpiarCamposVehiculo();
        }
    }

    @FXML
    public void onLimpiarSeleccion() {
        limpiarCamposVehiculo();
    }

    public Vehiculo buildVehiculo() {
        String marca = txfMarca.getText();
        String modelo = txfModelo.getText();
        String matricula = txfMatricula.getText();
        Year anio = Year.parse(txfAño.getText());
        String tipoVehiculo = cmbTipoVehiculo.getValue();

        switch (tipoVehiculo) {
            case "Moto":
                Transmision transmision = comboBoxTransmision.getValue();
                return new Moto(matricula, marca, modelo, anio, transmision);

            case "Auto":
                TextField textFieldNumPuertas = (TextField) vboxSpecificFields.getChildren().get(1);
                short numPuertas = Short.parseShort(textFieldNumPuertas.getText());
                return new Auto(matricula, marca, modelo, anio, numPuertas);

            case "Camioneta":
                TextField textFieldCapacidadCarga = (TextField) vboxSpecificFields.getChildren().get(1);
                double capacidadCarga = Double.parseDouble(textFieldCapacidadCarga.getText());
                return new Camioneta(matricula, marca, modelo, anio, capacidadCarga);

            default:
                throw new IllegalArgumentException("Tipo de vehículo no válido");
        }
    }

    private void limpiarCamposVehiculo() {
        txfAño.clear();
        txfMarca.clear();
        txfMatricula.clear();
        txfModelo.clear();
        if (comboBoxTransmision != null) {
            comboBoxTransmision.getSelectionModel().clearSelection();
        }
    }

    public void setApp(App app) {
        this.app = app;
    }

    private void initView() {
        initDataBinding();
        obtenerVehiculos();
        tblListVehiculos.setItems(listVehiculos);
        listenerSelection();
    }

    private void obtenerVehiculos() {
        listVehiculos.clear();
        listVehiculos.addAll(vehiculoController.obtenerListaVehiculos());
    }

    private void listenerSelection() {
        tblListVehiculos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedVehiculo = newSelection;
            mostrarInformacionVehiculo(selectedVehiculo);
        });
    }

    private void mostrarInformacionVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null) {
            txfMarca.setText(vehiculo.getMarca());
            txfModelo.setText(vehiculo.getModelo());
            txfMatricula.setText(vehiculo.getNumeroMatricula());
            txfAño.setText(String.valueOf(vehiculo.getAnioFabricacion().getValue()));
        }
    }

    private void initDataBinding() {
        tbcMarca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
        tbcModelo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
        tbcMatricula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumeroMatricula()));
        tbcAño.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAnioFabricacion().getValue())));
    }
}
