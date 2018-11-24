/*
The intuition behind this approach is that the area formed between the lines will always be limited by the height of the shorter line. Further, the farther the lines, the more will be the area obtained.

We take two pointers, one at the beginning and one at the end of the array constituting the length of the lines. Futher, we maintain a variable maxareamaxarea to store the maximum area obtained till now. At every step, we find out the area formed between them, update maxareamaxarea and move the pointer pointing to the shorter line towards the other end by one step.

*/

class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j = height.length -1;
        int maxArea = 0;
        while(i<j){
            int area = 0;
            if(height[i] < height[j]){
                area = (j-i)*height[i];
                i++;
            } else {
                area = (j-i)*height[j];
                j--;
            }
            if(area > maxArea) maxArea = area;
        }
        return maxArea;
    }
}