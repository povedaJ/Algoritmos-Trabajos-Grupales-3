package controller;


import domain.Course;
import domain.DoublyLinkedList;
import domain.ListException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import ucr.lab.HelloApplication;

import java.io.IOException;

public class AddCourseSortedController {

    @FXML
    private BorderPane bp;

    @FXML
    private TextField textFieldCredits;

    @FXML
    private TextField textFieldID;

    @FXML
    private TextField textFieldName;
    private DoublyLinkedList courseList;
    private Alert alert;
    @FXML
    public void initialize() {
        //cargamos la lista desde la clase Utility
        this.courseList = util.Utility.getCourseList();
        this.alert = util.FXUtility.alert("Courses Doubly Linked List", "Add courses...");
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
        return !this.textFieldID.getText().isEmpty()||!this.textFieldName.getText().isEmpty()||
                !this.textFieldCredits.getText().isEmpty();
    }

    @FXML
    void btnAdd(ActionEvent event) {
        alert.setHeaderText("Adding students...");
        try {
            if (isValid()) {
                int credits = Integer.parseInt(this.textFieldCredits.getText());
                Course newCourse = new Course(
                        this.textFieldID.textProperty().getValue(),
                        this.textFieldName.textProperty().getValue(),
                        credits);
                if (courseList.isEmpty() || !courseList.contains(newCourse)) {
                    courseList.add(newCourse);
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setContentText("The course was added to the list");
                    //tenemos que settear la lista de la clase Utility
                    //actualizo la lista global
                    util.Utility.setCourseList(courseList);
                    courseList.sort();
                } else {
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText("The course already exists in the list");
                }
            } else {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Complete the form with \nthe information, please");
            }
            alert.showAndWait();
            btnClean(event); //llama al boton de limpiar

        } catch (ListException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    void btnClean(ActionEvent event) {
        this.textFieldID.clear();
        this.textFieldName.clear();
        this.textFieldCredits.clear();
    }

    @FXML
    void btnCloseOnAction(ActionEvent event)  {
        loadPage("course.fxml");
    }

    @FXML
    void onKeyTypeCreditsValidation(KeyEvent event) {

    }


}