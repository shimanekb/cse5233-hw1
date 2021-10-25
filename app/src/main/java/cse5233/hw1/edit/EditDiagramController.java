package cse5233.hw1.edit;

import cse5233.hw1.edit.line.AddLine;
import cse5233.hw1.edit.line.SelectDestination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class EditDiagramController {

    private static Logger logger = LoggerFactory.getLogger(EditDiagramController.class);

    private State lineState;

    private Diagram diagram;

    public EditDiagramController(Diagram diagram) {
        // Init line state
        this.diagram = diagram;
        lineState = AddLine.getInstance();
        SelectDestination.getInstance().setDiagram(diagram);
    }

    public void addLine() {
        logger.info("Starting add line process.");
        // Init line state
        lineState = AddLine.getInstance();
        lineState = lineState.clickedAddLine();
    }

    public void selectOrigin() {
        logger.info("Mouse clicked, starting origin selection process for line.");
        lineState = lineState.mousePressed();
    }
}
