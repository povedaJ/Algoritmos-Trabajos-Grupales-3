package controller;

import domain.Dynamic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class DynamicController {

    @FXML
    private ChoiceBox<String> choicebox;
    private String[] choice = {"Factorial", "Fibonacci"};
    @FXML
    private TextField cbField;


    @FXML
    private TextField nField;

    @FXML
    private TextField resultCB;



    Alert alert;

    Dynamic dynamic;


    public void initialize() {

        this.choicebox.getItems().addAll(choice);
        dynamic = new Dynamic();
        this.cbField.setVisible(false);
        this.cbField.setEditable(false);
        this.resultCB.setEditable(false);
        alert = alert("Dynamic Algorithms ", "There was an error");
        alert.setAlertType(Alert.AlertType.ERROR);
    }

    @FXML
    void calculateOnAction(ActionEvent event) {

        if (choicebox.getValue() == "Factorial" && isValid()) {
            this.cbField.setText(choicebox.getValue());
            long n = Long.valueOf(this.nField.getText());
            n = dynamic.factorial(n);
            this.cbField.setText(this.choicebox.getValue());
            this.cbField.setVisible(true);
            this.resultCB.setText(String.valueOf(n));
        } else if (choicebox.getValue() == "Fibonacci" && isValid()) {
            this.cbField.setText(choicebox.getValue());
            int n =Integer.valueOf(this.nField.getText());
            n = dynamic.fibonacci2(n);
            this.cbField.setText(this.choicebox.getValue());
            this.cbField.setVisible(true);
            this.resultCB.setText(String.valueOf(n));
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Please choose an algorithm and try again");
            alert.showAndWait();
        }

    }

    private boolean isValid() {
        if (!this.nField.getText().isEmpty() && esNumerico(this.nField.getText())) {

            return true;
        } else
            return false;
    }

    public static boolean esNumerico(String valor) {
        try {
            if (valor != null) {
                Integer.parseInt(valor);
                return true;
            }
        } catch (NumberFormatException nfe) {
            return false;
        }
        return false;
    }

    @FXML
    void clearOnAction(ActionEvent event) {
        this.resultCB.clear();
        this.nField.clear();
        this.cbField.clear();
        this.cbField.setVisible(false);




    }

    private Alert alert(String title, String headerText) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(title);
        a.setHeaderText(headerText);
        DialogPane dp = a.getDialogPane();
        return a;
    }

}
