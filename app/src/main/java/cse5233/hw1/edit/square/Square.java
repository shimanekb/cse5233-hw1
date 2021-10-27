package cse5233.hw1.edit.square;

import cse5233.hw1.edit.DiagramElement;

import java.awt.*;

public class Square implements DiagramElement {

    private final int length;

    private final Point topLefCornerPoint;

    public Square(Point topLefCornerPoint, int length) {
        this.length = length;
        this.topLefCornerPoint = topLefCornerPoint;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.drawRect(topLefCornerPoint.x, topLefCornerPoint.y, length, length);
        g2d.dispose();
    }
}
