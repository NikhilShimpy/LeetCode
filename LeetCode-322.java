class Solution {
    int[] dp;

    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp, -2); 

        int res = helper(coins, amount);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int helper(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;
        if (dp[amount] != -2) return dp[amount];

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = helper(coins, amount - coin);
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, res + 1);
            }
        }

        dp[amount] = min;
        return min;
    }
}
class Solution {
    int[] dp;

    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp, -2); 

        int res = helper(coins, amount);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int helper(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;
        if (dp[amount] != -2) return dp[amount];

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = helper(coins, amount - coin);
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, res + 1);
            }
        }

        dp[amount] = min;
        return min;
    }
}
