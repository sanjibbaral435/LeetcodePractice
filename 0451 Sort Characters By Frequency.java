class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        PriorityQueue<Character> maxHeap = new PriorityQueue<Character>((n1, n2) -> map.get(n2) - map.get(n1));        
        for (char n: map.keySet()) {
            maxHeap.offer(n);
        }
        
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()){
            char c = maxHeap.poll();
            int count = map.get(c);
            while(count > 0){
                sb.append(c);
                count--;
            }
        }
        return sb.toString();
    }
}
