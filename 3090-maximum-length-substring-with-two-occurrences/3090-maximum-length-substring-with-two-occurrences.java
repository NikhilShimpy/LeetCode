class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];
        int left = 0;
        int res = 0;

        for (int right = 0; right < s.length(); right++) {
            int idx = s.charAt(right) - 'a';
            freq[idx]++;

            while (freq[idx] > 2) {
                freq[s.charAt(left) - 'a']--;
                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}