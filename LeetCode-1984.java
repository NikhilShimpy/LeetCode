class Solution {
    public int minimumDifference(int[] nums, int k) {
        
        if(k <= 1) return 0;
        int n = nums.length;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for(int i =0;i<=n-k;i++){
            min = Math.min(min,nums[i+k-1]-nums[i]);
        }
        return min;
    }
}
