class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    perimeter += getOpenSides(grid, i, j);
                }
            }    
        }
        return perimeter;
    }
    
    public int getOpenSides(int[][] grid, int i, int j){
        int count = 0;
        if(i == 0) count++;
        else if(grid[i-1][j] != 1) count++;
        
        if(i==grid.length-1) count++;
        else if(grid[i+1][j] != 1) count++;
        
        if(j == 0) count++;
        else if(grid[i][j-1] != 1) count++;
        
        if(j==grid[0].length-1) count++;
        else if(grid[i][j+1] != 1) count++;
        
        return count;
    }
}
