package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import ucr.lab.HelloApplication;

import java.io.IOException;

public class HelloController {
    @FXML
    private BorderPane bp;
    @FXML
    private AnchorPane ap;
    @FXML
    private Text txtMessage;

    private void loadPage(String page) {
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
        this.txtMessage.setText("Laboratory No. 9");
        this.bp.setCenter(ap);
    }

    @FXML
    void bTreeOperationsOnAction(ActionEvent event) {
        loadPage("bTreeOperations.fxml");
    }

    @FXML
    void bTreeTourOnAction(ActionEvent event) {
        loadPage("transversalT.fxml");
    }

    @FXML
    void graphicBTreeOnAction(ActionEvent event) {
        loadPage("graphicBTree.fxml");
    }

}