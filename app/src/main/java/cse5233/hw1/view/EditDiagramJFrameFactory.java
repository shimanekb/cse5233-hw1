package cse5233.hw1.view;

import cse5233.hw1.edit.Diagram;
import cse5233.hw1.edit.EditDiagramController;
import cse5233.hw1.edit.line.AddLine;
import cse5233.hw1.edit.line.SelectOrigin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

public class EditDiagramJFrameFactory {
    private final static Logger logger = LoggerFactory.getLogger(EditDiagramJFrameFactory.class);

    private EditDiagramController editDiagramController() {
        return new EditDiagramController(new Diagram());
    }

    private LineButton lineButton(EditDiagramController controller) {
        LineButton lineButton = new LineButton();
        lineButton.addActionListener(new LineButtonListener(controller));
        return lineButton;
    }

    private MenuPanel menuPanel(EditDiagramController controller) {
        MenuPanel menuPanel = new MenuPanel();
        menuPanel.addButton(lineButton(controller));
        menuPanel.addButton(new BoxButton());
        menuPanel.addButton(new CircleButton());
        menuPanel.addButton(new UndoButton());
        menuPanel.addButton(new RedoButton());

        return menuPanel;
    }

    private void configureLineStateMachine(Panel drawingPanel) {
        AddLine.getInstance().setDrawingPanel(drawingPanel);
        SelectOrigin.getInstance().setDrawingPanel(drawingPanel);
    }

    private Panel drawingPanel(EditDiagramController controller) {
        Panel drawingPanel = new Panel();
        configureLineStateMachine(drawingPanel);
        drawingPanel.addMouseListener(new SelectOriginMouseListener(controller));
        return drawingPanel;
    }

    public EditDiagramJFrame create() {
        logger.info("Creating Edit Diagram GUI with Controller bindings");
        EditDiagramController controller = editDiagramController();
        Panel drawingPanel = drawingPanel(controller);
        EditDiagramJFrame frame = new EditDiagramJFrame(menuPanel(controller), drawingPanel);
        return frame;
    }
}
