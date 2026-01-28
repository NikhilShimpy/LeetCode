class Solution {
    int MAX = Integer.MAX_VALUE;

    public int minCost(int[][] grid, int K) {
        int n = grid.length, m = grid[0].length;
        int range = 10000;

        int[][][] dp = new int[K+1][n][m];
        for(int p=0; p<=K; p++){
            for(int i=0; i<n; i++){
                Arrays.fill(dp[p][i], MAX);
            }
        }

        int[] bestPrefix = new int[range+1];
        Arrays.fill(bestPrefix, MAX);

        for(int p=0; p<=K; p++){
            int[] bestCurrent = new int[range+1];
            Arrays.fill(bestCurrent, MAX);

            for(int i=n-1;i>=0;i--){
                for(int j=m-1;j>=0;j--){
                    if(i==n-1 && j==m-1){
                        dp[p][i][j] = 0;
                    } else {
                        int ans = MAX;

                        if(i+1<n){
                            ans = Math.min(ans, grid[i+1][j] + dp[p][i+1][j]);
                        }
                        if(j+1<m){
                            ans = Math.min(ans, grid[i][j+1] + dp[p][i][j+1]);
                        }

                        if(p>0){
                            ans = Math.min(ans, bestPrefix[grid[i][j]]);
                        }

                        dp[p][i][j] = ans;
                    }
                    bestCurrent[grid[i][j]] = Math.min(bestCurrent[grid[i][j]], dp[p][i][j]);
                }
            }

            Arrays.fill(bestPrefix, MAX);
            bestPrefix[0] = bestCurrent[0];
            for(int r=1; r<=range; r++){
                bestPrefix[r] = Math.min(bestPrefix[r-1], bestCurrent[r]);
            }
        }
        return dp[K][0][0];
    }
}
