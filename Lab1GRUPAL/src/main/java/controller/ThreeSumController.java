package controller;

import domain.Stopwatch;
import domain.TestData;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ThreeSumController
{
    @javafx.fxml.FXML
    private BarChart barChart;
    @javafx.fxml.FXML
    private TextArea textArea;
    @javafx.fxml.FXML
    private Button btnRefresh;
    private TestData testData[];

    @javafx.fxml.FXML
    public void initialize() {
        this.testData = new TestData[5]; //TestData array
        this.textArea.setText(domain.ThreeSum.test1());
        testThreeSumCount(); //test for Bar Chart
        barChartGetData(); //BarChart info
    }

    private void testThreeSumCount(){
        for (int i = 0; i < 5; i++) {
            Stopwatch timer = new Stopwatch();
            int result = domain.ThreeSum.count(domain.ThreeSum.getA());
            double time = timer.elapsedTime();
            this.testData[i] = new TestData("Triples test-"+(i+1), time);
        }
    }

    private void barChartGetData() {
        barChart.getData().add(
                new XYChart.Series<String, Double>("Example Class",
                        FXCollections.observableArrayList(
                                new XYChart.Data<String, Double>(testData[0].getInfo(), testData[0].getTime()),
                                new XYChart.Data<String, Double>(testData[1].getInfo(), testData[1].getTime()),
                                new XYChart.Data<String, Double>(testData[2].getInfo(), testData[2].getTime()),
                                new XYChart.Data<String, Double>(testData[3].getInfo(), testData[3].getTime()),
                                new XYChart.Data<String, Double>(testData[4].getInfo(), testData[4].getTime()))
                ));
    }

    @javafx.fxml.FXML
    public void refreshOnAction(ActionEvent actionEvent) {
        testThreeSumCount(); //test for Bar Chart
        this.barChart.getData().clear();
        barChartGetData(); //BarChart info
        this.btnRefresh.setText("Refresh");
    }

    @javafx.fxml.FXML
    public void refreshOnMousePressed(Event event) {
        this.btnRefresh.setText("Updating!!!");
    }
}