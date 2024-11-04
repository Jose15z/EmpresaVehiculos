package co.edu.uniquindio.poo.empresavehiculos.viewController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import co.edu.uniquindio.poo.empresavehiculos.App;
import co.edu.uniquindio.poo.empresavehiculos.controller.ClienteController;
import co.edu.uniquindio.poo.empresavehiculos.model.Cliente;



public class ClienteViewController {
    ClienteController clienteController;
    ObservableList<Cliente> listClientes = FXCollections.observableArrayList();
    Cliente selectedCliente;
    private App app;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnInicio;

    @FXML
    private Button btnVerReservasCliente;

    @FXML
    private Button btnLimpiarSeleccion;

    @FXML
    private TableView<Cliente> tblListaClientes;

    @FXML
    private TextField txfTelefono;

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblTitulo;

    @FXML
    private TableColumn<Cliente, String> tbcCedula;

    @FXML
    private Label lblTelefono;

    @FXML
    private TableColumn<Cliente, String> tbcTelefono;

    @FXML
    private Button btnEditarCliente;

    @FXML
    private TextField txfCedula;

    @FXML
    private Button btnEliminarCliente;

    @FXML
    private Label lblCedula;

    @FXML
    private TableColumn<Cliente, String> tbcNombre;

    @FXML
    private Button btnAgregarCliente;

    @FXML
    private TextField txfNombre;


    @FXML
    void onAgregarCliente() {
        agregarCliente();
    }

    @FXML
    void onEditarCliente() {
        editarCliente();
    }

    @FXML
    void onEliminarCliente() {
        eliminarCliente();
    }

    @FXML
    void onLimpiarSeleccion() {
        limpiarSeleccion();
    }

    @FXML
    void onAbrirMenu() {
        app.openViewPrincipal();
    }


    
    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerClientes();

        // Limpiar la tabla
        tblListaClientes.getItems().clear();

        // Agregar los elementos a la tabla
        tblListaClientes.setItems(listClientes);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void initDataBinding() {
        tbcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tbcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void obtenerClientes() {
        listClientes.addAll(clienteController.obtenerListaClientes());
    }

    private void listenerSelection() {
        tblListaClientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedCliente = newSelection;
            mostrarInformacionCliente(selectedCliente);
        });
    }

    private void mostrarInformacionCliente(Cliente cliente) {
        if (cliente != null) {
            txfNombre.setText(cliente.getNombre());
            txfCedula.setText(cliente.getCedula());
            txfTelefono.setText(cliente.getTelefono());
        }
    }

    private void agregarCliente() {
        Cliente cliente = buildCliente();
        clienteController.crearCliente(cliente);
        listClientes.add(cliente);
        limpiarCamposCliente();
        
    }

    private Cliente buildCliente() {
        Cliente cliente = new Cliente(txfNombre.getText(), txfCedula.getText(), txfTelefono.getText());
        return cliente;
    }

    private void eliminarCliente() {
        clienteController.eliminarCliente(txfCedula.getText());
        listClientes.remove(selectedCliente);
        limpiarCamposCliente();
        limpiarSeleccion();
        
    }

    private void editarCliente() {

        clienteController.editarCliente(selectedCliente.getCedula(), buildCliente()); 

        int index = listClientes.indexOf(selectedCliente);
        if (index >= 0) {
            listClientes.set(index, buildCliente());
        }

        tblListaClientes.refresh();
        limpiarSeleccion();
    }
    
    private void limpiarSeleccion() {
        tblListaClientes.getSelectionModel().clearSelection();
        limpiarCamposCliente();
    }
    
    private void limpiarCamposCliente() {
        txfNombre.clear();
        txfCedula.clear();
        txfTelefono.clear();
    }

    @FXML
    void initialize() {
        clienteController = new ClienteController(app.empresa);
        initView();
    }

    public void setApp(App app) {
        this.app = app;
    }
}
