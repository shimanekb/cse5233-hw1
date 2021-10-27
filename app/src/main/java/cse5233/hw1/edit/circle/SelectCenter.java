package cse5233.hw1.edit.circle;

import cse5233.hw1.edit.InitState;
import cse5233.hw1.edit.State;
import cse5233.hw1.edit.line.SelectDestination;
import cse5233.hw1.view.DrawingPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

public class SelectCenter extends State {

    private static Logger logger = LoggerFactory.getLogger(SelectCenter.class);

    private static SelectCenter selectCenter;

    private DrawingPanel drawingPanel;

    private SelectCenter() {

    }

    public static SelectCenter getInstance() {
        if (selectCenter == null) {
            selectCenter = new SelectCenter();
        }

        return selectCenter;
    }

    @Override
    public State clickedMidButton() {
        return InitState.getInstance();
    }

    @Override
    public State mousePressed() {
        State state;
        logger.info("Mouse pressed for placing circle origin.");
        Point mousePoint = MouseInfo.getPointerInfo().getLocation();

        if (isPointInDrawingPanel(drawingPanel, mousePoint)) {
            logger.info("Mouse was pressed within drawing panel.");
            logger.info("Recording circle point, moving to select radius state.");
            state = SelectRadius.getInstance();
            SwingUtilities.convertPointFromScreen(mousePoint, drawingPanel);
            SelectRadius.getInstance().setCenter(mousePoint);
        } else {
            logger.info("Mouse was not pressed within drawing panel.");
            state = super.mousePressed();
        }

        return state;
    }

    public void setDrawingPanel(DrawingPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
    }
}
