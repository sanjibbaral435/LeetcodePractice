class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i=0; i<A.length; i++){
            int low = 0;
            int high = A[0].length-1;
            while(low < high){
                int temp = A[i][high];
                A[i][high] = 1 - A[i][low];
                A[i][low] = 1 - temp;
                low++;
                high--;
            }
            if(low == high){
                A[i][low] = 1 - A[i][low];
            }
        }
        return A;
    }
}
