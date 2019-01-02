class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        shifts[shifts.length-1] %= 26;
        for(int i = shifts.length-2; i>= 0; i--){
            shifts[i] = (shifts[i] + shifts[i+1])%26;
        }
        
        StringBuilder sb = new StringBuilder(S);
        for(int i=0; i< S.length(); i++){
            char newchar = (char)((S.charAt(i) - 97 + shifts[i])%26 + 97);
            sb.setCharAt(i, newchar);    
        }
        return sb.toString();
    }
}