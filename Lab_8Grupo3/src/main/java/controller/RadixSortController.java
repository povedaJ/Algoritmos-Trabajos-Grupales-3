package controller;

import domain.Complex;
import domain.Elementary;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.List;

public class RadixSortController {

    @FXML
    private TableView counterArrayTableView;

    @FXML
    private TableView noSortedTableView;
    private int count[] = new int[10];
    private Complex complex;
    @FXML
    private TableView sortedTableView;
    private int a[] = new int[200];


    @FXML
    public void initialize() {
        complex = new Complex();
        util.Utility.fill(a, 99);
        System.out.println(util.Utility.show(a, 200));
        //agregamos las columnas al tableview
        for (int i = 0; i < 200; i++) {
            final int colIndex = i;
            TableColumn<List<String>, String> columnNoSorted = new TableColumn<>(" " + i+" ");
            columnNoSorted.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(colIndex)));
            TableColumn<List<String>, String> columnSorted = new TableColumn<>(" " + i+" ");
            columnSorted.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(colIndex)));

            noSortedTableView.getColumns().add(columnNoSorted);
            sortedTableView.getColumns().add(columnSorted);


        }
        for (int i = 0; i < 10; i++) {
            final int colIndex = i;
            TableColumn<List<String>, String> columnCounter = new TableColumn<>("  " + i+" ");
            columnCounter.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(colIndex)));
            counterArrayTableView.getColumns().add(columnCounter);
        }
        noSortedTableView.setItems(getData());


    }

    public ObservableList<List<String>> getData() {
        ObservableList<List<String>> data = FXCollections.observableArrayList();
        List<String> info = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            info.add(String.valueOf(a[i]));
        }
        data.add(info);
        return data;
    }

    public ObservableList<List<String>> getDataCounter() {
        ObservableList<List<String>> data = FXCollections.observableArrayList();
        List<String> info = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            info.add(String.valueOf(count[i]));
        }
        data.add(info);
        return data;
    }

    @FXML
    void randomizeOnAction(ActionEvent event) {
        util.Utility.fill(a, 99);
        noSortedTableView.setItems(getData());
        sortedTableView.getItems().clear();
        counterArrayTableView.getItems().clear();

    }

    @FXML
    void startOnAction(ActionEvent event) {
        sortedTableView.getItems().clear();
        counterArrayTableView.getItems().clear();
        complex.radixSort(a, 200);
        sortedTableView.setItems(getData());
        count = complex.getCounterRadix();
        counterArrayTableView.setItems(getDataCounter());

    }

}
