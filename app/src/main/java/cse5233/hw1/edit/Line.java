package cse5233.hw1.edit;

import java.awt.*;

public class Line implements DiagramElement {

    private Point origin;

    private Point destination;

    public Point getOrigin() {
        return origin;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
    }

    public Point getDestination() {
        return destination;
    }

    public void setDestination(Point destination) {
        this.destination = destination;
    }

    @Override
    public void draw() {

    }
}
