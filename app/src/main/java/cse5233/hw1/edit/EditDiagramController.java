package cse5233.hw1.edit;

import cse5233.hw1.edit.line.SelectDestination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EditDiagramController {

    private static Logger logger = LoggerFactory.getLogger(EditDiagramController.class);

    private State state;

    public EditDiagramController() {
        // Init line state
        state = InitState.getInstance();
        SelectDestination.getInstance();
    }

    public void addLine() {
        logger.info("Starting add line process.");
        // Init line state
        state = InitState.getInstance();
        state = state.clickedAddLine();
    }

    public void mousePressed() {
        logger.info("Mouse clicked.");
        state = state.mousePressed();
    }

    public void dragMouse() {
        logger.info("Mouse dragged");
        state = state.mouseDragged();
    }

    public void mouseReleased() {
        logger.info("Mouse released.");
        state = state.mouseReleased();
    }

    public void undo() {
        logger.info("Undo button clicked, starting undo process.");
        state = state.clickedUndoButton();
    }

    public void redo() {
        logger.info("Starting redo process.");
        state = state.clickedRedoButton();
    }
}
