class Solution {
    public int[] sortedSquares(int[] A) {
        int len = A.length;

        int high = 0;
        // Find first non-negative position
        while(high < len && A[high] < 0)
            high++;
        
        int low = high-1;
        
        int[] res = new int[len];
        int index = 0;
        
        while(low >= 0 && high < len){
            if(-A[low] < A[high]){
                res[index++] = A[low]*A[low];
                low--;
            } else {
                res[index++] = A[high]*A[high];
                high++;
            }
            
        }
        
        if(low >= 0){
            while(index < len){
                res[index++] = A[low]*A[low];
                low--;
            }
        } else if(high < len){
            while(index < len){
                res[index++] = A[high]*A[high];
                high++;
            }
            
        }
        return res;
        
    }
    
}
