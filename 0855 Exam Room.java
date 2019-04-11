class ExamRoom {
    
    int N;
    TreeSet<Integer> set;
    
    public ExamRoom(int N) {
        this.N = N;
        set = new TreeSet<>();
    }
    
    public int seat() {
        // position of the next student to sit down.
        int index = 0;
        
        if(set.size() > 0){
            int max = set.first();
            Integer prev = null;
            for(Integer s: set){
                if(prev != null){
                    int dist = (s - prev)/2;
                    if(dist > max){
                        max = dist;
                        index = prev + max;
                    }
                }
                prev = s;                
            }
            
            if(N-1-set.last() > max){
                index = N-1;
            }
            
        }
        
        //Add the student to our sorted TreeSet of positions.
        set.add(index);
        return index;
    }
    
    public void leave(int p) {
        set.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
