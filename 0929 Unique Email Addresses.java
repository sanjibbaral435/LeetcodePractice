class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        int count = 0;
        for(int i=0;i<emails.length;i++){
            String s = emails[i];
            String domain = s.substring(s.indexOf('@'));
            String local = sanitizeEmail(s.substring(0, s.indexOf('@')));
            String email = local + domain;
            
            if(!set.contains(email)) {
                set.add(email);
                count++;
            }
        }
        return count;
    }
    
    public String sanitizeEmail(String s){
        s = s.substring(0, s.indexOf('+'));
        s = s.replaceAll("\\.", "");
        return s;
    }
}