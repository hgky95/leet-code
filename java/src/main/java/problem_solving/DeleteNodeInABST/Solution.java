package problem_solving.DeleteNodeInABST;

public class Solution {

    /**
     * Using Recursive to handle this challenge
     * 1. Find the node that equal key
     * 2. Delete this node:
     *      - If the node has only one child (left, right is null) then return left node
     *      - If the node has only one child (right, left is null) then return right node
     *      - If the node has two children:
     *          - Find the successor (in-order successor) by finding the smallest value on the right subtree
     *          - Set the value of current node by the successor's value
     *          - Delete this node to prevent duplicate value
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return  null;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else {
                TreeNode successor = root.right;
                while (successor.left != null) {
                    successor = successor.left;
                }
                root.val = successor.val;
                root.right = deleteNode(root.right, successor.val);
            }
        }
        return root;
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
