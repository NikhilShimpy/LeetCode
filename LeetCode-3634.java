class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums); 
        int n = nums.length;
        int maxsize = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            while (nums[right] > (long) k * nums[left]) left++;
            maxsize = Math.max(maxsize, right - left + 1);
        }
        return n - maxsize;
    }
}
