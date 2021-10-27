package cse5233.hw1.edit;

import cse5233.hw1.edit.circle.SelectCenter;
import cse5233.hw1.edit.cmd.DrawCommand;
import cse5233.hw1.edit.line.SelectOrigin;
import cse5233.hw1.edit.square.SelectCorner;
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

    private Stack<DrawCommand> redoStack;

    private InitState() {
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    public static InitState getInstance() {
        if (initState == null) {
            initState = new InitState();
        }

        return initState;
    }

    @Override
    public State clickedAddSquare() {
        try {
            logger.info("Clicked add square event triggered.");
            Point currentPoint = drawingPanel.getLocationOnScreen();
            Robot robot = new Robot();
            robot.mouseMove(currentPoint.x + 400, currentPoint.y + 250);
            logger.info("Moved cursor to mid screen, moving to Select corner square state.");
            return SelectCorner.getInstance();
        } catch (AWTException exception) {
            throw new RuntimeException("Could not move cursor after add square.");
        }
    }

    @Override
    public State clickedAddCircle() {
        try {
            logger.info("Clicked add circle event triggered.");
            Point currentPoint = drawingPanel.getLocationOnScreen();
            Robot robot = new Robot();
            robot.mouseMove(currentPoint.x + 400, currentPoint.y + 250);
            logger.info("Moved cursor to mid screen, moving to Select Center circle state.");
            return SelectCenter.getInstance();
        } catch (AWTException exception) {
            throw new RuntimeException("Could not move cursor after add circle.");
        }
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
            redoStack.push(command);
        }

        return this;
    }

    @Override
    public State clickedRedoButton() {
        if (redoStack.size() == 0) {
            logger.info("Redo stack is empty, no action needed.");
            return this;
        }
        DrawCommand command = redoStack.pop();
        logger.info("Attempting undo if reversable. Reversable results " + command.reversable());
        if (command.reversable()) {
            command.redo();
            undoStack.push(command);
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
