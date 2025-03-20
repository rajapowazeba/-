import java.util.*;

class BinarySearchTree {
    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            this.left = this.right = null;
        }
    }

    private Node root;

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.left = insertRecursive(node.left, value);
        } else if (value > node.value) {
            node.right = insertRecursive(node.right, value);
        }
        return node;
    }

    public void printLeaves(Node node) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                System.out.println(node.value);
            }
            printLeaves(node.left);
            printLeaves(node.right);
        }
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var tree = new BinarySearchTree();

        while (true) {
            var number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            tree.insert(number);
        }

        tree.printLeaves(tree.root);
    }
}
