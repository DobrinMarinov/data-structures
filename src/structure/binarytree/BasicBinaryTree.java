package structure.binarytree;

public class BasicBinaryTree<X extends Comparable<X>> {

    private Node root;
    private int size;

    public int size() {
        return this.size;
    }

    public void add(X item) {
        Node node = new Node(item);

        if(root == null) {
            this.root = node;
            System.out.println("Root is set: " + node.getItem());
            this.size++;
        } else {
            insert(this.root, node);
        }
    }

    private void insert(Node parent, Node child) {
        if(child.getItem().compareTo(parent.getItem()) < 0) {
            //if the child is less then the parent, it goes on the left
            if(parent.getLeft() == null) {
                parent.setLeft(child);
                child.setParent(parent);
                this.size++;
            } else {
                //otherwise call insert again and test for left or right
                insert(parent.getLeft(), child);
            }
        } else if (child.getItem().compareTo(parent.getItem()) > 0) {
            if(parent.getRight() == null) {
                parent.setRight(child);
                child.setParent(parent);
                this.size++;
            } else {
                insert(parent.getRight(), child);
            }

            //if they are equal new item is not stored in the tree
        }
    }



    private class Node {
        private Node left;
        private Node right;
        private Node parent;
        private X item;

        public Node(X item) {
            this.item = item;
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
