package cse5233.hw1.view.listeners;

import cse5233.hw1.edit.EditDiagramController;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class LineMouseMotionListener implements MouseMotionListener {

    @Override
    public void mouseDragged(MouseEvent e) {
        new EditDiagramController().dragMouse();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
