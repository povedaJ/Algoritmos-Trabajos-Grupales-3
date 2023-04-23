package controller;

import domain.CircularLinkedList;
import domain.Employee;
import domain.ListException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import ucr.laboratory5.HelloApplication;

import java.io.IOException;
import java.util.Date;

public class AddEmployeeController {

    @FXML
    private DatePicker DatePickerBirthday;

    @FXML
    private BorderPane bp;

    @FXML
    private TextField textFieldFirtsName;

    @FXML
    private TextField textFieldID;

    @FXML
    private TextField textFieldLastName;

    @FXML
    private TextField textFieldTitle;
    private CircularLinkedList employeesList;
    Alert alert;

    public void initialize(){
        //carga la lista
        this.employeesList = util.Utility.getEmployeeList();
        this.alert = util.FXUtility.alert("Employees Circular Linked List","Add Employees...");
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
    public void onKeyTypeCreditsValidation(Event event) { // para que solo me deje agregar el tipo de dato que recibe
    }
    @FXML
    void btnAdd(ActionEvent event) {
        alert.setHeaderText("Adding employees...");
        try {
            if(isValid()){
                int id = Integer.parseInt(this.textFieldID.getText());
                Date fecha = util.Utility.aDate(this.DatePickerBirthday.getValue()); //de localDate a Date
                Employee newEmployee = new Employee(
                        id,
                        this.textFieldLastName.textProperty().getValue(),
                        this.textFieldFirtsName.textProperty().getValue(),
                        this.textFieldTitle.textProperty().getValue(),
                        fecha
                );
                if (employeesList.isEmpty()|| !employeesList.contains(newEmployee)){
                    employeesList.add(newEmployee);
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setContentText("The employee was added to the list");
                    //settear lista de utiliti, la global
                    util.Utility.setEmployeeList(employeesList);
                }else{
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText("The employee already exists in the list");
                }
            }else{
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Complete the form with \nthe information, please");
            }
            alert.showAndWait();
            btnClean(event); //llama al boton clean
        }catch (ListException ex){
            System.out.println(ex.getMessage());
        }
    }

    private boolean isValid() {
        return !this.textFieldID.getText().isEmpty();
    }
    @FXML
    void btnClean(ActionEvent event) {
        this.textFieldFirtsName.clear();
        this.textFieldID.clear();
        this.textFieldLastName.clear();
        this.textFieldTitle.clear();
        this.DatePickerBirthday.cancelEdit();
    }

    @FXML
    void btnCloseOnAction(ActionEvent event) {
loadPage("employees.fxml");
    }

    @FXML
    void onKeyTypeCreditsValidation(KeyEvent event) {

    }

}
