class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> set = new HashSet(Arrays.asList(new String[] {"+", "-", "*", "/"}));
        int i=0; int res = 0;
        while(i < tokens.length){
            String val = tokens[i++];
            if(set.contains(val)){
                int val1 = stack.pop();
                int val2 = stack.pop();
                res = evaluate(val2, val1, val);
                stack.push(res);
            } else {
                stack.push(Integer.valueOf(val));
            }
        }
        return stack.pop();
    }
    
    public int evaluate(int a, int b, String operator){
        if(operator.equals("+"))
            return a + b;
        if(operator.equals("-"))
            return a - b;
        if(operator.equals("*"))
            return a * b;
        if(operator.equals("/"))
            return a / b;
        return 0;
    }
}