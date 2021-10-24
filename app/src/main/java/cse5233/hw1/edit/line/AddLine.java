package cse5233.hw1.edit.line;

import cse5233.hw1.edit.State;

import java.awt.*;

public class AddLine extends State {

    private static AddLine addLine = null;

    private AddLine() {}

    public static AddLine getInstance() {
        if (addLine == null) {
            addLine = new AddLine();
        }

        return addLine;
    }

    @Override
    public State clickedAddLine() {
        try {
            Robot robot = new Robot();
            robot.mouseMove(700, 250);
            return SelectOrigin.getInstance();
        } catch (AWTException exception) {
           throw new RuntimeException("Could not move cursor after add line.");
        }
    }
}
