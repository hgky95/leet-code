package problem_solving.LowestCommonAncestorOfABinaryTree;

import helper.BinaryTreeBuilder;
import helper.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    /**
     * Using Recursive DFS
     * Traverse the tree recursively and check for the presence of node p and q.
     * Once we find both nodes in different subtrees or one of them is the current node, we can determine LCA
     * Base case:
     *      - If the current node is null, return null.
     *      - If the current node is either p or q, return the current node because it could potentially be the LCA
     * Determine LCA:
     *      - If both left & right recursive call return non-null values, it means one of the nodes (p / q) is in the left,
     *      the other in the right subtree. In this case, return the current node
     *      - If only one subtree return non-null value, it means p & q are in the same subtree, we can return the non-null value
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // Both are non-null, return their root
        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    public static void main(String[] args) {
        TreeNode root = BinaryTreeBuilder.buildTree(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        Solution sol = new Solution();
        sol.lowestCommonAncestor(root, p, q);
    }
}
