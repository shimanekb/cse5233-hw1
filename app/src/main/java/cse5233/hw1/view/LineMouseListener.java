package cse5233.hw1.view;

import cse5233.hw1.edit.EditDiagramController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LineMouseListener implements MouseListener {

    private static final Logger logger = LoggerFactory.getLogger(LineMouseListener.class);

    private final EditDiagramController editDiagramController;

    public LineMouseListener(EditDiagramController editDiagramController) {
        this.editDiagramController = editDiagramController;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        logger.info("Mouse pressed detected.");
        editDiagramController.mousePressed();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        editDiagramController.mouseReleased();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
