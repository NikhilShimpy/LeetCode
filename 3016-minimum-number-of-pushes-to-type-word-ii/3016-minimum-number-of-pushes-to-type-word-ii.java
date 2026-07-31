class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        // count freq
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        Arrays.sort(freq);

        int ans = 0;
        int position = 0;

        // traverse highest to lowest freq
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) break;

            ans += freq[i] * ((position / 8) + 1);
            position++;
        }

        return ans;
    }
}