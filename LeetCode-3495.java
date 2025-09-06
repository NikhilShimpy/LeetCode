class Solution {
    public long minOperations(int[][] queries) {
        long ans = 0;
        for (int i = 0; i < queries.length; i++) {
            long start = queries[i][0], end = queries[i][1];
            long ops = 0;
            for (long d = 1, prev = 1; d < 17; d++) {
                long cur = prev * 4;
               
                long l = Math.max(start, prev);
                long r = Math.min(end, cur - 1);
                if (r >= l) {
                    ops += (r - l + 1) * d;
                }
                prev = cur;
            }
            ans += (ops + 1) / 2;
        }
        return ans;
    }
}
