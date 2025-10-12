import java.util.*;

class Solution {
    private static final int mod = 1_000_000_007;
    private static final int max = 31;
    private static long[] fact = new long[max];
    private static long[] invFact = new long[max];

    static {
        fact[0] = 1;
        for (int i = 1; i < max; i++) {
            fact[i] = fact[i - 1] * i % mod;
        }
        invFact[max - 1] = modPow(fact[max - 1], mod - 2);
        for (int i = max - 1; i > 0; i--) {
            invFact[i - 1] = invFact[i] * i % mod;
        }
    }

    public int magicalSum(int m, int k, int[] nums) {
        int n = nums.length;

        long[][] pows = new long[n][m + 1];
        for (int i = 0; i < n; i++) {
            pows[i][0] = 1;
            for (int j = 1; j <= m; j++) {
                pows[i][j] = pows[i][j - 1] * nums[i] % mod;
            }
        }

        long[][][][] dp = new long[n][m + 1][m / 2 + 2][k + 1];
        for (long[][][] a : dp)
            for (long[][] b : a)
                for (long[] c : b)
                    Arrays.fill(c, -1);

        long res = dfs(0, m, 0, k, pows, dp);
        res = res * fact[m] % mod;
        return (int) res;
    }

    private long dfs(int bitidx, int mleft, int carry, int kleft,
                     long[][] pows, long[][][][] dp) {
        int currone = Integer.bitCount(carry);
        if (currone + mleft < kleft) return 0;

        if (bitidx == pows.length) {
            return (mleft == 0 && currone == kleft) ? 1 : 0;
        }

        if (dp[bitidx][mleft][carry][kleft] != -1) {
            return dp[bitidx][mleft][carry][kleft];
        }

        long total = 0;
        for (int pk = 0; pk <= mleft; pk++) {
            int bitval = (carry + pk) & 1;
            if (bitval > kleft) continue;

            int newc = (carry + pk) >> 1;
            long sub = dfs(bitidx + 1, mleft - pk, newc, kleft - bitval, pows, dp);

            if (sub != 0) {
                long contrib = sub * pows[bitidx][pk] % mod;
                contrib = contrib * invFact[pk] % mod;
                total = (total + contrib) % mod;
            }
        }

        return dp[bitidx][mleft][carry][kleft] = total;
    }

    private static long modPow(long base, int exp) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = res * base % mod;
            base = base * base % mod;
            exp >>= 1;
        }
        return res;
    }
}
