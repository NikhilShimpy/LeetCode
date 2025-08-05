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
    public int diameterOfBinaryTree(TreeNode root) {
        int maxi[] = new int[1];
        findheight(root,maxi);
        return maxi[0];
    }
    public int findheight(TreeNode root,int maxi[]){
        if(root == null) return 0;

        int lh = findheight(root.left,maxi);
        int rh = findheight(root.right,maxi);
        maxi[0] = Math.max(maxi[0],lh+rh);
        return (1+Math.max(lh,rh)); 
    }
}
