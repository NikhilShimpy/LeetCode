class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        int maxfreq = 0;
        for (int count : freq.values()) {
            maxfreq = Math.max(maxfreq, count);
        }
        
        int res = 0;
        for (int count : freq.values()) {
            if (count == maxfreq) {
                res += count;
            }
        }
        
        return res;
    }
}
