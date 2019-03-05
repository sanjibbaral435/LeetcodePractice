class MaxStack {
    int max;
    Stack<Integer> stack;
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<Integer>();
        max = Integer.MIN_VALUE;
    }
    
    public void push(int x) {
        // only push the old maximum value when the current 
        // maximum value changes after pushing the new value x
        if(x >= max){
            // first push old max
            stack.push(max);
            max = x;
        }
        stack.push(x);
    }
    
    public int pop() {
        // if pop operation could result in the changing of the current maximum value, 
        // pop twice and change the current maximum value to the last maximum value.
        int val = stack.pop();
        if(val == max){
            max = stack.pop();
        }
        return val;
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return max;
    }
    
    public int popMax() {
        // Note when we are popping or pushing from original stack we are
        // using the current class methods, not stack methods
        Stack<Integer> tempStack = new Stack<Integer>();
        while(top() != max){
            tempStack.push(pop());
        }
        int val = pop();
        
        while(!tempStack.isEmpty()){
            push(tempStack.pop());
        }
        return val;
        
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
