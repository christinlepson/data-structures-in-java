package datastructures;

public class BasicBinaryTree<X extends Comparable<X>> {

    private Node root;
    private int size;

    public BasicBinaryTree() {
        root = null;
    }

    public void add(X item) {

        Node newNode = new Node(item);

        if (root == null) {
            root = newNode;
            size++;
        } else {
            insert(root, newNode);
        }

    }

    public boolean contains(X item) {
        return getNode(item, root) != null;
    }

    public Node getNode(X item, Node node) {
        if (node == null) {
            return null;
        } else if (item.compareTo(node.getItem()) == 0) {
            return node;
        } else if (item.compareTo(node.getItem()) < 0) {
            return getNode(item, node.getLeft());
        } else if (item.compareTo(node.getItem()) > 0) {
            return getNode(item, node.getRight());
        }

        return null;
    }

    private void insert(Node parent, Node child) {
        //If child is less than parent
        if (child.getItem().compareTo(parent.getItem()) < 0) {
            //If parent's left node is null
            if (parent.getLeft() == null) {
                //Insert the child node
                child.setParent(parent);
                parent.setLeft(child);
                size++;
            } else {
                //Parent's left node wasn't null, we've got to do it again
                insert(parent.getLeft(),child);
            }
            //If child is greater than parent
        } else if (child.getItem().compareTo(parent.getItem()) > 0) {
            //If parent's right node is null
            if(parent.getRight() == null) {
                //Insert the child
                child.setParent(parent);
                parent.setRight(child);
                size++;
            } else {
                //Parent's right node wasn't null, we've got to do it again
                insert(parent.getRight(), child);
            }
        }

        //If parent and child are equal, we don't insert.

    }

    public boolean delete(X item) {

        boolean deleted = false;

        if (root == null) {
            return false;
        }

        Node currentNode = getNode(item, root);

        if(currentNode != null) {

            //if the node has no children, simply replace it with null
            if(currentNode.getLeft() == null && currentNode.getRight() == null) {
                unlink(currentNode, null);
                deleted = true;
            }
            //if the node has only a right child, replace with right child
            else if (currentNode.getLeft() == null & currentNode.getRight() != null) {
                unlink(currentNode, currentNode.getRight());
                deleted = true;
            }
            //if the node has only a left child, replace with left child
            else if (currentNode.getLeft() != null && currentNode.getRight() ==  null) {
                unlink(currentNode, currentNode.getLeft());
                deleted = true;
            }
            //if node has both children, swap it out with the rightmost child of its left child
            else {
                Node child = currentNode.getLeft();
                while (child.getRight() != null && child.getLeft() != null) {
                    child = child.getRight();
                }
                // we have the rightmost node. we can now swap it with the current node
                child.getParent().setRight(null);

                child.setLeft(currentNode.getLeft());
                child.setRight(currentNode.getRight());

                unlink(currentNode, child);
                deleted =  true;

            }

            size--;

        }

        return deleted;

    }

    private void unlink(Node currentNode, Node newNode) {

        if(currentNode == root) {
            newNode.setLeft(currentNode.getLeft());
            newNode.setRight(currentNode.getRight());
            this.root = newNode;
        } else if (currentNode.getParent().getRight() == currentNode) {
            currentNode.getParent().setRight(newNode);
        } else if (currentNode.getParent().getLeft() == currentNode) {
            currentNode.getParent().setLeft(newNode);
        }

    }

    public int size() {
        return size;
    }

    private class Node {

        private Node left, right, parent;
        private X item;

        public Node(X item) {
            this.item = item;
            left = null;
            right = null;
            parent = null;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public X getItem() {
            return item;
        }

        public void setItem(X item) {
            this.item = item;
        }
    }

}
