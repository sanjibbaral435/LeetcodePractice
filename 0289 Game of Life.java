// For the current round
// if a live cell is dead in next round mark it as  -1
// if a dead cell is live in next round mark it as 2 (any other number than 0, 1, -1)

class Solution {
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                int lives = getLiveCount(board, i, j);
                
                if(board[i][j] == 0){
                    // cond 4
                    if(lives == 3) board[i][j] = 2;
                } else {
                    // cond 1 and 3
                    if(lives < 2 || lives > 3) board[i][j] = -1;
                }
            }    
        }
        
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(board[i][j] == -1) board[i][j] = 0;
                else if(board[i][j] > 1) board[i][j] = 1;
            }    
        }
    }
    
    public int getLiveCount(int[][] board, int row, int col){
        int[] xRow = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] xCol = {-1, 0, 1, 1, 1, 0, -1, -1};
        
        int liveCount = 0;
        for(int i = 0; i<8; i++){
            int cur_row = row + xRow[i];
            int cur_col = col + xCol[i];
            
            if(cur_row > -1 && cur_row < board.length && cur_col > -1 && cur_col < board[0].length){
                if(Math.abs(board[cur_row][cur_col]) == 1){
                    liveCount++;
                }
            }
        }
        return liveCount;
    }
}
