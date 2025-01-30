package problem_solving.PathSumIII;

import helper.TreeNode;

import java.util.HashMap;

import static helper.BinaryTreeBuilder.buildTree;

public class Solution {

    /**
     * Using prefixSum (to optimize the calculation of path sums, avoiding recalculating sums for overlapping subtrees) and DFS
     * 1. Path Sum Using Prefix Sum
     * 2. Recursive DFS
     */
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0L, 1);
        return dfs(root, 0, targetSum, prefixSumMap);
    }

    private int dfs(TreeNode node, long currentSum, int targetSum, HashMap<Long, Integer> prefixSumMap) {
        if (node == null) {
            return 0;
        }
        currentSum += node.val;
        // Path Sum = currentSum at B - prefixSum at A
        // If pathSum equals targetSum, we can rearrange the equation to:
        // prefixSum at A = currentSum at B - targetSum
        int paths = prefixSumMap.getOrDefault(currentSum - targetSum, 0);

        prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        paths += dfs(node.left, currentSum, targetSum, prefixSumMap);
        paths += dfs(node.right, currentSum, targetSum, prefixSumMap);

        // Backtrack: Remove the current sum from the map to avoid affecting sibling branches
        prefixSumMap.put(currentSum, prefixSumMap.get(currentSum) - 1);

        return paths;
    }

    public static void main(String[] args) {
        Integer[] values = {1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000};
        TreeNode root = buildTree(values);
        Solution sol = new Solution();
        int paths = sol.pathSum(root, 0);
        System.out.println(paths);

    }
    

}
