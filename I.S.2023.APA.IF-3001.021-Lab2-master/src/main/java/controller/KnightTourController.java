package controller;

import domain.KnightTour;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;

public class KnightTourController
{
    @javafx.fxml.FXML
    private TextArea textArea;
    @javafx.fxml.FXML
    private TableView tableView;
private String knigtTourData;
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
        knigtTourData = knigtTourData.replaceAll("\n",""); //para eliminar los saltos de linea
        String a[] = knigtTourData.split(" ");

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

       KnightTour KTour = new KnightTour();

        textArea.setText("  KnightTour for a 8X8 board"
                +"\n Solution"
                +"\n"+KTour.solveKT(8)
                );

        this.knigtTourData = KTour.solveKT(8); //para el table view
    }

}//end