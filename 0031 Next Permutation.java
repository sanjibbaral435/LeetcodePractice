class Solution {
    public void nextPermutation(int[] nums) {
        // find the first element from end which is smaller than it's next element
        int i = nums.length -2;

        while(i >=0 && nums[i+1] <= nums[i])
            i--;

        if(i >=0) {
           // find the element from end which is just larger than the num found above
            int j = nums.length - 1;
            while(j >=0 && nums[j] <= nums[i])
                j--;
            // swap these two
            swap(nums, i, j);
        }

        // then reverse from the initial num index+1 to end
        reverse(nums, i+1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
