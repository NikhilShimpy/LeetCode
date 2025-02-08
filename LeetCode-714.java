class Solution {
    public int maxProfit(int[] prices, int fee) {
        int s=0;
        int b = Integer.MIN_VALUE;
        
        for(int i=0;i<prices.length;i++){
          
                b = Math.max(b,s-prices[i]);
                s = Math.max(s,b+prices[i] - fee);
         
        }
        return s;
    }
}
