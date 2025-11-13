class Solution {
    public int maxOperations(String s) {
        int res = 0;
        int ones = 0;
        boolean use = false;
        
        for (char c : s.toCharArray()) {
            if (c == '0') {
                use = true;
            } else {
                if (use) {
                    res += ones;
                }
                
                ones++;
                use = false;
            }    
        }
        
        if (use) {
            res += ones;
        }
        
        return res;
    }
}
