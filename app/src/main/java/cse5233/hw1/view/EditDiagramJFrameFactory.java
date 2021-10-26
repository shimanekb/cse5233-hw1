package cse5233.hw1.view;

import cse5233.hw1.edit.Diagram;
import cse5233.hw1.edit.EditDiagramController;
import cse5233.hw1.edit.line.AddLine;
import cse5233.hw1.edit.line.SelectDestination;
import cse5233.hw1.edit.line.SelectOrigin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class EditDiagramJFrameFactory {
    private final static Logger logger = LoggerFactory.getLogger(EditDiagramJFrameFactory.class);

    private EditDiagramController editDiagramController() {
        return new EditDiagramController();
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

    private void configureLineStateMachine(DrawingPanel drawingPanel) {
        AddLine.getInstance().setDrawingPanel(drawingPanel);
        SelectOrigin.getInstance().setDrawingPanel(drawingPanel);
        SelectDestination.getInstance().setDrawingPanel(drawingPanel);
    }

    private DrawingPanel drawingPanel() {
        DrawingPanel drawingPanel = new DrawingPanel();
        configureLineStateMachine(drawingPanel);
        return drawingPanel;
    }

    public EditDiagramJFrame create() {
        logger.info("Creating Edit Diagram GUI with Controller bindings");
        DrawingPanel drawingPanel = drawingPanel();
        EditDiagramController controller = editDiagramController();
        drawingPanel.addMouseListener(new LineMouseListener(controller));
        drawingPanel.addMouseMotionListener(new LineMouseMotionListener(controller));
        EditDiagramJFrame frame = new EditDiagramJFrame(menuPanel(controller), drawingPanel);
        return frame;
    }
}
