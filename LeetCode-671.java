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
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        return dfs(root, root.val);
    }
    
    private int dfs(TreeNode node, int minval) {
        if (node == null) return -1;
        
        if (node.val > minval) return node.val;
        
        int l = dfs(node.left, minval);
        int r = dfs(node.right, minval);
        
        if (l == -1) return r;
        if (r == -1) return l;
        return Math.min(l, r);
    }
}
