/*
Complexity Analysis

Let N be the number of logs in the list and M be the maximum length of a single log.


Time Complexity: O(M.N.logN)

First of all, the time complexity of the Arrays.sort() is O(N.logN), as stated in the API specification,
which is to say that the compare() function would be invoked O(N.logN) times.

For each invocation of the compare() function, it could take up to O(M) time, since we compare the contents of the logs.

Therefore, the overall time complexity of the algorithm is O(M.N.logN).



Space Complexity: O(M.logN)

For each invocation of the compare() function, we would need up to O(M) space to hold the parsed logs.

In addition, since the implementation of Arrays.sort() is based on quicksort algorithm whose space complexity is O(logN),
assuming that the space for each element is O(1). Since each log could be of O(M) space, we would need O(M⋅logN) space
to hold the intermediate values for sorting.

In total, the overall space complexity of the algorithm is O(M+M⋅logN)=O(M⋅logN).

*/

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                //Split each log into <Id, content>
                String[] split1 = log1.split(" ", 2); // split into only 2 parts with first space
                String[] split2 = log2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

                // case1: both logs are letters
                if(!isDigit1 && !isDigit2) {
                    //compare the contents
                    int comp = split1[1].compareTo(split2[1]);

                    // if contents are different, sort contents lexicographically
                    if(comp != 0) {
                        return comp;
                    }
                    // if contents are same, sort identifiers lexicographically
                    return split1[0].compareTo(split2[0]);
                }

                // case2: one is letter and one is num
                if(!isDigit1 && isDigit2) {
                    // first log is letter and comes before
                    return -1;
                } else if (isDigit1 && !isDigit2) {
                    // first one is num, hence comes after
                    return 1;
                } else {
                    // case3: both nums
                    return 0;
                }

            }
        };

        Arrays.sort(logs, myComp);
        return logs;
    }
}
