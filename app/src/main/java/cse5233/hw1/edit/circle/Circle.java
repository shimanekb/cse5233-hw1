package cse5233.hw1.edit.circle;

import cse5233.hw1.edit.DiagramElement;

import java.awt.*;

public class Circle implements DiagramElement {
    private final int radius;

    private final Point center;

    public Circle(int radius, Point center) {
        this.radius = radius;
        this.center = center;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.drawOval(center.x, center.y, radius, radius);
        g2d.dispose();
    }
}
