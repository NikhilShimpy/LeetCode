class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int res = 0, currsum = 0, start = 0;
        Set<Integer> seen = new HashSet<>();

        for (int end = 0; end < nums.length; end++) {

            while (seen.contains(nums[end])) {
                seen.remove(nums[start]);
                currsum -= nums[start];
                start++;
            }

            currsum += nums[end];
            seen.add(nums[end]);

            res = Math.max(res, currsum);
        }

        return res;
    }
}
