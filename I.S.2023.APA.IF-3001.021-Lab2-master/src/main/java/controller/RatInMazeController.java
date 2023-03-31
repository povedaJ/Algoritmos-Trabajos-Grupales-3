package controller;

import domain.RatInMaze;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;

public class RatInMazeController
{
    private String ratInMazeData; //sirve para el table view
    private int[][] maze1 = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
    };

    private int maze2[][] = {
            {1, 0, 0, 1, 1, 0, 0, 0},
            {1, 0, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 1, 0, 1, 1},
            {1, 0, 0, 1, 1, 1, 1, 0},
            {1, 0, 0, 1, 1, 0, 1, 1},
            {1, 0, 0, 1, 1, 0, 0, 1},
    };
    private int maze4[][] = { // es la misma que maze 2
            {1, 0, 0, 1, 1, 0, 0, 0},
            {1, 0, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 1, 0, 1, 1},
            {1, 0, 0, 1, 1, 1, 1, 0},
            {1, 0, 0, 1, 1, 0, 1, 1},
            {1, 0, 0, 1, 1, 0, 0, 1},
    };
    private int maze3[][] = {
            {1, 1, 1, 1, 1, 1, 0, 0},
            {0, 0, 0, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 0, 0},
            {0, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 1},
            {1, 0, 0, 1, 1, 1, 1, 0},
            {1, 0, 0, 1, 1, 0, 1, 1},
            {1, 0, 0, 1, 1, 0, 0, 1},
    };
    @javafx.fxml.FXML
    private TableView tableView;
    @javafx.fxml.FXML
    private TextArea textArea;

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
       ratInMazeData = ratInMazeData.replaceAll("\n",""); //para eliminar los saltos de linea
        String a[] = ratInMazeData.split(" ");

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

        RatInMaze ratMaze = new RatInMaze();

        textArea.setText("Rat in Maze for a 4x4 board"
                +"\n"+ratMaze.printMaze(maze1) +"\n Solution"
                +"\n"+ratMaze.solveMaze(maze1)
                +"\nRat in Maze for a 8x8 board"
                +"\n"+ratMaze.printMaze(maze2) +"\n Solution"
                +"\n"+ratMaze.solveMaze(maze2)
                +"\nRat in Maze for a 8x8 board"
                +"\n"+ratMaze.printMaze(maze3) +"\n Solution"
                +"\n"+ratMaze.solveMaze(maze3)
        );

        this.ratInMazeData = ratMaze.solveMaze(maze4); //para el table view
    }


}//end