// Using PriorityQueue
// Time Complexity O(nLogN)
// Space Complexity O(N)
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return (a[0]*a[0]+a[1]*a[1]) - (b[0]*b[0]+b[1]*b[1]);
            }
        });
        
        for(int[] point: points){
            queue.add(point);
        }
        
        int[][] res = new int[K][2];
        for(int i = 0; i< K; i++){
            res[i] = queue.poll();
        }
        return res;
    }
}
