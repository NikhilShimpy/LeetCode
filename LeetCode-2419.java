class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0,  res =0;
        int n = nums.length;

        for(int i =0;i<n;i++){
            if(max<nums[i]) max = nums[i];
        }

        int count =0;
        for(int i=0;i<n;i++){
            if(nums[i]>=max){
                count++;
            }else{
                count = 0;
            }
            res = Math.max(count,res);
        }
        return res;
    }
}
