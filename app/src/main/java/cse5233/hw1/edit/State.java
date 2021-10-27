package cse5233.hw1.edit;

import cse5233.hw1.view.DrawingPanel;

import java.awt.*;

public class State {

    public State clickedAddLine() {
        return this;
    }

    public State mousePressed() {
        return this;
    }

    public State mouseDragged() {
        return this;
    }

    public State mouseReleased() {
        return this;
    }

    public State clickedUndoButton() {
        return this;
    }

    public State clickedRedoButton() {
        return this;
    }

    public State clickedAddCircle() {
        return this;
    }

    public State clickedAddSquare() {
        return this;
    }

    protected boolean isPointInDrawingPanel(DrawingPanel drawingPanel, Point point) {
        Rectangle drawingPanelBounds = drawingPanel.getBounds();
        drawingPanelBounds.setLocation(drawingPanel.getLocationOnScreen());
        return drawingPanelBounds.contains(point);
    }
}
