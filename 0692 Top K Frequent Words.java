class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<words.length; i++){
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        
        PriorityQueue<String> minHeap = new PriorityQueue<String>(
            (w1, w2) -> map.get(w1).equals(map.get(w2)) ?
                w2.compareTo(w1) : map.get(w1) - map.get(w2));
        
        for(String s: map.keySet()){
            minHeap.offer(s);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        
        List<String> list = new ArrayList<>();
        while(!minHeap.isEmpty()){
            list.add(minHeap.poll());
        }        
        Collections.reverse(list);
        
        return list;
    }
}
