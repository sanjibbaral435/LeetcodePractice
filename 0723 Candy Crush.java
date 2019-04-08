class Solution {
    public int[][] candyCrush(int[][] board) {
        int R = board.length, C = board[0].length;
        boolean todo = false;
        
        // Mark all to be crushed in col
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c + 2 < C; ++c) {
                int v = Math.abs(board[r][c]);
                if (v != 0 && v == Math.abs(board[r][c+1]) && v == Math.abs(board[r][c+2])) {
                    board[r][c] = board[r][c+1] = board[r][c+2] = -v;
                    todo = true;
                }
            }
        }
        
        // Mark all to be crushed in row
        for (int r = 0; r + 2 < R; ++r) {
            for (int c = 0; c < C; ++c) {
                int v = Math.abs(board[r][c]);
                if (v != 0 && v == Math.abs(board[r+1][c]) && v == Math.abs(board[r+2][c])) {
                    board[r][c] = board[r+1][c] = board[r+2][c] = -v;
                    todo = true;
                }
            }
        }

        // gravity
        for(int c=0; c<C; c++){
            int writeHead = R-1;
            for(int readHead = R-1; readHead >=0 ; readHead--){
                if(board[readHead][c] > 0){
                    board[writeHead--][c] = board[readHead][c];
                }
            }
            
            // empty the remainng cells as it has been graviated to all blank cells towards down
            while(writeHead>=0)
                board[writeHead--][c] = 0;
        }
        
        
        return todo? candyCrush(board): board;
    }
}
