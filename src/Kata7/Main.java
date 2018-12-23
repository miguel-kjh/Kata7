package Kata7;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Main extends JFrame {
    public static void main(String[] args) throws IOException {
      new Main().launch();
    }
    private Main() throws IOException {
        Watch watch = new Watch();
        WatchDisplay display = new WatchDisplay(background());
        new WatchPresenter(watch, display);
        init();
        add(display);
    }

    private static Image background() throws IOException {
        return ImageIO.read(new File("BG.jpg"));
    }

    private void launch(){
        setVisible(true);
    }

    private void init(){
        setTitle("CLOCK");
        setBounds(200,200,630,655);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
