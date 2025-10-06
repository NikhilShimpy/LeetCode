class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0; // handle empty array
        
        int maxLen = 1;
        int currLen = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currLen++;
                if (currLen > maxLen) maxLen = currLen; // inline max check for speed
            } else {
                currLen = 1;
            }
        }
        return maxLen;
    }
}
