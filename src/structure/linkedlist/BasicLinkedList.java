package structure.linkedlist;

import model.LinkedList;

public class BasicLinkedList<T> implements LinkedList<T> {
    private Node first;
    private Node last;
    private int nodeCount;

    public BasicLinkedList() {
        nodeCount = 0;
    }

    public int size() {
        return nodeCount;
    }

    @Override
    public void add(T item) {
        if(first == null) {
            first = new Node(item);
            last = first;
        } else {
            Node newLastNode = new Node(item);
            last.setNextNode(newLastNode);
            last = newLastNode;
        }
        nodeCount++;
    }

    @Override
    public void insert(T item, int position) {
        if (position > size()) {
            throw new IllegalArgumentException("LinkedList has fewer items than position provided");
        }

        Node tempNode = first;
        for(int i = 1; i < position && tempNode != null; i++) {
            tempNode = tempNode.getNextNode();
        }

        Node nodeToBeAdded = new Node(item);
        Node nextNode = tempNode.getNextNode();
        tempNode.setNextNode(nodeToBeAdded);
        nodeToBeAdded.setNextNode(nextNode);

        nodeCount++;
    }

    @Override
    public T remove() {
        if(first == null) {
            throw new IllegalStateException("LinkedList is empty");
        }
        T result = first.getNodeItem();
        first = first.getNextNode();
        nodeCount--;

        return result;
    }

    @Override
    public T get(int position) {
        if(first == null) {
            throw new IllegalArgumentException("LinkedList has fewer items than position provided");
        }

        Node tempNode = first;
        for(int i = 1; i < size() && tempNode != null; i++) {
            if(i == position) {
                return tempNode.getNodeItem();
            }
            tempNode = tempNode.getNextNode();
        }

        return null;
    }

    @Override
    public int find(T item) {
        if(first == null) {
            throw new IllegalArgumentException("LinkedList is empty");
        }

        Node temp = first;
        for (int i = 1; i < size() && temp != null; i++) {
            if(temp.getNodeItem().equals(item)) {
                return i;
            }
            temp = temp.getNextNode();
        }
        return -1;
    }

    @Override
    public T removeAt(int position) {
        if(first == null) {
            throw new IllegalStateException("LinkedList is empty");
        }

        Node nodeToBeRemoved = first;
        Node prevNode = first;

        for(int i = 1; i < position && nodeToBeRemoved != null; i++) {
            prevNode = nodeToBeRemoved;
            nodeToBeRemoved = nodeToBeRemoved.getNextNode();
        }

        T nodeItem = nodeToBeRemoved.getNodeItem();
        prevNode.setNextNode(nodeToBeRemoved.getNextNode());
        nodeCount--;
        return nodeItem;
    }

    @Override
    public String toString() {
        StringBuffer contents = new StringBuffer();
        Node currentNode = first;
        while (currentNode != null) {
            contents.append(currentNode.getNodeItem());
            currentNode = currentNode.getNextNode();
            if(currentNode != null) {
                contents.append(", ");
            }
        }
        return contents.toString();
    }

    private class Node {
        private Node nextNode;
        private T nodeItem;

        public Node(T nodeItem) {
            this.nextNode = null;
            this.nodeItem = nodeItem;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public T getNodeItem() {
            return nodeItem;
        }

    }

}
