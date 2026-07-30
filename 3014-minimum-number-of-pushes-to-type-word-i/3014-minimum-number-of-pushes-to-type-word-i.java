class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int res = 0;
        if(n <= 8) return n;
        for(int i =0;i<n;i++){
            res += (i / 8) + 1;
        }
        return res;
    }
}