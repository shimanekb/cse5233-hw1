package cse5233.hw1.edit.line;

import cse5233.hw1.edit.Diagram;
import cse5233.hw1.edit.InitState;
import cse5233.hw1.edit.State;
import cse5233.hw1.edit.cmd.DiagramElementDrawCommand;
import cse5233.hw1.view.DrawingPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

public class SelectDestination extends State {

    private static Logger logger = LoggerFactory.getLogger(SelectDestination.class);

    private static SelectDestination selectDestination = null;

    private static Point originPoint;

    private static Diagram diagram;

    private static DrawingPanel drawingPanel;

    private static Line line = null;

    private SelectDestination() {}

    public static SelectDestination getInstance() {
        if (selectDestination == null) {
            selectDestination = new SelectDestination();
        }

        return selectDestination;
    }

    @Override
    public State mouseDragged() {
        logger.info("Mouse dragged while looking for destination.");
        Point mousePoint = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(mousePoint, drawingPanel);

        removeLine();

        line = new Line(originPoint, mousePoint);
        drawingPanel.getDiagram().add(line);
        drawingPanel.repaint();
        return this;
    }

    @Override
    public State clickedMidButton() {
        removeLine();
        return InitState.getInstance();
    }

    private void removeLine() {
        if (line != null) {
            boolean removed = drawingPanel.getDiagram().remove(line);
            logger.info("Remove line attempt result " + removed);
            drawingPanel.repaint();
            line = null;
        }
    }

    @Override
    public State mouseReleased() {
        State state = InitState.getInstance();
        logger.info("Mouse released.");
        Point mousePoint = MouseInfo.getPointerInfo().getLocation();

        if (isPointInDrawingPanel(drawingPanel, mousePoint)) {
            logger.info("Mouse was released within drawing panel, line is drawn.");
            InitState.getInstance().addUndoCommand(new DiagramElementDrawCommand(drawingPanel, line, true));
            line = null;
        } else {
            logger.info("Mouse was not released within drawing panel.");
            removeLine();
        }

        return state;
    }

    public void setOriginPoint(Point originPoint) {
        SelectDestination.originPoint = originPoint;
    }

    public Diagram getDiagram() {
        return diagram;
    }

    public void setDiagram(Diagram diagram) {
        SelectDestination.diagram = diagram;
    }

    public void setDrawingPanel(DrawingPanel drawingPanel) {
        SelectDestination.drawingPanel = drawingPanel;
    }
}
