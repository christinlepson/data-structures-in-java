package datastructures;

public class BasicLinkedList<X> {

    private Node first, last;
    private int nodeCount;

    public BasicLinkedList() {
        first = null;
        last = null;
        nodeCount = 0;
    }

    public void add(X item) {

        Node newNode = new Node(item);

        if (first == null) {
            first = newNode;
            last = first;
        } else {
            last.setNextNode(newNode);
            last = newNode;
        }
            nodeCount++;
    }

    public X remove() {

        if (first == null) {
            throw new IllegalStateException("Can't remove from an empty Linked List");
        }

        X item = first.getNodeItem();
        first = first.getNextNode();
        nodeCount--;
        return item;

    }

    public void insert(X item, int position) {
        int itemIndex = position - 1;

        if (itemIndex > size()) {
            throw new IllegalArgumentException("Position is larger than Linked List size");
        } else if (itemIndex == size()) {
            add(item);
        } else {
            Node currentNode = first;

            for (int i = 0; i < itemIndex && currentNode != null; i++) {
               currentNode = currentNode.getNextNode();
            }

            Node newNode = new Node(item);
            newNode.setNextNode(currentNode.getNextNode());
            currentNode.setNextNode(newNode);
            nodeCount++;
        }

    }

    public X removeAt(int position) {

        if (first == null) {
            throw new IllegalArgumentException("Cannot remove from an empty linked list;");
        } else if (position < 1 || position > size()) {
            throw new IllegalArgumentException("Invalid position for removing from linked list");
        } else if (position == 1) {
            return remove();
        } else {
            int itemIndex = position - 1;
            Node prevNode = first;
            Node currentNode = first;
            for (int i = 0; i < itemIndex && currentNode.getNextNode() != null; i++) {
                prevNode = currentNode;
                currentNode = currentNode.getNextNode();
            }
            X item = currentNode.getNodeItem();
            prevNode.setNextNode(currentNode.getNextNode());
            nodeCount--;
            return item;
        }
    }

    public X get(int position) {
        if (first == null) {
            throw new IllegalArgumentException("Cannot get an item from an empty linked list");
        } else if (position < 1 || position > size()) {
            throw new IllegalArgumentException("Invalid position for getting an item from linked list");
        } else {
            int itemIndex = position - 1;
            Node currentNode = first;
            for (int i = 0; i < itemIndex && currentNode.getNextNode() != null; i++) {
                currentNode = currentNode.getNextNode();
            }
            return currentNode.getNodeItem();
        }
    }

    public int find(X item) {
        if (first == null) {
            throw new IllegalArgumentException("Cannot find an item from an empty linked list");
        }

        Node currentNode = first;
        for (int i = 1; i <= size() && currentNode.getNextNode() != null; i++) {
            if (currentNode.getNodeItem().equals(item)) {
                return i;
            }
            currentNode = currentNode.getNextNode();
        }

        return -1;

    }

    public String toString() {
        StringBuffer contents = new StringBuffer();
        Node currentNode = first;

        while (currentNode != null) {
            contents.append(currentNode.getNodeItem());
            currentNode = currentNode.getNextNode();
            if (currentNode != null) {
                contents.append(", ");
            }
        }

        return contents.toString();
    }

    public int size() {
        return nodeCount;
    }


    private class Node {

        private Node nextNode;
        private X  item;

        public Node(X item) {
            this.item = item;
            nextNode = null;
        }

        public void setNextNode(Node node) {
            nextNode = node;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public X getNodeItem() {
            return item;
        }
    }


}
