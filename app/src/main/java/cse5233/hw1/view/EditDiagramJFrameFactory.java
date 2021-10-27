package cse5233.hw1.view;

import cse5233.hw1.edit.EditDiagramController;
import cse5233.hw1.edit.InitState;
import cse5233.hw1.edit.circle.SelectCenter;
import cse5233.hw1.edit.circle.SelectRadius;
import cse5233.hw1.edit.line.SelectDestination;
import cse5233.hw1.edit.line.SelectOrigin;
import cse5233.hw1.edit.square.SelectCorner;
import cse5233.hw1.edit.square.SelectLength;
import cse5233.hw1.view.listeners.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private UndoButton undoButton(EditDiagramController controller) {
        UndoButton undoButton = new UndoButton();
        undoButton.addActionListener(new UndoButtonListener(controller));

        return undoButton;
    }

    private CircleButton circleButton(EditDiagramController controller) {
        CircleButton circleButton = new CircleButton();
        circleButton.addActionListener(new CircleButtonListener(controller));

        return circleButton;
    }

    private BoxButton boxButton(EditDiagramController controller) {
        BoxButton boxButton = new BoxButton();
        boxButton.addActionListener(new SquareButtonListener(controller));

        return boxButton;
    }

    private RedoButton redoButton(EditDiagramController controller) {
        RedoButton redoButton = new RedoButton();
        redoButton.addActionListener(new RedoButtonListener(controller));

        return redoButton;
    }

    private MenuPanel menuPanel(EditDiagramController controller) {
        MenuPanel menuPanel = new MenuPanel();
        menuPanel.addButton(lineButton(controller));
        menuPanel.addButton(boxButton(controller));
        menuPanel.addButton(circleButton(controller));
        menuPanel.addButton(undoButton(controller));
        menuPanel.addButton(redoButton(controller));

        return menuPanel;
    }

    private void configureSquareStateMachine(DrawingPanel drawingPanel) {
        InitState.getInstance().setDrawingPanel(drawingPanel);
        SelectCorner.getInstance().setDrawingPanel(drawingPanel);
        SelectLength.getInstance().setDrawingPanel(drawingPanel);
    }

    private void configureCircleStateMachine(DrawingPanel drawingPanel) {
        InitState.getInstance().setDrawingPanel(drawingPanel);
        SelectCenter.getInstance().setDrawingPanel(drawingPanel);
        SelectRadius.getInstance().setDrawingPanel(drawingPanel);
    }

    private void configureLineStateMachine(DrawingPanel drawingPanel) {
        InitState.getInstance().setDrawingPanel(drawingPanel);
        SelectOrigin.getInstance().setDrawingPanel(drawingPanel);
        SelectDestination.getInstance().setDrawingPanel(drawingPanel);
    }

    private DrawingPanel drawingPanel() {
        DrawingPanel drawingPanel = new DrawingPanel();
        configureLineStateMachine(drawingPanel);
        configureCircleStateMachine(drawingPanel);
        configureSquareStateMachine(drawingPanel);

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
