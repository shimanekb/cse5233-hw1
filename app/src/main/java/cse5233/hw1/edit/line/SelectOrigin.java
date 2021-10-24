package cse5233.hw1.edit.line;

import cse5233.hw1.edit.State;

public class SelectOrigin extends State {

    private static SelectOrigin selectOrigin = null;

    private SelectOrigin() {}

    public static SelectOrigin getInstance() {
        if (selectOrigin == null) {
            selectOrigin = new SelectOrigin();
        }

        return selectOrigin;
    }

    @Override
    public State mousePressed() {
        return super.mousePressed();
    }
}
