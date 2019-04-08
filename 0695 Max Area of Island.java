// The idea is to count the area of each island using dfs. 
// During the dfs, we set the value of each point in the island to 0. 
// The time complexity is O(mn).


class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int row = grid.length;
        int col = grid[0].length;
        
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j] == 1)
                    max = Math.max(max, AreaOfIslandDFS(grid, i, j));
            }
        }
        return max;
    }
    
    public int AreaOfIslandDFS(int[][] grid, int i, int j){
        if( i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
            grid[i][j] = 0;
            return 1 + 
                AreaOfIslandDFS(grid, i+1, j) + 
                AreaOfIslandDFS(grid, i-1, j) + 
                AreaOfIslandDFS(grid, i, j-1) + 
                AreaOfIslandDFS(grid, i, j+1);
        }
        return 0;
    }
}
