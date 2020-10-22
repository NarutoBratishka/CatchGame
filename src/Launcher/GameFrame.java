package Launcher;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GameFrame extends JFrame {

    private static GameFrame gameFrame = new GameFrame();
    private static Image background;
    private static Image drop;
    private static Image gameOver;
    private int score;
    private static int frWidth;
    private static int frHeight;

    static {
        try {
            BufferedImage image = ImageIO.read(GameFrame.class.getResourceAsStream("background.png"));
            frWidth = image.getWidth();
            frHeight = image.getHeight();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.setLocation(200, 100);
        gameFrame.setSize(frWidth, frHeight);
        gameFrame.setResizable(false);
        gameFrame.setVisible(true);
    }
}
