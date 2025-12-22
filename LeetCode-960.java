class Solution {
    public int minDeletionSize(String[] strs) {
    
        int length = strs[0].length();
        int[] dp = new int[length];
        
        int max = 0;
        for (int i = 0; i < length; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (checkLager(j,i, strs)){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return length - max;
    }
    public boolean checkLager(int j, int i, String[] strs){
        for (String s : strs){
            if (s.charAt(j) > s.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
