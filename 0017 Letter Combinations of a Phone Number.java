class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        char[] nums = digits.toCharArray();
        char[][] charMap = {{'a', 'b', 'c'},{'d', 'e', 'f'},{'g', 'h', 'i'},{'j', 'k', 'l'},{'m', 'n', 'o'},{'p', 'q', 'r', 's'},{'t', 'u','v'},{'w', 'x', 'y', 'z'}};
        if(digits.length() == 0) return res;
        StringBuilder sb = new StringBuilder();
        letterComb(nums, res, charMap, 0, sb);
        return res;
    }
    
    public void letterComb(char[] nums, List<String> res, char[][] charMap, int numIndex, StringBuilder sb ){
        if(numIndex == nums.length) {
            res.add(sb.toString());
            sb.deleteCharAt(numIndex-1);
            return;
        }
        
        int digit=Character.getNumericValue(nums[numIndex]) - 2;
        
        for(int i=0; i<charMap[digit].length;i++){
            sb.append(charMap[digit][i]);
            System.out.print(charMap[digit][i]);
            letterComb(nums, res, charMap, numIndex+1, sb);
        }
        if(numIndex > 0)
            sb.deleteCharAt(numIndex-1);
        return;
    }
}