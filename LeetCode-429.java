/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Node> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();
            ArrayList<Integer> level = new ArrayList<>();

            while(size>0) {
               Node node = que.poll();
               level.add(node.val);
               for(Node child : node.children){
                if(child!= null) que.offer(child);
               }
               size--;
            }

            res.add(level);
        }
        return res;
    }
}
