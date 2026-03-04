class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] rc = new int[m]; //count
        int[] cc = new int[n];
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 1) {
                    rc[row]++;
                    cc[col]++;
                }
            }
        }
        
        int res = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 1) {
                    if (rc[row] == 1 && cc[col] == 1) {
                        res++;
                    }
                }
            }
        }
        
        return res;
    }
}
