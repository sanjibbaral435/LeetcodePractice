class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if(num.length<4)return ans;
        Arrays.sort(num);
        for(int i=0; i<num.length-3; i++){
            //first candidate too large, search finished
            if(num[i]+num[i+1]+num[i+2]+num[i+3]>target)break; 

            //first candidate too small
            if(num[i]+num[num.length-1]+num[num.length-2]+num[num.length-3]<target)continue; 

            //prevents duplicate result in ans list
            if(i>0&&num[i]==num[i-1])continue;

            for(int j=i+1; j<num.length-2; j++){
                //second candidate too large
                if(num[i]+num[j]+num[j+1]+num[j+2]>target)break; 

                //second candidate too small
                if(num[i]+num[j]+num[num.length-1]+num[num.length-2]<target)continue;

                 //prevents duplicate results in ans list
                if(j>i+1&&num[j]==num[j-1])continue;

                int low=j+1, high=num.length-1;

                while(low<high){
                    int sum=num[i]+num[j]+num[low]+num[high];
                    if(sum==target){
                        ans.add(Arrays.asList(num[i], num[j], num[low], num[high]));
                        //skipping over duplicate on low
                        while(low<high&&num[low]==num[low+1])low++; 

                        //skipping over duplicate on high
                        while(low<high&&num[high]==num[high-1])high--; 
                        low++; 
                        high--;
                    }
                    //move window
                    else if(sum<target)low++; 
                    else high--;
                }
            }
        }
        return ans;
    }
}