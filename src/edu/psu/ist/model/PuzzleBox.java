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

    public void clear() {
        items.clear();
    }

    public int numOfItems() {
        return items.size();
    }

    public void sort() {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < items.size() - 1; i++) {
                T current = items.get(i);
                T next = items.get(i + 1);
                if (current.compareTo(next) > 0) {
                    items.set(i, next);
                    items.set(i + 1, current);
                    sorted = false;
                }
            }
        }
    }

    public boolean inDoubleOrder() {
        return inDoubleOrderHelper(items);
    }

    private boolean inDoubleOrderHelper(List<T> list) {
        if (list.size() <= 1) {
            return true;
        } else {
            T first = list.get(0);
            T second = list.get(1);
            if (first.compareTo(second) > 0) {
                return false;
            } else if (first.equals(second)) {
                return inDoubleOrderHelper(list.subList(2, list.size()));
            } else {
                int idx = Collections.lastIndexOfSubList(list.subList(1, list.size()), List.of(second, second));
                if (idx == -1) {
                    return false;
                } else {
                    return inDoubleOrderHelper(list.subList(idx + 2, list.size()));
                }
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
