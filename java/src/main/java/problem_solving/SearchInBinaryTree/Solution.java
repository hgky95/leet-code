package problem_solving.SearchInBinaryTree;

public class Solution {

    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return new TreeNode(val, root.left, root.right);
            } else if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }


    public class TreeNode {
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
