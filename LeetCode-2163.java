class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length, k = n / 3;
        long[] lmin = new long[n];
        long[] rmax = new long[n];

        PriorityQueue<Integer> maxl = new PriorityQueue<>(Collections.reverseOrder());
        long lsum = 0;

        for (int i = 0; i < k; i++) {
            maxl.add(nums[i]);
            lsum += nums[i];
        }
        lmin[k - 1] = lsum;

        for (int i = k; i < n - k; i++) {
            if (nums[i] < maxl.peek()) {
                lsum += nums[i] - maxl.poll();
                maxl.add(nums[i]);
            }
            lmin[i] = lsum;
        }

        PriorityQueue<Integer> minr = new PriorityQueue<>();
        long rightSum = 0;

        for (int i = n - 1; i >= n - k; i--) {
            minr.add(nums[i]);
            rightSum += nums[i];
        }
        rmax[n - k] = rightSum;

        for (int i = n - k - 1; i >= k - 1; i--) {
            if (nums[i] > minr.peek()) {
                rightSum += nums[i] - minr.poll();
                minr.add(nums[i]);
            }
            rmax[i] = rightSum;
        }

        long mindf = Long.MAX_VALUE;
        for (int i = k - 1; i < n - k; i++) {
            mindf = Math.min(mindf, lmin[i] - rmax[i + 1]);
        }

        return mindf;
    }
}
