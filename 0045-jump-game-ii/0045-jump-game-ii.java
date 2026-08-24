class Solution {
    public int jump(int[] nums) {
        int jump = 0; 
        int currend = 0;
        int far = 0; //sabse dur kaha ja sakte hai

        for(int i=0;i<nums.length-1;i++){

            far = Math.max(far,nums[i] + i);

            if(i == currend){
                jump++;
                currend = far;
            }
        }
        return jump;
    }
}