package controller;

import domain.ListException;
import domain.Person;
import domain.PriorityLinkedQueue;
import domain.QueueException;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
import util.Utility;

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
    public void initialize() {
        this.alert = util.FXUtility.alert("", "");
        //cargamos la cola de prioridadd
        this.priorityLinkedQueue = util.Utility.getPriorityLinkedQueue();
        //llenamos los choicebox
        this.ChoiceBoxMood.setItems(moodOl);
        this.ChoiceBoxPriority.setItems(priorityOl);
        this.tableColumnName.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyObjectWrapper<>(data.getValue().get(0));
            }
        });

        this.tableColumnMood.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyObjectWrapper<>(data.getValue().get(1));
            }
        });

        this.tableColumnPriority.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyObjectWrapper<>(data.getValue().get(2));
            }
        });
        updateTableView(priorityLinkedQueue);
    }

    public void updateTableView(PriorityLinkedQueue priorityLinkedQueue) {
        //setteo alert con tirulo y mensaje
        alert = util.FXUtility.alert("Priority Linked Queue", " ");
        alert.setAlertType(Alert.AlertType.ERROR);
        //lleno el tableView con los datos de la lista
        if (this.priorityLinkedQueue != null && !this.priorityLinkedQueue.isEmpty()) {
            this.priorityTableView.setItems(getData());
        }
    }

    private ObservableList<List<String>> getData() {

        ObservableList<List<String>> data = FXCollections.observableArrayList();
        try {

            PriorityLinkedQueue aux = new PriorityLinkedQueue();

            while (!priorityLinkedQueue.isEmpty()) {
                Person p = (Person) util.Utility.getPriorityLinkedQueue().front();
                List<String> arrayList = new ArrayList<>();

                arrayList.add(p.getName());
                arrayList.add(p.getMood());
                arrayList.add(p.getPriority());

                //Agrego el arrayList al ObservableList data
                data.add(arrayList);
                aux.enQueue(priorityLinkedQueue.deQueue(), getPriority(p.getPriority()));
            }

            //Al final dejamos la cola en su estado original
            while (!aux.isEmpty()) {
                Integer priority=aux.getFront().priority;
//                    linked.enQueue(aux.deQueue(), 1);
                priorityLinkedQueue.enQueue(aux.deQueue(), priority);
            }

        } catch (QueueException ex) {
            System.out.println(ex.getMessage());
        }

        return data;
    }


    ObservableList<String> moodOl = FXCollections.observableArrayList("Happiness", "Sadness", "Anger", "Sickness",
            "Cheerful", "Reflective", "Gloomy", "Romantic", "Calm", "Hopeful", "Fearful", "Tense",
            "Lonely");
    ObservableList<String> priorityOl = FXCollections.observableArrayList("Low", "Medium", "High");

    @FXML
    void autoEnQueueOnAction(ActionEvent event) {
        try {
//            priorityLinkedQueue.clear();
//            util.Utility.setPriorityLinkedQueue(priorityLinkedQueue);
//            updateTableView(priorityLinkedQueue);

            for (int i = 0; i < 19; i++) {
                //name y mood viene de forma random desde utility
                String prorityRandom = util.Utility.getPriority();
                priorityLinkedQueue.enQueue(new Person(util.Utility.getPerson(), util.Utility.getMood(), prorityRandom), getPriority(prorityRandom));

            }

            util.Utility.setPriorityLinkedQueue(priorityLinkedQueue);

        } catch (QueueException ex) {
            throw new RuntimeException(ex);

        }
        updateTableView(priorityLinkedQueue);
    }


    @FXML
    void clearOnAction(ActionEvent event) {
        this.ChoiceBoxMood.getSelectionModel().clearSelection();
        this.ChoiceBoxPriority.getSelectionModel().clearSelection();
        this.TextfieldName.clear();
        if (priorityLinkedQueue.isEmpty()) {
            alert.setContentText(" Priority Linked Queue is empty");
            alert.showAndWait();
        } else {
            String decision = util.FXUtility.alertYesNo("Priority Linked Queue ", "Delete ALL items from the queue ", "Are you sure?");
            if (decision.equals("YES")) {
                priorityTableView.getItems().clear();
                priorityLinkedQueue.clear();
                util.Utility.setPriorityLinkedQueue(priorityLinkedQueue);
                alert = util.FXUtility.alert("Priority Linked Queue", "Clear queue");
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
            if (this.priorityLinkedQueue != null) {
                try {
                    if (!priorityLinkedQueue.isEmpty() &&
                            priorityLinkedQueue.contains(new Person(this.TextfieldName.getText(), this.ChoiceBoxMood.getValue()))) {
                        alert.setAlertType(Alert.AlertType.ERROR);
                        alert.setContentText("There's already Person in queue");
                    } else {
                        priorityLinkedQueue.enQueue(new Person(this.TextfieldName.getText(), this.ChoiceBoxMood.getValue(), this.ChoiceBoxPriority.getValue()), getPriority(this.ChoiceBoxPriority.getValue()));
                        alert.setAlertType(Alert.AlertType.INFORMATION);
                        alert.setContentText("Person  was added to the queue");
                        //actualizo la cola global
                        util.Utility.setPriorityLinkedQueue(priorityLinkedQueue);
                    }
                } catch (QueueException e) {
                    throw new RuntimeException(e);
                }
                alert.showAndWait();
                this.TextfieldName.clear();
                this.ChoiceBoxPriority.getSelectionModel().clearSelection();
                this.ChoiceBoxMood.getSelectionModel().clearSelection();
            }
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Complete the form with\nthe information, please");
            alert.showAndWait();
        }

        priorityTableView.getItems().clear();
        System.out.println(priorityLinkedQueue.toString());
        updateTableView(util.Utility.getPriorityLinkedQueue());
    }

    private Integer getPriority(String priority) {

        switch (priority) {
            case "Low":
                return 1;
            case "Medium":
                return 2;
            case "High":
                return 3;
        }
        return -1;
    }

    private boolean isValid() {
        return !this.TextfieldName.getText().isEmpty()
                && !this.ChoiceBoxMood.getValue().isEmpty()
                && !this.ChoiceBoxPriority.getValue().isEmpty();
    }

}
