/*
Maintain 2 Priority Queues 
    A max-heap lo to store the smaller half of the numbers
    A min-heap hi to store the larger half of the numbers


Adding a number num:

    Add num to max-heap lo. Since lo received a new element, we must do a balancing step for hi. So remove the largest element from lo     and offer it to hi.
    The min-heap hi might end holding more elements than the max-heap lo, after the previous operation. We fix that by removing the       smallest element from hi and offering it to lo.
*/
class MedianFinder {
    PriorityQueue<Integer> hi;
    PriorityQueue<Integer> lo;
    /** initialize your data structure here. */
    public MedianFinder() {
        // min heap
        hi = new PriorityQueue<>();
        
        // max heap
        lo = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return b-a;
            } 
        });
    }
    
    public void addNum(int num) {
        lo.add(num);
        
        hi.add(lo.poll());
        
        if(lo.size() < hi.size()){
            lo.add(hi.poll());
        }
    }
    
    public double findMedian() {
        return lo.size() > hi.size() ? (double) lo.peek() : (lo.peek() + hi.peek()) * 0.5;
    }
    
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */