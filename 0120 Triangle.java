//https://leetcode.com/problems/triangle/discuss/38730/DP-Solution-for-Triangle
// DP Bottom Up Approach with O(n) space since for each row we are using same index
// Follow the explanation on the above link.

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] sum = new int[row];
        
        // first populate with the last row values
        for(int i=0;i<row;i++) sum[i] = triangle.get(row-1).get(i);
        
        for (int i = row-2; i >= 0; i--) {
            for(int j=0;j<=i;j++){
                sum[j] = Math.min(sum[j], sum[j+1]) + triangle.get(i).get(j);
            }
        }
        return sum[0];
    }
}