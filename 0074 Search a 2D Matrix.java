class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = -1; int col = -1;
        
        int rSize = matrix.length;
        if(rSize == 0) return false;
        int cSize = matrix[0].length;
        if(cSize == 0) return false;
        
        int low = 0; int high = rSize*cSize-1;
        
        //consider its one sorted array
        
        int mid,rMid,cMid,midValue;
        while (low <= high){
            mid = (low + high) / 2;
            rMid = mid / cSize;
            cMid = mid % cSize;
            midValue = matrix[rMid][cMid];
            if (midValue == target){
                return true;
            } else if (midValue < target){
                low = mid+1;
            } else if (midValue > target){
                high = mid-1;
            }
        }
        return false;
    }
}