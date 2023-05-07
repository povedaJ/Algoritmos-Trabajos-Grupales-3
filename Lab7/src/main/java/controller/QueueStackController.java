package controller;

import domain.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    // Creamos una cola con algunos elementos
    Queue queue = new LinkedQueue();

    @FXML
    public void initialize() {
        this.alert = util.FXUtility.alert("", "");
        //cargamos la cola de prioridadd
        //llenamos los choicebox
        this.weatherChoiceBox.setItems(weatherOl);
    }

    ObservableList<String> weatherOl = FXCollections.observableArrayList("Rainy", "ThunderStorm", "Sunny", "Cloudy", "Foggy");

    @FXML
    void autoEnQueueOnAction(ActionEvent event) {

    }

    @FXML
    void clearOnAction(ActionEvent event) {

    }

    @FXML
    void enQueueOnAction(ActionEvent event) {
        try {
            queue.enQueue(new Place(this.placeTextfield.getId()));
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
