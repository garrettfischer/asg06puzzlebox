package edu.psu.ist.controller;
import edu.psu.ist.model.IProducer;
import edu.psu.ist.model.PuzzleBox;
import edu.psu.ist.view.PuzzleBoxForm;
import edu.psu.ist.view.PuzzleBoxView;
import javax.swing.*;
import java.util.*;

/**
 * Controls the GUI interface for when buttons are used, or text input
 */
public class PuzzleBoxController {

    private PuzzleBox<Integer> model;
    private PuzzleBoxView view;

    public PuzzleBoxController(PuzzleBox model, PuzzleBoxView view) {
        this.model = model;
        this.view = view;

        PuzzleBoxForm form = view.getForm();

        //default disables clear, sort, and ordered buttons
        form.getClearButton().setEnabled(false);
        form.getSortButton().setEnabled(false);
        form.getDoubleOrderedButton().setEnabled(false);

        // at runtime sets the # of items
        form.getNumOfItems().setText(model.numOfItems()+"");


        /**
         *  clear and add text input - button controller
         *  Has error checking to make sure items are entered in text input
         *  Also enables the clear, sort, and ordered buttons
         *  Updates # of items
         */
        form.getClearAndAdd().addActionListener(e -> {
            String textFieldStr = form.getTextFieldStr().getText();
            if (textFieldStr.trim().isEmpty()){
                JOptionPane.showMessageDialog(view, "Error: Enter items in the text field!");
                return;
            }
            List<String> itemsToAdd = getTextFieldContents(textFieldStr);
            model.clear();
            model.addItemsTo(itemsToAdd);
            form.getNumOfItems().setText(model.numOfItems()+"");
            form.getClearButton().setEnabled(true);
            form.getSortButton().setEnabled(true);
            form.getDoubleOrderedButton().setEnabled(true);
        });

        /**
         * clears the puzzlebox - button controller
         * updates # of items
         * disables clear, sort, order buttons
         */
        form.getClearButton().addActionListener(e -> {
            model.clear();
            form.getTextFieldStr().setText("");
            form.getNumOfItems().setText(model.numOfItems()+"");
            form.getClearButton().setEnabled(false);
            form.getSortButton().setEnabled(false);
            form.getDoubleOrderedButton().setEnabled(false);
        });

        /**
         * Sort - button controller
         *
         */

        form.getSortButton().addActionListener(e ->{
            form.getTextFieldStr().setText(model.sort() + "");
        });

        /**
         * randomize - button controller
         * randomizes the puzzlebox using IProducer interface and num generator below
         * updates # of items
         * enables clear, sort, order buttons
         */
        form.getRandomizeButton().addActionListener(e -> {

            IProducer<Integer> numGenerator = () -> {
                Random ran = new Random(); // random num generator
                return ran.nextInt(6); // generates random num between 0-5
            };

            model.randomlyPopulate(numGenerator);
            form.getTextFieldStr().setText(model +"");
            form.getNumOfItems().setText(model.numOfItems()+"");
            form.getClearButton().setEnabled(true);
            form.getSortButton().setEnabled(true);
            form.getDoubleOrderedButton().setEnabled(true);

        });

        /**
         * double ordered controller
         * uses doubleOrder method to check if puzzlebox is ordered
         * COULDN'T FIGURE OUT HOW TO GET IT TO WORK, ONLY DISPLAYS NOT DOUBLE ORDERED
         */
        form.getDoubleOrderedButton().addActionListener(e -> {
            boolean result = model.inDoubleOrder();
            if (result == true) {
                JOptionPane.showMessageDialog(view, "It is double ordered :)");
            } else {
                JOptionPane.showMessageDialog(view, "It is NOT double ordered :(");
            }
        });
    }

    /**
     * Cleans the input
     * @param textFieldStr
     * @return
     */
    private List<String> getTextFieldContents(String textFieldStr) {
        List<String> result = new ArrayList<>();

        // want to split on one or more whitespace chars
        for (String s : textFieldStr.split("\\s+")) {
            s = s.trim(); // clean up the string, then verify (below)
            if (s.isEmpty() || s.isBlank() || s.contains(" ")) {
                JOptionPane.showMessageDialog(view,
                        "Invalid pattern: must be a " +
                                "whitespace delimited list");
                return new ArrayList<>();
            }
            result.add(s);
        }
        return result;
    }

}
