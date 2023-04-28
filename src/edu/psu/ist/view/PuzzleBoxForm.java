package edu.psu.ist.view;

import javax.swing.*;

public class PuzzleBoxForm {
    private JPanel myPanel;
    private JLabel AddItems;
    private JTextField textFieldStr;
    private JLabel countItems;
    private JButton clearAndAdd;
    private JButton clearButton;
    private JButton sortButton;
    private JButton randomizeButton;
    private JButton doubleOrderedButton;
    private JLabel numOfItems;

    public JLabel getAddItems() {
        return AddItems;
    }

    public JLabel getNumOfItems() {
        return numOfItems;
    }

    public JTextField getTextFieldStr() {
        return textFieldStr;
    }

    public JTextField getInputTextField() {
        return textFieldStr;
    }

    public JLabel getCountItems() {
        return countItems;
    }

    public JButton getClearAndAdd() {
        return clearAndAdd;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JButton getSortButton() {
        return sortButton;
    }

    public JButton getRandomizeButton() {
        return randomizeButton;
    }

    public JButton getDoubleOrderedButton() {
        return doubleOrderedButton;
    }

    public JPanel getMyPanel() {
        return myPanel;
    }
}
