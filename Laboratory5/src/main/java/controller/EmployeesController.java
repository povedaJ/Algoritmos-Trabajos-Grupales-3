package controller;

import domain.CircularLinkedList;
import domain.Employee;
import domain.ListException;
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
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import ucr.laboratory5.HelloApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    }

    @FXML
    void btnPrevOnAction(ActionEvent event) {

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
    }

}
