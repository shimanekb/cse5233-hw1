package cse5233.hw1;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    public MenuPanel() {
        Panel buttonPanel = new Panel();
        buttonPanel.add(new LineButton());
        BoxLayout layout = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
        buttonPanel.setLayout(layout);
        this.add(buttonPanel);
    }
}
