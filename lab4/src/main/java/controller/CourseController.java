package controller;

import domain.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import ucr.lab.HelloApplication;

import java.io.IOException;

public class CourseController {

    @FXML
    private BorderPane bp;

    @FXML
    private TableView<Course> courseTableView;

    @FXML
    private TableColumn<Course,String> creditsTableColumn;

    @FXML
    private TableColumn<Course,String> idTableColumn;

    @FXML
    private TableColumn<Course,String> nameTableColumn;
 private DoublyLinkedList courseList;
 private Alert alert;

    @FXML
    public void initialize() {
        //cargamos la lista desde la clase Utility
        this.courseList= util.Utility.getCourseList();
        this.idTableColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        this.nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        this.creditsTableColumn.setCellValueFactory(new PropertyValueFactory<>("Credits"));
        updateTableView(courseList);

    }
    public void updateTableView(DoublyLinkedList courseList) {
        try {
            this.alert = util.FXUtility.alert("Course List", "Display courses");
            alert.setAlertType(Alert.AlertType.ERROR);
            if (this.courseList != null && !this.courseList.isEmpty()) {
                int n = courseList.size();
                for (int i = 1; i <= n; i++) {
                    this.courseTableView.getItems().add((Course) courseList.getNode(i).data);

                }
            }
        } catch (ListException ex) {
            alert.setContentText("Course list is empty");
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
        loadPage("addCourseSorted.fxml");

    }

    @FXML
    void btClearOnAction(ActionEvent event) {
        if (courseList.isEmpty()) {
            alert.setContentText("Course list is empty");
            alert.showAndWait();
        } else {


            String decision = util.FXUtility.alertYesNo("Course List", "Delete ALL items from the list ", "Are you sure?");
            if (decision.equals("YES")) {
               courseTableView.getItems().clear();
                courseList.clear();
                alert = util.FXUtility.alert("Course List", "Clear list");
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
        loadPage("addFirstCourse.fxml");
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        loadPage("addCourse.fxml");
    }

    @FXML
    void btnContainsOnAction(ActionEvent event) {
        loadPage("containsCourse.fxml");

    }

    @FXML
    void btnGetFirstOnAction(ActionEvent event) {
        if (courseList.isEmpty()) {
            alert.setContentText("Course list is empty");
            alert.showAndWait();
        } else {

            alert = util.FXUtility.alert("Course List", "The first element in list is :");
            alert.setAlertType(Alert.AlertType.INFORMATION);
            try {
                alert.setContentText("" + courseList.getFirst());

                alert.showAndWait();
            } catch (ListException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void btnGetLastOnAction(ActionEvent event) {
        if (courseList.isEmpty()) {
            alert.setContentText("Course list is empty");
            alert.showAndWait();
        } else {

            alert = util.FXUtility.alert("Course List", "The last element in list is :");
            alert.setAlertType(Alert.AlertType.INFORMATION);
            try {
                alert.setContentText("" + courseList.getLast());
                alert.showAndWait();
            } catch (ListException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void btnRemoveFirstOnAction(ActionEvent event) {
        if (courseList.isEmpty()) {
            alert.setContentText("Course list is empty");
            alert.showAndWait();
        } else {


            try {
                String decision = util.FXUtility.alertYesNo("Course List", "The fist item from the list is :  " + courseList.getFirst(), "Remove this item?");
                if (decision.equals("YES")) {
                    courseList.removeFirst();
                    alert = util.FXUtility.alert("course List", "Remove first element");
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setContentText("The first element of the list was removed");
                    alert.showAndWait();
                    courseTableView.getItems().clear();
                    updateTableView(courseList);


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
        loadPage("removeCourse.fxml");

    }

    @FXML
    void btnSizeOnAction(ActionEvent event) {
        if (courseList.isEmpty()) {
            alert.setContentText("Course list is empty");
            alert.showAndWait();
        } else {

            alert = util.FXUtility.alert("Course List", "The course list has :  ");
            alert.setAlertType(Alert.AlertType.INFORMATION);
            try {
                alert.setContentText(" " + courseList.size()+" elements.");
                alert.showAndWait();
            } catch (ListException e) {
                throw new RuntimeException(e);
            }
        }
    }



}