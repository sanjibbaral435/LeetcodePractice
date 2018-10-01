class Solution {
    public int lengthOfLongestSubstring(String str) {
        int n = str.length(); 
        if(n < 1) return 0;
        int cur_len = 1;    // length of current substring 
        int max_len = 1;    // result 
        Integer prev_index;        //  previous index 
        int i; 
        Map<Character, Integer> map = new HashMap<>();

        /* Mark first character*/
        map.put(str.charAt(0), 0);
          
        /* Start from the second character */
        for(i = 1; i < n; i++) 
        { 
            prev_index = map.get(str.charAt(i)); 
              
            /* If the current char is not present in the already processed substring or it is not 
              part of the current NRCS, then do cur_len++ */
            if(prev_index == null || i - cur_len > prev_index) 
                cur_len++; 
              
            /* If the current character is present in currently considered NRCS, then update NRCS to start from 
               the next character of previous instance. */
            else
            { 
                /* when changing the NRCS, we should also check whether length of the 
                   previous NRCS was greater than max_len or not.*/
                if(cur_len > max_len) 
                    max_len = cur_len; 
                  
                cur_len = i - prev_index; 
            } 
            
            // update the index of current character 
            map.put(str.charAt(i), i); 
        } 
          
        // Compare the length of last NRCS with max_len and 
        // update max_len if needed 
        if(cur_len > max_len) 
            max_len = cur_len; 
          
        return max_len; 
    }
}