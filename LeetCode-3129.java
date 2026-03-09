class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int M = 1_000_000_007;
        int[][][] t = new int[one + 1][zero + 1][2];

        t[0][0][0] = 1;
        t[0][0][1] = 1;

        for (int oneleft = 0; oneleft <= one; oneleft++) {
            for (int zeroleft = 0; zeroleft <= zero; zeroleft++) {
                if (oneleft == 0 && zeroleft == 0) continue;

                int res = 0;
                for (int len = 1; len <= Math.min(zeroleft, limit); len++) {
                    res = (res + t[oneleft][zeroleft - len][0]) % M;
                }
                t[oneleft][zeroleft][1] = res;

                res = 0;
                for (int len = 1; len <= Math.min(oneleft, limit); len++) {
                    res = (res + t[oneleft - len][zeroleft][1]) % M;
                }
                t[oneleft][zeroleft][0] = res;
            }
        }

        int swo  = t[one][zero][0]; //start ho rhe one se 
        int swz = t[one][zero][1]; //s w one 
        return (swo + swz) % M;
    }
}
