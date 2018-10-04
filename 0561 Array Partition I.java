/*
What the for loop does is essentially sort this array in O(n) time due to the property of knowing the maximum length of the array and knowing the scope of the integers in the array. Because we know both, we create an array and “sort” nums by flagging elements in exist to 1 from 0 in constant time. After the for loop is finished, exist is an array of all 0’s and a 1 for each element (+ 10000). This means that exist is now nums “sorted” in ascending order with a lot of 0’s in between the 1’s.

The second loop essentially adds the numbers together knowing that we need the minimum of the pairs. In this case, the odd/even paradigm here is used so that only the odd numbers are added as they are the minimum of the pairs.
*/

// Time Complexity O(n)
// Space complexity O(n)
public class Solution {

	public int arrayPairSum(int[] nums) {
		int[] exist = new int[20001];
		for (int i = 0; i < nums.length; i++) {
			exist[nums[i] + 10000]++;
		}
		int sum = 0;
		boolean odd = true;
		for (int i = 0; i < exist.length; i++) {
			while (exist[i] > 0) {
				if (odd) {
					sum += i - 10000;
				}
				odd = !odd;
				exist[i]--;
			}
		}
		return sum;
	}
	
}