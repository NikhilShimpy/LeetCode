class Solution {
    String result = "";

    private boolean isSubsequence(String s, String sub, int k) {
        int i = 0, j = 0;
        int len = sub.length(), n = s.length();

        while (i < n && j < k * len) {
            if (s.charAt(i) == sub.charAt(j % len)) {
                j++;
            }
            i++;
        }

        return j == k * len;
    }

    private boolean backtracking(String s, StringBuilder curr, boolean[] canUse, int[] requiredFreq, int k, int maxLen) {
        if (curr.length() == maxLen) {
            if (isSubsequence(s, curr.toString(), k)) {
                result = curr.toString();
                return true;
            }
            return false;
        }

        for (int i = 25; i >= 0; i--) {
            if (!canUse[i] || requiredFreq[i] == 0)
                continue;

            curr.append((char) (i + 'a'));
            requiredFreq[i]--;

            if (backtracking(s, curr, canUse, requiredFreq, k, maxLen))
                return true;

            curr.deleteCharAt(curr.length() - 1);
            requiredFreq[i]++;
        }

        return false;
    }

    public String longestSubsequenceRepeatedK(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        boolean[] canUse = new boolean[26];
        int[] requiredFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            if (freq[i] >= k) {
                canUse[i] = true;
                requiredFreq[i] = freq[i] / k; 
            }
        }

        int maxLen = n / k;

        for (int len = maxLen; len >= 1; len--) {
            int[] tempRequiredFreq = requiredFreq.clone();  
            StringBuilder curr = new StringBuilder();

            if (backtracking(s, curr, canUse, tempRequiredFreq, k, len)) {
                return result;
            }
        }

        return result;
    }
}
