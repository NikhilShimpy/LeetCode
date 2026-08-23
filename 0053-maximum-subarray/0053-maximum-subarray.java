class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for(int num : nums){
            if(sum < 0){
                sum = 0;
            }
            sum += num;
            res = Math.max(res,sum);
        }

        return res;
    }
}