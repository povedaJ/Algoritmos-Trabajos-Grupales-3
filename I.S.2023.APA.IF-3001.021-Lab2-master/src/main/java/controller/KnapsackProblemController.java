package controller;

import domain.Item;
import domain.Knapsack;
import domain.RatInMaze;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapsackProblemController
{
    @javafx.fxml.FXML
    private TableView tableView1;
    @javafx.fxml.FXML
    private TableView tableView2;
    @javafx.fxml.FXML
    private TableView tableView4;
    @javafx.fxml.FXML
    private TableView tableView3;
    private String knapsackData;

    @javafx.fxml.FXML
    public void initialize() {
        test(); //para recopilar info

        //agregamos las columnas al tableview
        for (int i = 0; i < 8; i++) {
            final int colIndex = i;
            TableColumn<List<String>, String> column = new TableColumn<>("col-"+(i+1));
            column.setCellValueFactory(data->new SimpleStringProperty(data.getValue().get(colIndex)));
            tableView1.getColumns().add(column);
        }
        tableView1.setItems(getData());
    }

    public ObservableList<List<String>> getData() {
        ObservableList<List<String>> data = FXCollections.observableArrayList();
        knapsackData =knapsackData.replaceAll("\n",""); //para eliminar los saltos de linea
        String a[] = knapsackData.split(" ");

        int count = 0;
        List<String> info = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            info.add(a[i]);
            if(count++==7){
                data.add(info);
                info = new ArrayList<>();
                count = 0;
            }
        }
        return data;
    }

    private void test() {
        Item items[] = new Item[12];
        items[0] = new Item("Smart TV 65", 1000, 20);
        items[1] = new Item("PS5", 600, 2);
        items[2] = new Item("Libro java", 20, 1);
        items[3] = new Item("Samsung Galaxy", 700, 0.5);
        items[4] = new Item("Huawei", 400, 0.5);
        items[5] = new Item("Libro C++", 25, 0.5);
        items[6] = new Item("Xbox One", 500, 2.2);
        items[7] = new Item("Drone", 500, 3);
        items[8] = new Item("Proyector", 200, 3);
        items[9] = new Item("Laptop", 800, 3);
        items[10] = new Item("Impresora 3D", 800, 4);
        items[11] = new Item("iPhone", 800, 0.5);
      Knapsack knapsack1 = new Knapsack(items,14.5);



      this.knapsackData = Arrays.toString(knapsack1.solve()); //para el table view
    }

}//end