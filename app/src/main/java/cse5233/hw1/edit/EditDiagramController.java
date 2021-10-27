package cse5233.hw1.edit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EditDiagramController {

    private static Logger logger = LoggerFactory.getLogger(EditDiagramController.class);

    private static State state;

    public EditDiagramController() {
        // Init line state
        if (state == null) {
            state = InitState.getInstance();
        }
    }

    public void midButtonClick() {
        logger.info("Mid button clicked, starting reset process.");
        state = state.clickedMidButton();
    }
    public void addLine() {
        logger.info("Starting add line process.");
        // Init line state
        state = InitState.getInstance();
        state = state.clickedAddLine();
    }

    public void addBox() {
        logger.info("Starting add square process.");
        // Init line state
        state = InitState.getInstance();
        state = state.clickedAddBox();
    }

    public void addCircle() {
        logger.info("Starting add circle process.");
        // Init line state
        state = InitState.getInstance();
        state = state.clickedAddCircle();
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
