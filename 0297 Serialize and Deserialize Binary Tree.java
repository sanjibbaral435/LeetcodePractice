/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        
        serializeUtil(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        
        List<String> str_list = new LinkedList<String>(Arrays.asList(str));
        return deserializeUtil(str_list);
    }
    
    //preorder/DFS traversal
    public void serializeUtil(TreeNode root, StringBuilder sb){
        if(root == null) sb.append("null,");
        else {
            sb.append(String.valueOf(root.val));
            sb.append(",");
            serializeUtil(root.left, sb);
            serializeUtil(root.right, sb);
        }
        return;
    }
    
    public TreeNode deserializeUtil(List<String> list) {
        if(list.get(0).equals("null")){
            list.remove(0);
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        
        root.left = deserializeUtil(list);
        root.right = deserializeUtil(list);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));