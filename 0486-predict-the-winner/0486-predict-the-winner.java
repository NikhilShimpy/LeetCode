class Solution {
    int dp[][];
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        dp = new int[n][n];
        for(int row[] : dp) {
            Arrays.fill(row,-1);
        }

        int p1 = solve(0,n-1,nums);

        int ts = 0; // total score
        for(int x : nums) ts += x;

        
        return p1 >= ts-p1;
    }
    private int solve(int i , int j , int[] nums){
        if(i > j) return 0;
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(i == j) return nums[i];

        int takei = nums[i] + Math.min(solve(i+2,j,nums) , solve(i+1,j-1,nums));
        int takej = nums[j] + Math.min(solve(i+1,j-1,nums),solve(i,j-2,nums));
        return dp[i][j] = Math.max(takei, takej);
    }
}