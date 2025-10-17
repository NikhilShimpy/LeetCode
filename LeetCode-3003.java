public class Solution {

    public int maxPartitionsAfterOperations(String s, int k) {
        int n = s.length();
        int[][] left = new int[n][3];
        int[][] right = new int[n][3];

        int num = 0;
        int mask = 0;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            int binary = 1 << (s.charAt(i) - 'a');
            if ((mask & binary) == 0) {
                count++;
                if (count <= k) {
                    mask |= binary;
                } else {
                    num++;
                    mask = binary;
                    count = 1;
                }
            }
            left[i + 1][0] = num;
            left[i + 1][1] = mask;
            left[i + 1][2] = count;
        }

        num = 0;
        mask = 0;
        count = 0;
        for (int i = n - 1; i > 0; i--) {
            int binary = 1 << (s.charAt(i) - 'a');
            if ((mask & binary) == 0) {
                count++;
                if (count <= k) {
                    mask |= binary;
                } else {
                    num++;
                    mask = binary;
                    count = 1;
                }
            }
            right[i - 1][0] = num;
            right[i - 1][1] = mask;
            right[i - 1][2] = count;
        }

        int maxval = 0;
        for (int i = 0; i < n; i++) {
            int seg = left[i][0] + right[i][0] + 2;
            int tmask = left[i][1] | right[i][1];
            int tcount = Integer.bitCount(tmask);
            if (left[i][2] == k && right[i][2] == k && tcount < 26) {
                seg++;
            } else if (Math.min(tcount + 1, 26) <= k) {
                seg--;
            }
            maxval = Math.max(maxval, seg);
        }
        return maxval;
    }
}
