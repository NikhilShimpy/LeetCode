import java.util.*;

class Solution {

    int[] segTree;

    // Build Segment Tree
    void build(int node, int l, int r) {
        if (l == r) {
            segTree[node] = 0;
            return;
        }

        int mid = l + (r - l) / 2;
        build(2 * node + 1, l, mid);
        build(2 * node + 2, mid + 1, r);

        segTree[node] = 0;
    }

    // Point Update (+1)
    void update(int idx, int node, int l, int r) {
        if (l == r) {
            segTree[node]++;
            return;
        }

        int mid = l + (r - l) / 2;

        if (idx <= mid)
            update(idx, 2 * node + 1, l, mid);
        else
            update(idx, 2 * node + 2, mid + 1, r);

        segTree[node] = segTree[2 * node + 1] + segTree[2 * node + 2];
    }

    // Range Sum Query
    int query(int ql, int qr, int node, int l, int r) {

        if (ql > r || qr < l)
            return 0;

        if (ql <= l && r <= qr)
            return segTree[node];

        int mid = l + (r - l) / 2;

        return query(ql, qr, 2 * node + 1, l, mid)
                + query(ql, qr, 2 * node + 2, mid + 1, r);
    }

    // lower_bound
    int lowerBound(long[] arr, long target) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] < target)
                lo = mid + 1;
            else
                hi = mid;
        }

        return lo;
    }

    // upper_bound
    int upperBound(long[] arr, long target) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] <= target)
                lo = mid + 1;
            else
                hi = mid;
        }

        return lo;
    }

    public int countRangeSum(int[] nums, int lower, int upper) {

        int n = nums.length;

        // Prefix Sum
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // Coordinate Compression
        long[] values = prefix.clone();
        Arrays.sort(values);

        int m = 1;
        for (int i = 1; i < values.length; i++) {
            if (values[i] != values[m - 1]) {
                values[m++] = values[i];
            }
        }

        values = Arrays.copyOf(values, m);

        segTree = new int[4 * m];
        build(0, 0, m - 1);

        int ans = 0;

        // Insert prefix[0]
        int idx = lowerBound(values, prefix[0]);
        update(idx, 0, 0, m - 1);

        for (int i = 1; i <= n; i++) {

            long leftValue = prefix[i] - upper;
            long rightValue = prefix[i] - lower;

            int left = lowerBound(values, leftValue);
            int right = upperBound(values, rightValue) - 1;

            if (left <= right) {
                ans += query(left, right, 0, 0, m - 1);
            }

            idx = lowerBound(values, prefix[i]);
            update(idx, 0, 0, m - 1);
        }

        return ans;
    }
}