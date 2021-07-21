/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

/*

Instead of manually iterating on every room that's been allocated and checking if the room is available or not, we can keep all the rooms in a min heap where the key for the min heap would be the ending time of meeting.

So, every time we want to check if any room is free or not, simply check the topmost element of the min heap as that would be the room that would get free the earliest out of all the other rooms currently occupied.

Time Complexity O(nLogn)
Space Complexity O(n)
*/
class Solution {
    public int minMeetingRooms1(int[][] intervals) {
        // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0) {
            return 0;
        }

        // sort by start time
        Comparator<int[]> c = (int[] a, int[] b) -> (a[0] - b[0]);
        Arrays.sort(intervals, c);

        // create minHeap to store end times
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(intervals[0][1]); // add first element

        // if start time >= top meeting finish time, then remove top
        // add the endTime to priorityqueue
        for(int i=1; i<intervals.length; i++) {
            if(pq.peek() <= intervals[i][0]) {
                // No collision. Remove the min end time
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }

        return pq.size();
    }


    
    public int minMeetingRooms(Interval[] intervals) {

        // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0) {
            return 0;
        }

        //Min Heap
        PriorityQueue<Integer> allocator =
            new PriorityQueue<Integer>(
            intervals.length,
            new Comparator<Integer>(){
                public int compare(Integer a, Integer b){
                    return a - b;}
            });

        // Sort the intervals by start time
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        // Add the first meeting
        allocator.add(intervals[0].end);

        for(int i=1; i< intervals.length; i++){
            if(intervals[i].start >= allocator.peek()){
                // No collision. Remove the min end time
                allocator.poll();
            }
            allocator.add(intervals[i].end);
        }
        return allocator.size();

    }
}
