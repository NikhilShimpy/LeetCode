class Solution {
    public int countPartitions(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if(sum%2 != 0) return 0;
        return nums.length-1;
        
    }
}
