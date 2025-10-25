class Solution {
    public int totalMoney(int n) {
        int wc = n / 7;
        int remday = n % 7;
        
        int total = ((wc * (wc - 1)) / 2) * 7; 
        total += wc * 28; 
        total += ((remday * (remday + 1)) / 2) + (wc * remday); 
        
        return total;
    }
}
