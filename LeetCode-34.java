class Solution {
    public int[] searchRange(int[] nums, int target) {
       int first = bs(nums,target,true);
       int last = bs(nums,target,false);
       int[] res = new int[2];
       res[0] = first;
       res[1] = last;
       return res;
    }

    static int bs(int[] nums,int target , boolean isfirst){
        int start =0;
        int ans = -1;
        int end = nums.length-1;
        
        while(start<=end){
            int mid = start + (end-start) / 2;
            if(nums[mid] == target){
                ans = mid;
                if(isfirst){
                    end = mid-1;
                }else{
                    start = mid+1;
                }

            }else if(nums[mid]<target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return ans;
    }
}
