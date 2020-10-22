package Launcher;

import javax.swing.*;
import java.awt.*;

public class GameField extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        GameFrame.onRepaint(g);
        repaint();
    }
}
