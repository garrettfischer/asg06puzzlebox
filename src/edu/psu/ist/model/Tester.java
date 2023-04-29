package edu.psu.ist.model;

import java.util.List;
import java.util.Random;

public class Tester {
        public static void main(String[] args) {

            // tests adding items
            PuzzleBox<Integer> box = new PuzzleBox<>();
            box.addItemsTo(List.of(4, 3, 0, 1));
            System.out.println(box); //4 3 0 1

            //tests sort
            box.sort();
            System.out.println(box); //0 1 3 4

            //tests numOfItems
            System.out.println(box.numOfItems()); // 4


            //tests clear
            box.clear();
            System.out.println(box);

            //tests numOfItems and clear
            System.out.println(box.numOfItems()); // 0

            // tests in double order
            box.clear();
            box.addItemsTo(List.of(0, 0, 1, 1));
            System.out.println(box.inDoubleOrder()); // true

            box.clear();
            box.addItemsTo(List.of(0, 1, 2, 2));
            System.out.println(box.inDoubleOrder()); // false

            PuzzleBox<String> strBox = new PuzzleBox<>();
            strBox.addItemsTo(List.of("a", "a"));
            System.out.println(strBox.inDoubleOrder()); // true

            strBox.clear();
            strBox.addItemsTo(List.of("a", "b"));
            System.out.println(strBox.inDoubleOrder()); // false

            strBox.clear();
            strBox.addItemsTo(List.of("a"));
            System.out.println(strBox.inDoubleOrder()); // false

            box.clear();
            box.addItemsTo(List.of(0, 0, 0));
            System.out.println(box.inDoubleOrder()); // false

            box.clear();
            box.addItemsTo(List.of(1, 1, 1, 1));
            System.out.println(box.inDoubleOrder()); // true

            box.clear();
            box.addItemsTo(List.of(3, 3, 0, 0));
            System.out.println(box.inDoubleOrder()); // false

            box.clear();
            box.addItemsTo(List.of(0, 0, 3, 3));
            System.out.println(box.inDoubleOrder()); // true

            box.clear();
            box.addItemsTo(List.of(1, 2, 1, 2));
            System.out.println(box.inDoubleOrder()); // false





            // tests randomly populate and IProducer interface
            PuzzleBox<String> faceBox = new PuzzleBox<>();
            faceBox.addItemsTo(List.of("cat", "dog", "fish"));

            IProducer<String> faceStrGenerator = () -> {
                Random rand = new Random(); // declare a random num generator
                if (rand.nextInt(0,2) == 0) { // generates a random number between 0..1 (inclusive)
                    return ":-0";
                } else {
                    return ":-)";
                }
            };

// clears, then fills the puzzlebox with 8 diff faces
            faceBox.randomlyPopulate(faceStrGenerator);
            System.out.println(faceBox); // :-0 :-0 :-) :-0 :-0 :-) :-0 :-0
        }
    }
