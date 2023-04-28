package edu.psu.ist;

import java.util.*;

import edu.psu.ist.controller.PuzzleBoxController;
import edu.psu.ist.model.IProducer;
import edu.psu.ist.model.PuzzleBox;
import edu.psu.ist.view.PuzzleBoxView;

public class App{
    public static void main(String[] args) {
        PuzzleBox model = new PuzzleBox<>();
        PuzzleBoxView view = new PuzzleBoxView();
        PuzzleBoxController controller = new PuzzleBoxController(model, view);

        view.setVisible(true);
    }
}