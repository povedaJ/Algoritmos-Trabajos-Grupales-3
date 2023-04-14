package controller;

import domain.ListException;
import domain.SinglyLinkedList;
import domain.Student;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.event.Event;
import ucr.lab.HelloApplication;

import java.io.IOException;

public class AddStudentController
{
    @FXML
    private BorderPane bp;
    @FXML
    private TextField textFieldID;
    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldAge;
    @FXML
    private TextField textAreaAddress;
    private SinglyLinkedList studentList;
    private Alert alert;

    @FXML
    public void initialize() {
        //cargamos la lista desde la clase Utility
        this.studentList = util.Utility.getStudentList();
        this.alert = util.FXUtility.alert("Students Singly Linked List", "Add Students...");
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
    public void onKeyTypeAgeValidation(Event event) { // para que solo me deje agregar el tipo de dato que recibe
    }

    @Deprecated
    public void btnAdd(ActionEvent actionEvent) {
        alert.setHeaderText("Adding students...");
        try{
            if(isValid()){
                int age = Integer.parseInt(this.textFieldAge.getText());
                Student newStudent = new Student(
                        this.textFieldID.textProperty().getValue(),
                        this.textFieldName.textProperty().getValue(),
                        age, this.textAreaAddress.textProperty().getValue()
                );
                if(studentList.isEmpty()||!studentList.contains(newStudent)){
                    studentList.add(newStudent);
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setContentText("The student was added to the list");
                    //tenemos que settear la lista de la clase Utility
                    //actualizo la lista global
                    util.Utility.setStudentList(studentList);
                }else{
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText("The student already exists in the list");
                }
            }else{
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Complete the form with \nthe information, please");
            }
            alert.showAndWait();
            btnClean(actionEvent); //llama al boton de limpiar
        }catch (ListException ex){
            System.out.println(ex.getMessage());
        }
    }

    private boolean isValid(){
        return !this.textFieldID.getText().isEmpty();
    }

    @Deprecated
    public void btnClean(ActionEvent actionEvent) {
    }

    public void btnCloseOnAction(ActionEvent actionEvent) {
        loadPage("student.fxml");
    }
}