class Solution {

    public int getFood(char[][] grid) {
        if(grid.length == 0)
            return 0;

        int row = grid.length;
        int col = grid[0].length;

        boolean[][] dp = new boolean[row][col];

        int[] xRows = new int[]{0,1,0,-1};
        int[] yRows = new int[]{1,0,-1,0};

        Queue<int[]> q = new LinkedList<>();
	    q.add(findStart(grid));
        int step = 0;

        while(!q.isEmpty()) {
            // do a BFS from the queue elements
            int len = q.size();
            for(int i=0; i<len; i++) {
                int[] item = q.poll();

                int x = item[0];
                int y = item[1];

                if(grid[x][y] == '#') return step;

                for(int j=0; j<4; j++) {
                    // traverse in all directions
                    int xInd = x + xRows[j];
                    int yInd = y + yRows[j];
                    if(isValid(grid, xInd, yInd) && !dp[xInd][yInd]) {
                        dp[xInd][yInd] = true;
                        q.offer(new int[]{xInd, yInd});
                    }

                }

            }
            step++; // in each bfs level increase step 1, that's the distance we cover in each round
        }
        return -1;
    }

    private int[] findStart(char[][] grid){
        for(int i=0; i < grid.length; i++){
            for(int j=0; j < grid[0].length; j++){
                if(grid[i][j] == '*'){
                    return new int[]{i, j};
                }
            }
        }
        throw new RuntimeException();
    }

    private boolean isValid(char[][] grid, int i, int j){
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] != 'X';
    }
}
