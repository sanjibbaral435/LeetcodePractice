/*

1. Since players take turns, the number of 'X's must be equal to or one greater than the number of 'O's.
2. A player that wins has to win on the move that they make:
        If the first player wins, the number of 'X's is one more than the number of 'O's
        If the second player wins, the number of 'X's is equal to the number of 'O's.
3. The board can't simultaneously have three 'X's and three 'O's in a row: once one player has won (on their move), there are no subsequent moves.


*/

class Solution {
    public boolean validTicTacToe(String[] board) {
        int xCount = 0, oCount = 0;
        for (String row: board)
            for (char c: row.toCharArray()) {
                if (c == 'X') xCount++;
                if (c == 'O') oCount++;
            }

        if (oCount != xCount && oCount != xCount - 1) return false;
        if (win(board, 'X') && oCount != xCount - 1) return false;
        if (win(board, 'O') && oCount != xCount) return false;
        return true;
    }

    public boolean win(String[] B, char P) {
        // B: board, P: player
        for (int i = 0; i < 3; ++i) {
            if (P == B[0].charAt(i) && P == B[1].charAt(i) && P == B[2].charAt(i))
                return true;
            if (P == B[i].charAt(0) && P == B[i].charAt(1) && P == B[i].charAt(2))
                return true;
        }
        if (P == B[0].charAt(0) && P == B[1].charAt(1) && P == B[2].charAt(2))
            return true;
        if (P == B[0].charAt(2) && P == B[1].charAt(1) && P == B[2].charAt(0))
            return true;
        return false;
    }
}