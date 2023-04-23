module ucr.laboratory5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ucr.laboratory5 to javafx.fxml;
    exports ucr.laboratory5;

    exports controller;
    opens controller to javafx.fxml;

    opens domain to javafx.fxml;
    exports domain;
}