package cse5233.hw1.edit.cmd;

import cse5233.hw1.edit.DiagramElement;
import cse5233.hw1.view.DrawingPanel;

public class DiagramElementDrawCommand implements DrawCommand {

    private final DrawingPanel drawingPanel;

    private final DiagramElement element;

    private boolean reversable;

    public DiagramElementDrawCommand(DrawingPanel drawingPanel, DiagramElement element, boolean reversable) {
        this.drawingPanel = drawingPanel;
        this.element = element;
        this.reversable = reversable;
    }

    @Override
    public void undo() {
        drawingPanel.getDiagram().remove(element);
        drawingPanel.repaint();
    }

    @Override
    public void redo() {
        drawingPanel.getDiagram().add(element);
        drawingPanel.repaint();
        reversable = true;
    }

    @Override
    public void execute() {
        drawingPanel.repaint();
        reversable = true;
    }

    @Override
    public boolean reversable() {
        return reversable;
    }
}
