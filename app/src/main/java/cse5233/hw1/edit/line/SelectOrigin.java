package cse5233.hw1.edit.line;

import cse5233.hw1.edit.State;
import cse5233.hw1.view.DrawingPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

public class SelectOrigin extends State {

    private static final Logger logger = LoggerFactory.getLogger(SelectOrigin.class);

    private static SelectOrigin selectOrigin = null;

    private static DrawingPanel drawingPanel;

    private SelectOrigin() {}

    public static SelectOrigin getInstance() {
        if (selectOrigin == null) {
            selectOrigin = new SelectOrigin();
        }

        return selectOrigin;
    }

    private boolean isPointInDrawingPanel(Point point) {
        Rectangle drawingPanelBounds = drawingPanel.getBounds();
        drawingPanelBounds.setLocation(drawingPanel.getLocationOnScreen());
        return drawingPanelBounds.contains(point);
    }

    @Override
    public State mousePressed() {
        State state;
        logger.info("Mouse pressed for placing line origin.");
        Point mousePoint = MouseInfo.getPointerInfo().getLocation();

        if (isPointInDrawingPanel(mousePoint)) {
            logger.info("Mouse was pressed within drawing panel.");
            logger.info("Recording origin point, moving to destination state.");
            state = SelectDestination.getInstance();
            SwingUtilities.convertPointFromScreen(mousePoint, drawingPanel);
            SelectDestination.getInstance().setOriginPoint(mousePoint);
        } else {
            logger.info("Mouse was not pressed within drawing panel.");
            state = super.mousePressed();
        }

        return state;
    }

    public void setDrawingPanel(DrawingPanel drawingPanel) {
        SelectOrigin.drawingPanel = drawingPanel;
    }
}
