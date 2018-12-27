class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        if(row == 0) return;
        int col = matrix[0].length;
        if(col == 0) return;
		
		
        // mark the rows and cols which have at least one zero element
        List<Integer> zeroRow = new ArrayList<Integer>();
        List<Integer> zeroCol = new ArrayList<Integer>();
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j] == 0) {
                    zeroRow.add(i);
                    zeroCol.add(j);
                }
            }    
        }
        
        // Iterate over the array and using the rows and cols sets, update the elements.
        for (int i = 0; i < row; i++) {
          for (int j = 0; j < col; j++) {
            if (zeroRow.contains(i) || zeroCol.contains(j)) {
              matrix[i][j] = 0;
            }
          }
        }
    }
}