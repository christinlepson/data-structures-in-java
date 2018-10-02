package datastructures;

import interfaces.Stack;

import java.util.ArrayList;

public class ListStack<X> implements Stack<X> {

    private ArrayList<X> data;
    private int stackPointer;

    public ListStack() {
        data = new ArrayList<>();
        stackPointer = 0;
    }

    public void push(X item) {
        data.add(item);
        stackPointer++;
    }

    public X pop() {
        if (stackPointer <= 0) {
            return null;
        }
        return data.remove(--stackPointer);
    }

    public boolean contains(X item) {
        return data.contains(item);
    }

    public X access(X item) {
        while (stackPointer > 0) {
            X tmpItem = pop();
            if (tmpItem.equals(item)) {
                return tmpItem;
            }
        }
        return null;
    }

    public int size() {
        return stackPointer;
    }
}
