/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelOrderUtil(root, res, 0);
        return res;
    }
    
    public void levelOrderUtil(Node root, List<List<Integer>> res, int level) {
        if(root == null) return;
        
        if(res.size() == level)
            res.add(new ArrayList<Integer>());
        
        res.get(level).add(root.val);
        
        for(int i = 0; i<root.children.size(); i++){
            levelOrderUtil(root.children.get(i), res, level+1);            
        }    
    }
}
