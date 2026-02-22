class Solution {
    public int binaryGap(int n) {
        int prev = -1;
        int res = 0;

        for (int curr = 0; curr < 32; curr++) {
            if (((n >> curr) & 1) > 0) {
                res = (prev != -1) ? Math.max(res, curr - prev) : res;
                prev = curr;
            }
        }

        return res;
    }
}
