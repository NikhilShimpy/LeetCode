class Solution {

    static class Pair {
        int d1, d2;

        Pair(int d1, int d2) {
            this.d1 = d1;
            this.d2 = d2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair p = (Pair) o;
            return d1 == p.d1 && d2 == p.d2;
        }

        @Override
        public int hashCode() {
            return 31 * d1 + d2;
        }
    }

    public int longestBalanced(String s) {

        char[] c = s.toCharArray();
        int n = c.length;

        int res = 0;
        int cur = 1;

        for (int i = 1; i < n; i++) {
            if (c[i] == c[i - 1]) {
                cur++;
            } else {
                res = Math.max(res, cur);
                cur = 1;
            }
        }
        res = Math.max(res, cur);

        res = Math.max(res, find2(c, 'a', 'b'));
        res = Math.max(res, find2(c, 'a', 'c'));
        res = Math.max(res, find2(c, 'b', 'c'));

        int ca = 0, cb = 0, cc = 0;

        Map<Pair, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            if (c[i] == 'a') ca++;
            else if (c[i] == 'b') cb++;
            else cc++;

            if(ca == cb && ca == cc)
                res = Math.max(res, ca+cb+cc);

            Pair key = new Pair(ca - cb, ca - cc);

            Integer prev = map.get(key);
            if (prev != null) {
                res = Math.max(res, i - prev);
            } else {
                map.put(key, i);
            }
        }

        return res;
    }

    private int find2(char[] c, char x, char y) {

        int n = c.length;
        int maxlen = 0;

        int[] first = new int[2 * n + 1];
        Arrays.fill(first, -2);

        int clearidx = -1;
        int diff = n;

        first[diff] = -1;

        for (int i = 0; i < n; i++) {

            if (c[i] != x && c[i] != y) {

                clearidx = i;
                diff = n;
                first[diff] = clearidx;

            } else {

                if (c[i] == x) diff++;
                else diff--;

                if (first[diff] < clearidx) {
                    first[diff] = i;
                } else {
                    maxlen = Math.max(maxlen, i - first[diff]);
                }
            }
        }

        return maxlen;
    }
}
