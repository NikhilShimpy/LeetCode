class Solution {
    public int[] finalPrices(int[] p) {
        int n = p.length;
        int[] r = new int[n];

        for(int i = 0;i<n;i++){
            r[i] = p[i];
             for(int j =i+1;j<n;j++){
                if(p[j] <= p[i]){
                    r[i] -= p[j];
                    break;
                }
             }
        }
        return r;
    }
}
