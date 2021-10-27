package cse5233.hw1.view;

import cse5233.hw1.edit.InitState;
import cse5233.hw1.edit.circle.SelectCenter;
import cse5233.hw1.edit.circle.SelectRadius;
import cse5233.hw1.edit.line.SelectDestination;
import cse5233.hw1.edit.line.SelectOrigin;
import cse5233.hw1.edit.box.SelectCorner;
import cse5233.hw1.edit.box.SelectLength;
import cse5233.hw1.view.listeners.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EditDiagramJFrameFactory {
    private final static Logger logger = LoggerFactory.getLogger(EditDiagramJFrameFactory.class);

    private LineButton lineButton() {
        LineButton lineButton = new LineButton();
        lineButton.addActionListener(new LineButtonListener());
        return lineButton;
    }

    private UndoButton undoButton() {
        UndoButton undoButton = new UndoButton();
        undoButton.addActionListener(new UndoButtonListener());

        return undoButton;
    }

    private CircleButton circleButton() {
        CircleButton circleButton = new CircleButton();
        circleButton.addActionListener(new CircleButtonListener());

        return circleButton;
    }

    private BoxButton boxButton() {
        BoxButton boxButton = new BoxButton();
        boxButton.addActionListener(new BoxButtonListener());

        return boxButton;
    }

    private RedoButton redoButton() {
        RedoButton redoButton = new RedoButton();
        redoButton.addActionListener(new RedoButtonListener());

        return redoButton;
    }

    private MenuPanel menuPanel() {
        MenuPanel menuPanel = new MenuPanel();
        menuPanel.addButton(lineButton());
        menuPanel.addButton(boxButton());
        menuPanel.addButton(circleButton());
        menuPanel.addButton(undoButton());
        menuPanel.addButton(redoButton());

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
        drawingPanel.addMouseListener(new DiagramMouseListener());
        drawingPanel.addMouseMotionListener(new DiagramMouseMotionListener());
        EditDiagramJFrame frame = new EditDiagramJFrame(menuPanel(), drawingPanel);
        return frame;
    }
}
