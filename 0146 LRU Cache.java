// Set O(n) Get O(n)
class LRUCache {
    int capacity;
    int current;
    
    Map<Integer, Integer> map;
    Queue<Integer> queue;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        current = 0;
        map = new HashMap<Integer, Integer>();
        queue = new LinkedList<>();
        
    }
    
    public int get(int key) {
        System.out.println("Get: " + map); // method 1
        if(map.containsKey(key)){
            queue.remove(key);
            queue.add(key);
            return map.get(key);    
        } else return -1;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            // if already present, move it to the back of the queue again
            queue.remove(key);
            queue.add(key);
            map.put(key, value);
        } else{
            if(current < capacity){
                map.put(key, value);
                queue.add(key);
                current++;
            } else {
                int top = queue.remove();
                map.remove(top);
                map.put(key, value);
                queue.add(key);
            }
        }
        
        
        System.out.println("Put: " + map);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
