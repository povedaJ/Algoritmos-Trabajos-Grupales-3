package controller;

import domain.DivideAndConquer;
import domain.Dynamic;
import domain.Vector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Collections;

public class DivideAndConquerController {

    @FXML
    private ChoiceBox<String> choicebox;
    private String[] choice = {"Iteractive BS", "Recursive BS"};
    @FXML
    private TextField nField;
    Alert alert;
    @FXML
    private TextArea textArea;
    DivideAndConquer dAndc;
    Vector vector;

    public void initialize() {

        this.choicebox.getItems().addAll(choice);
        dAndc = new DivideAndConquer();
        this.textArea.setEditable(false);
        alert = alert("Divide & Conquer ", "There was an error");
        alert.setAlertType(Alert.AlertType.ERROR);
    }

    @FXML
    void clearOnAction(ActionEvent event) {
        this.textArea.clear();
        this.nField.clear();
        vector.clear();
    }

    @FXML
    void searchOnAction(ActionEvent event) {
        String result = " BINARY SEARCH TEST\n";
        if (choicebox.getValue() == "Iteractive BS"|| choicebox.getValue() == "Recursive BS" ){
        for (int i = 0; i < 20; i++) {
            int value = util.Utility.random(99);
            int indexArrays = java.util.Arrays.binarySearch(vector.getData(), value);
            //java.util.Arrays
            result += indexArrays >= 0
                    ? "java.util.Arrays class BS... the element [" + value + "] exist at the position " + indexArrays+"\n"
                    : "java.util.Arrays class BS... the element [" + value + "] does not exist in vector\n";

            //java.util.collection
            indexArrays= Collections.binarySearch(getDataList(vector),value);

            result+= indexArrays>=0
                            ?"java.util.collections BS... the element ["+value+"] exist at the position "+indexArrays+"\n"
                            :"java.util.collections  BS... the element ["+value+"] does not exist in vector\n";


            if (choicebox.getValue() == "Iteractive BS") {


                indexArrays= domain.DivideAndConquer.binarySearch(vector.getData(), value);

                result+=
                        indexArrays>=0
                                ?"domain.DivideAndConquer.BS (iterative ) ["+value+"] exist at the position "+indexArrays+"\n"
                                :"domain.DivideAndConquer.BS (iterative ) ["+value+"] does not exist in vector \n";

            } else if (choicebox.getValue() == "Recursive BS") {
                indexArrays= domain.DivideAndConquer.binarySearchRecursive(vector.getData(), value,0,vector.size()-1);

               result+=
                        indexArrays>=0 && indexArrays<50
                                ?"domain.DivideAndConquer.BS (recursive ) ["+value+"] exist at the position "+indexArrays+"\n"
                                :"domain.DivideAndConquer.BS (recursive ) ["+value+"] does not exist in vector\n";

            } result+="\n\n";
            this.textArea.setText(result);
        }}else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Please complete the info and try again");
            alert.showAndWait();
        }

        }

    public ArrayList<Integer> getDataList(Vector v) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < v.size(); i++) {
            list.add((int) v.get(i)) ;
        }
        return list;
    }
    @FXML
    void showOnAction(ActionEvent event) {
        // permite mostrar el contenido del vector con el tamaño indicado.
        if (isValid()) {
            int n = Integer.valueOf(this.nField.getText());
            vector = new Vector(n);
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

    private Alert alert(String title, String headerText) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(title);
        a.setHeaderText(headerText);
        DialogPane dp = a.getDialogPane();
        return a;
    }

}
