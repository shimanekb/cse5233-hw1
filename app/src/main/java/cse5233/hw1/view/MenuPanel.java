package cse5233.hw1.view;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    private static final int BUTTON_WIDTH = 80;
    private static final int BUTTON_HEIGHT = 25;
    private static final int BUTTON_GAP_HEIGHT = 5;

    public MenuPanel() {
        Dimension buttonGap = new Dimension(0, BUTTON_GAP_HEIGHT);
        Panel buttonPanel = new Panel();

        buttonPanel.add(configureButton(new LineButton()));
        buttonPanel.add(Box.createRigidArea(buttonGap));

        buttonPanel.add(configureButton(new BoxButton()));
        buttonPanel.add(Box.createRigidArea(buttonGap));

        buttonPanel.add(configureButton(new CircleButton()));
        buttonPanel.add(Box.createRigidArea(buttonGap));

        buttonPanel.add(configureButton(new UndoButton()));
        buttonPanel.add(Box.createRigidArea(buttonGap));

        buttonPanel.add(configureButton(new RedoButton()));

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
}
