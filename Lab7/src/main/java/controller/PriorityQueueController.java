package controller;

import domain.PriorityLinkedQueue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueueController {

    @FXML
    private ChoiceBox<String> ChoiceBoxMood;

    @FXML
    private ChoiceBox<String> ChoiceBoxPriority;

    @FXML
    private TextField TextfieldName;

    @FXML
    private TableView<List<String>> priorityTableView;

    @FXML
    private TableColumn<List<String>, String> tableColumnMood;

    @FXML
    private TableColumn<List<String>, String> tableColumnName;

    @FXML
    private TableColumn<List<String>, String> tableColumnPriority;
    private PriorityLinkedQueue priorityLinkedQueue;
    private Alert alert;


    @FXML
    public void initialize(){
        this.alert=util.FXUtility.alert("","");
        //cargamos la cola de prioridadd
        this.priorityLinkedQueue= util.Utility.getPriorityLinkedQueue();
        //llenamos los choicebox
        this.ChoiceBoxMood.setItems(moodOl);
        this.ChoiceBoxPriority.setItems(priorityOl);
    }
    ObservableList<String> moodOl= FXCollections.observableArrayList("Happiness", "Sadness", "Anger", "Sickness",
            "Cheerful", "Reflective", "Gloomy", "Romantic", "Calm", "Hopeful", "Fearful", "Tense",
             "Lonely");
    ObservableList<String> priorityOl= FXCollections.observableArrayList("Low","Medium","High");
    @FXML
    void autoEnQueueOnAction(ActionEvent event) {

    }

    @FXML
    void clearOnAction(ActionEvent event) {

    }

    @FXML
    void enQueueOnAction(ActionEvent event) {

    }

}
