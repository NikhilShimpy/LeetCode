class Solution {
    public long flowerGame(int n, int m) {
        long oddn = (n + 1) / 2;  
        long evenn = n / 2;        
        long oddm = (m + 1) / 2;   
        long evenm = m / 2;        

        return oddn * evenm + evenn * oddm;
    }
}
