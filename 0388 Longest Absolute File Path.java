class Solution {
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        int[] stack = new int[paths.length];
        
        stack[0] = paths[0].length(); // root dir length // level 0 
        int maxLen = paths[0].contains(".")?stack[0]:0; //  case like "a.txt" where it's in the root
        for(int i = 1; i< paths.length; i++){
            String str = paths[i];
            int level = str.lastIndexOf("\t")+1; // number of \t i.e level
            
            //”dir\n(4-space) file.txt" mean there is a file named "(4-space)file.txt" at root directory, whose length is 12. Accordingly, "dir\n(4-space)(4-space)file.txt means there is a file names "(4-space)(4-space)file.txt" at root directory, whose length is 16. A file name starting with space is allowed.
            int currLen = 0;
            if(level == 0){
                currLen = str.length();
            } else {
                currLen = stack[level-1] + str.length() - level + 1; // level-1 beacuse we need to remove "\t", add"/"    
            }
            
            stack[level] = currLen;
            
            if(str.contains(".")) maxLen = Math.max(maxLen, currLen);
        }
        
        return maxLen;
        
    }
}