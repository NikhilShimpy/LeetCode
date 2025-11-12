class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        int count1 = 0;
        for (int num : nums) {
            if (num == 1)
                count1++;
        }

        if (count1 > 0) {
            return n - count1;
        }

        int minstepto1 = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int gcdval = nums[i];
            for (int j = i + 1; j < n; j++) {
                gcdval = gcd(gcdval, nums[j]);

                if (gcdval == 1) {
                    minstepto1 = Math.min(minstepto1, j - i);
                    break;
                }
            }
        }

        if (minstepto1 == Integer.MAX_VALUE) {
            return -1;
        }

        return minstepto1 + (n - 1);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
