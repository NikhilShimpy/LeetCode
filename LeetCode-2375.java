class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder res = new StringBuilder();
        Stack<Integer> s = new Stack<>();
        
        for (int i = 0; i <= pattern.length(); i++) {
            s.push(i + 1);
            
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                while (!s.isEmpty()) {
                    res.append(s.pop());
                }
            }
        }
        
        return res.toString();
    }
}
