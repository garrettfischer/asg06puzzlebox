package edu.psu.ist.model;

import java.util.List;
import java.util.Random;

public class Tester {
        public static void main(String[] args) {
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
            System.out.println(faceBox); // will print a string like ":-) :-0 :-) :-0 :-0 :-) :-0 :-)"

            PuzzleBox<Integer> intBox = new PuzzleBox<>();
            intBox.addItemsTo(List.of(1, 2, 3, 4, 5));

            IProducer<Integer> intGenerator = () -> {
                Random rand = new Random();
                return rand.nextInt(10); // generates a random number between 0..9 (inclusive)
            };

            // clears, then fills the puzzlebox with 5 random numbers
            intBox.randomlyPopulate(intGenerator);
            System.out.println(intBox.inDoubleOrder());
        }
    }
