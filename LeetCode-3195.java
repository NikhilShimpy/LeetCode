class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length, n =  grid[0].length;
        int top = m,down = -1, left = n, right = -1;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j] == 1)
                {
                    if(top>i) top = i;
                    if(down<i) down = i;
                    if(left>j) left = j;
                    if(right<j) right = j;
                }
            }
        }
        return (down-top+1) * (right-left+1);
    }
}
