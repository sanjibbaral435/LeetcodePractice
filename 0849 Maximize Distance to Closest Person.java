/*
So the problem is to find the maximum distance between two continuous 1 in an array, and just return half of that maximum value...(also before the first 1 and after the last 1 will be two special cases)

Time Complexity = O(n)
*/
class Solution {
    public int maxDistToClosest(int[] seats) {
        int left = -1;
        int max = 0;
        
        int len = seats.length;
        
        for(int i=0; i<len; i++){
            if(seats[i] == 0) continue;
            
            if(left == -1){
                // case where there are initial zeros in the beginning
                max = Math.max(max, i);
            } else {
                // left is the recent left 1 and here i is the current 1 position.
                // so we caluclate the diff/2 and compare with current max
                max = Math.max(max, (i-left)/2);
            }
            // this only gets updated once we meet an 1. 
            left = i;
        }
        
        if(seats[len-1] == 0){
            // case where there are zeros in the end
            max = Math.max(max, len-1-left);
        }
        
        return max;
    }
}
