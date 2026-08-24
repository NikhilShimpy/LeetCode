class Solution {
    private int n;
    private int[][] dp;

    public int lengthOfLIS(int[] nums) {
        dp = new int[2501][2501];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        n = nums.length;
        return lis(nums, -1, 0);
    }

    public int lis(int[] nums, int previdx, int curridx) {
        if (curridx == n)
            return 0;

        if (previdx != -1 && dp[previdx][curridx] != -1)
            return dp[previdx][curridx];

        int taken = 0;
        if (previdx == -1 || nums[curridx] > nums[previdx])
            taken = 1 + lis(nums, curridx, curridx + 1);

        int skip = lis(nums, previdx, curridx + 1);

        if (previdx != -1)
            dp[previdx][curridx] = Math.max(taken, skip);

        return Math.max(taken, skip);
    }
}