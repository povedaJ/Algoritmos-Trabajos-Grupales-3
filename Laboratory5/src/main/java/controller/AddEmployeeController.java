package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import ucr.laboratory5.HelloApplication;

import java.io.IOException;

public class AddEmployeeController {

    @FXML
    private DatePicker DatePickerBirthday;

    @FXML
    private BorderPane bp;

    @FXML
    private TextField textFieldFirtsName;

    @FXML
    private TextField textFieldID;

    @FXML
    private TextField textFieldLastName;

    @FXML
    private TextField textFieldTitle;

    @FXML
    void btnAdd(ActionEvent event) {

    }

    @FXML
    void btnClean(ActionEvent event) {
this.textFieldFirtsName.clear();
this.textFieldID.clear();
this.textFieldLastName.clear();
this.textFieldTitle.clear();
this.DatePickerBirthday.cancelEdit();
    }

    @FXML
    void btnCloseOnAction(ActionEvent event) {
loadPage("employees.fxml");
    }

    @FXML
    void onKeyTypeCreditsValidation(KeyEvent event) {

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
