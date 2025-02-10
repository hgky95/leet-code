package problem_solving.BinaryTreeRightSideView;

import com.sun.source.tree.Tree;
import helper.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    /**
     * Using BFS
     * The right side view node - it means the last node on each level
     * Beside with normal BFS operation, we also need to iterate on each node of each level to find the latest node
     * Add this node's value to the list
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> nodeValues = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return nodeValues;

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode lastNode = null;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                lastNode = current;

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            nodeValues.add(lastNode.val);
        }
        return nodeValues;
    }
}
