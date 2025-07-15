public class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n < 3) {
            return false;
        }

        int v = 0;
        int cons = 0;

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                if ("aeiouAEIOU".indexOf(c) != -1) {
                    v++;
                } else {
                    cons++;
                }
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }
        return v >= 1 && cons >= 1;
    }
}
