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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            res.add(level);
        }
        //question ke according 1 level : left to right , 2nd level : r to l , 3rd level : l to r , 4th level : r to left
        //if(i%2 == 1) reverse kro kyuki right to left hai // odd idx ko 
         for(int i = 1; i < res.size(); i += 2){
            Collections.reverse(res.get(i));
        }
        return res;
    }
}