package problem_solving.LongestZigZagPathInABinaryTree;

import helper.TreeNode;

public class Solution {

    /**
     * Using Depth-First-Search
     * Define a DFS find longest path:
     * If the first direction is right, next path should be left:
     *      - Increase the path and change direction
     * If the first direction is right, we also need to check next right path:
     *      - Reset the length to 1, change the direction
     * Update the maxLength every time we change the direction
     */

    int maxLength = 0;
    public int longestZigZag(TreeNode root) {
        findLongestPath(root, true, 0);
        findLongestPath(root, false, 0);
        return maxLength;
    }

    public void findLongestPath(TreeNode node, boolean isLeft, int length) {
        if (node == null) return;
        maxLength = Math.max(length, maxLength);
        if (isLeft) {
            findLongestPath(node.right, false, length + 1);
            findLongestPath(node.left, true, 1);
        } else {
            findLongestPath(node.left, true, length + 1);
            findLongestPath(node.right, false, 1);
        }
    }
}
