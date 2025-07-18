class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int max=0;
        for(Integer element: set){
            int prev = element-1; 
            if(!set.contains(prev)){
                int len=1;
                int next=element+1; 
                while(set.contains(next)){
                    len++;
                    next++;
                }
                max = Math.max(max,len);
            }
        }
        return max;
    }
}
