/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
/*
DFS
Time Complexity:O(N+M), where N is a number of nodes (vertices) and M is a number of edges.
Space Complexity: O(N). This space is occupied by the visited hash map and in addition to that,
space would also be occupied by the recursion stack since we are adopting a recursive approach here.
The space occupied by the recursion stack would be equal to O(H) where H is the height of the graph.
Overall, the space complexity would be O(N)


bfs
Time Complexity : O(N+M), where N is a number of nodes (vertices) and M is a number of edges.

Space Complexity : O(N). This space is occupied by the visited dictionary and in addition to that,
space would also be occupied by the queue since we are adopting the BFS approach here. The space
occupied by the queue would be equal to O(W) where W is the width of the graph. Overall,
the space complexity would be O(N).
*/
class Solution {
    private HashMap<Node,Node> visited = new HashMap<>();
    public Node cloneGraphDFS(Node node) {
        if(node == null) return node;

        // If the node was already visited before.
        // Return the clone from the visited dictionary.
        if(visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a clone for the given node.
        // Note that we don't have cloned neighbors as of now, hence [].
        Node clonedNode = new Node(node.val);
        visited.put(node, clonedNode);

        // Iterate through the neighbors to generate their clones
        // and prepare a list of cloned neighbors to be added to the cloned node.
        for(Node nbr: node.neighbors) {
            clonedNode.neighbors.add(cloneGraph(nbr));
        }
        return clonedNode;

    }

    public Node cloneGraphBFS(Node node) {
        if(node == null) return node;

        HashMap<Node,Node> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        Node clonedNode = new Node(node.val, new ArrayList<>());

        visited.put(node, clonedNode);
        q.add(node);

        while(!q.isEmpty()) {
            Node n = q.remove();

            for(Node nbr: n.neighbors) {
                if(!visited.containsKey(nbr)) {
                    visited.put(nbr, new Node(nbr.val, new ArrayList<>()));
                    q.add(nbr);
                }

                visited.get(n).neighbors.add(visited.get(nbr));
            }

        }
         return visited.get(node);
    }
}
