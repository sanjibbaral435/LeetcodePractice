/*
Using a hashtable that keeps track of the keys and its values in the double linked list.
it takes constant time to add and remove nodes from the head or tail in doubly linked list

We create a pseudo head and tail to mark the boundary, so that we don't need to check
the NULL node during the update. This makes the code more concise and clean, and also it is good for the performance as well.

Complexity - Set O(1) Get O(1)
*/

class DLinkedList{
    int key;
    int val;
    DLinkedList next;
    DLinkedList prev;
}

class LRUCache {
    int capacity;
    int current;

    Map<Integer, DLinkedList> map;
    DLinkedList head, tail;

    public void addNode(DLinkedList node){
        // addition is always just after the head (head is the marker pseudo node)
        node.prev = head;
        node.next = head.next;

        head.next = node;
        node.next.prev = node;
    }

    public void removeNode(DLinkedList node){
        DLinkedList pre = node.prev;
        DLinkedList post = node.next;

        pre.next = post;
        post.prev = pre;
    }

    private void moveToHead(DLinkedList node){
        // Move certain node in between to the head.
        removeNode(node);
        addNode(node);
    }
    public DLinkedList removeTail(){
        DLinkedList res = tail.prev;
        this.removeNode(res);
        return res;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        current = 0;
        map = new HashMap<Integer, DLinkedList>();
        head = new DLinkedList();
        head.prev = null;

        tail = new DLinkedList();
        tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        //System.out.println("Get: " + map); // method 1
        if(map.containsKey(key)){
            DLinkedList node = map.get(key);
            moveToHead(node);
            return node.val;
        } else return -1;

    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            // if already present, move it to the head of the list
            DLinkedList node = map.get(key);
            node.val = value;
            moveToHead(node);
        } else{
            DLinkedList node = new DLinkedList();
            node.key = key;
            node.val = value;

            if(current < capacity){
                current++;
            } else {
                DLinkedList tail = removeTail();
                map.remove(tail.key);
            }
            addNode(node);
            map.put(key, node);
        }


        //System.out.println("Put: " + map);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
