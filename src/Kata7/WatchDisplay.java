package Kata7;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class WatchDisplay extends JPanel {
    public BufferedImage backgroud;
    public Point[] Points = new Point[0];

    public WatchDisplay() throws IOException {
        backgroud = ImageIO.read(new FileInputStream("/home/miguel/IdeaProjects/Kata7/BG.jpg"));
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
            transform2D(graphics).setStroke(new BasicStroke(width));
            width += 2;
            transform2D(graphics).drawLine(x,y,x-point.x, y - point.y);

        }

    }

    private Graphics2D transform2D(Graphics graphics) {
        return (Graphics2D) graphics;
    }
}
