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
    public int maxDepth(Node root) {
        int dep =0 ;
        if(root == null) return 0;
        for(Node node : root.children){
            if(node != null){
                dep = Math.max(maxDepth(node),dep);
            }
        }
        return (1+dep);
    }
}
