package cse5233.hw1.edit.cmd;

public interface DrawCommand {
    void execute();
    void redo();
    void undo();
    boolean reversable();
}
