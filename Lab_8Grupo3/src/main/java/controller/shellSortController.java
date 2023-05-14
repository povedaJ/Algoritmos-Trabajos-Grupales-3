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
import javafx.scene.control.TextField;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.List;

public class shellSortController {

    @FXML
    private TextField gapn2TField;

    @FXML
    private TableView noSortedTableView;

    @FXML
    private TableView sortedTableView;

    @FXML
    private TextField subarray1TF;

    @FXML
    private TextField subarray2TF;

    @FXML
    private TextField subarray3TF;
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
        gapn2TField.clear();
        subarray1TF.clear();
        subarray2TF.clear();
        subarray3TF.clear();

    }

    @FXML
    void startOnAction(ActionEvent event) {
        sortedTableView.getItems().clear();
        gapn2TField.clear();
        subarray1TF.clear();
        subarray2TF.clear();
        subarray3TF.clear();
        complex.shellSort(a);
        sortedTableView.setItems(getData());
        gapn2TField.setText(complex.getGapC());
        subarray1TF.setText(complex.getGapSA1());
        subarray2TF.setText(complex.getGapSA2());
        subarray3TF.setText(complex.getGapSA3());
    }

}
