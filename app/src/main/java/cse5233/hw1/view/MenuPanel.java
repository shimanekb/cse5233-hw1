package cse5233.hw1.view;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    private static final int BUTTON_WIDTH = 50;
    private static final int BUTTON_HEIGHT = 25;

    public MenuPanel() {
        Panel buttonPanel = new Panel();
        buttonPanel.add(configureButton(new LineButton()));
        buttonPanel.add(configureButton(new BoxButton()));
        buttonPanel.add(configureButton(new CircleButton()));
        buttonPanel.add(configureButton(new UndoButton()));
        buttonPanel.add(configureButton(new RedoButton()));
        BoxLayout layout = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
        buttonPanel.setLayout(layout);
        this.add(buttonPanel);
    }

    private JButton configureButton(JButton button) {
        button.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        return button;
    }
}
