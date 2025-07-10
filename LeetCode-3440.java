class Solution {
    public int maxFreeTime(int ev, int[] s, int[] e) {
        int last = 0, n = s.length, left = 0, res = 0;
        int[] right = new int[n + 1];
        int[] gaps = new int[n + 1];

        for (int i = 0; i < n; i++) {
            gaps[i] = s[i] - last;
            last = e[i];
        }

        gaps[n] = ev - last;
        for (int i = n - 1; i >= 0; i--) right[i] = Math.max(right[i + 1], gaps[i + 1]);

        for (int i = 1; i <= n; i++) {
            int dur = e[i - 1] - s[i - 1];

            if (left >= dur || right[i] >= dur) res = Math.max(res, gaps[i - 1] + dur + gaps[i]);

            left = Math.max(left, gaps[i - 1]);
            res = Math.max(res, gaps[i - 1] + gaps[i]);
        }

        return res;
    }
}
