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
}
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        help(root, res);
        return res;
    }
    private void help(Node node, List<Integer> res) {
        if (node == null) return;

        if (node.children != null) {
            for (Node child : node.children) {
                help(child, res);
            }
        }
        res.add(node.val);
    }
}


