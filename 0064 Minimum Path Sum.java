/*
DP Solution. Extension of 62 Unique Paths
Make First Row and Column added to its previous cost
Then arr[i][j] = Min of upper cell and left cell
*/

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] arr = new int[m][n];
        arr[0][0] = grid[0][0];
        
        for(int i=1;i<m;i++){
            // first column all added with its top cell value
            arr[i][0] = arr[i-1][0] + grid[i][0];
        }

        for(int i=1;i<n;i++){
            // first row all added with its top cell value
            arr[0][i] = arr[0][i-1] + grid[0][i];
        }        
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                arr[i][j] = Math.min(arr[i][j-1] + grid[i][j], arr[i-1][j] + grid[i][j]);
            }
        }
        return arr[m-1][n-1];        
    }
}