package cse5233.hw1.view;

import java.awt.*;

public class EditDiagramJFrameFactory {

    public EditDiagramJFrame create() {
        MenuPanel menuPanel = new MenuPanel();
        Panel drawingPanel = new Panel();

        return new EditDiagramJFrame(menuPanel, drawingPanel);
    }
}
