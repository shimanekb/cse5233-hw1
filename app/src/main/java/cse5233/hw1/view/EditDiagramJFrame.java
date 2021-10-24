package cse5233.hw1.view;

import javax.swing.*;
import java.awt.*;

public class EditDiagramJFrame extends JFrame {

    private static final String TITLE = "HW1 GUI";

    public EditDiagramJFrame(MenuPanel menuPanel, Panel drawingPanel) throws HeadlessException {
        this.setTitle(TITLE);
        this.setSize(1000, 500);
        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);

        menuPanel.setSize(400, 500);
        menuPanel.setBackground(Color.LIGHT_GRAY);
        this.add(menuPanel, BorderLayout.WEST);


        drawingPanel.setSize(600, 500);
        drawingPanel.setBackground(Color.WHITE);
        this.add(drawingPanel, BorderLayout.CENTER);
    }
}
