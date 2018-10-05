package datastructures;

import interfaces.Queue;

import java.util.ArrayList;

public class ListQueue<X> implements Queue<X> {

    private ArrayList<X> data;

    public ListQueue() {
        data = new ArrayList<>();
    }

    public void enQueue(X item) {
        data.add(item);
    }

    public X deQueue() {

        if (size() == 0) {
            throw new IllegalStateException("Cannot deQueue from an empty queue");
        }

        return data.remove(0);

    }

    public boolean contains(X item) {
        return data.contains(item);
    }

    public X access(int position) {
        if (size() == 0) {
            throw new IllegalArgumentException("Cannot access from an empty queue");
        } else if (position - 1 > size()) {
            throw new IllegalArgumentException("Position for queue is out of bounds");
        }

        return data.get(position - 1);

    }

    public int size() {
        return data.size();
    }
}
