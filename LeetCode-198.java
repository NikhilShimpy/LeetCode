class Solution {
    int dp[];
    public int rob(int[] nums) {
        dp = new int[101];
        Arrays.fill(dp,-1);
       return find(nums,nums.length);
    }
    public int find(int[] nums , int n){
        if(n<=0) return 0;
        if(dp[n] != -1) return dp[n];
        return dp[n] = Math.max(find(nums,n-1), find(nums,n-2)+nums[n-1]);
    }
}
