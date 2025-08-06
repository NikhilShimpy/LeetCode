class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int[] segtree = new int[4 * n];

        build(0, 0, n - 1, baskets, segtree);

        int unplaced = 0;
        for (int fruit : fruits) {
            if (!querySegmentTree(0, 0, n - 1, segtree, fruit)) {
                unplaced++;
            }
        }

        return unplaced;
    }

    private void build(int i, int l, int r, int[] baskets, int[] segtree) {
        if (l == r) {
            segtree[i] = baskets[l];
            return;
        }
        int m = (l + r) / 2;

        build(2 * i + 1, l, m, baskets, segtree);
        build(2 * i + 2, m + 1, r, baskets, segtree);

        segtree[i] = Math.max(segtree[2 * i + 1], segtree[2 * i + 2]);
    }

    private boolean querySegmentTree(int i, int l, int r, int[] segtree, int val) {
        if (segtree[i] < val) {
            return false; 
        }

        if (l == r) {
            segtree[i] = -1; 
            return true;
        }

        int mid = (l + r) / 2;
        boolean placed;

        if (segtree[2 * i + 1] >= val) {
            placed = querySegmentTree(2 * i + 1, l, mid, segtree, val);
        } else {
            placed = querySegmentTree(2 * i + 2, mid + 1, r, segtree, val);
        }

        segtree[i] = Math.max(segtree[2 * i + 1], segtree[2 * i + 2]);

        return placed;
    }
}
