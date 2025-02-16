class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2 * n - 1]; 
        boolean[] used = new boolean[n + 1]; 
        genseq(res, used, 0, n);
        return res;
    }

    private boolean genseq(int[] res, boolean[] used, int idx, int n) {
        
        if (idx == res.length) {
            return true;
        }

        if (res[idx] != 0) {
            return genseq(res, used, idx + 1, n);
        }

        for (int i = n; i >= 1; i--) {
            if (!used[i]) {
                if (i == 1) {  
                    res[idx] = 1;
                    used[1] = true;
                    if (genseq(res, used, idx + 1, n)) {
                        return true;
                    }
                  
                    res[idx] = 0;
                    used[1] = false;
                } else {
                   
                    if (idx + i < res.length && res[idx + i] == 0) {
                        res[idx] = i;
                        res[idx + i] = i;
                        used[i] = true;
                        if (genseq(res, used, idx + 1, n)) {
                            return true;
                        }
                       
                        res[idx] = 0;
                        res[idx + i] = 0;
                        used[i] = false;
                    }
                }
            }
        }

        return false; 
    }
}
