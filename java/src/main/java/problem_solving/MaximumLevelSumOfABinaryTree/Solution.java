package problem_solving.MaximumLevelSumOfABinaryTree;

import helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /**
     * Using BFS to accumulate sum on each level
     * At each level, accumulate sum and compare with the current max value.
     * If newSum > max:
     *  - update max value
     *  - update result level
     */
    public int maxLevelSum(TreeNode root) {
        if (root.left == null & root.right == null)  return 1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        int max = root.val;
        int result = 1;

        while(!queue.isEmpty()) {
            int sum = 0;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                sum += current.val;
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            if (sum > max) {
                max = sum;
                result = level;
            }
            level++;
        }
        return result;
    }

}
