package cse5233.hw1.view;

import cse5233.hw1.edit.EditDiagramController;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class LineMouseMotionListener implements MouseMotionListener {

    private final EditDiagramController controller;

    public LineMouseMotionListener(EditDiagramController controller) {
        this.controller = controller;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        controller.dragMouse();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
