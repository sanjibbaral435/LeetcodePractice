// Time O(n)
// space O(n)
class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0; i<ppid.size(); i++){
            if(ppid.get(i) > 0){
                List<Integer> list = map.getOrDefault(ppid.get(i), new ArrayList<Integer>());
                list.add(pid.get(i)); // put the child into the same parent list
                map.put(ppid.get(i), list);    
            }
        }
        
        List<Integer> res = new ArrayList<>();
        
        res.add(kill);
        
        // find all childrens recursively
        findAllChildren(map, res, kill);
        return res;
        
    }
    
    public void findAllChildren(Map<Integer,List<Integer>> map, List<Integer> res, int kill){
        if(map.containsKey(kill)){
            for(int child: map.get(kill)){
                res.add(child);
                findAllChildren(map, res, child);
            }    
        }
    }
}
