class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        
        long res = Long.MAX_VALUE, windowsum = 0l;
        int n = nums.length;
        TreeSet<Integer> using = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);
        TreeSet<Integer> waiting = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);
        
        for(int i = 1; i <= dist + 1; i++){
            using.add(i);
            windowsum += nums[i];
        }
        while(using.size() > k - 1){
            int i = using.pollLast();
            windowsum -= nums[i];
            waiting.add(i);
        }
        res = Math.min(res, windowsum);
        for(int i = 1; i + dist + 1 < n; i++){
            
            waiting.add(i + dist + 1);
                
            if(using.contains(i)){
                windowsum -= nums[i];
                using.remove(i);
                int j = waiting.pollFirst();
                windowsum += nums[j];
                using.add(j);
            }else{
                waiting.remove(i);
                int j1 = waiting.first(), j2 = using.last();
                if(nums[j1] < nums[j2]){
                    windowsum -= nums[j2];
                    using.remove(j2);
                    waiting.add(j2);
                    
                    windowsum += nums[j1];
                    using.add(j1);
                    waiting.remove(j1);
                }
            }
            
            res = Math.min(res, windowsum);
        }
        return res + nums[0];
    }
}
