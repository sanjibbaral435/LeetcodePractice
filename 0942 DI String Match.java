class Solution {
    public int[] diStringMatch(String S) {
        int len = S.length();
        
        int low = 0;
        int high = len;
        
        int[] arr = new int[len+1];
        int index = 0;
        int i=0;
        for(;i<len; i++){
            if(S.charAt(i) == 'I'){
                arr[index] = low;
                low++;
                index++;
            } else {
                arr[index] = high;
                high--;
                index++;
            }
        }
        if(S.charAt(i-1) == 'I'){
                arr[index] = low;
                low++;
                index++;
        } else {
                arr[index] = high;
                high--;
                index++;
        }
        return arr;
    }
}