class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0]==b[0]) return a[1]-b[1];
                else return a[0]-b[0];
            }
	    });
        
        int currEnd = points[0][1];
        int count = 1;
        for(int i=1; i < points.length; i++){
            int[] point = points[i];
            
            if(point[0] > currEnd){
                // Non overlapping interval. So increase count
                count++;
                currEnd = point[1];
            } else {
                currEnd = Math.min(currEnd, point[1]);
            }
        }
        return count;
    }
}