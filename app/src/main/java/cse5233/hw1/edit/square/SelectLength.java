package cse5233.hw1.edit.square;

import cse5233.hw1.edit.InitState;
import cse5233.hw1.edit.State;
import cse5233.hw1.edit.cmd.DiagramElementDrawCommand;
import cse5233.hw1.edit.line.Line;
import cse5233.hw1.view.DrawingPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class SelectLength extends State {


    private static Logger logger = LoggerFactory.getLogger(SelectLength.class);

    private static SelectLength selectLength;

    private DrawingPanel drawingPanel;

    private Point cornerPoint;

    private Square square;

    private SelectLength() {
        square = null;
    }

    public static SelectLength getInstance() {
        if (selectLength == null) {
            selectLength = new SelectLength();
        }

        return selectLength;
    }

    public void setDrawingPanel(DrawingPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
    }

    public void setCornerPoint(Point cornerPoint) {
        this.cornerPoint = cornerPoint;
    }

    private void removeSquare() {
        if (square != null) {
            boolean removed = drawingPanel.getDiagram().remove(square);
            logger.info("Remove square attempt result " + removed);
            drawingPanel.repaint();
            square = null;
        }
    }

    @Override
    public State mouseDragged() {
        logger.info("Mouse dragged while looking for square length.");
        Point mousePoint = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(mousePoint, drawingPanel);

        removeSquare();

        double length = Point2D.distance(cornerPoint.x, cornerPoint.y, mousePoint.x, mousePoint.y);
        square = new Square(cornerPoint, (int) length);
        drawingPanel.getDiagram().add(square);
        drawingPanel.repaint();

        return this;
    }

    @Override
    public State mouseReleased() {

        State state = InitState.getInstance();
        logger.info("Mouse released.");
        Point mousePoint = MouseInfo.getPointerInfo().getLocation();

        if (isPointInDrawingPanel(drawingPanel, mousePoint)) {
            logger.info("Mouse was released within drawing panel, square is drawn.");
            InitState.getInstance().addUndoCommand(new DiagramElementDrawCommand(drawingPanel, square, true));
            square = null;
        } else {
            logger.info("Mouse was not released within drawing panel.");
            removeSquare();
        }

        return state;
    }
}
