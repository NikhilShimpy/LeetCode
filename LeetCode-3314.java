class Solution {
        public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size(), res[] = new int[n];
        for (int i = 0; i < n; i++) {
            int a = nums.get(i);
            if (nums.get(i) % 2 == 0) {
                res[i] = -1;
            } else {
                res[i] = a - ((a + 1) & (-a - 1)) / 2;
            }
        }
        return res;
    }
}
