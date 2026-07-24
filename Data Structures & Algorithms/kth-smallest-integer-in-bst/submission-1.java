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
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;
        while(curr!=null) {
            if(curr.left == null) {
                --k;
                if(k==0) {
                    return curr.val;
                }
                curr = curr.right;
            } else {
                TreeNode leftNode = curr.left;
                while(leftNode.right!=null) {
                    leftNode = leftNode.right;
                }
                leftNode.right = curr;
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }
        return -1;
    }
}
