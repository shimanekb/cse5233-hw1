package cse5233.hw1.edit;

public class SelectDestination extends State {

    private static SelectDestination selectDestination = null;

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
}
