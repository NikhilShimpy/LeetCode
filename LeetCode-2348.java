class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;   
        long subarr = 0;    
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                count++;               
                subarr += count;    
                
            }
            else {
                count = 0; 
            }
        }
        
        return subarr;
    }
}
