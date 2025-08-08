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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, "", res);
        return res;
    }
    
    private void dfs(TreeNode node, String path, List<String> res) {
        if (node == null) return;

        if (path.length() == 0) {
            path += node.val;
        } else {
            path += "->" + node.val;
        }
        
        if (node.left == null && node.right == null) {
            res.add(path);
            return;
        }
        dfs(node.left, path, res);
        dfs(node.right, path, res);
    }
}
