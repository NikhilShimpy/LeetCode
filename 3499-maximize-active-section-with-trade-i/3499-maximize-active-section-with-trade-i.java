class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();

        // existing count of 1s
        int activecount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') activecount++;
        }

        List<Integer> inactivecount = new ArrayList<>();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '0') {
                int start = i;
                while (i < n && s.charAt(i) == '0') i++;

                inactivecount.add(i - start);
            } else {
                i++;
            }
        }

        int maxpairsum = 0;
        // max(inactivecount[i] + inactivecount[i-1])
        for (int j = 1; j < inactivecount.size(); j++) {
            maxpairsum = Math.max(maxpairsum, inactivecount.get(j) + inactivecount.get(j - 1));
        }

        return maxpairsum + activecount;
    }
}