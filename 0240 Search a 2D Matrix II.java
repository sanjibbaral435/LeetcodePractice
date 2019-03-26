// Time Complexity O(NlogN)
class Solution {
    private int[][] matrix;
    private int target;
    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        this.target = target;
        
        // an empty matrix obviously does not contain `target`
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        return searchMatrixRecur(0, matrix[0].length - 1, 0, matrix.length - 1);
    }
    
    public boolean searchMatrixRecur(int left, int right, int up, int down) {
        if(left > right || up > down) 
            return false;
        
        else if(matrix[up][left] > target || matrix[down][right] < target)
            return false;
        
        int mid = left + (right-left)/2;
        int row = up;
        
        // Locate `row` such that matrix[row-1][mid] < target < matrix[row][mid]
        while(row <= down && target >= matrix[row][mid]){
            if(target == matrix[row][mid]) return true;
            row++;
        }
        // recursively search bottom-left and top-right submatrices
        return searchMatrixRecur(left, mid-1, row, down) || searchMatrixRecur(mid+1, right, up, row-1);
    }
}