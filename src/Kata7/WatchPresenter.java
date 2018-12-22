package Kata7;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class WatchPresenter implements Observer {
    private final Watch watch;
    private final WatchDisplay Display;

    public WatchPresenter(Watch watch, WatchDisplay display) {
        this.watch = watch;
        this.Display = display;
        this.Display.paint(pointsOf(watch));
        this.watch.add(this);
    }

    private Point[] pointsOf(Watch watch) {
        Point[] points = new Point[3];
        points[0] = pointsAngle(watch.getSeconds(),250);
        points[1] = pointsAngle(watch.getMinutes(),150);
        points[2] = pointsAngle(watch.getHours(),100);
        return points;
    }

    private Point pointsAngle(double angle, int lenght) {
        return new Point((int) (Math.cos(angle) * lenght), (int) (Math.sin(angle) * lenght));
    }

    @Override
    public void update(Observable observable, Object o) {
        Display.paint(pointsOf(watch));
    }
}
