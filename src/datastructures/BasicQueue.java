package datastructures;

import interfaces.Queue;

public class BasicQueue<X> implements Queue<X> {

    private X[] data;
    private int front, end;

    public BasicQueue(){
        this(1000);
    }

    public BasicQueue(int size) {
        data = (X[]) new Object[size];
        this.front = -1;
        this.end = -1;
    }

    public void enQueue(X item) {
        if ((end + 1) % data.length == front) {
            throw new IllegalStateException("Queue is full.");
        }
        else if (size() == 0) {
            this.front++;
            this.end++;
            data[end] = item;
        } else {
            data[++end] = item;
        }
    }

    public X deQueue() {
        X item = null;

        if (size() == 0) {
        throw new IllegalStateException("Cannot dequeue an empty queue");
        } else if (size() == 1) {
            item = data[front];
            data[front] = null;
            front = -1;
            end = -1;
        } else {
            item = data[front];
            data[front] = null;
            front++;
        }

        return item;
    }

    public int size() {
        if (front == -1 && end == -1) {
            return 0;
        } else {
            return end - front + 1;
        }
    }

    public boolean contains(X item) {
        boolean contains = false;

        if (size() > 0) {
            X tmpItem;
            for (int i = front; i <= end; i++) {
                tmpItem = data[i];
                if (item.equals(tmpItem)) {
                    contains = true;
                    break;
                }
            }

        }

        return contains;
    }

    public X access(int position) {

        int adjustedPosition = front + position -1;

        if (adjustedPosition > end || position < 0) {
            throw new IllegalArgumentException("Invalid queue item position");
        }

        X item = null;

        if (size() > 0) {
            item = data[front + position];
        }

        return item;

    }

}
