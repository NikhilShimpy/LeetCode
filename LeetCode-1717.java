class Solution {
    public int maximumGain(String s, int x, int y) {
        StringBuilder sb = new StringBuilder(s);
        int res = 0;

        res += (x > y) ? removePairs(sb, "ab", x) + removePairs(sb, "ba", y)
                      : removePairs(sb, "ba", y) + removePairs(sb, "ab", x);

        return res;
    }

    private int removePairs(StringBuilder sb, String pair, int score) {
        StringBuilder stack = new StringBuilder();
        int res = 0;
        for (int i = 0; i < sb.length(); ++i) {
            char c = sb.charAt(i);
            if (stack.length() > 0 && c == pair.charAt(1) && stack.charAt(stack.length() - 1) == pair.charAt(0)) {
                stack.deleteCharAt(stack.length() - 1);
                res += score;
            } else {
                stack.append(c);
            }
        }
        sb.setLength(0);
        sb.append(stack);
        return res;
    }
}
