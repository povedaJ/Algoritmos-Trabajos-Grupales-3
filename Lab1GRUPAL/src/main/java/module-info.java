module ucr.lab1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ucr.lab1 to javafx.fxml;
    exports ucr.lab1;
    exports controller;
    opens controller to javafx.fxml;
}