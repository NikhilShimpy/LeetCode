class Solution {
    public int maximumLength(int[] nums) {
        int c = nums[0] % 2, odd = 0, even = 0, both = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
            if (num % 2 == c) {
                both++;
                c = 1 - c;  
            }
        }
        return Math.max(both, Math.max(even, odd));
    }
}
