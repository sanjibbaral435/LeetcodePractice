/*
https://www.geeksforgeeks.org/edit-distance-dp-5/
DP. The subproblems are
1. If last characters of two strings are same, nothing much to do. Ignore last characters and get count for remaining strings. So we recur for lengths m-1 and n-1.
2. Else (If last characters are not same), we consider all operations on ‘str1’, consider all three operations on last character of first string, recursively compute minimum cost for all three operations and take minimum of three values.
        Insert: Recur for m and n-1
        Remove: Recur for m-1 and n
        Replace: Recur for m-1 and n-1

So we can maintain a table of all these operations.

Time Complexity O(mxn)
*/ 
class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        
        // dist[m][n] = edit distance between two strings of size m and n
        int[][] dist = new int[len1+1][len2+1];
        
        dist[0][0] = 0;
        
        // for str1 of 0 length, operations needed will be only insertions of the length of the str2 and vice versa
        for(int i=1; i<=len1; i++){
            dist[i][0] = i;
        }
        
        for(int i=1; i<=len2; i++){
            dist[0][i] = i;
        }
        
        for(int i=1; i<=len1; i++){
            for(int j=1; j<=len2; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dist[i][j] = dist[i-1][j-1]; // both char are same, so no operations
                else
                    // else 1 + min of (the 3 previous entries (i-1, j-1)(i, j-1), (i-1, j))
                    dist[i][j] = 1 + Math.min(dist[i-1][j-1], Math.min(dist[i-1][j], dist[i][j-1]));
            }

        }
        return dist[len1][len2];
    }
}
