package controller;

import domain.ListException;
import domain.SinglyLinkedList;
import domain.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import ucr.lab.HelloApplication;
import javafx.fxml.FXML;
import util.FXUtility;

import java.io.IOException;

public class StudentController {
    @FXML
    private BorderPane bp;
    @FXML
    private TableView<Student> studentTableView;
    @FXML
    private TableColumn<Student, String> idTableColumn;
    @FXML
    private TableColumn<Student, String> nameTableColumn;
    @FXML
    private TableColumn<Student, Integer> ageTableColumn;
    @FXML
    private TableColumn<Student, String> addressTableColumn;
    private SinglyLinkedList studentList;
    private Alert alert;
    private Dialog dialog;

    @FXML
    public void initialize() {
        //cargamos la lista desde la clase Utility
        this.studentList = util.Utility.getStudentList();
        this.idTableColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        this.nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        this.ageTableColumn.setCellValueFactory(new PropertyValueFactory<>("Age"));
        this.addressTableColumn.setCellValueFactory(new PropertyValueFactory<>("Address"));
        updateTableView(studentList);
    }

    public void updateTableView(SinglyLinkedList studentList) {
        try {
            this.alert = util.FXUtility.alert("Student List", "Display Students");
            alert.setAlertType(Alert.AlertType.ERROR);
            if (this.studentList != null && !this.studentList.isEmpty()) {
                int n = studentList.size();
                for (int i = 1; i <= n; i++) {
                    this.studentTableView.getItems().add((Student) studentList.getNode(i).data);

                }
            }
        } catch (ListException ex) {
            alert.setContentText("Student list is empty");
            alert.showAndWait();
        }
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
        if (studentList.isEmpty()) {
            alert.setContentText("Student list is empty");
            alert.showAndWait();
        } else {


            String decision = util.FXUtility.alertYesNo("Student List", "Delete ALL items from the list ", "Are you sure?");
            if (decision.equals("YES")) {
                studentTableView.getItems().clear();
                studentList.clear();
                alert = util.FXUtility.alert("Student List", "Clear list");
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setContentText("All elements  were removed");
                alert.showAndWait();

            }
            if (decision.equals("NO")) {
                alert.setContentText("No item has been removed");
                alert.showAndWait();
            }


        }
    }

    @FXML
    void btnAddFirstOnAction(ActionEvent event) {
        loadPage("addFirstStudent.fxml");
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        loadPage("addStudent.fxml");
    }

    @FXML
    void btnContainsOnAction(ActionEvent event) {

    }

    @FXML
    void btnGetFirstOnAction(ActionEvent event) {
        if (studentList.isEmpty()) {
            alert.setContentText("Student list is empty");
            alert.showAndWait();
        } else {

            alert = util.FXUtility.alert("Student List", "The first element in list is :");
            alert.setAlertType(Alert.AlertType.INFORMATION);
            try {
                alert.setContentText("" + studentList.getFirst());

                alert.showAndWait();
            } catch (ListException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @FXML
    void btnGetLastOnAction(ActionEvent event) {
        if (studentList.isEmpty()) {
            alert.setContentText("Student list is empty");
            alert.showAndWait();
        } else {

            alert = util.FXUtility.alert("Student List", "The last element in list is :");
            alert.setAlertType(Alert.AlertType.INFORMATION);
            try {
                alert.setContentText("" + studentList.getLast());
                alert.showAndWait();
            } catch (ListException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void btnRemoveFirstOnAction(ActionEvent event) {
        if (studentList.isEmpty()) {
            alert.setContentText("Student list is empty");
            alert.showAndWait();
        } else {


            try {
                String decision = util.FXUtility.alertYesNo("Student List", "The fist item from the list is :  " + studentList.getFirst(), "Remove this item?");
                if (decision.equals("YES")) {
                    studentList.removeFirst();
                    alert = util.FXUtility.alert("Student List", "Remove first element");
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setContentText("The first element of the list was removed");
                    alert.showAndWait();
                    studentTableView.getItems().clear();
                    updateTableView(studentList);


                }
                if (decision.equals("NO")) {
                    alert.setContentText("No item has been removed");
                    alert.showAndWait();
                }

            } catch (ListException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {

    }

    @FXML
    void btnSizeOnAction(ActionEvent event) {
        if (studentList.isEmpty()) {
            alert.setContentText("Student list is empty");
            alert.showAndWait();
        } else {

            alert = util.FXUtility.alert("Student List", "The student list has :  ");
            alert.setAlertType(Alert.AlertType.INFORMATION);
            try {
                alert.setContentText(" " + studentList.size()+" elements.");
                alert.showAndWait();
            } catch (ListException e) {
                throw new RuntimeException(e);
            }
        }
    }

}