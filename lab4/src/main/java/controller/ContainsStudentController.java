package controller;

import domain.ListException;
import domain.SinglyLinkedList;
import domain.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import ucr.lab.HelloApplication;

import java.io.IOException;

public class ContainsStudentController {

    @FXML
    private BorderPane bp;

    @FXML
    private TextField textAreaAddress;

    @FXML
    private TextField textFieldAge;

    @FXML
    private TextField textFieldID;

    @FXML
    private TextField textFieldName;
    private SinglyLinkedList studentList;
    private Alert alert;


    @FXML
    public void initialize() {
        //cargamos la lista desde la clase Utility
        this.studentList = util.Utility.getStudentList();
        this.alert = util.FXUtility.alert("Students Singly Linked List", "Contains Students...");
    }

    private void loadPage(String page) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(page));
        try {
            this.bp.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private boolean isValid() {
        return !this.textFieldID.getText().isEmpty();
    }
    @FXML
    void btnClean(ActionEvent event) {
        this.textFieldID.clear();
        this.textFieldName.clear();
        this.textFieldAge.clear();
        this.textAreaAddress.clear();
    }

    @FXML
    void btnCloseOnAction(ActionEvent event) {
        loadPage("student.fxml");
    }

    @FXML
    void btnContains(ActionEvent event) {
        alert.setHeaderText("Contains student ...");
        try {
            if (isValid()) {
                int age = Integer.parseInt(this.textFieldAge.getText());
                Student newStudent = new Student(
                        this.textFieldID.textProperty().getValue(),
                        this.textFieldName.textProperty().getValue(),
                        age, this.textAreaAddress.textProperty().getValue()
                );
                if (!studentList.isEmpty() || studentList.contains(newStudent)) {

                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setContentText("The student exists in the list, position: "+studentList.indexOf(newStudent));
                    //tenemos que settear la lista de la clase Utility
                    //actualizo la lista global

                } else {
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText("The student don't exists in the list");
                }
            } else {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Complete the form with \nthe information, please");
            }
            alert.showAndWait();
            btnCloseOnAction(event); //llama al boton de limpiar
        } catch (ListException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    void onKeyTypeAgeValidation(KeyEvent event) {

    }

}
