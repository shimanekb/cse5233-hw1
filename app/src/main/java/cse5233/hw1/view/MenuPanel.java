package cse5233.hw1.view;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    private static final int BUTTON_WIDTH = 80;
    private static final int BUTTON_HEIGHT = 25;
    private static final int BUTTON_GAP_HEIGHT = 5;

    private final Panel buttonPanel;

    public MenuPanel() {
        this.buttonPanel = new Panel();
        BoxLayout layout = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
        buttonPanel.setLayout(layout);
        this.add(buttonPanel);
    }

    private JButton configureButton(JButton button) {
        Dimension dimension = new Dimension();
        dimension.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        button.setMinimumSize(dimension);
        button.setMaximumSize(dimension);
        button.setPreferredSize(dimension);
        return button;
    }

    public void addButton(JButton button) {
        Dimension buttonGap = new Dimension(0, BUTTON_GAP_HEIGHT);
        buttonPanel.add(configureButton(button));
        buttonPanel.add(Box.createRigidArea(buttonGap));
    }
}
