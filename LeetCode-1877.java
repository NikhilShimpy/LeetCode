class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = 0;
        for(int i = 0;i<n;i+=2){
            max = Math.max(max,nums[i]+nums[n-i-1]);
        }
        return max;
    }
}
