// Using a hashmap
// Time Complexity O(n) space complexity O(n)
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = nums[0];
        for(int num : nums){
            if(map.containsKey(num)){
                int count = map.get(num);
                if(count == nums.length/2) {
                    res = num;
                    break;
                }
                map.put(num, count+1);
            } else {
                map.put(num,1);
            }
        }
        return res;
    }
}