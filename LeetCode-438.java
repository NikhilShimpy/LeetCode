class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int k = p.length();
        int[] count = new int[26];
        Arrays.fill(count, 0);
        
        for (char ch : p.toCharArray()) {
            count[ch - 'a']++;
        }

        int i = 0, j = 0;
        int n = s.length();
        List<Integer> res = new ArrayList<>();

        while (j < n) {
            int idx = s.charAt(j) - 'a';
            count[idx]--;

            if (j - i + 1 == k) {
                if (allZero(count)) {
                    res.add(i);
                }

                count[s.charAt(i) - 'a']++;
                i++;
            }
            j++;
        }
        return res;

    }

    private boolean allZero(int[] count) {
        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}

    

   
