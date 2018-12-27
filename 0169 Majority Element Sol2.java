/*Moore’s Voting Algorithm. Basic idea of the algorithm is that if we cancel out each occurrence of an element e with all the other elements that are different from e then e will exist till end if it is a majority elemen
*/
class Solution {
    public int majorityElement(int[] nums) {
        int maj_index = 0, count = 1; 
        for (int i = 1; i < nums.length; i++) 
        { 
            if (nums[maj_index] == nums[i]) 
                count++; 
            else
                count--; 
            if (count == 0) 
            { 
                maj_index = i; 
                count = 1; 
            } 
        } 
        return nums[maj_index]; 
    }
}