class Solution {
    public int longestSubsequence(int[] nums) {
        
        int xor = 0;
        boolean hasnonzero = false;

        for (int num : nums) {
            xor ^= num;

            if (num != 0) {
                hasnonzero = true;
            }
        }

        // xor 0 nhi hai
        if (xor != 0) {
            return nums.length;
        }

        // Entire array XOR 0,
        // remove 1 non-zero element
        if (hasnonzero) {
            return nums.length - 1;
        }

        // sabhi ele 0 hai
        return 0;
    }
}