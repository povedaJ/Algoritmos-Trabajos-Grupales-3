package controller;

import domain.ListException;
import domain.SinglyLinkedList;
import domain.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import ucr.lab.HelloApplication;
import javafx.fxml.FXML;

import java.io.IOException;

public class StudentController
{
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

    @FXML
    public void initialize() {
        //cargamos la lista desde la clase Utility
        this.studentList = util.Utility.getStudentList();
        this.idTableColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        this.nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        this.ageTableColumn.setCellValueFactory(new PropertyValueFactory<>("Age"));
        this.addressTableColumn.setCellValueFactory(new PropertyValueFactory<>("Address"));
        try{
            this.alert = util.FXUtility.alert("Student List", "Display Students");
            alert.setAlertType(Alert.AlertType.ERROR);
            if(this.studentList!=null&&!this.studentList.isEmpty()){
                int n = studentList.size();
                for (int i = 1; i <= n; i++) {
                    this.studentTableView.getItems().add((Student) studentList.getNode(i).data);
                }
            }
        }catch(ListException ex){
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

    }

    @FXML
    void btnAddFirstOnAction(ActionEvent event) {

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