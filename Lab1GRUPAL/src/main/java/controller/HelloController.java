package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import ucr.lab1.HelloApplication;
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
    void Example(ActionEvent event) {
        loadPage("example.fxml");
    }

    @FXML
    void Exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void Home(ActionEvent event) {
        this.txtMessage.setText("Laboratory No. 1");
        this.bp.setCenter(ap);
    }

    @FXML
    void Recursive(ActionEvent event) {
        loadPage("recursive.fxml");

    }

    @FXML
    void ThreeSum(ActionEvent event) {
        loadPage("threeSum.fxml");
    }

    @FXML
    void threeSumOnMousePressed(MouseEvent event) {
        this.txtMessage.setText("Loading ThreeSum. Please wait!!!");
        this.bp.setCenter(ap);
    }

    @FXML
    void exampleOnMousePressed(MouseEvent event) {
        this.txtMessage.setText("Loading Example. Please wait!!!");
        this.bp.setCenter(ap);
    }


}
