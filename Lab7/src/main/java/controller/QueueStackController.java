package controller;

import domain.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;

public class QueueStackController {

    @FXML
    private TableColumn<List<String>, String> placeQueueTableColumn;

    @FXML
    private TableColumn<List<String>, String> placeStackTableColumn;

    @FXML
    private TextField placeTextfield;

    @FXML
    private TableView<List<String>> queueTableView;

    @FXML
    private TableView<List<String>> stackTableView;

    @FXML
    private ChoiceBox<String> weatherChoiceBox;

    @FXML
    private TableColumn<List<String>, String> weatherQueueTableColumn;

    @FXML
    private TableColumn<List<String>, String> weatherStackTableColumn;
    private Alert alert;
    // Creamos una cola
   private LinkedQueue linkedQueue ;

    @FXML
    public void initialize() {
        this.alert = util.FXUtility.alert("", "");
        //cargamos la queue
        this.linkedQueue=util.Utility.getLinkedQueue();
        //llenamos los choicebox
        this.weatherChoiceBox.setItems(weatherOl);
        this.placeQueueTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyObjectWrapper<>(data.getValue().get(0));
            }
        });
        this.weatherQueueTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyObjectWrapper<>(data.getValue().get(1));
            }
        });
        updateTableView(linkedQueue);
    }
    public void updateTableView(LinkedQueue linkedQueue) {
        //setteo alert con tirulo y mensaje
        alert = util.FXUtility.alert("Linked Queue", " ");
        alert.setAlertType(Alert.AlertType.ERROR);
        //lleno el tableView con los datos de la lista
        if (this.linkedQueue != null && !this.linkedQueue.isEmpty()) {
            this.queueTableView.setItems(getData());
        }
    }
    private ObservableList<List<String>> getData() {
        ObservableList<List<String>> data = FXCollections.observableArrayList();
        if (this.linkedQueue!= null && !this.linkedQueue.isEmpty()) {
            try {
                LinkedQueue aux = new LinkedQueue();
                while (!linkedQueue.isEmpty()) {
                    Climate climate = (Climate) linkedQueue.front();
                    List<String> arrayList = new ArrayList<>();

                    arrayList.add(climate.getPlace().getName());
                    arrayList.add(climate.getWeather().getWeather());
                    //Agrego el arrayList a ObservableList<List<String>> data
                    data.add(arrayList);
                    aux.enQueue(linkedQueue.deQueue());
                }
                //al final dejamos la cola en su estado original
                while (!aux.isEmpty()) {
                    linkedQueue.enQueue(aux.deQueue());
                }
            } catch (QueueException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return data;
    }
    ObservableList<String> weatherOl = FXCollections.observableArrayList("Rainy", "ThunderStorm", "Sunny", "Cloudy", "Foggy");

    @FXML
    void autoEnQueueOnAction(ActionEvent event) {
        try {
            for (int i = 0; i < 19; i++) {
                //name y mood viene de forma random desde utility
                linkedQueue.enQueue(new Climate(new Place(util.Utility.getPlace()),
                       new Weather(util.Utility.getWeather())));

            }

            util.Utility.setLinkedQueue(linkedQueue);

        } catch (QueueException ex) {
            throw new RuntimeException(ex);

        }
        updateTableView(linkedQueue);

    }

    private boolean isValid() {
        return !this.placeTextfield.getText().isEmpty()
                && !this.weatherChoiceBox.getValue().isEmpty();
    }

    @FXML
    void clearOnAction(ActionEvent event) {
this.weatherChoiceBox.getSelectionModel().clearSelection();
this.placeTextfield.clear();
        if (linkedQueue.isEmpty()) {
            alert.setContentText("Linked Queue is empty");
            alert.showAndWait();
        } else {
            String decision = util.FXUtility.alertYesNo("Linked Queue", "Delete ALL items from the Linked Queue ", "Are you sure?");
            if (decision.equals("YES")) {
                queueTableView.getItems().clear();
                linkedQueue.clear();
                util.Utility.setLinkedQueue(linkedQueue);
                alert = util.FXUtility.alert("Linked Queue", "Clear Linked Queue");
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setContentText("All elements  were removed");
                alert.showAndWait();

            }
            if (decision.equals("NO")) {
                alert.setContentText("No item has been removed");
                alert.showAndWait();
            }


        }
    }

    @FXML
    void enQueueOnAction(ActionEvent event) {
        try {
           linkedQueue.enQueue(new Place(this.placeTextfield.getId()));
        } catch (QueueException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void pushAllOnAction(ActionEvent event) {
           // Creamos una pila vacía
//        Stack<Integer> stack = new Stack<>();
//
//        // Apilamos los elementos de la cola en la pila
//        while (!queue.isEmpty()) {
//            stack.push(queue.clear());
//        }
//
//        // Mostramos los elementos de la pila
//        while (!stack.isEmpty()) {
//            System.out.println(stack.pop());
//        }
    }

}
