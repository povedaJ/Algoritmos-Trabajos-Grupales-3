package controller;

import domain.ListException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import ucr.laboratory5.HelloApplication;

import java.io.IOException;

public class EmployeesController {

    @FXML
    private TableColumn<?, ?> BirthdayTableColumn;

    @FXML
    private TableColumn<?, ?> LastNameTableColumn;

    @FXML
    private TableColumn<?, ?> TitleTableColumn;

    @FXML
    private BorderPane bp;

    @FXML
    private TableColumn<?, ?> fNameTableColumn;

    @FXML
    private TableColumn<?, ?> idTableColumn;

    @FXML
    private TableView<?> studentTableView;

    @FXML
    public void initialize() {

    }
    @FXML
    void addSortNameOnAction(ActionEvent event) {

    }

    @FXML
    void btClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
loadPage("addEmployee.fxml");
    }

    @FXML
    void btnContainsOnAction(ActionEvent event) {

    }

    @FXML
    void btnGetNextOnAction(ActionEvent event) {

    }

    @FXML
    void btnPrevOnAction(ActionEvent event) {

    }

    @FXML
    void btnRemoveLastOnAction(ActionEvent event) {

    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {

    }

    @FXML
    void btnSizeOnAction(ActionEvent event) {

    }

    @FXML
    void btnSortbyIdOnAction(ActionEvent event) {

    }
    private void loadPage(String page) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(page));
        try {
            this.bp.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
