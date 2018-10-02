package datastructures;

public class BasicStack<X> {

    private X[] data;
    private int stackPointer;

    public BasicStack() {
        data = (X[]) new Object[1000];
        stackPointer = 0;
    }

    public void push(X newItem) {
        data[stackPointer] = newItem;
        stackPointer++;
    }

    public X pop() {
        if (stackPointer == 0) {
            throw new IllegalStateException("No more items on the stack.");
        }
        stackPointer--;
        return data[stackPointer];
    }

    public X peek() {
        if (stackPointer == 0) {
            throw new IllegalStateException("No more items on the stack.");
        }
        return data[stackPointer - 1];
    }

    public boolean contains(X item) {
        boolean found = false;

        for (int i = 0; i < stackPointer; i++) {
            if (data[i].equals(item)) {
                found = true;
                break;
            }
        }

        return found;

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
