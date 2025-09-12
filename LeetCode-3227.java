class Solution {
    public boolean doesAliceWin(String s) {
        int count = 0;
        
        for (char c : s.toCharArray()){
            if (isVowel(c))
                return true;
        }
        
        return false;
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u';
    }
}
