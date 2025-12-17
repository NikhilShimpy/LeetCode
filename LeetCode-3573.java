class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        if (n < 2 || k == 0) return 0;

        long[] dp_prev = new long[n];
        long[] dp_cur = new long[n];

        for (int t = 1; t <= k; t++) {
            long best_buy = -prices[0];
            long best_short = prices[0];
            dp_cur[0] = 0;

            for (int i = 1; i < n; i++) {
                long a = dp_cur[i - 1];
                long b = best_buy + prices[i];
                long c = best_short - prices[i];

                dp_cur[i] = Math.max(Math.max(a, b), c);

                best_buy = Math.max(best_buy, dp_prev[i - 1] - prices[i]);
                best_short = Math.max(best_short, dp_prev[i - 1] + prices[i]);
            }

            long[] temp = dp_prev;
            dp_prev = dp_cur;
            dp_cur = temp;
        }

        return dp_prev[n - 1];
    }
}
