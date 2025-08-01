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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        int n = preorder.length - 1;
        int m = inorder.length - 1;

        TreeNode root = ctree(preorder, inorder, map, 0, n, 0, m);
        return root;
    }

    public TreeNode ctree(int[] preorder, int[] inorder, HashMap<Integer, Integer> map,
                          int pidxstart, int pidxend, int inidxstart, int inidxend) {

        if (pidxstart > pidxend || inidxstart > inidxend) return null;

        int rootdata = preorder[pidxstart];
        int rootidx = map.get(rootdata);
        TreeNode root = new TreeNode(rootdata);

        int lst = rootidx - inidxstart;     
        int rst = inidxend - rootidx;  

        root.left = ctree(preorder, inorder, map, 
                          pidxstart + 1, pidxstart + lst, 
                          inidxstart, rootidx - 1);

        root.right = ctree(preorder, inorder, map, 
                           pidxstart + lst + 1, pidxstart + lst + rst, 
                           rootidx + 1, inidxend);

        return root;
    }
}
