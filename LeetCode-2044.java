class Solution {
    public void backtrack(int[] nums, int index, int curror, int maxor, int[] count) {
        if (curror == maxor) {
            count[0]++;
        }

        for (int i = index; i < nums.length; i++) {
            backtrack(nums, i + 1, curror | nums[i], maxor, count);
        }
    }

    public int countMaxOrSubsets(int[] nums) {
        int maxor = 0;

        for (int num : nums) {
            maxor |= num;
        }

        int[] count = new int[1];
        backtrack(nums, 0, 0, maxor, count);

        return count[0];
    }
}
