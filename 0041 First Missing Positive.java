// First Missing Positive

// Given an unsorted integer array, find the smallest missing positive integer.

class Solution {

    /* Separate Positive and Non Positive(-ve and 0) by shifting all 
    the non-positive to the left. And return the index of first
    positive element*/
    public int separate(int[] nums){
        
        int i=0;
        int j=nums.length-1;
        while(i<j){
            if(nums[i] > 0){
                if(nums[j] < 1){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                    j--;
                } else {
                    j--;
                }
            } else {
                i++;
            }
        }
        
        for(i=0;i<nums.length;){
            if(nums[i] < 1) i++;
            else break;
        }
        return i;
    }
    
    
    /* Find the smallest positive missing number in an array that contains
       all positive integers */
    
    /*Algorithm: We traverse the array containing all positive numbers and
    to mark presence of an element x, we change the sign of value at index x
    to negative. We traverse the array again and print the first index which 
    has positive value */
    
    public int findMissingPositive(int arr[], int size)
    {
      int i;
      
      // Mark arr[i] as visited by making 
      // arr[arr[i] - 1] negative. Note that 
      // 1 is subtracted because index start 
      // from 0 and positive numbers start from 1
      for(i = 0; i < size; i++)
      {
        if(Math.abs(arr[i]) - 1 < size && arr[Math.abs(arr[i]) - 1] > 0)
          arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
      }
      
      // Return the first index value at which 
      // is positive
      for(i = 0; i < size; i++)
        if (arr[i] > 0)
          return i+1;  // 1 is added becuase indexes start from 0
      
      return size+1;
    }
    
    
    public int firstMissingPositive(int[] nums) {
        int size = nums.length;
        int index = separate(nums);
        
        int arr2[] = new int[size-index];
        int j=0;
        for(int i=index;i<size;i++){
           arr2[j] = nums[i];
           j++;
        }    
        
        return findMissingPositive(arr2, j);
    }
}