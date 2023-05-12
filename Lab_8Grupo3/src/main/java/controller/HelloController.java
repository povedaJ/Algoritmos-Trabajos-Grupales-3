
package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
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
        this.txtMessage.setText("Laboratory No. 8");
        this.bp.setCenter(ap);
    }

    @FXML
    void bubbleSortOnAction(ActionEvent event) {
        loadPage("bubbleSort.fxml");
    }

    @FXML
    void countingSortOnAction(ActionEvent event) {
        loadPage("countingSort.fxml");
    }

    @FXML
    void improvedBubbleSortOnAction(ActionEvent event) {
        loadPage("improvedBubbleSort.fxml");
    }

    @FXML
    void mergeSortOnAction(ActionEvent event) {
        loadPage("mergeSort.fxml");
    }

    @FXML
    void quixkSortOnAction(ActionEvent event) {
        loadPage("quickSort.fxml");
    }

    @FXML
    void radixSortOnAction(ActionEvent event) {
        loadPage("radixSort.fxml");
    }

    @FXML
    void selectionSortOnAction(ActionEvent event) {
        loadPage("selectionSort.fxml");
    }

    @FXML
    void shellSortOnAction(ActionEvent event) {
        loadPage("shellSort.fxml");
    }

}