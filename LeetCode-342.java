class Solution {
    public boolean isPowerOfFour(int n) {
        // int n = n;
         if(n==0) return false;
        while(n>0){
            if(n==1) return true;
            if(n%4 != 0) break;
            n=n/4;
        }
        return false;
    }
}
