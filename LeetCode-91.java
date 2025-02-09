class Solution {
    public int[] dp;
    public int n;

    public int numDecodings(String s) {
        n = s.length();
        dp = new int[n + 1]; 
        Arrays.fill(dp, -1);
        return numDecodingsHelper(s, 0);
    }

    public int numDecodingsHelper(String s, int pos) {
        if (pos == n) return 1;
        if (s.charAt(pos) == '0') return 0;

        if (dp[pos] != -1) return dp[pos];

        int count = numDecodingsHelper(s, pos + 1);
        if (pos < n - 1 && Integer.parseInt(s.substring(pos, pos + 2)) < 27) {
            count += numDecodingsHelper(s, pos + 2);
        }

        return dp[pos] = count;
    }
}
