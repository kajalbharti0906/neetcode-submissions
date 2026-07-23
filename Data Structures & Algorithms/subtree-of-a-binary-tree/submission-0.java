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
    public boolean isSame(TreeNode p, TreeNode q) {
        if(p==null && q==null) {
            return true;
        } else if(p==null || q==null) {
            return false;
        } 
        if(p.val != q.val) {
            return false;
        }
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(isSame(root,subRoot)) {
            return true;
        }
        boolean left = root.left!=null && isSubtree(root.left, subRoot);
        boolean right = root.right!=null && isSubtree(root.right, subRoot);
        return left || right;
    }
}
