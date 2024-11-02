module co.edu.uniquindio.poo.empresavehiculos {
    requires javafx.controls;
    requires javafx.fxml;

    exports co.edu.uniquindio.poo.empresavehiculos.viewController;
    exports co.edu.uniquindio.poo.empresavehiculos;
    opens co.edu.uniquindio.poo.empresavehiculos.viewController to javafx.fxml;
    opens co.edu.uniquindio.poo.empresavehiculos to javafx.fxml;
}