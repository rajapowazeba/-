import java.util.Scanner;

class BinarySearchTree {
    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    public Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.value) {
            root.left = insert(root.left, value);
        } else if (value > root.value) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public Node findMax(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public int findSecondMax(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return -1; // Нет второго по величине элемента
        }

        Node parent = null;
        Node current = root;

        while (current.right != null) {
            parent = current;
            current = current.right;
        }

        if (current.left != null) {
            return findMax(current.left).value;
        }

        return parent.value;
    }

    public static void main(String[] args) {
        var tree = new BinarySearchTree();
        var scanner = new Scanner(System.in);
        Node root = null;

        while (true) {
            var number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            root = tree.insert(root, number);
        }

        int secondMax = tree.findSecondMax(root);
        System.out.println(secondMax);
    }
}
