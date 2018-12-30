class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        Stack<Character> stack = new Stack<Character>();
        int i = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                // Closing brace
                if(stack.isEmpty() || map.get(c) != stack.pop()) return false;
            } else {
                stack.push(s.charAt(i));
            }   
            i++;
        }
        return stack.isEmpty();
    }
}