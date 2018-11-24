class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int row = 0;
        
        int totalGap = (numRows-1)*2;
        while(row < numRows){
            int gap1 = ((numRows-row-1)*2);
            int gap2 = totalGap - gap1;
            i = row;
            while(i < s.length()){
                if(gap1 != 0 && i < s.length()){
                    sb.append(s.charAt(i));
                    i +=gap1;
                }
                if(gap2 != 0 && i < s.length()){
                    sb.append(s.charAt(i));
                    i +=gap2;
                }
                
            }
            row++;
        }
        return sb.toString();
    }
}