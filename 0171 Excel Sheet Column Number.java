// Same as binary to decimal with base 26

class Solution {
    public int titleToNumber(String s) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        int decimal = 0;
        // Initializing base value to 1, i.e 2^0 
        int base = 1; 
        int i = s.length()-1;
        
        while(i >=0){
            int last_digit = alphabet.indexOf(s.charAt(i))+1; 
            i--;
            decimal += last_digit*base; 
            base = base*26; 
        } 
        return decimal; 
    }
     
}