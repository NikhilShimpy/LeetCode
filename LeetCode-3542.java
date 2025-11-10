class Solution {
    public static int minOperations(int[] nums) {
        int n = nums.length;
        int res = 0;
        boolean[] isnum = new boolean[100001];
        int[] monostack = new int[n];
        int size = 0;

        for (int i = 0; i < n; i++) {
            int curr = nums[i];

            if (curr == 0) {
                while (size > 0) {
                    isnum[monostack[--size]] = false;
                }
                continue;
            }

            while (size > 0 && monostack[size - 1] > curr) {
                isnum[monostack[--size]] = false;
            }

            if (!isnum[curr]) {
                res++;
                isnum[curr] = true;
            }

            monostack[size++] = curr;
        }

        return res;
    }
}
