package controller;

import domain.StackException;
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
        count1 = count2 = 0;
    }

    @FXML
    void closeParenthesesOnAction(ActionEvent event) {
        if (isEmpty() && count1 > count2) {
            if (util.Utility.isPreviousNumber(this.TextFieldExp.getText())) {
                this.TextFieldExp.setText(this.TextFieldExp.getText() + ")");
                count2++;
            }
        }
    }

    private boolean isEmpty() {
        return !this.TextFieldExp.getText().isEmpty();
    }

    @FXML
    void deleteOnAction(ActionEvent event) {
        this.TextFieldExp.setText(util.Utility.deleteLastDigit(this.TextFieldExp.getText()));
    }

    @FXML
    void dividedOnAction(ActionEvent event) {
        //si tiene un numero adelante
        if (!this.TextFieldExp.getText().isEmpty()) {
            //si hay un operador antes se reemplaza
            if (util.Utility.isPreviousNumber(this.TextFieldExp.getText())) {
                this.TextFieldExp.setText(this.TextFieldExp.getText() + "/");
            } else {
                //si hay un operador antes se reemplaza
                while (!this.TextFieldExp.getText().isEmpty() && !util.Utility.isPreviousNumber(this.TextFieldExp.getText())) {
                    this.TextFieldExp.setText(util.Utility.deleteLastDigit(this.TextFieldExp.getText()));
                }
                if (!this.TextFieldExp.getText().isEmpty()) {
                    this.TextFieldExp.setText(this.TextFieldExp.getText() + "/");
                }
            }
        }
    }

    @FXML
    void eightOnAction(ActionEvent event) {
        this.TextFieldExp.setText(this.TextFieldExp.getText() + "8");
    }

    @FXML
    void equalOnAction(ActionEvent event) throws StackException {  // =
        if (!this.TextFieldExp.getText().isEmpty()) {
            // Hace una serie de condiciones
            String exp = util.Utility.infixToPostfixConverter(this.TextFieldExp.getText().toString());
            //Imprime la operacion  en el label  Y pone en el textField  el resultado
            this.labelExp.setText(this.TextFieldExp.getText() + "=");
            this.TextFieldExp.setText(util.Utility.postFixExpResult(exp));
        }
    }

    @FXML
    void exponentOnAction(ActionEvent event) {
        //si tiene un numero adelante
        if (!this.TextFieldExp.getText().isEmpty()) {
            //si hay un operador antes se reemplaza
            if (util.Utility.isPreviousNumber(this.TextFieldExp.getText())) {
                this.TextFieldExp.setText(this.TextFieldExp.getText() + "^");
            } else {
                //si hay un operador antes se reemplaza
                while (!this.TextFieldExp.getText().isEmpty() && !util.Utility.isPreviousNumber(this.TextFieldExp.getText())) {
                    this.TextFieldExp.setText(util.Utility.deleteLastDigit(this.TextFieldExp.getText()));
                }
                if (!this.TextFieldExp.getText().isEmpty()) {
                    this.TextFieldExp.setText(this.TextFieldExp.getText() + "^");
                }
            }
        }
    }

    @FXML
    void fiveOnAction(ActionEvent event) {
        this.TextFieldExp.setText(this.TextFieldExp.getText() + "5");
    }

    @FXML
    void fourOnAction(ActionEvent event) {
        this.TextFieldExp.setText(this.TextFieldExp.getText() + "4");
    }

    @FXML
    void minusOnAction(ActionEvent event) {
        if (!this.TextFieldExp.getText().isEmpty()) {
        //si hay un operador antes se reemplaza
        if (util.Utility.isPreviousNumber(this.TextFieldExp.getText())) {
            this.TextFieldExp.setText(this.TextFieldExp.getText() + "-");
        } else {
            //si hay un operador antes se reemplaza
            while (!this.TextFieldExp.getText().isEmpty() && !util.Utility.isPreviousNumber(this.TextFieldExp.getText())) {
                this.TextFieldExp.setText(util.Utility.deleteLastDigit(this.TextFieldExp.getText()));
            }
            if (!this.TextFieldExp.getText().isEmpty()) {
                this.TextFieldExp.setText(this.TextFieldExp.getText() + "-");
            }
        }}
    }

    @FXML
    void multiplyOnAction(ActionEvent event) { //*
        if (!this.TextFieldExp.getText().isEmpty()) {
            //si hay un operador antes se reemplaza
            if (util.Utility.isPreviousNumber(this.TextFieldExp.getText())) {
                this.TextFieldExp.setText(this.TextFieldExp.getText() + "*");
            } else {
                //si hay un operador antes se reemplaza
                while (!this.TextFieldExp.getText().isEmpty() && !util.Utility.isPreviousNumber(this.TextFieldExp.getText())) {
                    this.TextFieldExp.setText(util.Utility.deleteLastDigit(this.TextFieldExp.getText()));
                }
                if (!this.TextFieldExp.getText().isEmpty()) {
                    this.TextFieldExp.setText(this.TextFieldExp.getText() + "*");
                }
            }
        }
    }

    @FXML
    void nineOnAction(ActionEvent event) {
        this.TextFieldExp.setText(this.TextFieldExp.getText() + "9");
    }

    @FXML
    void oneOnAction(ActionEvent event) {
        this.TextFieldExp.setText(this.TextFieldExp.getText() + "1");
    }

    @FXML
    void openParenthesesOnAction(ActionEvent event) {
        String result = this.TextFieldExp.getText();
        if (this.TextFieldExp.getText().isEmpty()) {
            this.TextFieldExp.setText(result + "(");
            count1++;
        } else {
            if (!util.Utility.isPreviousNumber(result)) {
                this.TextFieldExp.setText(result + "(");
                count1++;
            }
        }
    }

    @FXML
    void plusOnAction(ActionEvent event) {
        if (!this.TextFieldExp.getText().isEmpty()) {
            if (util.Utility.isPreviousNumber(this.TextFieldExp.getText())) {
                this.TextFieldExp.setText(this.TextFieldExp.getText() + "+");
            } else {
                //si hay un operador antes se reemplaza
                while (!this.TextFieldExp.getText().isEmpty() && !util.Utility.isPreviousNumber(this.TextFieldExp.getText())) {
                    this.TextFieldExp.setText(util.Utility.deleteLastDigit(this.TextFieldExp.getText()));
                }
                if (!this.TextFieldExp.getText().isEmpty()) {
                    this.TextFieldExp.setText(this.TextFieldExp.getText() + "+");
                }
            }
        }
    }

    @FXML
    void sevenOnAction(ActionEvent event) {
        this.TextFieldExp.setText(this.TextFieldExp.getText() + "7");
    }

    @FXML
    void sixOnAction(ActionEvent event) {
        this.TextFieldExp.setText(this.TextFieldExp.getText() + "6");
    }

    @FXML
    void threeOnAction(ActionEvent event) {
        this.TextFieldExp.setText(this.TextFieldExp.getText() + "3");
    }

    @FXML
    void twoOnAction(ActionEvent event) {
        this.TextFieldExp.setText(this.TextFieldExp.getText() + "2");
    }

    @FXML
    void zeroOnAction(ActionEvent event) {
        this.TextFieldExp.setText(this.TextFieldExp.getText() + "0");
    }


}
