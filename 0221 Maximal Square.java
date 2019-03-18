// max[i][j] = length of the sqaure ending at i, j right corner
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        
        int[][] max = new int[row][col];
        
        int maxLength = 0;
        for(int i=0; i< row; i++){
            for(int j=0; j<col; j++){
                if(i == 0 || j == 0 ){
                    max[i][j] = Character.getNumericValue(matrix[i][j]);
                } else if(Character.getNumericValue(matrix[i][j]) == 1) {
                    max[i][j] = 1 + Math.min(max[i-1][j-1], Math.min(max[i][j-1], max[i-1][j]));
                }
                if(maxLength < max[i][j]) maxLength = max[i][j];
            }
        }
        return maxLength*maxLength;
    }
}
