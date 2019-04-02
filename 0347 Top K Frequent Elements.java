class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2));        
        // keep k top frequent elements in the heap
        for (int n: map.keySet()) {
            minHeap.add(n);
            
            if (minHeap.size() > k)
                minHeap.poll();
        }
        
            // build output list
        List<Integer> top_k = new LinkedList();
        while (!minHeap.isEmpty())
            top_k.add(minHeap.poll());
        
        Collections.reverse(top_k);
        
        return top_k;
    }
}
