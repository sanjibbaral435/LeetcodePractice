// Maintain 3 sets and keep adding charcter to respective sets

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i<9; i++){
            Set<Character> row = new HashSet<Character>();
            Set<Character> col = new HashSet<Character>();
            Set<Character> box = new HashSet<Character>();

            for(int j = 0; j<9; j++){
                if(board[i][j] != '.' && !row.add(board[i][j]))
                    return false;
                if(board[j][i] != '.' && !col.add(board[j][i]))
                    return false;
                
                int rowIndex = 3*(i/3);
                int colIndex = 3*(i%3);
                if(board[rowIndex+j/3][colIndex+j%3] != '.' && !box.add(board[rowIndex+j/3][colIndex+j%3]))
                    return false;
            }   
        }
        return true;
    }
}