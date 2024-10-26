module co.edu.uniquindio.poo.empresavehiculos {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.empresavehiculos to javafx.fxml;
    exports co.edu.uniquindio.poo.empresavehiculos;
}