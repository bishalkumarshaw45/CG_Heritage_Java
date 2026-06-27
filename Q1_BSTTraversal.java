import java.util.*;

public class Q1_BSTTraversal {
    // Node class represents each node in the binary search tree
    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static class BinarySearchTree {
        Node root;

        // Insert values into the BST
        void insert(int value) {
            root = insertRec(root, value);
        }

        private Node insertRec(Node current, int value) {
            if (current == null) {
                return new Node(value);
            }

            if (value < current.value) {
                current.left = insertRec(current.left, value);
            } else if (value > current.value) {
                current.right = insertRec(current.right, value);
            }
            return current;
        }

        // Inorder: Left -> Root -> Right
        void inorder(Node node) {
            if (node == null) {
                return;
            }
            inorder(node.left);
            System.out.print(node.value + " ");
            inorder(node.right);
        }

        // Preorder: Root -> Left -> Right
        void preorder(Node node) {
            if (node == null) {
                return;
            }
            System.out.print(node.value + " ");
            preorder(node.left);
            preorder(node.right);
        }

        // Postorder: Left -> Right -> Root
        void postorder(Node node) {
            if (node == null) {
                return;
            }
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.value + " ");
        }
    }

    public static void main(String[] args) {
        int[] values = {10, 5, 15, 3, 7, 12, 20};
        BinarySearchTree bst = new BinarySearchTree();

        for (int value : values) {
            bst.insert(value);
        }

        System.out.println("BST Traversals:");
        System.out.print("Inorder: ");
        bst.inorder(bst.root);
        System.out.println();

        System.out.print("Preorder: ");
        bst.preorder(bst.root);
        System.out.println();

        System.out.print("Postorder: ");
        bst.postorder(bst.root);
        System.out.println();
    }
}
