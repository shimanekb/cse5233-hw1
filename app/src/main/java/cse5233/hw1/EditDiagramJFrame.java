package cse5233.hw1;

import javax.swing.*;
import java.awt.*;

public class EditDiagramJFrame extends JFrame {

    private static final String TITLE = "HW1 GUI";

    public EditDiagramJFrame() throws HeadlessException {
        this.setTitle(TITLE);
        this.setSize(1000, 500);
        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);

        MenuPanel menuPanel = new MenuPanel();
        menuPanel.setSize(400, 500);
        menuPanel.setBackground(Color.BLUE);
        this.add(menuPanel, BorderLayout.WEST);


        Panel panel = new Panel();
        panel.setSize(600, 500);
        panel.setBackground(Color.ORANGE);
        this.add(panel, BorderLayout.CENTER);
    }
}
