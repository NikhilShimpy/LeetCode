class Solution {
    public int maxDistance(String s, int k) {
        int maxmd = 0;
        int east =0 ,west =0, north =0,south =0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(c == 'N') north++;
            else if(c == 'S') south++;
            else if(c == 'E') east++;
            else if(c == 'W') west++;

            int currmd = Math.abs(north-south)+Math.abs(east-west);
            int step = i+1;
            int waste =step - currmd;
            int extra = Math.min(2*k ,waste);
            int finalmd = currmd+extra;
            maxmd = Math.max(finalmd,maxmd);
        }
        return maxmd;
    }
}
