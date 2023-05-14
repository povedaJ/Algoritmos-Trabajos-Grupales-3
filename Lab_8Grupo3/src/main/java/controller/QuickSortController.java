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

public class QuickSortController {

    @FXML
    private TextField highTF;

    @FXML
    private TextField lowTField;

    @FXML
    private TableView noSortedTableView;

    @FXML
    private TextField pivotTF;

    @FXML
    private TextField recursiveCTF;

    @FXML
    private TableView sortedTableView;
    private int a[] = new int[200];

    private Complex complex ;

    @FXML
    public void initialize() {
        complex=new Complex();
        util.Utility.fill(a, 99);
        //agregamos las columnas al tableview
        for (int i = 0; i < 200; i++) {
            final int colIndex = i;
            TableColumn<List<String>, String> columnSorted = new TableColumn<>(" " + i+" ");
            columnSorted.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(colIndex)));
            sortedTableView.getColumns().add(columnSorted);
            TableColumn<List<String>, String> columnNoSorted = new TableColumn<>(" " + i+" ");
            columnNoSorted.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(colIndex)));
            noSortedTableView.getColumns().add(columnNoSorted);
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
    @FXML
    void randomizeOnAction(ActionEvent event) {
        util.Utility.fill(a, 99);
        noSortedTableView.setItems(getData());
        sortedTableView.getItems().clear();
        highTF.clear();
        lowTField.clear();;
        pivotTF.clear();
        recursiveCTF.clear();
    }

    @FXML
    void startOnAction(ActionEvent event) {
        sortedTableView.getItems().clear();
        highTF.clear();
        lowTField.clear();;
        pivotTF.clear();
        recursiveCTF.clear();
        complex.quickSort(a,0,199);
        sortedTableView.setItems(getData());
        highTF.setText(complex.getHighMs());
        lowTField.setText(complex.getLowMs());
        pivotTF.setText(complex.getPivotM());
        recursiveCTF.setText(String.valueOf(complex.getItCounter()));
        complex.setItCounter(0);
        complex.setHighMs("");
        complex.setLowMs("");
        complex.setPivotM("");

}
}
