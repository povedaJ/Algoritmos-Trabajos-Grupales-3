package controller;

import domain.StackException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ConverterController {

    @FXML
    private TextField exp1TextField;

    @FXML
    private TextField exp2TextField;

    @FXML
    private TextField exp3TextField;

    @FXML
    private TextField exp4TextField;

    @FXML
    private TextField exp5TextField;

    @FXML
    private RadioButton infixRadioButton;

    @FXML
    private Text msg1Text;

    @FXML
    private Text msg2Text;

    @FXML
    private RadioButton postfixRadioButton;

    @FXML
    private Text result1Text;

    @FXML
    private Text result2Text;

    @FXML
    private Text result3Text;

    @FXML
    private Text result4Text;

    @FXML
    private Text result5Text;

    @FXML
    void initialize() {
        cleanOnAction(new ActionEvent());

    }

    @FXML
    void cleanOnAction(ActionEvent event) {
        //limpio los objetos tipo texyfield
        this.exp1TextField.setText("");
        this.exp2TextField.setText("");
        this.exp3TextField.setText("");
        this.exp4TextField.setText("");
        this.exp5TextField.clear();
        //limpio los objetos tipo text, de resultado
        this.result1Text.setText("");
        this.result2Text.setText("");
        this.result3Text.setText("");
        this.result4Text.setText("");
        this.result5Text.setText("");

    }

    @FXML
    void convertOnAction(ActionEvent event) {
        try {
            //expresion1
            if (!this.exp1TextField.getText().isEmpty()) {//convertimos infijo a postfijo
                if (this.infixRadioButton.isSelected()) {
                   String result =util.Utility.infixToPostfixConverter(this.exp1TextField.getText());
                this.result1Text.setText(result);
                    if(util.Utility.isNumberExp(this.exp1TextField.getText())){
                        this.result1Text.setText(result+" = "+util.Utility.postFixExpResult(result));
                }
                } else {//convertimos posfijo ingijo
                    String result =util.Utility.postfixToInfixConverter(this.exp1TextField.getText());
                    this.result1Text.setText(result);

                    if(util.Utility.isNumberExp(this.exp1TextField.getText())){
                        this.result1Text.setText(result+" = "+ util.Utility.inFixExpResult(result));
                    }

                }
            }
            //expresion2
            if (!this.exp2TextField.getText().isEmpty()) {//convertimos infijo a postfijo
                if (this.infixRadioButton.isSelected()) {
                   String result =util.Utility.infixToPostfixConverter(this.exp2TextField.getText());
                this.result2Text.setText(result);
                    if(util.Utility.isNumberExp(this.exp2TextField.getText())){
                        this.result2Text.setText(result+" = "+util.Utility.postFixExpResult(result));
                }
                } else {//convertimos posfijo ingijo
                    String result =util.Utility.postfixToInfixConverter(this.exp2TextField.getText());
                    this.result2Text.setText(result);

                    if(util.Utility.isNumberExp(this.exp2TextField.getText())){
                        this.result2Text.setText(result+" = "+ util.Utility.inFixExpResult(result));
                    }

                }
            }
            //expresion3
            if (!this.exp3TextField.getText().isEmpty()) {//convertimos infijo a postfijo
                if (this.infixRadioButton.isSelected()) {
                    String result =util.Utility.infixToPostfixConverter(this.exp3TextField.getText());
                    this.result3Text.setText(result);
                    if(util.Utility.isNumberExp(this.exp3TextField.getText())){
                        this.result3Text.setText(result+" = "+util.Utility.postFixExpResult(result));
                    }
                } else {//convertimos posfijo ingijo
                    String result =util.Utility.postfixToInfixConverter(this.exp3TextField.getText());
                    this.result3Text.setText(result);

                    if(util.Utility.isNumberExp(this.exp3TextField.getText())){
                        this.result3Text.setText(result+" = "+ util.Utility.inFixExpResult(result));
                    }

                }
            }
            //expresion4
            if (!this.exp4TextField.getText().isEmpty()) {//convertimos infijo a postfijo
                if (this.infixRadioButton.isSelected()) {
                    String result =util.Utility.infixToPostfixConverter(this.exp4TextField.getText());
                    this.result4Text.setText(result);
                    if(util.Utility.isNumberExp(this.exp4TextField.getText())){
                        this.result4Text.setText(result+" = "+util.Utility.postFixExpResult(result));
                    }
                } else {//convertimos posfijo ingijo
                    String result =util.Utility.postfixToInfixConverter(this.exp4TextField.getText());
                    this.result4Text.setText(result);

                    if(util.Utility.isNumberExp(this.exp4TextField.getText())){
                        this.result4Text.setText(result+" = "+ util.Utility.inFixExpResult(result));
                    }

                }
            }
            //expresion5
            if (!this.exp5TextField.getText().isEmpty()) {//convertimos infijo a postfijo
                if (this.infixRadioButton.isSelected()) {
                    String result =util.Utility.infixToPostfixConverter(this.exp5TextField.getText());
                    this.result5Text.setText(result);
                    if(util.Utility.isNumberExp(this.exp5TextField.getText())){
                        this.result5Text.setText(result+" = "+util.Utility.postFixExpResult(result));
                    }
                } else {//convertimos posfijo ingijo
                    String result =util.Utility.postfixToInfixConverter(this.exp5TextField.getText());
                    this.result5Text.setText(result);

                    if(util.Utility.isNumberExp(this.exp5TextField.getText())){
                        this.result5Text.setText(result+" = "+ util.Utility.inFixExpResult(result));
                    }

                }
            }
        } catch (StackException e) {
            throw new RuntimeException(e);
        }
    }



    @FXML
    void infixToPostfixOnAction(ActionEvent event) {
        cleanOnAction(event);
        this.msg1Text.setText("Infix");
        this.msg2Text.setText("PostFix");
        this.postfixRadioButton.setSelected(!this.postfixRadioButton.selectedProperty().getValue());
        // si esta selecionado lo deselecciono
    }

    @FXML
    void postfixToInfixOnAction(ActionEvent event) {
        cleanOnAction(event);
        this.msg1Text.setText("Postfix");
        this.msg2Text.setText("InFix");
        this.infixRadioButton.setSelected(!this.infixRadioButton.selectedProperty().getValue());
    }

}
