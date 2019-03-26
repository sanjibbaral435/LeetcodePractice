class Solution {
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }
    
    public boolean solveSudokuHelper(char[][] board) {
        int row = 0;
        int col = 0;
        int len = board.length;
        boolean isBlankLeft = true;
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(board[i][j] == '.'){
                    // blank space found
                    row = i;
                    col = j;
                    isBlankLeft = false;
                    break;
                }
            }
            if(!isBlankLeft) break;
        }
        
        if(isBlankLeft) return true;
        
        // try all numbers from 1..9 recursively
        for(int num=1; num<= len; num++){
            char res = Character.forDigit(num,10);
            if(isSafeMove(board, row, col, res)){
                // choose
                board[row][col] = res;
                
                //explore
                if(solveSudokuHelper(board)){
                    return true;
                }
                
                //unchoose
                else {
                    board[row][col] = '.';
                }
            }
        }
        return false;
        
    }
    
    public boolean isSafeMove(char[][] board, int row, int col, char num){
        int len = board.length;
        
        // check if row or col is violated
        for(int i=0; i<len; i++){
            if(board[row][i] == num){
                return false;
            }
            
            if(board[i][col] == num){
                return false;
            }
        }
                
        // check if current block is violated
        int sqrt = (int) Math.sqrt(board.length); 
        int boxRowStart = row - row % sqrt; 
        int boxColStart = col - col % sqrt; 

        for (int r = boxRowStart; r < boxRowStart + sqrt; r++)  
        { 
            for (int d = boxColStart; d < boxColStart + sqrt; d++)  
            { 
                if (board[r][d] == num)  
                { 
                    return false; 
                } 
            } 
        } 
        return true;
        
    }
}