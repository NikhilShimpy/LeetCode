class Solution {
    public int maxFrequency(int[] nums, int k, int numOps) {
        int maxval = Arrays.stream(nums).max().getAsInt() + k + 2;
        int[] count = new int[maxval];

        for (int v : nums)
            count[v]++;

        for (int i = 1; i < maxval; i++)
            count[i] += count[i - 1];

        int res = 0;
        for (int i = 0; i < maxval; i++) {
            int l = Math.max(0, i - k);
            int r = Math.min(maxval - 1, i + k);
            int total = count[r] - (l > 0 ? count[l - 1] : 0);
            int freq = count[i] - (i > 0 ? count[i - 1] : 0);
            res = Math.max(res, freq + Math.min(numOps, total - freq));
        }

        return res;
    }
}
