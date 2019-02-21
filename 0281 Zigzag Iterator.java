// Using in-built java Iterator
public class ZigzagIterator {
    LinkedList<Iterator> list;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<Iterator>();
        if(!v1.isEmpty()) list.add(v1.iterator());
        if(!v2.isEmpty()) list.add(v2.iterator());
    }

    public int next() {
        //get current iterator and remove it
        Iterator poll = list.remove();
        int result = (Integer)poll.next();
        
        //add to the list again if iterator still has elements
        if(poll.hasNext()) list.add(poll);
        return result;
    }

    public boolean hasNext() {
        // when iteration is done, both iterators would have been removed from list
        return (!list.isEmpty());
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */