package edu.psu.ist.model;

import java.util.*;

public class PuzzleBox<T extends Comparable<T>> {
    private List<T> items;

    public PuzzleBox() {
        items = new ArrayList<>();
    }

    public void addItemsTo(List<T> newItems) {
        items.addAll(newItems);
    }

    /**
     * recursively clears this.items list
     */
    public void clear() {
        if (this.items.size() == 0) {
            return;
        }
        this.items.remove(0);
        clear();
    }

    /**
     * uses helper method to recursively return count of items in this.items
     * @return countItems in this.items
     */
    public int numOfItems() {
        return numOfItemsHelper(this.items);
    }

    //helper method
    private int numOfItemsHelper(List<T> items) {
        if (items.isEmpty()) {
            return 0;
        } else {
            return 1 + numOfItemsHelper(items.subList(1, items.size())); //starts at 2nd item (item 1 is already counted) then adds 1 for item in sublist and repeats
        }
    }


    /**
     * uses bubble sort algo I read about online
     * repeatedly swaps adjacent elements and is repeated until the list is sorted
     * also mutates this.items list
     * <p>
     * runtime of O(n^2) - honestly I only know this because I know the algo has that runtime
     */
    public List<T> sort() {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < this.items.size() - 1; i++) {
                if (this.items.get(i).compareTo(this.items.get(i+1)) > 0) {
                    // Swap the elements
                    T temp = this.items.get(i);
                    this.items.set(i, this.items.get(i+1));
                    this.items.set(i+1, temp);
                    sorted = false;
                }
            }
        }
        return items;
    }


    public boolean inDoubleOrder() {
        if (this.items.size() < 2) {
            //empty one element list is sorted
            return true;
        } else {
            return inDoubleOrderHelper(this.items);
        }
    }


    // todo: not working correctly
    /**
     * double order helper.
     * recursively checks if the elements are in order
     * @param items
     * @return bool on if elements in order
     */
    private boolean inDoubleOrderHelper(List<T> items) {
        if (items.size() < 2) {
            return true;
        } else {
            // check if the first two elements are in order then recursively check the rest
            T first = items.get(0);
            T second = items.get(1);
            if (first instanceof Double && second instanceof Double) {
                Double firstDouble = (Double) first;
                Double secondDouble = (Double) second;
                if (firstDouble <= secondDouble) {
                    return inDoubleOrderHelper(items.subList(1, items.size()));
                } else {
                    return false;
                }
            } else {
                // If any element is not double, false
                return false;
            }
        }
    }


    public void randomlyPopulate(IProducer<T> itemProducer) {
        clear();
        for (int i = 0; i < 8; i++) {
            T generatedItem = itemProducer.produce();
            items.add(generatedItem);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T item : items) {
            sb.append(item).append(" ");
        }
        return sb.toString().trim();
    }
}
