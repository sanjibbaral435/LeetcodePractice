/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Iterator poll = null;
    int index;
    Stack<NestedInteger> stack;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<NestedInteger>();
        
        // put all elements into stack starting from the end
        for(int i=nestedList.size()-1; i>=0; i--){
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if(hasNext()) return stack.pop().getInteger();
        else return null;
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()){
            NestedInteger top = stack.peek();
            if(top.isInteger()) return true;
            
            // remove the top as we will flatten it and put into stack again
            stack.pop();
                // flatten the top elements into stack starting from the end
            for(int i=top.getList().size()-1; i>=0; i--){
                stack.push(top.getList().get(i));
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */