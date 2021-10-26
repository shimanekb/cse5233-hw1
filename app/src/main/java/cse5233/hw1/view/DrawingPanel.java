package cse5233.hw1.view;

import cse5233.hw1.edit.Diagram;

import java.awt.*;

public class DrawingPanel extends Panel {

    private final Diagram diagram;

    public DrawingPanel() {
        this.diagram = new Diagram();
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        diagram.draw(g);
    }

    public Diagram getDiagram() {
        return diagram;
    }
}
