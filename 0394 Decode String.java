class Solution {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<StringBuilder> value = new Stack<>();
        int i = 0, num = 0;
        
        int len = s.length();
        
        //add a stringbuilder which will be the result
        value.push(new StringBuilder());
        
        while(i<len){
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9'){
                // it's num character
                num = num*10+ (ch - '0');
            } else if(ch == '['){
                count.push(num);
                num = 0;
                value.push(new StringBuilder());
            } else if(ch == ']'){
                String str = value.pop().toString();
                int rep = count.pop();
                StringBuilder temp = new StringBuilder();
                while(rep > 0){
                    temp.append(str);
                    rep--;
                }
                // push this
                value.peek().append(temp.toString());
            } else {
                value.peek().append(ch);
            }
            i++;
        }
        return value.pop().toString();
    }
}
