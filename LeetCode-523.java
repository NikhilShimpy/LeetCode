class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); 

        for (int i=0;i<nums.length;i++) {
            sum += nums[i];
            if(map.containsKey(sum%k)){
                int idx = map.get(sum%k);
                if(i-idx > 1) return true;
            }else{
                map.put(sum%k,i);
            }       
        }

        return false;
    }
}
