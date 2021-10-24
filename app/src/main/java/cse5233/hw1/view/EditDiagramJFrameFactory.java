package cse5233.hw1.view;

import java.awt.*;

public class EditDiagramJFrameFactory {

    private MenuPanel menuPanel() {
        MenuPanel menuPanel = new MenuPanel();
        menuPanel.addButton(new LineButton());
        menuPanel.addButton(new BoxButton());
        menuPanel.addButton(new CircleButton());
        menuPanel.addButton(new UndoButton());
        menuPanel.addButton(new RedoButton());

        return menuPanel;
    }

    public EditDiagramJFrame create() {
        Panel drawingPanel = new Panel();
        return new EditDiagramJFrame(menuPanel(), drawingPanel);
    }
}
