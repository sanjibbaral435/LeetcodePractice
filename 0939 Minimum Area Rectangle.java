// First of all from all the points store all y points for each x axis i.e. for x=1 axis what all y points are present
// and so on. Then starting for each point, (x1, y1) get all other ponts (x2 y2) one by one and consider that to be a
// diagonal. And based on that diagonal calculate the rectangle area and compare with overall minimum
// Time Complexity O(N^2)
// Space Complexity O(N)
class Solution {
    public int minAreaRect(int[][] points) {
        if(points.length ==  0) return 0;
        Map<Integer, Set<Integer>> map = new HashMap();
        
        for(int[] p: points){
            if(!map.containsKey(p[0])){
                map.put(p[0], new HashSet());
            }
            map.get(p[0]).add(p[1]);
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<points.length-1; i++){
            for(int j=i+1; j<points.length; j++){
                if(points[i][0] == points[j][0] || points[i][1] == points[j][1]){
                    // same x or same y. so they are not a diagnonal which can form a rectangle parallel to x and y axis
                    continue;
                } 
                if(map.get(points[i][0]).contains(points[j][1]) && map.get(points[j][0]).contains(points[i][1])){
                    min = Math.min(min, Math.abs(points[i][0] - points[j][0]) * Math.abs(points[i][1] - points[j][1]));
                }
            }    
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
