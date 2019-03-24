class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(int i = 0; i<words.length; i++){
            if(set.add(words[i]) && exist(board, words[i])) res.add(words[i]);
        }
        return res;
    }
    
    public boolean exist(char[][] board, String word) {
        int[] rowX = {0, 0, 1, -1};
        int[] colX = {1, -1, 0, 0};
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(word.charAt(0) == board[i][j]){
                    if(existHelper(board, word, i, j, 0, rowX, colX))
                        return true;
                }            
            }    
        }
        return false;
    }
    
    public boolean existHelper(char[][] board, String word, int curRow, int curCol, int index, int[] rowX, int[] colX) {
        //System.out.println("Index: " + index + " Row: " + curRow + " Col: " + curCol);
        // check if word has been searched cmpletely
        if(index == word.length()) return true;
        
        // check if boundaries reached
        if(curRow <0 || curCol <0 | curRow == board.length || curCol == board[curRow].length) return false;
        
        if(board[curRow][curCol] != word.charAt(index)) return false;
        
        // the current char matches. Hence make that invalid for further recusrion
        char temp = board[curRow][curCol];
        board[curRow][curCol] = '-';
        boolean res = false;
        
        for(int i=0; i<rowX.length; i++){
            res = res || existHelper(board, word, curRow + rowX[i], curCol + colX[i], index+1, rowX, colX);
        }
        board[curRow][curCol] = temp;
        return res;
    }
}