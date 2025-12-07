class Solution {
    public int countOdds(int low, int high) {
        int t = high-low+1;
        if(t == 2) return 1;
        if(low%2 == 0 || high%2 == 0) return (t/2);
        else{
            return (t/2 +1);
        }
    }
}
