package cse5233.hw1.view;

import cse5233.hw1.edit.Diagram;
import cse5233.hw1.edit.EditDiagramController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class EditDiagramJFrameFactory {
    private final static Logger logger = LoggerFactory.getLogger(EditDiagramJFrameFactory.class);

    private EditDiagramController editDiagramController() {
        return new EditDiagramController(new Diagram());
    }

    private LineButton lineButton() {
        LineButton lineButton = new LineButton();
        lineButton.addActionListener(new LineButtonListener(editDiagramController()));
        return lineButton;
    }

    private MenuPanel menuPanel() {
        MenuPanel menuPanel = new MenuPanel();
        menuPanel.addButton(lineButton());
        menuPanel.addButton(new BoxButton());
        menuPanel.addButton(new CircleButton());
        menuPanel.addButton(new UndoButton());
        menuPanel.addButton(new RedoButton());

        return menuPanel;
    }

    public EditDiagramJFrame create() {
        logger.info("Creating Edit Diagram GUI with Controller bindings");
        Panel drawingPanel = new Panel();
        return new EditDiagramJFrame(menuPanel(), drawingPanel);
    }
}
