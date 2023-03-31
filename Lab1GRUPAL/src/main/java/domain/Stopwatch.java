package domain;

public class Stopwatch {
    private final long start;

    public Stopwatch() {
        start = System.currentTimeMillis();
    }

    public double elapsedTime(){
        long now = System.currentTimeMillis();
        return now - start;
    }

    public String elapsedTimeHMS(){
        long now = System.currentTimeMillis();
        long milliseconds = now-start;
        long hour = milliseconds / 3600000;
        long restHour = milliseconds % 3600000;
        long minute = restHour / 60000;
        long restMinute = restHour % 60000;
        long second = restMinute / 1000;
        long restSecond = restMinute % 1000;
        return hour+":"+minute+":"+second+"."+restSecond;
    }

}
