class Solution {
    public int minimumDeletions(String s) {
        int res = 0, b = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'b')
                b++;
            else if (b > 0) {
                res++;
                b--;
            }
        }

        return res;
    }
}
