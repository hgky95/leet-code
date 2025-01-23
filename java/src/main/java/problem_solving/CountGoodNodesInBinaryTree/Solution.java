package problem_solving.CountGoodNodesInBinaryTree;

public class Solution {

    /**
     * Using DFS
     * Lookup on each sub-tree, if the next node's value is greater than the current node:
     *  + increase counter
     *  + set new compared value by max(current compared value, current node's value)
     */
    public int goodNodes(TreeNode root) {
        int counter = 1;
        counter = dfs(root.left, root.val, counter);
        counter = dfs(root.right, root.val, counter);
        return counter;
    }

    private int dfs(TreeNode root, int comparedValue, int counter) {
        if (root == null) return counter;
        if (root.val >= comparedValue) {
            counter++;
        }
        int newComparedValue = Math.max(comparedValue, root.val);
        counter = dfs(root.left, newComparedValue, counter);
        counter = dfs(root.right, newComparedValue, counter);
        return counter;
    }

    static class TreeNode {
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

    public static void main(String[] args) {
        Solution x = new Solution();
        TreeNode root = new TreeNode(9);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        int rs = x.goodNodes(root);
        System.out.println(rs);
    }
}
