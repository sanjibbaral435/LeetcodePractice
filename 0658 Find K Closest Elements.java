/*
Time complexity : O(\log n +k)O(logn+k). O(\log n)O(logn) is for the time of binary search, while O(k)O(k) is for shrinking the index range to k elements.

Space complexity : O(k)O(k). It is to generate the required sublist.
*/
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
		if (x <= arr[0]) {
            return getResult(arr, 0, k-1);
		} else if (arr[n - 1] <= x) {
            return getResult(arr, n-k, n-1);
		} else {
            // the index of the search key, if it is contained in the list; otherwise, insertion point). 
            // The insertion point is defined as the point at which the key would be inserted into the list
            int index = binarySearch(arr, x);
            
            
            int low = Math.max(0, index - k - 1);
            int high = Math.min(arr.length - 1, index + k - 1);
            
            while (high - low > k - 1) {
				if (low < 0 || (x - arr[low]) <= (arr[high] - x))
					high--;
				else if (high > arr.length - 1 || (x - arr[low]) > (arr[high] - x))
					low++;
				else
					System.out.println("unhandled case: " + low + " " + high);
			}
            return getResult(arr, low, high);
        }
    }
    
    private List<Integer> getResult(int[] arr, int start, int end){
        List<Integer> res = new ArrayList<>();
        
        for(int i = start; i<=end; i++){
            res.add(arr[i]);
        }
        return res;
    }
    
    private int binarySearch(int[] arr, int x){         //Leetcode 35 search insert position
        int low = 0;
        int high = arr.length-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == x) return mid;
            else if(arr[mid] < x) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
}
