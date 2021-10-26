package cse5233.hw1.view.listeners;

import cse5233.hw1.edit.EditDiagramController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RedoButtonListener implements ActionListener  {

    private static final Logger logger = LoggerFactory.getLogger(RedoButtonListener.class);

    private final EditDiagramController controller;

    public RedoButtonListener(EditDiagramController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        logger.info("Redo button selected.");
        controller.redo();
    }
}
