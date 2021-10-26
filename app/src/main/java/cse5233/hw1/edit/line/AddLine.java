package cse5233.hw1.edit.line;

import cse5233.hw1.edit.State;
import cse5233.hw1.view.DrawingPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class AddLine extends State {

    private static final Logger logger = LoggerFactory.getLogger(AddLine.class);

    private static AddLine addLine = null;

    private static DrawingPanel drawingPanel;

    private AddLine() {}

    public static AddLine getInstance() {
        if (addLine == null) {
            addLine = new AddLine();
        }

        return addLine;
    }

    @Override
    public State clickedAddLine() {
        try {
            logger.info("Clicked add line event triggered.");
            Point currentPoint = drawingPanel.getLocationOnScreen();
            Robot robot = new Robot();
            robot.mouseMove(currentPoint.x + 400, currentPoint.y + 250);
            logger.info("Moved cursor to mid screen, moving to Select origin line state.");
            return SelectOrigin.getInstance();
        } catch (AWTException exception) {
           throw new RuntimeException("Could not move cursor after add line.");
        }
    }

    public void setDrawingPanel(DrawingPanel drawingPanel) {
        AddLine.drawingPanel = drawingPanel;
    }
}
