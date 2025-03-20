import java.util.Scanner;

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

    public boolean isAVLTree() {
        return checkBalance(root) != -1;
    }

    private int checkBalance(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = checkBalance(node.left);
        int rightHeight = checkBalance(node.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();

        while (true) {
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            tree.insert(number);
        }

        System.out.println(tree.isAVLTree() ? "YES" : "NO");
    }
}
