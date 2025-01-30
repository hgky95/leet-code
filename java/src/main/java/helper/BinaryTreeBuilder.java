package helper;

import problem_solving.PathSumIII.Solution;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeBuilder {

    public static TreeNode buildTree(Integer[] values) {
        if (values == null || values.length == 0) return null;

        // Create the root node
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1; // Start with the second element
        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();

            // Add the left child
            if (values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.add(current.left);
            }
            i++;

            // Add the right child
            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

}
