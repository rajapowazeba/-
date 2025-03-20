import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

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

    public void printNodesWithOneChild() {
        ArrayList<Integer> nodesWithOneChild = new ArrayList<>();
        findNodesWithOneChild(root, nodesWithOneChild);
        Collections.sort(nodesWithOneChild);
        for (int node : nodesWithOneChild) {
            System.out.println(node);
        }
    }

    private void findNodesWithOneChild(Node node, ArrayList<Integer> nodesWithOneChild) {
        if (node == null) {
            return;
        }
        if ((node.left == null && node.right != null) || (node.left != null && node.right == null)) {
            nodesWithOneChild.add(node.value);
        }
        findNodesWithOneChild(node.left, nodesWithOneChild);
        findNodesWithOneChild(node.right, nodesWithOneChild);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();

        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            tree.insert(number);
        }

        tree.printNodesWithOneChild();
    }
}