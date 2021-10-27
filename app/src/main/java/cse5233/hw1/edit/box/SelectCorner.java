package cse5233.hw1.edit.box;

import cse5233.hw1.edit.InitState;
import cse5233.hw1.edit.State;
import cse5233.hw1.view.DrawingPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

public class SelectCorner extends State {

    private static Logger logger = LoggerFactory.getLogger(SelectCorner.class);

    private static SelectCorner selectCorner;

    private DrawingPanel drawingPanel;

    private SelectCorner() {

    }

    public static SelectCorner getInstance() {
        if (selectCorner == null) {
            selectCorner = new SelectCorner();
        }

        return selectCorner;
    }

    @Override
    public State clickedMidButton() {
        return InitState.getInstance();
    }

    @Override
    public State mousePressed() {
        State state;
        logger.info("Mouse pressed for placing square corner.");
        Point mousePoint = MouseInfo.getPointerInfo().getLocation();

        if (isPointInDrawingPanel(drawingPanel, mousePoint)) {
            logger.info("Mouse was pressed within drawing panel.");
            logger.info("Recording square corner point, moving to select length square state.");
            state = SelectLength.getInstance();
            SwingUtilities.convertPointFromScreen(mousePoint, drawingPanel);
            SelectLength.getInstance().setCornerPoint(mousePoint);
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
