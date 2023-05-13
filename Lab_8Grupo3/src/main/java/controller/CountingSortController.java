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

public class CountingSortController {
    @FXML
    private TableView counterArrayTableView;

    @FXML
    private TableView noSortedTableView;

    @FXML
    private TableView sortedTableView;
    private int k = 200;  //tamaño lista
    private int aux[] = new int[k];
    private Elementary elementary;

    @FXML
    public void initialize() {
        elementary = new Elementary();
        util.Utility.fill(aux);
        //agregar columnas
        for (int i = 0; i < k; i++) {
            //indices columnas
            int colIndex = i;
            TableColumn<List<String>, String> columnNoSorted = new TableColumn<>(" " + i+" ");
            columnNoSorted.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(colIndex)));

            TableColumn<List<String>, String> columnSorted = new TableColumn<>(" " + i+" ");
            columnSorted.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(colIndex)));

            noSortedTableView.getColumns().add(columnNoSorted);

            sortedTableView.getColumns().add(columnSorted);
        }
        for (int i = 0; i < 100; i++) { //100 es por el numero mayor = 99
            int colIndex = i;
            TableColumn<List<String>, String> columnCounter = new TableColumn<>("  " + i);
            columnCounter.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(colIndex)));
            counterArrayTableView.getColumns().add(columnCounter);
        }

        //Valores a los indices
        noSortedTableView.setItems(getData());
    }

    public ObservableList<List<String>> getData() {
        ObservableList<List<String>> data = FXCollections.observableArrayList();
        List<String> info = new ArrayList<>();
        for (int i = 0; i < aux.length; i++) {
            info.add(String.valueOf(aux[i]));
        }
        data.add(info);
        return data;
    }

    @FXML
    void randomizeOnAction(ActionEvent event) {
        util.Utility.fill(aux, 99);
        noSortedTableView.setItems(getData());
        sortedTableView.getItems().clear();
        counterArrayTableView.getItems().clear();
    }
    public ObservableList<List<String>> getDataCounter() {
        ObservableList<List<String>> data = FXCollections.observableArrayList();
        List<String> info = new ArrayList<>();
        int count=0;
        for (int i = 0; i < 100; i++) { //cant max de numeros
            for (int j = 0; j < aux.length; j++) {
                if(i == aux[j]){
                    count++;
                }
            }
            info.add(String.valueOf(count));
            count=0;
        }
        data.add(info);
        return data;
    }
    @FXML
    void startOnAction(ActionEvent event) {
        sortedTableView.getItems().clear();
        counterArrayTableView.getItems().clear();
        elementary.countingSort(aux); //revisar
        sortedTableView.setItems(getData());
        counterArrayTableView.setItems(getDataCounter());
    }

}
