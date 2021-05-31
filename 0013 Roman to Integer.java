class Solution {
    public int romanToInt(String s) {

        HashMap<Character, Integer> romanChar = new HashMap();
        romanChar.put('I', 1);
        romanChar.put('V', 5);
        romanChar.put('X', 10);
        romanChar.put('L', 50);
        romanChar.put('C', 100);
        romanChar.put('D', 500);
        romanChar.put('M', 1000);

        int res = 0; int prev = 0; int curr = 0;
        //start from the back and if i is less than i+1, then subtract
        // if i is equal and greater than i+1, then add
        for(int i=s.length()-1; i >= 0; i--){
            curr = romanChar.get(s.charAt(i));
            if(prev == 0) {
                res = curr;
            }
            else if(curr < prev) res -= curr;
            else res += curr;

            prev = curr;
        }

        return res;
    }
}
