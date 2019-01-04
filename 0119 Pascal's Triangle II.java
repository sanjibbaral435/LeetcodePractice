class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        List<Integer> res = new ArrayList<Integer>();
        
        List<Integer> prev = new ArrayList<Integer>();

        prev.add(1);
        
        for(int i=1; i<=rowIndex; i++){
            List<Integer> curr = new ArrayList<Integer>();

            for(int j=0; j<=i; j++){
                if(j == 0 || i==j) curr.add(1); 
                else curr.add(prev.get(j-1) + prev.get(j));
            }
            if(i==rowIndex) return curr;
            prev = curr;

        }
        return prev;        
    }
}