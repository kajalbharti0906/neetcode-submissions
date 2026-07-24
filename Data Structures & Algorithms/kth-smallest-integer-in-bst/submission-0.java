/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    List<Integer> traverse = new ArrayList<>();
    public void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        preOrder(root.left);
        traverse.add(root.val);
        preOrder(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        preOrder(root);
        return traverse.get(k-1);
    }
}
