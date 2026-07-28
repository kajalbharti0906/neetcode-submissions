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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder str = new StringBuilder();
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                if(node == null) {
                    str.append("N,");
                } else {
                    str.append(node.val).append(",");
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        if(vals[0].equals("N"))
            return null;
            TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int index = 1;
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if(!vals[index].equals("N")) {
                    node.left = new TreeNode(Integer.parseInt(vals[index]));
                    queue.add(node.left);
                }
                index++;
                if(!vals[index].equals("N")) {
                    node.right = new TreeNode(Integer.parseInt(vals[index]));
                    queue.add(node.right);
                }
                index++;
            }
            return root;
    }
}
