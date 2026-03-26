class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int maxlen = 0, cost = 0;

        int i = 0 ,j = 0 ;

        while(j<n){
            cost += Math.abs(s.charAt(j) - t.charAt(j));
            while(cost > maxCost){
                cost -= Math.abs(s.charAt(i) - t.charAt(i));
                i++;
            }
            maxlen = Math.max(maxlen,j-i+1);
            j++;
        }
        return maxlen;
    }
}
