//TC : O(N) , SC : O(1)
class Solution {
    public int[] productExceptSelf(int[] nums) {
       int n = nums.length;
       int res[] = new int[n];
    //    prefix sum of 0 = 1 hoga 
       res[0] = 1; 
       for(int i=1;i<n;i++){
        res[i] = res[i-1] * nums[i-1];
       }

       int suffix = 1;
       for(int i = n-1;i >= 0; i--){
        res[i] = res[i] * suffix;
        suffix *= nums[i];
       }
       return res;
    }
}

//TC : O(N) , SC : O(N)
// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int prod = 1;
//         int n = nums.length;
//         int prefix[] = new int[n];
//         int suffix[] = new int[n];
//         //intialize first for prefix
//         prefix[0] = 1;
//         //for suffix also
//         suffix[n-1] = 1;
       
//         for(int i=1;i<n;i++){
//             prefix[i] = prefix[i-1] * nums[i-1];
//             suffix[n-i-1] = suffix[n-i] * nums[n-i];
//         }
//         int res[] = new int[n];
//         for(int i=0;i<n;i++){
//             res[i] = prefix[i] * suffix[i];
//         }

//         return res;
//     }
// }