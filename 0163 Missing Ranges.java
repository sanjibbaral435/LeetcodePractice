class Solution {
    public List<String> findMissingRanges(int[] a, int lo, int hi) {
        List<String> res = new ArrayList<String>();
        // the next number we need to find
        
        long next = lo;
        for (int i = 0; i < a.length; i++) {
            // not within the range yet
            if (a[i] < next) continue;

            // continue to find the next one
            if (a[i] == next) {
                next++;
                continue;
            }
            // get the missing range string format
            res.add(getRange(next, a[i] - 1));

            // now we need to find the next number
            next = (long) a[i] + 1;
        }
        
        // do a final check
        if (next <= hi) res.add(getRange(next, hi));

        return res;
    }

    String getRange(long n1, long n2) {
      return (n1 == n2) ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
    }
}
