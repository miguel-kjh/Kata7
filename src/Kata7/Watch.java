package Kata7;

import java.time.LocalDateTime;
import java.util.*;

public class Watch {
    private static final double seconds = (2*Math.PI)/60.0;
    private static final double minutes = seconds/60;
    private static final double hours = minutes/12;
    private final List<Observer> observers = new ArrayList<>();
    private double CurrentSeconds =  (Math.PI / 2) + seconds * LocalDateTime.now().getSecond();
    private double CurrentMinutes =  (Math.PI / 2) +LocalDateTime.now().getMinute() *seconds;
    private double CurrentHours = (Math.PI / 2) + (LocalDateTime.now().getHour() % 12) *(2* Math.PI/12);

    public Watch() {
        Timer timer = new Timer();
        timer.schedule(timerTask(),0,1000);
    }

    private TimerTask timerTask() {
        return new TimerTask() {
            @Override
            public void run() {
                step();
                update();
            }
        };
    
    }

    public void update() {
        for (Observer observer: observers)
            observer.update();
    }

    public void step(){
        CurrentSeconds = (CurrentSeconds + seconds) % (2*Math.PI);
        CurrentMinutes = (CurrentMinutes + minutes)% (2*Math.PI);
        CurrentHours = (CurrentHours + hours)% (2*Math.PI);
    }

    public void add(Observer observer){
        observers.add(observer);
    }

    public double getSeconds() {
        return CurrentSeconds;
    }

    public double getMinutes() {
        return CurrentMinutes;
    }

    public double getHours() {
        return CurrentHours;
    }

    public interface Observer{
        public void update();
    }
}
