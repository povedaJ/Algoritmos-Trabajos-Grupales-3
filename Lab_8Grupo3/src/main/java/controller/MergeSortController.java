package controller;

import domain.Complex;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class MergeSortController {

    @FXML
    private TextField highTF;

    @FXML
    private TextField lowTF;

    @FXML
    private TableView noSortedTableView;

    @FXML
    private TextField recursiveCTF;

    @FXML
    private TableView sortedTableView;

    @FXML
    private TableView tempArrayTableView;
    private int a[] = new int[200];
    private int temp[] = new int[200];
    private Complex complex ;


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
            noSortedTableView.getColumns().add(columnNoSorted);
            TableColumn<List<String>, String> columnSorted = new TableColumn<>(" " + i+" ");
            columnSorted.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(colIndex)));
            sortedTableView.getColumns().add(columnSorted);
            TableColumn<List<String>, String> columnTemp = new TableColumn<>(" " + i+" ");
            columnTemp.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(colIndex)));
            tempArrayTableView.getColumns().add(columnTemp);
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
    public ObservableList<List<String>> getDataCounter(int tmp[]) {
        ObservableList<List<String>> data = FXCollections.observableArrayList();
        List<String> info = new ArrayList<>();
        for (int i = 0; i < tmp.length; i++) {
            info.add(String.valueOf(tmp[i]));
        }
        data.add(info);
        return data;
    }
    @FXML
    void randomizeOnAction(ActionEvent event) {
        util.Utility.fill(a, 99);
        noSortedTableView.setItems(getData());
        sortedTableView.getItems().clear();
        tempArrayTableView.getItems().clear();
        highTF.clear();
        lowTF.clear();
        recursiveCTF.clear();
        complex.setItCounter(0);
    }

    @FXML
    void startOnAction(ActionEvent event) {

        sortedTableView.getItems().clear();
        tempArrayTableView.getItems().clear();
        tempArrayTableView.getItems().clear();
        highTF.clear();
        lowTF.clear();
        recursiveCTF.clear();
        complex.mergeSort(a,temp,0,a.length-1);
        highTF.setText(complex.getHighMs());
        lowTF.setText(complex.getLowMs());
        recursiveCTF.setText(String.valueOf(complex.getItCounter()));
        temp=complex.getTempMS();
        sortedTableView.setItems(getData());
complex.setItCounter(0);
       tempArrayTableView.setItems(getDataCounter(temp));
    }

}
