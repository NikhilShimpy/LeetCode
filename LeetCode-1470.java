class Solution {
    public int[] shuffle(int[] nums, int n) {
       int[] res = new int[n*2];
       
       int x = 0;
       int y = n;
       
       for(int i=0;i<nums.length;i++){
        if(i%2 == 0){
            res[i] = nums[x];
            x++;
        }else{
            res[i] = nums[y];
            y++;
        }
       }
       return res;
    }
}
