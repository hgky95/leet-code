package problem_solving.LeafSimilarTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     *  Using DFS
     *  Create two lists to store the leafs of two tree
     *  Lookup on each tree to find the leaf, if the current node is the leaf (root.left & root.right is null)
     *      + add this leaf's value to list
     *  Compare two lists
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();
        dfs(root1, leaf1);
        dfs(root2, leaf2);
        return Arrays.equals(leaf1.toArray(), leaf2.toArray());
    }

    private void dfs(TreeNode root, List<Integer> leaf) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leaf.add(root.val);
            return;
        }
        dfs(root.left, leaf);
        dfs(root.right, leaf);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


