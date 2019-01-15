class MinStack {
    
    public class MyDS{
        int val;
        int min;
        public MyDS(int i, int j) {
            val = i;
            min = j;
        }
        
        public int getMin() {
            return min;
        }
        
        public int getVal() {
            return val;
        }
    }
    
    Stack<MyDS> stack; 

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<MyDS>(); 
    }
    
    public void push(int x) {
        if(stack.isEmpty()){
            MyDS obj = new MyDS(x, x);
            stack.push(obj);
        } else {
            int min = Math.min(stack.peek().getMin(), x);
            MyDS obj = new MyDS(x, min);
            stack.push(obj);
        }    
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().getVal();
    }
    
    public int getMin() {
        return stack.peek().getMin();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */