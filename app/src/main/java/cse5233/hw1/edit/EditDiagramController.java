package cse5233.hw1.edit;

import cse5233.hw1.edit.line.AddLine;
import cse5233.hw1.edit.line.SelectDestination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class EditDiagramController {

    private static Logger logger = LoggerFactory.getLogger(EditDiagramController.class);

    private State lineState;

    public EditDiagramController() {
        // Init line state
        lineState = AddLine.getInstance();
        SelectDestination.getInstance();
    }

    public void addLine() {
        logger.info("Starting add line process.");
        // Init line state
        lineState = AddLine.getInstance();
        lineState = lineState.clickedAddLine();
    }

    public void mousePressed() {
        logger.info("Mouse clicked.");
        lineState = lineState.mousePressed();
    }

    public void dragMouse() {
        logger.info("Mouse dragged");
        lineState = lineState.mouseDragged();
    }

    public void mouseReleased() {
        logger.info("Mouse released.");
        lineState = lineState.mouseReleased();
    }
}
