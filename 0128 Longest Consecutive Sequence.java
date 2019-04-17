// O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }  
        int longest = 0;
        for(int num: nums){
            if(!set.contains(num-1)){
                // if num-1 not present, then we can start current streak from this num
                int current = num;
                int current_length = 1;
                
                while(set.contains(current+1)){
                    current++;
                    current_length++;
                }
                
                longest = Math.max(longest, current_length);
            }
        }
        
        return longest;
    }
}
