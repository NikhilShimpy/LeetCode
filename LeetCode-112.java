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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        return find(root,targetSum,sum);
    }
    public boolean find(TreeNode root, int targetsum , int sum){
        if(root== null) return false;
        if(root.left == null && root.right == null){
            sum += root.val;
            if(sum == targetsum) return true;
        }
        return find(root.left, targetsum, sum + root.val) || find(root.right, targetsum, sum + root.val);
    }
}
