package controller;

import domain.CircularDoublyLinkedList;
import domain.CircularLinkedList;
import domain.JobPosition;
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


public class JobPositionsController {

    @FXML
    private TableColumn<List<String>, String> DescriptionTableColumn;

    @FXML
    private TableColumn<List<String>, String> MontlyWageTableColumn;

    @FXML
    private TableColumn<List<String>, String> TotalHTableColumn;

    @FXML
    private BorderPane bp;

    @FXML
    private TableColumn<List<String>, String> hWageTableColumn;

    @FXML
    private TableColumn<List<String>, String> idTableColumn;

    @FXML
    private TableView<List<String>> positionsTableView;
    private CircularDoublyLinkedList jobPositionList;
    Alert alert;

    @FXML
    public void initialize() {
        this.jobPositionList = util.Utility.getJobPositionList();
        this.idTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<List<String>, String> data) {
               // return null;
                return new ReadOnlyObjectWrapper<>(data.getValue().get(0));
            }
        });

        this.DescriptionTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyObjectWrapper<>(data.getValue().get(1));
            }
        });

        this.hWageTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyObjectWrapper<>(data.getValue().get(2));
            }
        });


        this.TotalHTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyObjectWrapper<>(data.getValue().get(3));
            }
        });
        this.MontlyWageTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyObjectWrapper<>(data.getValue().get(4));
            }
        });
       updateTableView(jobPositionList);
    }
    public void updateTableView(CircularDoublyLinkedList jobPositionList){
        //setteo alert con tirulo y mensaje
        alert= util.FXUtility.alert("Job Position list","Display Jon Positions");
        alert.setAlertType(Alert.AlertType.ERROR);
        //lleno el tableView con los datos de la lista
        if (this.jobPositionList!=null && !this.jobPositionList.isEmpty()){
            this.positionsTableView.setItems(getData());
        }
    }

    private ObservableList<List<String>> getData() {
        ObservableList<List<String>> data= FXCollections.observableArrayList();
        try {
            int n = this.jobPositionList.size();
            for (int i = 1; i <=n ; i++) {
                JobPosition jp= (JobPosition) this.jobPositionList.getNode(i).data;
                //establezco 2 campos calculados
                int hours= util.Utility.random(40,50);
                double mWage = jp.getSalary(hours);
                // defino un objeto List<String>
                List<String> arrayList= new ArrayList<>();
                arrayList.add(String.valueOf(jp.getId()));
                arrayList.add(jp.getDescription());
                arrayList.add(String.valueOf(jp.getHourlyWage()));
                arrayList.add(String.valueOf(hours));
                arrayList.add("$"+util.Utility.format(mWage));
                //al final agregamos el arraylist a obsevableList<String> data
                data.add(arrayList);
            }
        } catch (ListException e) {
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
        if (jobPositionList.isEmpty()) {
            alert.setContentText(" Job Position list is empty");
            alert.showAndWait();
        } else {


            String decision = util.FXUtility.alertYesNo(" Job Position list", "Delete ALL items from the list ", "Are you sure?");
            if (decision.equals("YES")) {
               positionsTableView.getItems().clear();
                jobPositionList.clear();
                alert = util.FXUtility.alert("Job Position list", "Clear list");
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
    void btnAddOnAction(ActionEvent event) {
        loadPage("addPosition.fxml");
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
        if (jobPositionList.isEmpty()) {
            alert.setContentText(" Job Position list is empty");
            alert.showAndWait();
        } else {


            String decision = util.FXUtility.alertYesNo(" Job Position list", "Delete last  item from the list ", "Are you sure?");
            if (decision.equals("YES")) {

                alert = util.FXUtility.alert("Job Position list", "Remove last");
                alert.setAlertType(Alert.AlertType.INFORMATION);
                try {
                    alert.setContentText(" Element"+jobPositionList.removeLast().toString()+ " was removed");
                    alert.showAndWait();
                    positionsTableView.getItems().clear();
                    updateTableView(jobPositionList);
                } catch (ListException e) {
                    throw new RuntimeException(e);
                }

            }
            if (decision.equals("NO")) {
                alert.setContentText("No item has been removed");
                alert.showAndWait();
            }


        }

    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {

    }

    @FXML
    void btnSizeOnAction(ActionEvent event) {
        if (jobPositionList.isEmpty()) {
            alert.setContentText(" Job Position list is empty");
            alert.showAndWait();
        } else {

            alert = util.FXUtility.alert(" Job Position list", " Job Position list has :  ");
            alert.setAlertType(Alert.AlertType.INFORMATION);
            try {
                alert.setContentText(" " + jobPositionList.size()+" elements.");
                alert.showAndWait();
            } catch (ListException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @FXML
    void btnSortbyHourlyOnAction(ActionEvent event) {

    }

}
