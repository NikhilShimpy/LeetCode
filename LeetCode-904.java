public class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int lastfr = -1, seclastfr = -1;
        int lastcount = 0, currmax = 0, max = 0;

        for (int i = 0; i < n; i++) {
            int fruit = fruits[i];

            if (fruit == lastfr || fruit == seclastfr) {
                currmax++;
            } else {
                currmax = lastcount + 1;
            }

            if (fruit == lastfr) {
                lastcount++;
            } else {
                lastcount = 1;
                seclastfr = lastfr;
                lastfr = fruit;
            }

            max = Math.max(max, currmax);
        }

        return max;
    }
}
