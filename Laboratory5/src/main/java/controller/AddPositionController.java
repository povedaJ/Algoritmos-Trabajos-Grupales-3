package controller;

import domain.CircularDoublyLinkedList;
import domain.JobPosition;
import domain.ListException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import ucr.laboratory5.HelloApplication;
import util.FXUtility;

import java.io.IOException;

public class AddPositionController {

    @FXML
    private BorderPane bp;

    @FXML
    private TextField textFieldDescription;

    @FXML
    private TextField textFieldHourlyWage;

    @FXML
    private TextField textFieldID;
    private CircularDoublyLinkedList jobPositionList;
    Alert alert;


    @FXML
    public void initialize() {
        //cargo la lista
        this.jobPositionList = util.Utility.getJobPositionList();
        this.textFieldID.setText(String.valueOf(getMaxId(jobPositionList)));
        alert = util.FXUtility.alert("", "");
    }

    private int getMaxId(CircularDoublyLinkedList list) {
        int maxValue = 0;
        try{
            int n = list.size();
            for (int i = 1; i <= n ; i++) {
                JobPosition jp = (JobPosition) list.getNode(i).data;
                if(maxValue<jp.getId()){
                    maxValue = jp.getId();
                }
            }
        }catch (ListException ex){
            System.out.println(ex.getMessage());
        }
        return maxValue+1;
    }
@FXML
public void hwageKyTypedPressed(Event event) {
    // force the field to be numeric only
    textFieldHourlyWage.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue,
                            String newValue) {
            if (!newValue.matches("\\d*")) {
                textFieldHourlyWage.setText(newValue.replaceAll("[^\\d]", ""));
            }
        }
    });
}


    private void loadPage(String page) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(page));
        try {
            this.bp.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnAdd(ActionEvent event) {
        if(isValid()){
            Double hourlyWage = Double.parseDouble(
                    this.textFieldHourlyWage.getText()
            );
            String name = this.textFieldDescription.getText();
            if(this.jobPositionList!=null){
                try {
                    if(!jobPositionList.isEmpty()&&jobPositionList.contains(new JobPosition(name))) {
                        alert.setAlertType(Alert.AlertType.ERROR);
                        alert.setContentText("There's already a Job Position with this name");
                    }else{
                        this.jobPositionList.add(new JobPosition(name, hourlyWage));
                        alert.setAlertType(Alert.AlertType.INFORMATION);
                        alert.setContentText("Job Position was added to the list");
                        //actualizo la lista global
                        util.Utility.setJobPositionList(this.jobPositionList);
                    }
                } catch (ListException e) {
                    throw new RuntimeException(e);
                }
                alert.showAndWait();
                btnClean(event);
            }
        }else{
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Complete the form with\nthe information, please");
            alert.showAndWait();
        }
    }

    private boolean isValid() {
        return !this.textFieldID.getText().isEmpty()
                &&!this.textFieldDescription.getText().isEmpty()
                &&!this.textFieldHourlyWage.getText().isEmpty();
    }

    @FXML
    void btnClean(ActionEvent event) {
        this.textFieldID.setText(String.valueOf(this.getMaxId(this.jobPositionList)));
        this.textFieldDescription.setText("");
        this.textFieldHourlyWage.setText("");
    }

    @FXML
    void btnCloseOnAction(ActionEvent event) {
      loadPage("positions.fxml");
    }

    @FXML
    void onKeyTypeCreditsValidation(KeyEvent event) {

    }
    @FXML
    void hwageKyTypedPressed(KeyEvent event) {
        // force the field to be numeric only
        textFieldHourlyWage.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    textFieldHourlyWage.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

}
