class Solution {
    int dp[];
    public int climbStairs(int n, int[] costs) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n, costs);
    }
    public int solve(int n, int[] costs){
        if(n == 0){
            return 0;
        }
        
        if(dp[n] != -1) return dp[n];
        int res = Integer.MAX_VALUE;
        //one step
        if(n-1 >= 0){
            res = Math.min(res,solve(n-1,costs) + costs[n-1] + 1);
        }
        if(n-2 >= 0){
            res = Math.min(res,solve(n-2,costs) + costs[n-1] + 4);
        }
        if(n-3 >= 0){
            res = Math.min(res,solve(n-3,costs) + costs[n-1] + 9);
        }
        return dp[n] = res;
    }
}