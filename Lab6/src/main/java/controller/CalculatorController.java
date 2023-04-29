package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class CalculatorController {
    private int count1; // "("
    private int count2;// ")"

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
        count1=count2=0;
    }

    @FXML
    void closeParenthesesOnAction(ActionEvent event) {
        if (isEmpty() && count1>count2) {
            this.TextFieldExp.setText(this.TextFieldExp.getText()+")");
            count2++;
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
        this.TextFieldExp.setText(this.TextFieldExp.getText()+"(");
        count1++;
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
