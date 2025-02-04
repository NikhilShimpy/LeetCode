class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int sum =nums[0];
        int res=nums[0];
        for(int i=0;i<n-1;i++){
            if(nums[i] < nums[i+1]){
                sum = nums[i+1]+sum;
            }else{
                sum = nums[i+1];
            } 
               res = Math.max(sum,res);
        }
        return res;
    }
}
