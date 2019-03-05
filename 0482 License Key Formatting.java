class Solution {
    public String licenseKeyFormatting(String S, int K) {
        String str = S.replace("-", "");
        if(str.length() <= K) return str.toUpperCase();
        
        
        int  i = str.length()%K;
        StringBuilder sb = new StringBuilder();
        
        if(i != 0) {
            sb.append(str.substring(0, i).toUpperCase());
            sb.append("-");    
        }
        while(i < str.length()){
            sb.append(str.substring(i,i+K).toUpperCase());
            i = i+K;
            if(i != str.length())
                sb.append("-");
        }
        return sb.toString();
        
    }
}
