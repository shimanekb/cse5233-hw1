package cse5233.hw1.edit;

import cse5233.hw1.edit.cmd.DiagramElementDrawCommand;
import cse5233.hw1.edit.cmd.DrawCommand;
import cse5233.hw1.edit.line.SelectOrigin;
import cse5233.hw1.view.DrawingPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.Stack;

public class InitState extends State {

    private static final Logger logger = LoggerFactory.getLogger(InitState.class);

    private static InitState initState = null;

    private static DrawingPanel drawingPanel;

    private Stack<DrawCommand> undoStack;

    private InitState() {
        this.undoStack = new Stack<>();
    }

    public static InitState getInstance() {
        if (initState == null) {
            initState = new InitState();
        }

        return initState;
    }

    @Override
    public State clickedAddLine() {
        try {
            logger.info("Clicked add line event triggered.");
            Point currentPoint = drawingPanel.getLocationOnScreen();
            Robot robot = new Robot();
            robot.mouseMove(currentPoint.x + 400, currentPoint.y + 250);
            logger.info("Moved cursor to mid screen, moving to Select origin line state.");
            return SelectOrigin.getInstance();
        } catch (AWTException exception) {
           throw new RuntimeException("Could not move cursor after add line.");
        }
    }

    @Override
    public State clickedUndoButton() {
        if (undoStack.size() == 0) {
            logger.info("Undo stack is empty, no action needed.");
            return this;
        }

        DrawCommand command = undoStack.pop();
        logger.info("Attempting undo if reversable. Reversable results " + command.reversable());
        if (command.reversable()) {
            command.undo();
        }

        return this;
    }

    public void addUndoCommand(DrawCommand command) {
        logger.info("Draw command added to undo stack.");
        this.undoStack.push(command);
    }

    public void setDrawingPanel(DrawingPanel drawingPanel) {
        InitState.drawingPanel = drawingPanel;
    }
}
