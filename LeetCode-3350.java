class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int maxk = 0, prev = 0;
        int curr = 1;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                curr++;
            } else {
                maxk = Math.max(maxk, Math.max(curr / 2, Math.min(prev, curr)));
                prev = curr;
                curr = 1;
            }
        }
        maxk = Math.max(maxk, Math.max(curr / 2, Math.min(prev, curr)));
        return maxk;
    }
}
