class MovingAverage {
    Queue<Integer> queue;
    int size;
    double sum = 0.0;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }
    
    public double next(int val) {
        if(queue.size() == size){
            sum -= queue.remove();
        }
        queue.add(val);
        sum += val;
        return sum/queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */