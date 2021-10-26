/*
Intuition:
Basically after one round of sequence, robot is bounded by a circle if
1. if the end position is (0,0) OR
2. if end position is not (0,0) and the end direction is not NORTH (initial direction)

If the end position is not 0,0 and dir is NORTH, then the robot will keep mvoing away
For other direction it will reach to 0,0 definitely after maximum of 3 steps

Time Complexity - O(N)
Space: O(1)

*/

class Solution {
    public boolean isRobotBounded(String instructions) {
        //N=0, E=1, S=2, W-3
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

        int x =0, y = 0; //initial position
        int idx = 0;

        for(char c : instructions.toCharArray()) {
            if(c == 'R') {
                idx = (idx+1)%4;
            } else if(c == 'L') {
                idx = (idx+3)%4; // for left, idx = (idx - 1) % 4. means negative indices. so 1L  = 3R
            } else {
                x = x+dir[idx][0];
                y = y+dir[idx][1];
            }
        }

        return (x == 0 && y == 0) || (idx != 0);
    }
}
