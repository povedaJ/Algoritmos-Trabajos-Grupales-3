package controller;

import domain.NQueenProblem;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;

public class NQueenProblemController
{
    @javafx.fxml.FXML
    private TextArea textArea;
    @javafx.fxml.FXML
    private TableView tableView;
    private String nQueenData; //sirve para el table view

    @javafx.fxml.FXML
    public void initialize() {
        test(); //para recopilar info

        //agregamos las columnas al tableview
        for (int i = 0; i < 8; i++) {
            final int colIndex = i;
            TableColumn<List<String>, String> column = new TableColumn<>("col-"+(i+1));
            column.setCellValueFactory(data->new SimpleStringProperty(data.getValue().get(colIndex)));
            tableView.getColumns().add(column);
        }
        tableView.setItems(getData());
    }

    public ObservableList<List<String>> getData() {
        ObservableList<List<String>> data = FXCollections.observableArrayList();
        nQueenData = nQueenData.replaceAll("\n",""); //para eliminar los saltos de linea
        String a[] = nQueenData.split(" ");
//        System.out.println( "contenido en a de obsevable list" );
//        for (int i = 0; i <a.length ; i++) {
//
//            System.out.println(a[i]+"\n");
//        }
        int count = 0;
        List<String> info = new ArrayList<>();
        for (int i = 0; i < 64; i++) {
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
        NQueenProblem nQueen = new NQueenProblem();
        textArea.setText("N Queens Problem solution for a 8x8 board"
                +"\n"+nQueen.solveNQueen(8)
                +"\nN Queens Problem solution for a 4x4 board"
                +"\n"+nQueen.solveNQueen(4)
        );
        this.nQueenData = nQueen.solveNQueen(8); //para el table view
    }

}