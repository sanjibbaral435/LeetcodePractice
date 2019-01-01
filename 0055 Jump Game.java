// Start from the backend. Check if this last position can be reached from any of the previous elements.
// Once we find a index from where we can reach that end, we update the lat position. Now our target is to find an index less than that to reach till that
// like that we come till we get to index 0. 
class Solution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}