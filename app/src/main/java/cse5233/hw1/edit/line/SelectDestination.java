package cse5233.hw1.edit.line;

import cse5233.hw1.edit.Diagram;
import cse5233.hw1.edit.State;

import java.awt.*;

public class SelectDestination extends State {

    private static SelectDestination selectDestination = null;

    private static Point originPoint;

    private static Diagram diagram;

    private SelectDestination() {}

    public static SelectDestination getInstance() {
        if (selectDestination == null) {
            selectDestination = new SelectDestination();
        }

        return selectDestination;
    }

    @Override
    public State mouseDragged() {
        return super.mouseDragged();
    }

    @Override
    public State mouseReleased() {
        return super.mouseReleased();
    }

    public static Point getOriginPoint() {
        return originPoint;
    }

    public static void setOriginPoint(Point originPoint) {
        SelectDestination.originPoint = originPoint;
    }

    public Diagram getDiagram() {
        return diagram;
    }

    public void setDiagram(Diagram diagram) {
        SelectDestination.diagram = diagram;
    }
}
