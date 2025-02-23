class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int first = bs(nums,target,true);
        if (first == -1) return list;
        int last = bs(nums,target,false);
        
        for(int i = first;i<=last;i++) list.add(i);
        return list;
        
    }
     static int bs(int[] nums,int target , boolean isfirst){
        int start =0;
        int ans =-1;
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

/*
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                list.add(i);
            }
        }
        return list;
        
    }
}
*/
