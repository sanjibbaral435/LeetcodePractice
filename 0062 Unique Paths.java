/*
DP Solution
Make First Row and Column each 1
Then arr[i][j] = arr[i][j-1] + arr[i-1][j] 
*/


class Solution {
    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        for(int i=0;i<m;i++){
            // first column all 1
            arr[i][0] = 1;   
        }
        
        for(int i=0;i<n;i++){
            // first row all 1
            arr[0][i] = 1;   
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                arr[i][j] = arr[i][j-1] + arr[i-1][j];   
            }
        }
        
        return arr[m-1][n-1];
    }
}