package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class CalculatorController {

    @FXML
    private TextField TextFieldExp;

    @FXML
    private BorderPane bp;

    @FXML
    private Label labelExp;

    @FXML
    void cleanAddOnAction(ActionEvent event) {
        this.labelExp.setText("");
        this.TextFieldExp.clear();
    }

    @FXML
    void closeParenthesesOnAction(ActionEvent event) {
        if (isEmpty()) {
            this.TextFieldExp.setText(this.TextFieldExp.getText()+")");
        }
    }

    private boolean isEmpty() {
        return !this.TextFieldExp.getText().isEmpty();
    }

    @FXML
    void deleteOnAction(ActionEvent event) {

    }

    @FXML
    void dividedOnAction(ActionEvent event) {

    }

    @FXML
    void eightOnAction(ActionEvent event) {

    }

    @FXML
    void equalOnAction(ActionEvent event) {

    }

    @FXML
    void exponentOnAction(ActionEvent event) {

    }

    @FXML
    void fiveOnAction(ActionEvent event) {

    }

    @FXML
    void fourOnAction(ActionEvent event) {

    }

    @FXML
    void minusOnAction(ActionEvent event) {

    }

    @FXML
    void multiplyOnAction(ActionEvent event) {

    }

    @FXML
    void nineOnAction(ActionEvent event) {

    }

    @FXML
    void oneOnAction(ActionEvent event) {

    }

    @FXML
    void openParenthesesOnAction(ActionEvent event) {
        if (!isEmpty()) {
            this.TextFieldExp.setText(this.TextFieldExp.getText()+"(");
        }
    }

    @FXML
    void plusOnAction(ActionEvent event) {

    }

    @FXML
    void sevenOnAction(ActionEvent event) {

    }

    @FXML
    void sixOnAction(ActionEvent event) {

    }

    @FXML
    void threeOnAction(ActionEvent event) {

    }

    @FXML
    void twoOnAction(ActionEvent event) {

    }

    @FXML
    void zeroOnAction(ActionEvent event) {

    }


}
