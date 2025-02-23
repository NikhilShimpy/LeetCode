class Solution {
    Boolean dp[][];
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        
        for(int i : nums) sum+=i;
        
        if(sum%2!=0) return false;
        
        sum /= 2;
        
        dp = new Boolean[n+1][sum+1];
        
        return subsetSum(nums,0,sum);
    }
    
    boolean subsetSum(int[] nums, int n, int sum){
        if(sum==0) return true;
        
        else if(n>=nums.length || sum<0) return false;
        
        if(dp[n][sum]!=null) return dp[n][sum];
        
        return dp[n][sum] = subsetSum(nums,n+1,sum-nums[n]) ||
                                subsetSum(nums,n+1,sum);
        
    }
}
