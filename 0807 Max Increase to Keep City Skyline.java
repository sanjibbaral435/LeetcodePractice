class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int rowNum = grid.length;
        int colNum = grid[0].length;
        
        int[] rowMax = new int[rowNum];
        int[] colMax = new int[colNum];
        
        // Find max for each row and col
        for(int i = 0; i<rowNum; i++){
            for(int j = 0; j<colNum; j++){
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);

            }
        }
        
        int ans = 0;
        // Find the max increase for each building
        for(int i = 0; i<rowNum; i++){
            for(int j = 0; j<colNum; j++){
                ans = ans + Math.min(rowMax[i], colMax[j]) - grid[i][j];
            }
        }        
        return ans;
    }
}
