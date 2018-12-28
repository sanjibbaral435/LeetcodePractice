/*Moore’s Voting Algorithm. Basic idea of the algorithm is that if we cancel out each occurrence of an element e with all the other elements that are different from e then e will exist till end if it is a majority elemen
*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
	
        if (nums == null || nums.length == 0)
		    return result;
	    
        int number1 = nums[0], number2 = nums[0], count1 = 0, count2 = 0, len = nums.length;
        
        // Find the top 2 number with high frequency
        for (int i = 0; i < len; i++) {
            if (nums[i] == number1)
                count1++;
            else if (nums[i] == number2)
                count2++;
            else if (count1 == 0) {
                number1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                number2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        // Find the exact count of the top 2 numbers
        for (int i = 0; i < len; i++) {
            if (nums[i] == number1)
                count1++;
            else if (nums[i] == number2)
                count2++;
        }
        
        //check if these counts are more than 1/3
        if (count1 > len / 3)
            result.add(number1);
        if (count2 > len / 3)
            result.add(number2);
        return result;
	
    }
}