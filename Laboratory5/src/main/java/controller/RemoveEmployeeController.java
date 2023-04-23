package controller;

import domain.CircularLinkedList;
import domain.Employee;
import domain.ListException;
import domain.SinglyLinkedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import ucr.laboratory5.HelloApplication;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public class RemoveEmployeeController {
    @FXML
    private BorderPane bp;

    @FXML
    private TextField textFieldTitle; //address

    @FXML
    private TextField textFieldFirstName; //age

    @FXML
    private TextField textFieldID;

    @FXML
    private TextField textFieldLastName; //name
    @FXML
    private TextField textFieldBirthday; //se debe agregar

    private CircularLinkedList employeesList;
    private Alert alert;

    @FXML
    public void initialize(){
        //carga la lista
        this.employeesList = util.Utility.getEmployeeList();
        this.alert = util.FXUtility.alert("Employees Circular Linked List","Remove Employees");
    }
    private void loadPage(String page){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(page));
        try {
            this.bp.setCenter(fxmlLoader.load());
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    @FXML
    void btnClean(ActionEvent event){
        this.textFieldID.clear();
        this.textFieldLastName.clear();
        this.textFieldFirstName.clear();
        this.textFieldTitle.clear();
        this.textFieldBirthday.clear();
    }
    @FXML
    void btnCloseOnAction(ActionEvent event){loadPage("employees.fxml"); }
    @FXML
    private boolean isValid(){return !this.textFieldID.getText().isEmpty();}
    @FXML
    void btnRemove(ActionEvent event){
        alert.setHeaderText("Remove employees...");
        try {
            if(isValid()){
                int id = Integer.parseInt(this.textFieldID.getText());
                Date fecha = util.Utility.convierteDate(this.textFieldBirthday.textProperty().getValue());
                Employee newEmployee = new Employee(
                        id,
                        this.textFieldLastName.textProperty().getValue(),
                        this.textFieldFirstName.textProperty().getValue(),
                        this.textFieldTitle.textProperty().getValue(),
                        fecha
                );
                if (!employeesList.isEmpty()&& employeesList.contains(newEmployee)){
                    employeesList.remove(newEmployee);
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setContentText("The employee was removed to the list");
                    //settear lista de utiliti, la global
                    util.Utility.setEmployeeList(employeesList);
                }else{
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText("The employee do not exists in the list");
                }
            }else{
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Complete the form with \nthe information, please");
            }
            alert.showAndWait();
            btnClean(event); //llama al boton clean
        }catch (ListException ex){
            System.out.println(ex.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }//finRemove

    @FXML
    void onKeyTypeAgeValidation(KeyEvent event) {}

}//fin
