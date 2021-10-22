package cse5233.hw1.edit;

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
        return super.clickedAddLine();
    }
}
