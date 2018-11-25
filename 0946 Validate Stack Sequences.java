class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed==null || popped==null || (pushed.length<popped.length))
        return false;

        boolean bPossible = false;
        int nLength = popped.length;

        Stack <Integer> stackData = new Stack<Integer>();
        ArrayList<Integer> pNextPush =getListFromArr(pushed);  
        ArrayList<Integer> pNextPop = getListFromArr(popped);

        int i = 0; int j = 0;

        while(j < nLength){
            while(stackData.empty() || !stackData.peek().equals(pNextPop.get(j))){
                if(stackData.empty() && pNextPush.size()==0){
                    break;
                }
                else if(i < pNextPush.size()){
                    stackData.push(pNextPush.get(i++));
                }
                if(i == nLength){
                    break;       
                }
            }
            
            if(j < pNextPop.size()){
                if(!stackData.peek().equals(pNextPop.get(j))){
                    break;
                }
            }
            stackData.pop();
            j++;
        }

        if(stackData.empty() && j == nLength)
            bPossible = true;
        return bPossible;
    }
    
    private ArrayList<Integer> getListFromArr(int[] arr){
        ArrayList<Integer> aL = new ArrayList<>();
        for(int i: arr){
            aL.add(i);
        }
        return aL;
    }
}