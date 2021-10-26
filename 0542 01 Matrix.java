/*
The idea is to scan the matrix twice
once to calculate the distance from top and left
second to calculate the disatnce from bottom, right


*/

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat.length == 0) return mat;

        int row = mat.length;
        int col = mat[0].length;

        int MAX = row*col;

        int[][] dist = new int[row][col];

        // top and left pass
        for(int i=0; i< row; i++) {
            for(int j=0; j<col; j++) {
                if(mat[i][j] == 0)
                    dist[i][j] = 0;
                else {
                    int topDist = (i > 0) ? dist[i-1][j] : MAX;
                    int leftDist = (j > 0) ? dist[i][j-1] : MAX;
                    dist[i][j] = Math.min(topDist, leftDist) + 1;
                }
            }
        }

        // bottom and right pass
        for(int i=row-1; i>=0; i--) {
            for(int j=col-1; j>=0; j--) {
                if(mat[i][j] == 0)
                    dist[i][j] = 0;
                else {
                    int bottomDist = (i < row-1) ? dist[i+1][j] : MAX;
                    int rightDist = (j < col-1) ? dist[i][j+1] : MAX;
                    dist[i][j] = Math.min(Math.min(bottomDist, rightDist) + 1, dist[i][j]);
                }
            }
        }
        return dist;
    }
}
