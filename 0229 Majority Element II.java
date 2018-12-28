// Using a hashmap
// Time Complexity O(n) space complexity O(n)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return res;
        else if(nums.length == 1) {
            res.add(nums[0]);
        } else if(nums.length == 2){
            res.add(nums[0]);
            if(nums[0] != nums[1]) res.add(nums[1]);
        } else {
            for(int num : nums){
                if(map.containsKey(num)){
                    int count = map.get(num);
                    if(count == nums.length/3) {
                        if(!res.contains(num)) res.add(num);
                    }
                    map.put(num, count+1);
                } else {
                    map.put(num,1);
                }
            }       
        }
        return res;
    }
}