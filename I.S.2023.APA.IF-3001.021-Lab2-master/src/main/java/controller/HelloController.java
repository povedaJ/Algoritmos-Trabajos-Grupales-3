package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import ucr.lab2.HelloApplication;
import java.io.IOException;

public class HelloController {

    @FXML
    private BorderPane bp;
    @FXML
    private AnchorPane ap;
    @FXML
    private Text txtMessage;

    private void loadPage(String page){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(page));
        try {
            this.bp.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void Exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void Home(ActionEvent event) {
        this.txtMessage.setText("Laboratory No. 2");
        this.bp.setCenter(ap);
    }

    @FXML
    void knapsackOnMousePressed(MouseEvent event) {
        this.txtMessage.setText("Loading Knapsack Problem. Please wait!!!");
        this.bp.setCenter(ap);
    }

    @FXML
    void knapsackProblem(ActionEvent event) {
        loadPage("KnapsackProblem.fxml");
    }

    @FXML
    void knightTour(ActionEvent event)  {loadPage("knightTour.fxml");}

    @FXML
    void knightTourOnMousePressed(MouseEvent event) {
        this.txtMessage.setText("Loading The Knight Tour. Please wait!!!");
        this.bp.setCenter(ap);
    }

    @FXML
    void nQueenOnMousePressed(MouseEvent event) {
        this.txtMessage.setText("Loading N Queen Problem. Please wait!!!");
        this.bp.setCenter(ap);
    }

    @FXML
    void nQueenProblem(ActionEvent event) {
        loadPage("nQueenProblem.fxml");
    }

    @FXML
    void ratInMaze(ActionEvent event) {
        loadPage("ratInMaze.fxml");
    }

    @FXML
    void ratInMazeOnMousePressed(MouseEvent event) {
        this.txtMessage.setText("Loading Rat in a Maze. Please wait!!!");
        this.bp.setCenter(ap);
    }

    @FXML
    void sudokuOnMousePressed(MouseEvent event) {
        this.txtMessage.setText("Loading Sudoku Solver. Please wait!!!");
        this.bp.setCenter(ap);
    }

    @FXML
    void sudokuSolver(ActionEvent event) {
        loadPage("sudokuSolver.fxml");
    }
}