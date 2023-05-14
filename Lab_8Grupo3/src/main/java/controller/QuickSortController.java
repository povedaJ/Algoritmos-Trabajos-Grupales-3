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
    private TextField highTextField;

    @FXML
    private TextField lowTextField;

    @FXML
    private TableView noSortedTableView;

    @FXML
    private TextField pivotTextField;

    @FXML
    private TextField recursiveTextField;

    @FXML
    private TableView sortedTableView;

    private int k = 200;  //tamaño lista
    private int aux[] = new int[k];
    private Complex complex;

    @FXML
    public void initialize() {
        complex = new Complex();
        util.Utility.fill(aux);
        //agregar columnas
        for (int i = 0; i < k; i++) {
            //indices columnas
            int colIndex = i;
            TableColumn<List<String>, String> columnNoSorted = new TableColumn<>("  " + i);
            columnNoSorted.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(colIndex)));

            TableColumn<List<String>, String> columnSorted = new TableColumn<>("  " + i);
            columnSorted.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(colIndex)));

            noSortedTableView.getColumns().add(columnNoSorted);
            sortedTableView.getColumns().add(columnSorted);
        }
        //Valores a la primera
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
        lowTextField.clear();
        highTextField.clear();
        pivotTextField.clear();
        recursiveTextField.clear();
    }
    public String getDatatext(List a) {
        String data = "";
        for (int i = 0; i < a.size(); i++) {
            if (util.Utility.isNumberExp(a.get(i)+"")){
                data= data+ a.get(i)+" ";
            }
        }
        return data;
    }
    @FXML
    void startOnAction(ActionEvent event) {
        lowTextField.clear();
        highTextField.clear();
        pivotTextField.clear();
        recursiveTextField.clear();
        sortedTableView.getItems().clear();
        //llena
        complex.quickSort(aux,0, k-1);
        sortedTableView.setItems(getData());

        lowTextField.setText(getDatatext(complex.getLowQuick()));
        highTextField.setText(getDatatext(complex.getHighQuick()));
        pivotTextField.setText(getDatatext(complex.getPivotQuick()));

        recursiveTextField.setText(complex.getRecursivo()+"");
    }
}
