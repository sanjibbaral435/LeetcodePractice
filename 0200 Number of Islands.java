// Using DFS
// Scan hrizontally. whenever found 1, increment res and recursively make all horizontal and vertically connected 1s to zero
// Time O(MN)
// Space O(MN)
class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        if(rows == 0) return 0;
        int cols = grid[0].length;
        
        int res = 0;
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == '1'){
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }
    
    public void dfs(char[][] grid, int row, int col){
        if(row < 0 || row >= grid.length
          || col < 0 || col >= grid[0].length
          || grid[row][col] == '0')
            return;
        
        // current cell is 1, Make it 0 and do the same recursively in 4 directions
        grid[row][col] = '0';
        dfs(grid, row-1, col); // up
        dfs(grid, row+1, col); // down
        dfs(grid, row, col+1); // right
        dfs(grid, row, col-1); // left
    }
}
