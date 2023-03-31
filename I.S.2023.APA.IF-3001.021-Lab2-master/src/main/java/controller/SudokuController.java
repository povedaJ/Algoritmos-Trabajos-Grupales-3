package controller;


import domain.Sudoku;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;

public class SudokuController
 {
     int[][] board = {
             {5, 3, 0, 0, 7, 0, 0, 0, 0},
             {6, 0, 0, 1, 9, 5, 0, 0, 0},
             {0, 9, 8, 0, 0, 0, 0, 6, 0},
             {8, 0, 0, 0, 6, 0, 0, 0, 3},
             {4, 0, 0, 8, 0, 3, 0, 0, 1},
             {7, 0, 0, 0, 2, 0, 0, 0, 6},
             {0, 6, 0, 0, 0, 0, 2, 8, 0},
             {0, 0, 0, 4, 1, 9, 0, 0, 5},
             {0, 0, 0, 0, 8, 0, 0, 7, 9}};
    @javafx.fxml.FXML
    private TextArea textArea;
    @javafx.fxml.FXML
    private TableView tableView;
    private String sudokU; //sirve para el table view

    @javafx.fxml.FXML
    public void initialize() {
        test(); //para recopilar info

        //agregamos las columnas al tableview
        for (int i = 0; i < 9; i++) {
            final int colIndex = i;
            TableColumn<List<String>, String> column = new TableColumn<>("col-"+(i+1));
            column.setCellValueFactory(data->new SimpleStringProperty(data.getValue().get(colIndex)));
            tableView.getColumns().add(column);
        }
        tableView.setItems(getData());
    }

    public ObservableList<List<String>> getData() {
        ObservableList<List<String>> data = FXCollections.observableArrayList();
        sudokU = sudokU.replaceAll("\n",""); //para eliminar los saltos de linea
        String a[] = sudokU.split(" ");
        int count = 0;
        List<String> info = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            info.add(a[i]);
            if(count++==8){
                data.add(info);
                info = new ArrayList<>();
                count = 0;
            }
        }
        return data;
    }

    private void test()  {
        Sudoku sudoku = new Sudoku();
        textArea.setText("solutions for sudoku \n"+sudoku.printBoard(board)+"\n solution \n"+sudoku.solverSudoku(board));

        this.sudokU = sudoku.solverSudoku(board);//para el table view
    }
    }









