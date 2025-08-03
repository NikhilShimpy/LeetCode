class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        if (n == 0) {
            return 0;
        }

        int[] pos = new int[n];
        long[] prefixsum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pos[i] = fruits[i][0];
            prefixsum[i + 1] = prefixsum[i] + fruits[i][1];
        }

        long maxfr = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            long posl = pos[left];
            long posr = pos[right];
            long cost = (posr - posl) + Math.min(Math.abs(startPos - posl), Math.abs(startPos - posr));

            while (left <= right && cost > k) {
                left++;
                if (left > right) break;
                posl = pos[left];
                cost = (posr - posl) + Math.min(Math.abs(startPos - posl), Math.abs(startPos - posr));
            }

            if (left <= right) {
                long currentFruits = prefixsum[right + 1] - prefixsum[left];
                maxfr = Math.max(maxfr, currentFruits);
            }
        }

        return (int) maxfr;
    }
}
