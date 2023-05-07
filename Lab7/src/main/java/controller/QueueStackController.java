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
    private LinkedQueue linkedQueue;
    private LinkedStack linkedStack;
    @FXML
    public void initialize() {
        this.alert = util.FXUtility.alert("", "");
        //cargamos la queue
        this.linkedQueue = util.Utility.getLinkedQueue();
        this.linkedStack=util.Utility.getLinkedStack();
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

        this.placeStackTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyObjectWrapper<>(data.getValue().get(0));
            }
        });
        this.weatherStackTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyObjectWrapper<>(data.getValue().get(1));
            }
        });
        updateTableViewQueue(linkedQueue);
    }

    public void updateTableViewQueue(LinkedQueue linkedQueue) {
        //setteo alert con tirulo y mensaje
        alert = util.FXUtility.alert("Linked Queue", " ");
        alert.setAlertType(Alert.AlertType.ERROR);
        //lleno el tableView con los datos de la lista
        if (this.linkedQueue != null && !this.linkedQueue.isEmpty()) {
            this.queueTableView.setItems(getDataQueue());
        }
    }
    public void updateTableViewStack(LinkedStack linkedStack) {
        //setteo alert con tirulo y mensaje
        alert = util.FXUtility.alert("Linked Stack", " ");
        alert.setAlertType(Alert.AlertType.ERROR);
        //lleno el tableView con los datos de la lista
        if (this.linkedStack != null && !this.linkedStack.isEmpty()) {
            this.stackTableView.setItems(getDataStack());
        }
    }

    private ObservableList<List<String>> getDataQueue() {
        ObservableList<List<String>> data = FXCollections.observableArrayList();
        if (this.linkedQueue != null && !this.linkedQueue.isEmpty()) {
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
    private ObservableList<List<String>> getDataStack() {
        ObservableList<List<String>> data = FXCollections.observableArrayList();
        if (this.linkedStack != null && !this.linkedStack.isEmpty()) {
            try {
                LinkedStack aux = new LinkedStack();
                while (!linkedStack.isEmpty()) {
                    Climate climate = (Climate) linkedStack.peek();
                    List<String> arrayList = new ArrayList<>();

                    arrayList.add(climate.getPlace().getName());
                    arrayList.add(climate.getWeather().getWeather());
                    //Agrego el arrayList a ObservableList<List<String>> data
                    data.add(arrayList);
                    aux.push(linkedStack.pop());
                }
                //al final dejamos la cola en su estado original
                while (!aux.isEmpty()) {
                    linkedStack.push(aux.pop());
                }
            } catch (StackException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return data;
    }

    ObservableList<String> weatherOl = FXCollections.observableArrayList("Rainy", "ThunderStorm", "Sunny", "Cloudy", "Foggy");

    @FXML
    void autoEnQueueOnAction(ActionEvent event) {
        try {
            for (int i = 0; i < 20; i++) {
                //name y mood viene de forma random desde utility
                linkedQueue.enQueue(new Climate(new Place(util.Utility.getPlace()),
                        new Weather(util.Utility.getWeather())));

            }

            util.Utility.setLinkedQueue(linkedQueue);

        } catch (QueueException ex) {
            throw new RuntimeException(ex);

        }
        updateTableViewQueue(linkedQueue);

    }

    private boolean isValid() {
        return !this.placeTextfield.getText().isEmpty()
                && !this.weatherChoiceBox.getSelectionModel().isEmpty();
    }

    @FXML
    void clearOnAction(ActionEvent event) {
        this.weatherChoiceBox.getSelectionModel().clearSelection();
        this.placeTextfield.clear();
        if (linkedQueue.isEmpty()) {
            alert.setContentText("Linked Queue is empty");
            alert.showAndWait();
        } else {
            String decision = util.FXUtility.alertYesNo("Linked Queue", "Delete ALL items from the Linked Queue and Linked Stack", "Are you sure?");
            if (decision.equals("YES")) {
                queueTableView.getItems().clear();
                stackTableView.getItems().clear();
                linkedStack.clear();
                linkedQueue.clear();
                util.Utility.setLinkedQueue(linkedQueue);
                alert = util.FXUtility.alert("Linked Queue", "Clear Linked Queue and Linked Stack");
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
        if (isValid()) {
            if (this.linkedQueue != null) {
                try {
                    if (!linkedQueue.isEmpty() &&
                            linkedQueue.contains(new Climate(new Place(this.placeTextfield.getText()),
                                    new Weather(this.weatherChoiceBox.getValue())))) {
                        alert.setAlertType(Alert.AlertType.ERROR);
                        alert.setContentText("There's already Climate in queue");
                    } else {
                        linkedQueue.enQueue(new Climate(new Place(this.placeTextfield.getText()),
                                new Weather(this.weatherChoiceBox.getValue())));
                        alert.setAlertType(Alert.AlertType.INFORMATION);
                        alert.setContentText("Climate  was added to the queue");
                        //actualizo la cola global
                        util.Utility.setLinkedQueue(linkedQueue);
                    }
                } catch (QueueException e) {
                    throw new RuntimeException(e);
                }
                alert.showAndWait();
                this.placeTextfield.clear();
                this.weatherChoiceBox.getSelectionModel().clearSelection();

            }
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Complete the form with\nthe information, please");
            alert.showAndWait();
        }

        queueTableView.getItems().clear();
        updateTableViewQueue(util.Utility.getLinkedQueue());

    }

    @FXML
    void pushAllOnAction(ActionEvent event) {
        if (linkedQueue.isEmpty()) {
            alert.setContentText("Linked Queue is empty");
            alert.showAndWait();
        } else {
           try{
            try {
                LinkedQueue aux = new LinkedQueue();
                linkedStack.clear();
                util.Utility.setLinkedStack(linkedStack);
                this.stackTableView.getSelectionModel().clearSelection();
                while (!linkedQueue.isEmpty()) {
                    linkedStack.push(linkedQueue.getFront().data);
                    aux.enQueue(linkedQueue.deQueue());
                }
                //al final dejamos las cola en su estado original
                while (!aux.isEmpty()) {
                    linkedQueue.enQueue(aux.deQueue());
                }

            } catch (StackException ex ) {
                throw new RuntimeException(ex);

            }
           } catch (QueueException ex ) {
               throw new RuntimeException(ex);

           }


    }
//        System.out.println("Stack"+linkedStack.toString());
//        System.out.println("queue"+linkedQueue.toString());
   updateTableViewStack(linkedStack);
        }

}
