package domain;

public class TestData {
    private String info;
    private double time;

    public TestData(String info, double time) {
        this.info = info;
        this.time = time;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "TestData{" +
                "info='" + info + '\'' +
                ", time=" + time +
                '}';
    }
}
