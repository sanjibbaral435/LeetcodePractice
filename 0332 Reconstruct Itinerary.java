// Maintaina Map with source as the key and the destinations from that source in a PQ of strings
// Then do DFS and poll that from PQ once visited

// Time O(nLogN)
// Space O(N)
class Solution {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    LinkedList<String> res = new LinkedList<>();
    public List<String> findItinerary(String[][] tickets) {
        for(int i=0; i<tickets.length; i++){
            String start = tickets[i][0];
            if(!map.containsKey(start)){
                map.put(start, new PriorityQueue<String>());
            }
            map.get(start).offer(tickets[i][1]);
        }
        dfs("JFK");
        return res;
    }
    
    public void dfs(String start){
        PriorityQueue<String> dest = map.get(start);
        while (dest != null && !dest.isEmpty())
            dfs(dest.poll());
        res.addFirst(start);
    }
}
