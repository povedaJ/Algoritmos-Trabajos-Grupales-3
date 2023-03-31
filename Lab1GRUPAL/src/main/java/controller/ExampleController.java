package controller;

import domain.Example;
import domain.Stopwatch;
import domain.TestData;
import javafx.collections.FXCollections;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextArea;

public class ExampleController
{
    @javafx.fxml.FXML
    private BarChart barChart;
    private final int N=10000000; //example1, example2, example4
    private final int M=100000; //example3
    private final int P=2000; //example5
    private final int Q=3000; //example5
    private int a[];
    private int b[];
    private int c[];
    private int d[];
    private Example example;
    private TestData testData[];
    @javafx.fxml.FXML
    private TextArea textArea;

    @javafx.fxml.FXML
    public void initialize() {
        this.example = new Example();
        this.a = new int[N];
        this.b = new int[M];
        this.c = new int[P];
        this.d = new int[Q];
        this.testData = new TestData[5]; //TestData array
        util.Utility.fill(a); util.Utility.fill(b);
        util.Utility.fill(c); util.Utility.fill(d);
        textArea.setText(testExample1()+"\n"+testExample2()+"\n"+testExample3()+"\n"+testExample4()+"\n"+testExample5());

        //BarChart info
        barChartGetData();
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

    public String testExample1() {
        String resultTest="";
        Stopwatch timer = new Stopwatch();
        int result = example.example1(a);
        double time = timer.elapsedTime();
        String hhmmss = timer.elapsedTimeHMS();
        this.testData[0] = new TestData("example1", time);
        resultTest+=
                "Test Example 1"
                        +"\nn: "+util.Utility.format(N)
                        +"\nResult: "+util.Utility.format(result)
                        +"\nTn: "+util.Utility.format(time)+" milliseconds"
                        +"\nTn: "+hhmmss+"\n";
        return resultTest;
    }

    public String testExample2() {
        String resultTest="";
        Stopwatch timer = new Stopwatch();
        int result = example.example2(a);
        double time = timer.elapsedTime();
        String hhmmss = timer.elapsedTimeHMS();
        this.testData[1] = new TestData("example2", time);
        resultTest+=
                "Test Example 2"
                        +"\nn: "+util.Utility.format(N)
                        +"\nResult: "+util.Utility.format(result)
                        +"\nTn: "+util.Utility.format(time)+" milliseconds"
                        +"\nTn: "+hhmmss+"\n";
        return resultTest;
    }

    public String testExample3() {
        String resultTest = "";
        Stopwatch timer = new Stopwatch();
        int result = example.example3(b);
        double time = timer.elapsedTime();
        String hhmmss = timer.elapsedTimeHMS();
        this.testData[2] = new TestData("example3", time);
        resultTest +=
                "Test Example 3"
                        + "\nn: " + util.Utility.format(M)
                        + "\nResult: " + util.Utility.format(result)
                        + "\nTn: " + util.Utility.format(time) + " milliseconds"
                        + "\nTn: " + hhmmss + "\n";
        return resultTest;
    }

    public String testExample4() {
        String resultTest="";
        Stopwatch timer = new Stopwatch();
        int result = example.example4(a);
        double time = timer.elapsedTime();
        String hhmmss = timer.elapsedTimeHMS();
        this.testData[3] = new TestData("example4", time);
        resultTest +=
                "Test Example 4"
                +"\nn: "+util.Utility.format(N)
                +"\nResult: "+ util.Utility.format(result)
                +"\nTn: "+ util.Utility.format(time) +" milliseconds"
                +"\nTn: "+ hhmmss+"\n";
        return resultTest;
    }

    public String testExample5() {
        String resultTest="";
        Stopwatch timer = new Stopwatch();
        int result = example.example5(c, d);
        double time = timer.elapsedTime();
        String hhmmss = timer.elapsedTimeHMS();
        this.testData[4] = new TestData("example5", time);
        resultTest +=
                "Test Example 5"
                +"\nn: "+util.Utility.format(P)
                +"\nm: "+util.Utility.format(Q)
                +"\nResult: "+ util.Utility.format(result)
                +"\nTn: "+ util.Utility.format(time) +" milliseconds"
                +"\nTn: "+ hhmmss+"\n";
        return resultTest;
    }

}