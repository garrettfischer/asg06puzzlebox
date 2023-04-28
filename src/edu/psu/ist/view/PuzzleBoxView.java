package edu.psu.ist.view;

import javax.swing.*;
import java.awt.*;

public class PuzzleBoxView extends JFrame {
    private PuzzleBoxForm form;

    public PuzzleBoxView() {
        this.form = new PuzzleBoxForm();
        JPanel content = form.getMyPanel();
        this.setContentPane(content);
        this.setPreferredSize(new Dimension(500, 500));
        this.pack();

        this.setTitle("Puzzle Box");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public PuzzleBoxForm getForm(){
        return form;
    }
}
