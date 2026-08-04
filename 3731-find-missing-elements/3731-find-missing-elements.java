class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<n;i++){
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
            //add kr do set me
            set.add(nums[i]);
        }
        List<Integer> res = new ArrayList<>();
        for(int x = min;x <= max;x++){
            if(!set.contains(x)) res.add(x);
        }

        return res;
    }
}