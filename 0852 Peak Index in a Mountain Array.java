class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int start = 0;
        int end = A.length-1;
        
        return search(A, start, end);
    }
    
    public int search(int[] A, int start, int end){
        int mid = (start + end)/2;
        if(A[mid] > A[mid+1] && A[mid] > A[mid-1])
            return mid;
        else if(A[mid] < A[mid+1]){
            return search(A, mid+1, end);
        }
        else return search(A, start, mid-1);
    }
}