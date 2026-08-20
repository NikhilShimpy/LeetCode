class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        
        return solve(n);
    }
    public int solve(int n){
        if(n == 0) return dp[n] = 1;
        if(n < 0) return 0;
        if(dp[n] != -1) return dp[n];
        //return oneStep + twoStep
        return dp[n] = solve(n-1) + solve(n-2);
    }
}

//    class Solution{
//     public int climbStairs(int n) {
//         HashMap<Integer,Integer> map = new HashMap<>();
//         return climbStairs(n,map);
//     }
//     private int climbStairs(int n, Map<Integer,Integer> map){
//          if(n==0 || n==1) return 1;
//          if(!map.containsKey(n)){
//             map.put(n,climbStairs(n-1,map) + climbStairs(n-2,map));
//          }
//          return map.get(n);
//     }
// }