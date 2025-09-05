class Solution {
    public int countBits(long num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }

    public int makeTheIntegerZero(int num1, int num2) {
        if (num1 < num2) {
            return -1;
        }

        for (int steps = 0; steps <= 100; steps++) {
            long diff = num1 - 1L * num2 * steps;
            int bits = countBits(diff);
            if (bits <= steps && steps <= diff) {
                return steps;
            }
        }

        return -1;
    }
}
