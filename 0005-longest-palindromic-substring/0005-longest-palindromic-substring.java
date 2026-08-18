class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxlen = Integer.MIN_VALUE;
        int sidx = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(solve(i,j,s)){
                    if(j-i+1 > maxlen){
                        sidx = i;
                        maxlen = j-i+1;
                    }
                }
            }
        }
        return s.substring(sidx,sidx+maxlen);
    }
    boolean solve(int i, int j, String s){
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}