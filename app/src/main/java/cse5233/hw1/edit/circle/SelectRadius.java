package cse5233.hw1.edit.circle;

import cse5233.hw1.edit.InitState;
import cse5233.hw1.edit.State;
import cse5233.hw1.edit.cmd.DiagramElementDrawCommand;
import cse5233.hw1.view.DrawingPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class SelectRadius extends State {

    private static final Logger logger = LoggerFactory.getLogger(SelectRadius.class);

    private static SelectRadius selectRadius;

    private Point center;

    private DrawingPanel drawingPanel;

    private Circle circle;

    private SelectRadius() {
        this.circle = null;
    }

    public static SelectRadius getInstance() {
        if (selectRadius == null) {
            selectRadius = new SelectRadius();
        }

        return selectRadius;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    private void removeCircle() {
        if (circle != null) {
            boolean removed = drawingPanel.getDiagram().remove(circle);
            logger.info("Remove circle attempt result " + removed);
            drawingPanel.repaint();
            circle = null;
        }
    }

    @Override
    public State mouseDragged() {
        logger.info("Mouse dragged while looking for circle radius.");
        Point mousePoint = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(mousePoint, drawingPanel);


        double radius = Point2D.distance(center.x, center.y, mousePoint.x, mousePoint.y);
        removeCircle();
        circle = new Circle((int) radius, center);
        drawingPanel.getDiagram().add(circle);
        drawingPanel.repaint();
        return this;
    }

    @Override
    public State clickedMidButton() {
        removeCircle();
        return InitState.getInstance();
    }

    @Override
    public State mouseReleased() {
        State state = InitState.getInstance();
        logger.info("Mouse released.");
        Point mousePoint = MouseInfo.getPointerInfo().getLocation();

        if (isPointInDrawingPanel(drawingPanel, mousePoint)) {
            logger.info("Mouse was released within drawing panel, Circle is drawn.");
            InitState.getInstance().addUndoCommand(new DiagramElementDrawCommand(drawingPanel, circle, true));
            circle = null;
        } else {
            logger.info("Mouse was not released within drawing panel.");
            removeCircle();
        }

        return state;
    }

    public void setDrawingPanel(DrawingPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
    }
}
