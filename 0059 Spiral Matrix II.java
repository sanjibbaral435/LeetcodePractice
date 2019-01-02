class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int cur_row = 0, cur_col = 0, count = 1;
        
        // direction clockwise movement
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        
        int di = 0; // first direction is east
        
        while(count <= n*n){
            matrix[cur_row][cur_col] = count;
            count++;
            
            int next_row = cur_row + dr[di];
            int next_col = cur_col + dc[di];
            
            if(next_row >=0 && next_row < n && next_col >=0 
               && next_col < n && matrix[next_row][next_col] == 0){
                //safe to go to next row and col
                cur_row = next_row;
                cur_col = next_col;
            } else {
                // not safe. so change direction
                di = (di+1)%4;
                cur_row += dr[di];
                cur_col += dc[di];
            }
        }
        return matrix;
        
    }
}