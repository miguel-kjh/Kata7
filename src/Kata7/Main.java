package Kata7;

import javax.swing.*;
import java.io.IOException;
import java.io.WriteAbortedException;

public class Main extends JFrame {
    public static void main(String[] args) throws IOException {
      new Main().start();
    }
    private Main() throws IOException {
        Watch watch = new Watch();
        WatchDisplay display = new WatchDisplay();
        new WatchPresenter(watch, display);
        setTitle("CLOCK");
        setBounds(200,200,630,655);
        setResizable(false);
        add(display);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void start(){
        setVisible(true);
    }

}
