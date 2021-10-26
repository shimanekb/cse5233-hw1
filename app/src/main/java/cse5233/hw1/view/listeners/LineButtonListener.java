package cse5233.hw1.view.listeners;

import cse5233.hw1.edit.EditDiagramController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LineButtonListener implements ActionListener  {

    private static final Logger logger = LoggerFactory.getLogger(LineButtonListener.class);

    private final EditDiagramController controller;

    public LineButtonListener(EditDiagramController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        logger.info("Line button selected.");
        controller.addLine();
    }
}
