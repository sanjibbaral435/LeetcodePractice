class Solution {
    public void reverseWords(char[] str) {
        int ctr = 0;
        int start = 0;
        int end = 0;

        while(ctr < str.length){
            if(str[ctr] == ' ') {
                end = ctr;
                reverse(str, start, end - 1);
                start = ctr + 1;
            } else if(ctr == str.length-1){
                end = ctr;
                reverse(str, start, end);
                start = ctr + 1;
            }
            ctr++;
        }
        
        reverse(str, 0, str.length-1);
    }
    
    public void reverse(char[] arr, int i, int j){
        
        while(i<j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}