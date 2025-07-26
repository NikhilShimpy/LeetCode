class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        long valid = 0;

        List<List<Integer>> cnfpoint = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            cnfpoint.add(new ArrayList<>());
        }

        for (int[] p : conflictingPairs) { 
            int a = Math.min(p[0], p[1]);
            int b = Math.max(p[0], p[1]);
            cnfpoint.get(b).add(a);
        }

        int maxcnf = 0;
        int smcnf = 0; //second max conflict 

        long[] extra = new long[n + 1];

        for (int end = 1; end <= n; end++) {
            for (int u : cnfpoint.get(end)) {
                if (u >= maxcnf) {
                    smcnf = maxcnf;
                    maxcnf = u;
                } else if (u > smcnf) {
                    smcnf = u;
                }
            }
            valid += end - maxcnf;
            extra[maxcnf] += maxcnf - smcnf;
        }

        long maxe = 0;
        for (long val : extra) {
            if (val > maxe) {
                maxe = val;
            }
        }

        return valid + maxe;
    }
}
