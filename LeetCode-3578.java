class Solution {
    public int countPartitions(int[] nums, int k) {
        int MOD = (int)1e9 + 7;
        int n = nums.length;

        long[] dp = new long[n + 1];
        long[] pref = new long[n + 1];

        dp[0] = 1;
        pref[0] = 1;

        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();

        int i = 0, j = 0;

        while (j < n) {

            while (!maxQ.isEmpty() && nums[j] > nums[maxQ.peekLast()])
                maxQ.pollLast();
            maxQ.addLast(j);

            while (!minQ.isEmpty() && nums[j] < nums[minQ.peekLast()])
                minQ.pollLast();
            minQ.addLast(j);

            while (nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > k) {
                i++;
                if (!maxQ.isEmpty() && maxQ.peekFirst() < i) maxQ.pollFirst();
                if (!minQ.isEmpty() && minQ.peekFirst() < i) minQ.pollFirst();
            }

            long val = (pref[j] - (i > 0 ? pref[i - 1] : 0) + MOD) % MOD;

            dp[j + 1] = val;
            pref[j + 1] = (pref[j] + dp[j + 1]) % MOD;

            j++;
        }

        return (int) dp[n];
    }
}
