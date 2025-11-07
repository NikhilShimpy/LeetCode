class Solution {

    private boolean check(long mid, long[] diff, int r, long k, int n) {
        long[] tempdiff = Arrays.copyOf(diff, n);
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += tempdiff[i];

            if (sum < mid) {
                long need = mid - sum;
                if (need > k) {
                    return false;
                }

                k -= need;
                sum += need;

                if (i + 2L * r + 1 < n) {
                    tempdiff[(int)(i + 2L * r + 1)] -= need;
                }
            }
        }
        return true;
    }

    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] diff = new long[n];

        // diff array --> asani se calculate kr sake diff 
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - r);
            int right = i + r + 1;
            diff[left] += stations[i];
            if (right < n) diff[right] -= stations[i];
        }

        long left = Arrays.stream(stations).min().getAsInt();
        long right = Arrays.stream(stations).asLongStream().sum() + k;
        long res = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (check(mid, diff, r, k, n)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }
}
