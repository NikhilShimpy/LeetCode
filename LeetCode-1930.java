class Solution {
    public int countPalindromicSubsequence(String inputString) {
  
        int[] mine = new int[26];
        int[] maxe = new int[26];
        for (int i = 0; i < 26; i++) {
            mine[i] = Integer.MAX_VALUE;
            maxe[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < inputString.length(); i++) {
            int charIndex = inputString.charAt(i) - 'a';
            mine[charIndex] = Math.min(mine[charIndex], i);
            maxe[charIndex] = Math.max(maxe[charIndex], i);
        }

        int count = 0;

        for (int charIndex = 0; charIndex < 26; charIndex++) {
            if (mine[charIndex] == Integer.MAX_VALUE || maxe[charIndex] == Integer.MIN_VALUE) {
                continue; 
            }
            HashSet<Character> unichar = new HashSet<>();

            for (int j = mine[charIndex] + 1; j < maxe[charIndex]; j++) {
                unichar.add(inputString.charAt(j));
            }

            count += unichar.size();
        }

        return count;
    }
}
