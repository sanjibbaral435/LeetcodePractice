// Without Using in-built java Iterator
public class ZigzagIterator {
    int index;
    
    boolean isV1;
    
    List<Integer> v1;
    List<Integer> v2;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        index = 0;
        isV1 = true;
        this.v1 = new LinkedList<Integer>();
        this.v2 = new LinkedList<Integer>();
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        // v1 list
        int res = Integer.MAX_VALUE;
        if(isV1 && index < v1.size()){
            res = v1.get(index);
            if(index < v2.size()){
                // go to v2 with same index
                isV1 = false;
            }else {
                index++;
            }
        } else {
            //v2 list
            res = v2.get(index);
            if(index < v1.size()){
                // go to v2 with same index
                isV1 = true;
            }
            index++;
            
        }
        return res;
    }

    public boolean hasNext() {
        return (index < v1.size() || index < v2.size());
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */