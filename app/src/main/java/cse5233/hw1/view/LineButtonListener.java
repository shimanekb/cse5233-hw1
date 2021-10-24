package cse5233.hw1.view;

import cse5233.hw1.edit.EditDiagramController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LineButtonListener implements ActionListener  {

    private final EditDiagramController controller;


    public LineButtonListener(EditDiagramController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.addLine();
    }
}
