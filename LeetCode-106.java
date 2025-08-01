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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        int n = postorder.length - 1;
        int m = inorder.length - 1;

        TreeNode root = ctree(postorder, inorder, map, 0, n, 0, m);
        return root;
    }
    public TreeNode ctree(int[] postorder, int[] inorder, HashMap<Integer, Integer> map,
                          int postidxstart, int postidxend, int inidxstart, int inidxend) {

        if (postidxstart > postidxend || inidxstart > inidxend) return null;

        int rootdata = postorder[postidxend];
        int rootidx = map.get(rootdata);
        TreeNode root = new TreeNode(rootdata);

        int lst = rootidx - inidxstart;     
        int rst = inidxend - rootidx;  

        root.left = ctree(postorder, inorder, map, 
                          postidxstart , postidxstart + lst-1, 
                          inidxstart, rootidx - 1);

        root.right = ctree(postorder, inorder, map, 
                           postidxstart + lst, postidxstart + lst + rst-1, 
                           rootidx + 1, inidxend);

        return root;
    }
}
