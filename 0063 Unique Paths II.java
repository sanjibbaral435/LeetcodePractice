/*
DP Solution. Extension of 62 Unique Paths
Make First Row and Column each 1 untill we encounter the first obstacle, after that all 0
Then arr[i][j] = 0 if there is a obstacle at that location else arr[i][j] = arr[i][j-1] + arr[i-1][j] 
*/


class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] arr = new int[m][n];
        
        boolean isObstacleFound = false; 
        for(int i=0;i<m;i++){
            // first column all 1 untill we encounter the first obstacle, after that all 0
            if(isObstacleFound || obstacleGrid[i][0] == 1){
                isObstacleFound = true;
                arr[i][0] = 0;   
            } else {
                arr[i][0] = 1;
            }
        }
        
        isObstacleFound = false;
        
        for(int i=0;i<n;i++){
            // first row all 1 untill we encounter the first obstacle, after that all 0
            if(isObstacleFound || obstacleGrid[0][i] == 1){
                isObstacleFound = true;
                arr[0][i] = 0;   
            } else {
                arr[0][i] = 1;
            }
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j] == 1) arr[i][j] = 0;
                else arr[i][j] = arr[i][j-1] + arr[i-1][j];   
            }
        }
        
        return arr[m-1][n-1];
    }
}