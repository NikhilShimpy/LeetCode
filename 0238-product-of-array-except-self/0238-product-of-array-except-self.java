class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int n = nums.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];
        //intialize first for prefix
        prefix[0] = 1;
        //for suffix also
        suffix[n-1] = 1;
       
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1] * nums[i-1];
            suffix[n-i-1] = suffix[n-i] * nums[n-i];
        }
        int res[] = new int[n];
        for(int i=0;i<n;i++){
            res[i] = prefix[i] * suffix[i];
        }

        return res;
    }
}