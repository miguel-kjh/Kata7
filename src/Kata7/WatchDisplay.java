package Kata7;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class WatchDisplay extends JPanel {
    public final Image backgroud;
    public Point[] Points = new Point[0];

    public WatchDisplay(Image backgroud) throws IOException {
        this.backgroud = backgroud;
    }

    public void paint(Point[] points){
        this.Points = points;
        repaint();
    }

    @Override
    public void paint(Graphics graphics){
        graphics.drawImage(backgroud,0,0,this);
        graphics.setColor(Color.BLACK);
        int width = 1;
        int x = getWidth()/2;
        int y = getHeight()/2;
        for (Point point:
             Points) {
            transform2D(graphics).setStroke(new BasicStroke(width++));
            transform2D(graphics).drawLine(x,y,x-point.x, y - point.y);

        }

    }

    private Graphics2D transform2D(Graphics graphics) {
        return (Graphics2D) graphics;
    }
}
