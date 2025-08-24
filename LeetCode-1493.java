class Solution {
    public int longestSubarray(int[] nums) {
        int zc = 0;
        int lw = 0;
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                zc++;
            }

            while (zc > 1) {
                if (nums[i] == 0) {
                    zc--;
                }
                i++;
            }

            lw = Math.max(lw, j - i);
        }

        return lw;
    }
}
