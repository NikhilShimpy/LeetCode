class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] freq = new int[51];

        for (int i = 0; i <= nums.length - k; i++) {
            HashSet<Integer> set = new HashSet<>();

            for (int j = i; j < i + k; j++) {
                set.add(nums[j]);
            }

            for (int x : set) {
                freq[x]++;
            }
        }

        // largest no find kro
        for (int x = 50; x >= 0; x--) {
            if (freq[x] == 1) {
                return x;
            }
        }

        return -1;
    }
}