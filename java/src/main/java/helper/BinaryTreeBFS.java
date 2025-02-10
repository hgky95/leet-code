package helper;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeBFS {

    // Method to perform BFS on a binary tree
    public static void bfs(TreeNode root) {
        if (root == null) {
            return; // If the tree is empty, do nothing
        }

        // Create a queue to store nodes
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // Start with the root node

        // Loop until the queue is empty
        while (!queue.isEmpty()) {
            // Remove the front node from the queue
            TreeNode currentNode = queue.poll();
            System.out.print(currentNode.val + " "); // Process the node (print its value)

            // Add the left child to the queue if it exists
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            // Add the right child to the queue if it exists
            if (currentNode.right != null) {
                queue.add(currentNode.right);

            }
        }
    }

    public static void main(String[] args) {
        // Create the binary tree from the example
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // Perform BFS traversal
        System.out.println("BFS Traversal:");
        bfs(root);
    }
}
