class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        for (int i = 0, n = nums.length; i < n; i++) {
            int start = nums[i];
            int end = start;
            for (; i + 1 < n && nums[i] + 1 == nums[i + 1]; i++) {
                end++;
            }
            ranges.add(getRange(start, end));
        }
        return ranges;
    }

    private String getRange(int start, int end) {
        return start == end ? start + "" : start + "->" + end;
    }
}
