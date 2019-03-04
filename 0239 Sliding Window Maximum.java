class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if(len == 0 || len < k) return new int[0];
        int left = 0, right=0;
        int[] res = new int[len-k+1];
        
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a; 
            }
        }); 
        
        
        while(right < nums.length){
            if(right-left + 1 < k){
                maxHeap.add(nums[right]);
            } else{
                maxHeap.add(nums[right]);
                int max = maxHeap.peek();
                maxHeap.remove(nums[left]);
                res[left++] = max; 
            }
            right++;
        }
        return res;
    }
}
