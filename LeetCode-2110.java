class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;

        long count = 1;
        long res = 1;
        for(int i =1;i<n;i++){
            
            if(prices[i-1] - prices[i] == 1) count++;
            else count =1;
            
            res += count;
        }

        return res;
    }
}
