package controller;

import domain.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import ucr.laboratory5.HelloApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeesController {

    @FXML
    private TableColumn<List<String>, String> BirthdayTableColumn;

    @FXML
    private TableColumn<List<String>, String> LastNameTableColumn;

    @FXML
    private TableColumn<List<String>, String> TitleTableColumn;

    @FXML
    private BorderPane bp;

    @FXML
    private TableColumn<List<String>, String> fNameTableColumn;

    @FXML
    private TableColumn<List<String>, String> idTableColumn;

    @FXML
    private TableView<List<String>> studentTableView;

    private CircularLinkedList employeesList;
    Alert alert;
    TextInputDialog dialog;
    @FXML
    public void initialize() {
        this.employeesList = util.Utility.getEmployeeList();
        this.idTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyObjectWrapper<>(data.getValue().get(0));
            }
        });

        this.LastNameTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyObjectWrapper<>(data.getValue().get(1));
            }
        });

        this.fNameTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyObjectWrapper<>(data.getValue().get(2));
            }
        });

        this.TitleTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyObjectWrapper<>(data.getValue().get(3));
            }
        });

        this.BirthdayTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyObjectWrapper<>(data.getValue().get(4));
            }
        });
        updateTableView(employeesList);

    }//fin initialize

    private void updateTableView(CircularLinkedList employeesList) {
        //setteo alert con titulo y mensaje
        alert= util.FXUtility.alert("Employees List","Display Employees");
        alert.setAlertType(Alert.AlertType.ERROR);
        //llena tableView
        if (this.employeesList!=null && !this.employeesList.isEmpty()){
            this.studentTableView.setItems(getData());
        }
    }

    private ObservableList<List<String>> getData() {
        ObservableList<List<String>> data = FXCollections.observableArrayList();
        try {
            int n = this.employeesList.size();
            for (int i = 0; i <= n; i++) {
                Employee jp = (Employee) this.employeesList.getNode(i).data;
                //defino objeto List
                List<String> arrayList = new ArrayList<>();
                arrayList.add(String.valueOf(jp.getId()));
                arrayList.add(jp.getLastName());
                arrayList.add(jp.getFirstName());
                arrayList.add(jp.getTitle());
                arrayList.add(String.valueOf(jp.getBirthday()));
                //se agrega el arrayList al observableList<String>data
                data.add(arrayList);
            }
        }catch (ListException e){
            alert.setContentText("There was an error in the process");
            alert.showAndWait();
        }
        return data;
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
    void addSortNameOnAction(ActionEvent event) {
        if (employeesList.isEmpty()) {
            alert.setContentText(" Employees list is empty");
            alert.showAndWait();
        } else {
            try {
                int n = employeesList.size();
                for (int i = 1; i <= n; i++) {
                    for (int j = i + 1; j <= n; j++) {
                        Employee jobPosition1 = (Employee) employeesList.getNode(i).data;
                        Employee jobPosition2 = (Employee) employeesList.getNode(j).data;
                        if (jobPosition2.getFirstName().compareToIgnoreCase(jobPosition1.getFirstName()) < 1) {
                            Object aux = employeesList.getNode(i).data;
                            employeesList.getNode(i).data = employeesList.getNode(j).data;
                            employeesList.getNode(j).data = aux;
                        }//if
                    }//for j
                }

            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setContentText("Employees list are sorted by name");
            //actualizo la lista global
            util.Utility.setEmployeeList(this.employeesList);
            updateTableView(employeesList);
            } catch (ListException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void btClearOnAction(ActionEvent event) {
        if (employeesList.isEmpty()){
            alert.setContentText(" Employee list is empty");
            alert.showAndWait();
        }else {
            String decision = util.FXUtility.alertYesNo("Employee list","Delete ALL items from the list","Are you sure?");
            if (decision.equals("YES")){
                studentTableView.getItems().clear();
                employeesList.clear();

                alert = util.FXUtility.alert("Employees List", "Clear list");
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setContentText("All elements were removed");
                alert.showAndWait();
            }
            if (decision.equals("NO")){
                alert.setContentText("No item has been removed");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        loadPage("addEmployee.fxml");
    }

    @FXML
    void btnContainsOnAction(ActionEvent event) {
        if (employeesList.isEmpty()) {
            alert.setContentText("Employee list is empty");
            alert.showAndWait();
        } else {
            loadPage("containsEmployee.fxml");
        }
    }

    @FXML
    void btnGetNextOnAction(ActionEvent event) {
        if (employeesList.isEmpty()) {
            alert.setContentText(" Employees list is empty");
            alert.showAndWait();
        } else {
            dialog = util.FXUtility.dialog("Next element", "");
            dialog.setContentText("Enter the employees ID to know the next position");
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent() && result.get().compareTo("") != 0) {

                try {

                    if (searchByID(employeesList, Integer.parseInt(result.get())) != null) {

                        alert.setAlertType(Alert.AlertType.INFORMATION);
                        alert.setContentText("The next position is : " + searchByID(employeesList, Integer.parseInt(result.get())).next.data);
                        alert.showAndWait();

                    } else {
                        alert.setAlertType(Alert.AlertType.ERROR);
                        alert.setContentText("The employee searched for in the list does not exist");
                        alert.show();
                    }

                } catch (ListException ex) {
                    throw new RuntimeException(ex);
                }

            } else {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Complete the form with\nthe information, please");
                alert.showAndWait();
            }

        }
    }

    @FXML
    void btnPrevOnAction(ActionEvent event) {
        if (employeesList.isEmpty()) {
            alert.setContentText(" Emply list is empty");
            alert.showAndWait();
        } else {

            dialog = util.FXUtility.dialog("Prev element", "");
            dialog.setContentText("Enter the employee ID to know the previous position");
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent() && result.get().compareTo("") != 0) {

                try {

                    if (searchByID(employeesList, Integer.parseInt(result.get())) != null) {

                        alert.setAlertType(Alert.AlertType.INFORMATION);
                        alert.setContentText("The prev position is : " + searchByID(employeesList, Integer.parseInt(result.get())).prev.data);
                        alert.showAndWait();

                    } else {
                        alert.setAlertType(Alert.AlertType.ERROR);
                        alert.setContentText("The employee searched for in the list does not exist");
                        alert.show();
                    }

                } catch (ListException ex) {
                    throw new RuntimeException(ex);
                }

            } else {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Complete the form with\nthe information, please");
                alert.showAndWait();
            }

        }
    }

    @FXML
    void btnRemoveLastOnAction(ActionEvent event) {
        if (employeesList.isEmpty()){
            alert.setContentText(" Employee list is empty");
            alert.showAndWait();
        }else {
            String decision = util.FXUtility.alertYesNo("Employee list","Delete last item from the list","Are you sure?");
            if (decision.equals("YES")){
                alert = util.FXUtility.alert("Employees List", "Remove list");
                alert.setAlertType(Alert.AlertType.INFORMATION);
                try {
                    alert.setContentText(" Element"+employeesList.removeLast().toString()+" was removed");
                    alert.showAndWait();
                    studentTableView.getItems().clear();
                    updateTableView(employeesList);
                }catch (ListException e){
                    throw new RuntimeException(e);
                }
            }
            if (decision.equals("NO")){
                alert.setContentText("No item has been removed");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        if (employeesList.isEmpty()){
            alert.setContentText(" Employee list is empty");
            alert.showAndWait();
        }else {
            loadPage("removeEmployee.fxml");
        }

    }

    @FXML
    void btnSizeOnAction(ActionEvent event) {
        if(employeesList.isEmpty()){
            alert.setContentText(" Employee list is empty");
            alert.showAndWait();
        }else {
            alert = util.FXUtility.alert("Employees List", "Employees list has: ");
            alert.setAlertType(Alert.AlertType.INFORMATION);
            try {
                alert.setContentText(" "+employeesList.size()+" elements.");
                alert.showAndWait();
            }catch (ListException e){
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void btnSortbyIdOnAction(ActionEvent event) {
        //sortbyId buscar por Id
        if (employeesList.isEmpty()) {
            alert.setContentText(" Employees list is empty");
            alert.showAndWait();
        } else {
            employeesList.addInSortedList(employeesList);

            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setContentText("Employees list are sorted by id");
            //actualizo la lista global
            util.Utility.setEmployeeList(this.employeesList);
            updateTableView(employeesList);
        }
    }

    private Node searchByID(CircularLinkedList list, int id) throws ListException {
        for (int i = 1; i < list.size(); i++) {
            JobPosition jobPosition = (JobPosition) list.getNode(i).data;
            //  if (jobPosition.getId()== id) {
            if (util.Utility.compare(jobPosition.getId(), id) == 0) {
                return list.getNode(i);
            }
        }
        return null;
    }

}
