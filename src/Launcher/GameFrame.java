package Launcher;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class GameFrame extends JFrame {

    private static GameFrame gameFrame = new GameFrame();
    private static Image background;
    private static Image drop;
    private static Image gameOver;
    private static float dropLeft = 200;
    private static float dropTop = -100;
    private static float dropV = 200;
    private static int score;
    private static float shiftSize = 0.7f;

    public static void main(String[] args) throws IOException {
        background = ImageIO.read(GameFrame.class.getResourceAsStream("background.png"));
        drop = ImageIO.read(GameFrame.class.getResourceAsStream("drop.png"));
        gameOver = ImageIO.read(GameFrame.class.getResourceAsStream("game_over.png"));
        int frWidth = background.getWidth(null);
        int frHeight = background.getHeight(null);

        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.setLocation(200, 100);
        gameFrame.setSize(frWidth, frHeight);
        gameFrame.setResizable(false);


        GameField gameField = new GameField();
        gameField.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                float dropRight = dropLeft + drop.getWidth(null);
                float dropBottom = dropTop + drop.getHeight(null);
                boolean isDrop = x >= dropLeft && x <= dropRight && y >= dropTop && y <= dropBottom;

                if (isDrop) {
                    dropTop = -100;
                    dropLeft = (int) (Math.random() * (gameField.getWidth() - drop.getWidth(null)));
                    dropV = dropV + 20;
                    score++;

                    gameFrame.setTitle("Score: " + score);

                }
            }
        });
        gameFrame.add(gameField);
        gameFrame.setTitle("Score: " + score);
        gameFrame.setVisible(true);
    }

    static void onRepaint(Graphics g) {
        shiftSize += 0.0001;
        g.drawImage(background, 0, 0, null);

        dropTop = dropTop + shiftSize;
        g.drawImage(drop, (int)dropLeft, (int)dropTop, null);
        if (dropTop > gameFrame.getHeight()) g.drawImage(gameOver, 0, 330, null);

    }
}
