package controller;

import domain.Vector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class VectorController {
    Alert alert;
    Vector vector;
    @FXML
    private TextField maxField;
    @FXML
    private TextArea textArea;

    @FXML
    public void initialize() {
        alert = alert("Vector Algorithm", "There was an error");
        alert.setAlertType(Alert.AlertType.ERROR);
    }

    @FXML
    void addIndexOnAction(ActionEvent event) {
        //inserta elemento en la posicion dada  //el valor del elemento no cambia, por el momento es 50
        if (isValid()) {
            int i= (int) Integer.valueOf(this.maxField.getText());

            int result= 50;  //da el valor de posision i
            vector.add(i, result);
            this.textArea.setText("The added element is: " + result + "\n" + vector.toString());

        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Please complete the info and try again");
            alert.showAndWait();
        }

    }

    @FXML
    void addVlueOnAction(ActionEvent event) {
        //inserta elemento al final
        if (isValid()) {
            vector.add(Integer.valueOf(this.maxField.getText()));
            this.textArea.setText("Element added successfully"+vector.toString());
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Please complete the info and try again");
            alert.showAndWait();
        }
    }

    @FXML
    void clearOnAction(ActionEvent event) {
        this.maxField.clear();
        this.textArea.clear();

    }

    @FXML
    void containsOnAction(ActionEvent event) {
        //Si el elemento existe
        if (isValid()) {
            if(vector.contains(Integer.valueOf(this.maxField.getText()))){
                textArea.setText("The element exists");
            }else{
                textArea.setText("The element don't exist");
            }
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Please complete the info and try again");
            alert.showAndWait();
        }
    }

    @FXML
    void fillShowOnAction(ActionEvent event) {
        if (isValid()) {
            vector = new Vector(Integer.valueOf(this.maxField.getText()));
            util.Utility.fill(vector);
            vector.sort();
            this.textArea.setText(vector.toString());
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Please complete the info and try again");
            alert.showAndWait();
        }

    }

    private boolean isValid() {
        return !this.maxField.getText().isEmpty();
    }


    @FXML
    void removeIndexOnAction(ActionEvent event) {
        if (isValid()) {
            int i= (int) Integer.valueOf(this.maxField.getText());
            this.textArea.setText("The removed element is: "+vector.remove(i)+"\n"+vector.toString());
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Please complete the info and try again");
            alert.showAndWait();
        }
    }

    @FXML
    void removeValueOnAction(ActionEvent event) {
        //recibe un valor y lo elimina del vector
        if (isValid()) {
            int i= (int) Integer.valueOf(this.maxField.getText());
            int resul= vector.indexOf(i); //busca la posicion del valor
            if(resul==-1){
                this.textArea.setText("Element not found");
            }else {
                this.textArea.setText("The removed element is: " + vector.remove(resul) + "\n" + vector.toString());
            }
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Please complete the info and try again");
            alert.showAndWait();
        }
    }

    @FXML
    void sizeOnAction(ActionEvent event) {

        if (isValid()) {
            textArea.setText("The vector size is : " + vector.size());
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Please complete the info and try again");
            alert.showAndWait();
        }

    }

    private Alert alert(String title, String headerText) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(title);
        a.setHeaderText(headerText);
        DialogPane dp = a.getDialogPane();
        return a;
    }

}
