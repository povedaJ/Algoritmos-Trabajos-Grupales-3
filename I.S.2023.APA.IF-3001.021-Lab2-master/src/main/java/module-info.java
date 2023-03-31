module ucr.lab2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ucr.lab2 to javafx.fxml;
    exports ucr.lab2;
    exports controller;
    opens controller to javafx.fxml;
}