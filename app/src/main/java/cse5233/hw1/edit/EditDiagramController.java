package cse5233.hw1.edit;

import cse5233.hw1.edit.line.AddLine;
import cse5233.hw1.edit.line.SelectDestination;

import java.awt.*;

public class EditDiagramController {

    private State lineState;

    private Diagram diagram;

    public EditDiagramController() {
        // Init line state
        lineState = AddLine.getInstance();
        diagram = new Diagram();
        SelectDestination.getInstance().setDiagram(diagram);
    }

    public void addLine() {
        // Init line state
        lineState = AddLine.getInstance();
    }

    public void selectOrigin(Point point) {
        lineState.mousePressed();
    }
}
