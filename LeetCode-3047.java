class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        
        long ans=0;
        for(int i=0;i<bottomLeft.length;i++)
        {
            for(int j=i+1;j<bottomLeft.length;j++)
            {
                
                
                int Xa=Math.max(bottomLeft[i][0],bottomLeft[j][0]);
                int Xb=Math.max(bottomLeft[i][1],bottomLeft[j][1]);
                
                int Ya=Math.min(topRight[i][0],topRight[j][0]);
                int Yb=Math.min(topRight[i][1],topRight[j][1]);
                
                
                if(Xa<Ya && Xb<Yb){
                    
                    int s=Math.min(Ya-Xa,Yb-Xb);
                    ans=Math.max(ans, (long)s*s);
                }
            }
         }
        return ans;
    }
}
