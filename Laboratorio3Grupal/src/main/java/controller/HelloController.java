package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import ucr.lab3.HelloApplication;
import java.io.IOException;

public class HelloController {

    @FXML
    private BorderPane bp;
    @FXML
    private AnchorPane ap;
    @FXML
    private Text txtMessage;

    private void loadPage(String page){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(page));
        try {
            this.bp.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void Exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void Home(ActionEvent event) {
        this.txtMessage.setText("Laboratory No. 3");
        this.bp.setCenter(ap);
    }

    @FXML
    void divideAndConquerOnAction(ActionEvent event) {
        loadPage("divideAndConquer.fxml");
    }

    @FXML
    void dynamicOnAction(ActionEvent event) {
        loadPage("dynamic.fxml");
    }

    @FXML
    void probabilisticOnAction(ActionEvent event) {
        loadPage("probabilistic.fxml");
    }

    @FXML
    void vectorOnAction(ActionEvent event) {
        loadPage("vector.fxml");
    }
}