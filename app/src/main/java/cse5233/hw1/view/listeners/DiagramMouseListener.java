package cse5233.hw1.view.listeners;

import cse5233.hw1.edit.EditDiagramController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DiagramMouseListener implements MouseListener {

    private static final Logger logger = LoggerFactory.getLogger(DiagramMouseListener.class);


    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        logger.info("Mouse pressed detected.");
        if(SwingUtilities.isMiddleMouseButton(e)) {
            logger.info("Middle mouse button clicked reset.");
            new EditDiagramController().midButtonClick();
        } else {
            new EditDiagramController().mousePressed();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        new EditDiagramController().mouseReleased();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
