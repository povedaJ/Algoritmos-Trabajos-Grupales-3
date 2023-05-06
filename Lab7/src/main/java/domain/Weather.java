package domain;

public class Weather {

    private int id;
    private String weather;
    private static int counter;

    public Weather(String weather) {
        this.weather = weather;
        this.id=++counter;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", weather='" + weather + '\'' +
                '}';
    }
}
