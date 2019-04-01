class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create a array to store indegrees of all 
        // vertices. Initialize all indegrees as 0. 
        int indegree[] = new int[numCourses];
        
        //create the adjancency list from the edges
        List<Integer> adj[] = new ArrayList[numCourses]; 
        
        // Traverse prerequisites lists to fill indegrees of 
        // vertices. This step takes O(V+E) time         
        for(int i = 0; i < prerequisites.length; i++) 
        {
            int src = prerequisites[i][1];
            int dst = prerequisites[i][0];
            
            if(adj[src] == null)
                adj[src]=new ArrayList<Integer>();
            
            adj[src].add(dst); 
            indegree[dst]++; 
        }
        
        // Create a queue and enqueue all vertices with 
        // indegree 0 
        Queue<Integer> q = new LinkedList<Integer>(); 
        for(int i = 0; i < numCourses; i++) 
        { 
            if(indegree[i]==0) 
                q.add(i); 
        }
        
        if(q.size() < 1) {
            return new int[0];
        }
        
        // Initialize count of visited vertices 
        int cnt = 0; 
          
        // Create a vector to store result (A topological 
        // ordering of the vertices) 
        List<Integer> topOrder=new LinkedList<Integer>(); 
        while(!q.isEmpty()) 
        { 
            // Extract front of queue (or perform dequeue) 
            // and add it to topological order 
            int u=q.poll(); 
            topOrder.add(u); 
              
            // Iterate through all its neighbouring nodes 
            // of dequeued node u and decrease their in-degree 
            // by 1 
            List<Integer> list = adj[u];
            cnt++; 
            if(list == null) continue;
            for(int i=0; i<list.size();i++) 
            {
                int node = list.get(i);
                // If in-degree becomes zero, add it to queue 
                if(--indegree[node] == 0) 
                    q.add(node); 
            } 
            
        }
        
        // Check if there was a cycle         
        if(cnt != numCourses) 
        { 
            return new int[0]; 
        }
        int[] res = new int[numCourses];
        int count = 0;
        // get topological order             
        for(int i : topOrder) 
        { 
            res[count++] = i;
        }
        return res;
    }
}
