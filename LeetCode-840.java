class Solution {
    public int rs(int grid[][], int r, int c){
       boolean bool[] = new boolean[10];
       int sum=0;
       for(int i=0;i<3;i++){
        int rowsum=0;
        for(int j=0;j<3;j++){
            int val = grid[r+i][c+j];
            if(val==0 || val>=10 || bool[val]){
                return -1;
            }
            bool[val] = true;
            rowsum+=val;
        }
        if(i==0){
            sum = rowsum;
        }else{
            if(sum!=rowsum){
                return -1;
            }
        }
       }
       return sum;
    }

    public int cs(int grid[][], int r, int c){
       int sum=0;
       for(int j=0;j<3;j++){
        int colsum=0;
        for(int i=0;i<3;i++){
            int val = grid[r+i][c+j];
            colsum+=val;
        }
        if(j==0){
            sum = colsum;
        }else{
            if(sum!=colsum){
                return -1;
            }
        }
       }
       return sum;
    }

    public int ds(int grid[][], int r, int c){
        int sum1 = grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2];
        int sum2 = grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c];
        if(sum1==sum2){
            return sum1;
        }
        return -1;
    }
    public boolean ms(int grid[][], int r, int c){
        int rowsum = rs(grid,r,c); 
        if(rowsum==-1) return false;
        int colsum = cs(grid,r,c);
        if(colsum==-1) return false;
        int ds = ds(grid,r,c); 
        if(ds==-1) return false;
        if(rowsum==colsum && rowsum==ds){
            return true;
        }
        return false;
    }
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count=0;
        for(int i=0;i<rows-2;i++){
            for(int j=0;j<cols-2;j++){
                if(ms(grid,i,j)){
                    count++;
                }
            }   
        }
        return count;
    }
}
