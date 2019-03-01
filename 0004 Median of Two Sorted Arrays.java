/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Solution
 * Take minimum size of two array. Possible number of partitions are from 0 to m in m size array.
 * Try every cut in binary search way. When you cut first array at i then you cut second array at (m + n + 1)/2 - i
 * Now try to find the i where a[i-1] <= b[j] and b[j-1] <= a[i]. So this i is partition around which lies the median.
 *
 * Time complexity is O(log(min(x,y))
 * Space complexity is O(1)
 * https://www.youtube.com/watch?v=LPFhl65R7ww
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        //if input1 length is greater than switch them so that input1 is smaller than input2.
        if(len1 > len2) return findMedianSortedArrays(nums2, nums1);
        
        int low = 0;
        int high = len1;
        
        while(low <= high){
            int partitionX = (low + high)/2;
            int partitionY = (len1+len2+1)/2 - partitionX;
            
            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == len1) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == len2) ? Integer.MAX_VALUE : nums2[partitionY];
            
            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                // We are at the right partition
                // Now get max of left elements and min of right elements to get the 
                // median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((len1 + len2) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    // if odd number of elements, then left will have one extra element
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            }else if(maxLeftX > minRightY){
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        return Double.MIN_VALUE;
    }
}
