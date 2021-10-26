package cse5233.hw1.edit.line;

import cse5233.hw1.edit.DiagramElement;

import java.awt.*;

public class Line implements DiagramElement {

    private final Point origin;

    private final Point destination;

    public Line(Point origin, Point destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public Point getOrigin() {
        return origin;
    }

    public Point getDestination() {
        return destination;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.drawLine(origin.x, origin.y, destination.x, destination.y);
        g2d.dispose();
    }
}
