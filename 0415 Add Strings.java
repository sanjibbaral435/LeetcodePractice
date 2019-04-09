class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int carry = 0;
        int a1 , a2 = 0;
        StringBuilder sb = new StringBuilder();
        while(len1 >= 0 || len2 >= 0){
            if(len1 >= 0)
                a1 = num1.charAt(len1) - '0';
            else a1 = 0;
            if(len2 >= 0)
                a2 = num2.charAt(len2) - '0';
            else a2 = 0;
            
            len1--;
            len2--;
            
            int sum = a1+a2+carry;
            sb.insert(0, sum%10);
            carry = sum/10;
        }
        
        if(carry > 0) sb.insert(0, carry);
        return sb.toString();
    }
}
