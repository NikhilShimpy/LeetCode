class Solution {
    public long minNumberOfSeconds(int height, int[] times) {
        long low = 1, high = 10000000000000000L;

        while (low < high) {
            long mid = (low + high) >> 1;
            long tot = 0;
            for (int i = 0; i < times.length && tot < height; i++)
                tot += (long) (Math.sqrt((double) mid / times[i] * 2 + 0.25) - 0.5);
            if (tot >= height)
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }
}
