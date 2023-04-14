package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import ucr.lab.HelloApplication;

import java.io.IOException;

public class CourseController {

    @FXML
    private BorderPane bp;

    @FXML
    private TableView<?> courseTableView;

    @FXML
    private TableColumn<?, ?> creditsTableColumn;

    @FXML
    private TableColumn<?, ?> idTableColumn;

    @FXML
    private TableColumn<?, ?> nameTableColumn;


    @FXML
    public void initialize() {

    }

    private void loadPage(String page) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(page));
        try {
            this.bp.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void addSortedOnAction(ActionEvent event) {

    }

    @FXML
    void btClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnAddFirstOnAction(ActionEvent event) {

    }

    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnContainsOnAction(ActionEvent event) {

    }

    @FXML
    void btnGetFirstOnAction(ActionEvent event) {

    }

    @FXML
    void btnGetLastOnAction(ActionEvent event) {

    }

    @FXML
    void btnRemoveFirstOnAction(ActionEvent event) {

    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {

    }

    @FXML
    void btnSizeOnAction(ActionEvent event) {

    }


}