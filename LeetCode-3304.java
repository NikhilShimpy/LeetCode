class Solution {
    public char kthCharacter(int k) {
    String s = "a";
    while (s.length() < k) {
        StringBuilder temp = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == 'z') {
                temp.append('a');
            }
            else {
                temp.append((char) (c + 1));
            }
        }
        s += temp.toString();
    }
        
     return s.charAt(k - 1);
    }
}
