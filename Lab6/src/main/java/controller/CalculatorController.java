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
        //si tiene un numero adelante
        this.TextFieldExp.setText(this.TextFieldExp.getText()+"/");
    }

    @FXML
    void eightOnAction(ActionEvent event) {
        this.TextFieldExp.setText(this.TextFieldExp.getText()+"8");
    }

    @FXML
    void equalOnAction(ActionEvent event) {  // =
        // Hace una serie de condiciones

        //Imprime esto en el texto de arriba. Y sustituye lo de abajo con el resultado
    }

    @FXML
    void exponentOnAction(ActionEvent event) {
        //si tiene un numero adelante
        this.TextFieldExp.setText(this.TextFieldExp.getText()+"^");
    }

    @FXML
    void fiveOnAction(ActionEvent event) {
        this.TextFieldExp.setText(this.TextFieldExp.getText()+"5");
    }

    @FXML
    void fourOnAction(ActionEvent event) {
        this.TextFieldExp.setText(this.TextFieldExp.getText()+"4");
    }

    @FXML
    void minusOnAction(ActionEvent event) {
        //si tiene un numero adelante
        this.TextFieldExp.setText(this.TextFieldExp.getText()+"-");
    }

    @FXML
    void multiplyOnAction(ActionEvent event) { //*
        //si tiene un numero adelante
        this.TextFieldExp.setText(this.TextFieldExp.getText()+"x");
    }

    @FXML
    void nineOnAction(ActionEvent event) {
        this.TextFieldExp.setText(this.TextFieldExp.getText()+"9");
    }

    @FXML
    void oneOnAction(ActionEvent event) {
        this.TextFieldExp.setText(this.TextFieldExp.getText()+"1");
    }

    @FXML
    void openParenthesesOnAction(ActionEvent event) {
        this.TextFieldExp.setText(this.TextFieldExp.getText()+"(");
        count1++;
    }

    @FXML
    void plusOnAction(ActionEvent event) {
        //si tiene un numero adelante
        this.TextFieldExp.setText(this.TextFieldExp.getText()+"+");
    }

    @FXML
    void sevenOnAction(ActionEvent event) {
        this.TextFieldExp.setText(this.TextFieldExp.getText()+"7");
    }

    @FXML
    void sixOnAction(ActionEvent event) {
        this.TextFieldExp.setText(this.TextFieldExp.getText()+"6");
    }

    @FXML
    void threeOnAction(ActionEvent event) {
        this.TextFieldExp.setText(this.TextFieldExp.getText()+"3");
    }

    @FXML
    void twoOnAction(ActionEvent event) {
        this.TextFieldExp.setText(this.TextFieldExp.getText()+"2");
    }

    @FXML
    void zeroOnAction(ActionEvent event) {
        this.TextFieldExp.setText(this.TextFieldExp.getText()+"0");
    }


}
