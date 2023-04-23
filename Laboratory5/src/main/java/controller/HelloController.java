package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import ucr.laboratory5.HelloApplication;

import java.io.IOException;

public class HelloController {

    @FXML
    private BorderPane bp;
    @FXML
    private AnchorPane ap;
    @FXML
    private Text txtMessage;

    private void loadPage(String page) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(page));
        try {
            this.bp.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void Exit(ActionEvent event) {
        String decision = util.FXUtility.alertYesNo("Laboratory 5", "Closing the project.... " , "Aree you sure?");
        if (decision.equals("YES")) {
            System.exit(0);
        }
    }

    @FXML
    void Home(ActionEvent event) {
        this.txtMessage.setText("Laboratory No. 5");
        this.bp.setCenter(ap);
    }


    @FXML
    void employeesOnAction(ActionEvent event) {
loadPage("employees.fxml");
    }

    @FXML
    void positionsOnAction(ActionEvent event) {
        loadPage("positions.fxml");

    }

}