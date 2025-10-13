public class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        List<String> res = new ArrayList<>();

        res.add(words[0]);

        for (int i = 1; i < n; i++) {
            String lastWord = res.get(res.size() - 1);
            if (!checkAnagram(words[i], lastWord)) {
                res.add(words[i]);
            }
        }

        return res;
    }
     private boolean checkAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] arr = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            arr[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
