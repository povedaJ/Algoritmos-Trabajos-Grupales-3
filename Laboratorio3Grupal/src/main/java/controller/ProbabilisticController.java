package controller;

import domain.Probabilistic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ProbabilisticController {


    @FXML
    private TextField nField;

    @FXML
    private TextArea textArea;
    Alert alert;
    Probabilistic prob;

    @FXML
    public void initialize() {
        alert = alert("Probabilistic Algorithm", "There was an error");
        alert.setAlertType(Alert.AlertType.ERROR);
        prob = new Probabilistic();
        this.textArea.setEditable(false);
    }

    @FXML
    void calculateOnAction(ActionEvent event) {
        String result = "Birthday Paradox Probability for ";
        if (isValid()) {
            int n = Integer.valueOf(this.nField.getText());
            result += n + " persons: "
                    + util.Utility.format(prob.BirthdayParadox(n)) + "%\n";
            this.textArea.setText(result);

        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Please complete the info and try again");
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
        this.nField.clear();
        this.textArea.clear();
    }

    private Alert alert(String title, String headerText) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(title);
        a.setHeaderText(headerText);
        DialogPane dp = a.getDialogPane();
        return a;
    }
}
