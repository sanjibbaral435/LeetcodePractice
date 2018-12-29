class Solution {
    public boolean buddyStrings(String A, String B) {
        
        // length mismatch
        if(A.length() != B.length()) return false;
        
        //equal
        if(A.equals(B)){
            //If A == B, we should check each index i for two matches with the same value.
            int[] count = new int[26];
            for (int i = 0; i < A.length(); ++i)
                count[A.charAt(i) - 'a']++;

            for (int c: count)
                if (c > 1) return true;
            return false;
        } else {
            List<Integer> mismatchIndex = new ArrayList<Integer>();

            for(int i=0; i<A.length(); i++){
                if(A.charAt(i) != B.charAt(i)) mismatchIndex.add(i);
            }

            if(mismatchIndex.size() != 2) return false;

            if(A.charAt(mismatchIndex.get(1)) == B.charAt(mismatchIndex.get(0))
                && A.charAt(mismatchIndex.get(0)) == B.charAt(mismatchIndex.get(1)))
                return true;
            else return false;       
        }
    }
}