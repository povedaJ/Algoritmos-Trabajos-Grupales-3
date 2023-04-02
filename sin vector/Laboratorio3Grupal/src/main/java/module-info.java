module ucr.lab3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ucr.lab3 to javafx.fxml;
    exports ucr.lab3;
    exports controller;
    opens controller to javafx.fxml;
}