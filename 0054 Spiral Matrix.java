class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if(matrix.length == 0) return list;
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] isDone = new boolean[row][col];
        
        int cur_row = 0, cur_col = 0, count = 0;
        
        // direction clockwise movement
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        
        int di = 0; // first direction is east
        
        while(count < col * row){
            list.add(matrix[cur_row][cur_col]);
            isDone[cur_row][cur_col] = true;
            count++;
            
            int next_row = cur_row + dr[di];
            int next_col = cur_col + dc[di];
            
            if(next_row >=0 && next_row < row && next_col >=0 
               && next_col < col && !isDone[next_row][next_col]){
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
        return list;
    }
    
}